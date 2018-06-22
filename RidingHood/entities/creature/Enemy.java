package RidingHood.entities.creature;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import RidingHood.Handler;
import RidingHood.entities.Entity;
import RidingHood.skill.HurtPlayer;
import RidingHood.skill.Skill;

public abstract class Enemy extends Creature
{
	protected boolean detected = false, fire = false;
	protected float playerX, xd ,xa, pcx, pcy;;
	protected int ar, amt;
	protected Skill hurtPlayer;
	
	public Enemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		
		
		
	}

	@Override
	public void tick() 
	{
		playerX = handler.getWorld().getEntityManager().getPlayer().getX() +  handler.getWorld().getEntityManager().getPlayer().getBound().x ;
		detectBound(xd);
		if(detected)
		{
			followPlayer();
			attack();
			//System.out.println("detect");
		}
		
		actRange(ar);
		move();
		if(hurt)
			hurt((int)handler.getPlayer().getWeapon().getAttackCoe()*handler.getPlayer().getRank());
		pcx = handler.getWorld().getEntityManager().getPlayer().getX() + handler.getWorld().getEntityManager().getPlayer().getWidth()/2 
				-x - width/2;
		pcy = handler.getWorld().getEntityManager().getPlayer().getY() + handler.getWorld().getEntityManager().getPlayer().getHeight()/2 
				-y - height/2;
		tic();
	}
	public void move()
	{
		if(!checkEntityCollision(xMove, 0f) || cross || xintercross)
			moveX();
		if(!checkEntityCollision(0f, yMove) || cross || yintercross)
			moveY();
	}

	@Override
	public void die() {
		
		
	}
	public void detectBound(float xd)
	{
		if(playerX >= x + bound.x- xd && playerX <= x + bound.x + bound.width + xd)
			detected = true;
	}
	public abstract void actRange(int ar);
	public void followPlayer()
	{
		
		if(checkAttackWalk(xa))
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
	public abstract void attack();
	public boolean checkAttack(float xa)
	{
		if(getAttackBound(xa).intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0f, 0f)))
			return true;
		return false;
	}
	public boolean checkAttackWalk(float xa)
	{
		if(getAttackWalkBound(xa).intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0f, 0f)))
			return true;
		return false;
	}
	public Rectangle getAttackWalkBound(float xoff)
	{
		return new Rectangle((int)(x + bound.x - xoff), 0, (int)(bound.width + 2*xoff), 648);
	}
	public Rectangle getAttackBound(float xoff)
	{
		return new Rectangle((int)(x + bound.x - xoff), (int)(y + bound.y), (int)(bound.width + 2*xoff), bound.height);
	}
	public abstract void tic();
	public float getXa() {
		return xa;
	}
	public boolean isFire()
	{
		return fire;
	}
	public void setFire(boolean fire)
	{
		this.fire = fire;
	}

	public int getAmt() {
		return amt;
	}

	
}
