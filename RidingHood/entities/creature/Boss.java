package RidingHood.entities.creature;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import RidingHood.Handler;
import RidingHood.gfx.Animation;
import RidingHood.gfx.Assets;
import RidingHood.skill.BossAttack;
import RidingHood.skill.HurtPlayer;
import RidingHood.skill.Jump;
import RidingHood.skill.Skill;
import RidingHood.weapon.Bullet;

public class Boss extends Enemy
{
	private ArrayList<BufferedImage[]> imageList;
	private Skill jump, bossAttack, hurtPlayer;
	private Bullet bullet, bullet2, bullet3;
	private String type;
	
	private boolean bigA = false, bigFirst = true;
	
	public Boss(Handler handler, float x, float y, int width, int height, int ar, int amt, float xa, float xd, String type) 
	{
		super(handler, x, y, width, height);
		this.ar = ar;
		this.amt = amt;
		this.xa = xa;
		this.xd = xd;
		this.type = type;
		jump = new Jump(handler, this, (long) (Math.random()*10+50), (int) (Math.random()*5+20), (float) (Math.random()*5+3));
		xMove = (float) (-speed/(Math.random()*2+2));
		hurtPlayer = new HurtPlayer(handler, this, 250, 15, amt, "boss");
		decideType();
		bossAttack = new BossAttack(handler, this, 150);
		health = 50*handler.getPlayer().getRank();
		expG = 50;
	}

	@Override
	public void render(Graphics2D g)
	{
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
			if(y < spawny && !jump.getSkillHappen())
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
	public void decideType()
	{
		switch(type)
		{
			case "onion": bound.x = width*44/160;bound.y = height*88/160;bound.width = width*67/160;bound.height = height*67/160;break;
		}
	}

	public BufferedImage getCurrentFrame()
	{
		if(bigA)
			return bossAttack.getCurrentFrame();
		
		else if(xMove > 0)
		{
			if(hurtPlayer.getSkillHappen())
				return hurtPlayer.getCurrentFrame();
			else
				return Assets.right_onionBoss[0];
		}
			
		else
		{
			if(hurtPlayer.getSkillHappen())
				return hurtPlayer.getCurrentFrame();
			else
				return Assets.left_onionBoss[0];
		}
			
	}

	@Override
	public void attack() 
	{
		
		if(health <= 25 && bigFirst)
		{
			bigA = true;
			bigFirst = false;
		}
		else if(checkAttack(xa))
		{
			
			hurtPlayer.skilling();
		}
		
			
		
	}

	@Override
	public void tic() {
		if(bigA)
		{
			bossAttack.skilling();
			if(!bossAttack.getSkillHappen())
				bigA = false;
		}
		
	}
	public void bigA()
	{
		if(x > playerX && !fire)
		{
			
				bullet = new Bullet(handler, this,(float)(-324), -108, 0, height*67/160, 315*50/314, 227*50/314, "line");
				bullet.setFire(true);
				bullet.setCurrentF(Assets.bullet);
				bullet.setExF(Assets.bulletEx);
			
				bullet2 = new Bullet(handler, this, -324, 0, 0, height*67/160, 354*50/314, 187*50/314, "line");
				bullet2.setFire(true);
				bullet2.setCurrentF(Assets.bullet2);
				bullet2.setExF(Assets.bullet2Ex);
				
			
				bullet3 = new Bullet(handler, this, (float)(-324), 108, 0, height*67/160, 50, 243*50/314, "line");
				bullet3.setFire(true);
				bullet3.setCurrentF(Assets.bullet3);
				bullet3.setExF(Assets.bullet3Ex);
			fire = true;
		}
		else if(x < playerX && !fire)
		{

			bullet = new Bullet(handler, this,(float)(324), -108, width, height*67/160, 315*50/314, 227*50/314, "line");
			bullet.setFire(true);
			bullet.setCurrentF(Assets.rbullet);
			bullet.setExF(Assets.rbulletEx);
		
			bullet2 = new Bullet(handler, this, 324, 0, width, height*67/160, 354*50/314, 187*50/314, "line");
			bullet2.setFire(true);
			bullet2.setCurrentF(Assets.rbullet2);
			bullet2.setExF(Assets.rbullet2Ex);
			
		
			bullet3 = new Bullet(handler, this, (float)(324), 108, width, height*67/160, 50, 243*50/314, "line");
			bullet3.setFire(true);
			bullet3.setCurrentF(Assets.rbullet3);
			bullet3.setExF(Assets.rbullet3Ex);
		fire = true;
		}
		if(bullet != null && bullet2 != null &&  bullet3 != null)
		{
			bullet.tick();
			bullet2.tick();
			bullet3.tick();
			if(!bullet.isFire() && !bullet2.isFire() && !bullet3.isFire())
				fire = false;
		}
	}
	public void followPlayer()
	{
		
		if(checkAttackWalk(xa) || bigA)
			xMove = 0;
			
		else if(x > playerX)
		{
			xMove = (float) (-speed/(Math.random()*4+3));
			//System.out.println("left");
		}
			
		
		else
		{
			xMove = (float) (speed/(Math.random()*4+3));
			//System.out.println("right");
		}
	}
	public Bullet getBullet() {
		return bullet;
	}

	public Bullet getBullet2() {
		return bullet2;
	}

	public Bullet getBullet3() {
		return bullet3;
	}
}
