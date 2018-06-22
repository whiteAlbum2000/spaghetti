package RidingHood.entities.creature;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import RidingHood.Handler;
import RidingHood.gfx.Assets;
import RidingHood.skill.HurtPlayer;
import RidingHood.skill.Jump;
import RidingHood.skill.Skill;

public class WalkEnemy extends Enemy
{
	private ArrayList<BufferedImage[]> imageList;
	private Skill jump;
	private String type;
	
	
	public WalkEnemy(Handler handler, float x, float y, int width, int height, int ar, int amt, float xa, float xd, String type) 
	{
		super(handler, x, y, width, height);
		this.ar = ar;
		this.amt = amt;
		this.xa = xa;
		this.xd = xd;
		health = 15*handler.getPlayer().getRank();
		expG = 5;
		jump = new Jump(handler, this, (long) (Math.random()*10+50), (int) (Math.random()*5+20), (float) (Math.random()*5+8));
		xMove = (float) (speed/(Math.random()*2+3));
		this.imageList = new ArrayList<BufferedImage[]>();
		this.type = type;
		hurtPlayer = new HurtPlayer(handler, this, 250, 10, amt, type);
		decideType();
	}

	@Override
	public void render(Graphics2D g) {
		//g.fill(getAttackWalkBound(xa));
		g.drawImage(getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.fillRect((int)(x + bound.x - handler.getGameCamera().getxOffset()), (int)(y + bound.y - handler.getGameCamera().getyOffset()), bound.width, bound.height);
		
		
	}

	@Override
	public void actRange(int ar) {
		
		
		if(!checkAttackWalk(xa))
		{
			jump.skilling();
			
		}
		else
		{
			jump.stop();
			if(y < spawny && !jump.getSkillHappen() || y < spawny && jump.getT() == jump.gettLimit())
				yMove = speed/2;
		}
			
		if(!detected)
		{			
			
			if(jump.getTt()/jump.gettLimit() >= ar)
			{
				jump.setTt(0);
	
					xMove = -xMove;
					//System.out.println("turn");
				
			}
		}
		
		
	}
	public BufferedImage getCurrentFrame()
	{
		if(xMove > 0)
			return imageList.get(0)[0];
		else if(xMove < 0)
			return imageList.get(0)[1];
		else if(hurtPlayer.getSkillHappen())
			return hurtPlayer.getCurrentFrame();
		return imageList.get(0)[1];
	}
	public void decideType()
	{
		switch(type)
		{
			case "onion": bound.x = width*37/160;bound.y = height*52/160;bound.width = width*84/160;bound.height = height*66/160;imageList.add(Assets.walkOnion);break;
		}
	}

	

	@Override
	public void attack() {
		
		if(checkAttack(xa))
			{
				hurtPlayer.skilling();
				//System.out.println("walk hurt");
			}
	}

	@Override
	public void tic() {
		// TODO Auto-generated method stub
		
	}
}
