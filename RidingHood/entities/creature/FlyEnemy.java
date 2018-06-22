package RidingHood.entities.creature;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import RidingHood.Handler;
import RidingHood.gfx.Animation;
import RidingHood.gfx.Assets;
import RidingHood.skill.Circle;
import RidingHood.skill.Sin;
import RidingHood.skill.Skill;
import RidingHood.weapon.Bullet;

public class FlyEnemy extends Enemy
{
	private Skill sin, circle, cos ;
	
	private ArrayList<Skill> fly;
	private String type;
	private BufferedImage[] imageList, imageRist;
	private boolean skilling = false;
	private Bullet bullet;
	private Animation rwalk, lwalk, rwalkA, lwalkA;
	
	public FlyEnemy(Handler handler, float x, float y, int width, int height, int ar, int amt, float xa, float xd, String type) {
		super(handler, x, y, width, height);
		this.ar = ar;
		this.amt = amt;
		this.xa = xa;
		this.xd = xd;
		this.type = type;
		xMove = (float) (speed/(Math.random()*2+3));
		this.sin = new Sin(handler, this, 100, 20, 1, "sin");
		this.cos = new Sin(handler, this, 100, 20, 1, "cos");
		this.circle = new Circle(handler, this, 100, 20, 1);
		decideType();
		rwalk = new Animation(250, Assets.right_flyOnion);
		lwalk = new Animation(250, Assets.left_flyOnion);
		rwalkA = new Animation(250, Assets.right_flyOnionA);
		lwalkA = new Animation(250, Assets.left_flyOnionA);
		health = 10*handler.getPlayer().getRank();
		expG = 10;
		
		fly = new ArrayList<Skill>();
		fly.add(sin);
		fly.add(circle);
		fly.add(cos);
		Collections.shuffle(fly);
	
	}

	@Override
	public void actRange(int ar) 
	{	
		if(!detected && !checkAttackWalk(xa)) 
		{
			if(!fly.get(1).getSkillHappen())
			{
				if(!fly.get(2).getSkillHappen())
				{
					fly.get(0).skilling();
					if(!fly.get(0).getSkillHappen())
						{fly.get(1).skilling();}
				}
					
				else
				{
					fly.get(2).skilling();
					if(!fly.get(2).getSkillHappen())
						{fly.get(0).skilling();}
					if(fly.get(2).getTt()/fly.get(2).gettLimit() >= ar)
						Collections.shuffle(fly);
				}
					
			}
			else
			{
				fly.get(1).skilling();
				if(!fly.get(1).getSkillHappen())
					{fly.get(2).skilling();}
			}
		}
		else
		{
			
			sin.skilling();
		}
	}

	@Override
	public void render(Graphics2D g) {
		//g.setColor(Color.red);
		//g.fill(getAttackWalkBound(xa));
		//g.setColor(Color.BLACK);
		//g.fill(getAttackWalkBound(xa));
		g.drawImage(getCurrentFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.fillRect((int)(x + bound.x - handler.getGameCamera().getxOffset()), (int)(y + bound.y - handler.getGameCamera().getyOffset()), bound.width, bound.height);
		
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
		
			if(checkAttackWalk(xa))
			{
				if(!fire)
				{
					bullet = new Bullet(handler, this, pcx, pcy, width/2 - 3, height, 10, 10, "line");
					bullet.setExF(Assets.gbulletEx);
					bullet.setFire(true);
					fire = true;
				}
					
			}
			if(bullet != null)	
			{
				bullet.tick();
				if(!bullet.isFire())
					fire = false;
			}
				
			
		
		
	}
	public void decideType()
	{
		switch(type)
		{
			case "onion" : bound.x = width*37/160;bound.y = height*52/160;bound.width = width*84/160;bound.height = height*66/160;break;
		}
	}
	public BufferedImage getCurrentFrame()
	{
		if(xMove < 0 && !checkAttackWalk(xa))
			return lwalk.getCurrentFrame();
		else if(xMove > 0 && !checkAttackWalk(xa))
			return rwalk.getCurrentFrame();
		else if(x < handler.getWorld().getEntityManager().getPlayer().getX())
			return rwalkA.getCurrentFrame();
		else 
			return lwalkA.getCurrentFrame();
	}

	@Override
	public void tic() {
		rwalk.tick();
		lwalk.tick();
		rwalkA.tick();
		lwalkA.tick();
		
	}
	
}
