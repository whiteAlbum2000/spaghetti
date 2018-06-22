package RidingHood.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import RidingHood.Handler;
import RidingHood.entities.creature.Creature;
import RidingHood.entities.creature.Player;
import RidingHood.entities.staticc.Ground;


public abstract class Entity 
{
	protected int health, hurtTime = 0;
	protected static final int DEFAULT_HEALTH = 10;
	protected Handler handler;
	protected float x, y, spawny;
	protected int width, height, expG;
	protected Rectangle bound;
	protected boolean active = true, enemy = true, hurt = false, xintercross = false, yintercross = false, cross = false, ground = false;
	
	public Entity(Handler handler, float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.spawny = y;
		this.width = width;
		this.height = height;
		this.handler = handler;
		health = DEFAULT_HEALTH;
		bound = new Rectangle(0, 0, width, height);
	}
	public abstract void tick();
	public abstract void render(Graphics2D g);
	public abstract void die();
	
	public void hurt(int amt)
	{	
		
		//System.out.println("hurt");
		hurt = false;
		if(health <= 0)
		{
			active = false;
			die();
		}
		else
			health -= amt;
	}
	
	public boolean checkPlayerCollision(float xoffset, float yoffset)
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this)) 
				continue;				
			if((Math.abs(-e.y-e.bound.y - e.bound.height/2 + y + bound.y + bound.height/2)+1 < (e.bound.height + bound.height)/2 && e.isEnemy()) 
					&& (Math.abs(-e.x-e.bound.x - e.bound.width/2 + x + bound.x + bound.width/2) < (e.bound.width + bound.width)/2))
				{yintercross = true;xintercross = true;}
			else
			{
				xintercross = false;
				yintercross = false;
			}
				
			if(e.getCollisionBound(0f, 0f).intersects(getCollisionBound(xoffset, yoffset)))
				return true;
		}
		return false;
	}
	public boolean checkEntityCollision(float xoffset, float yoffset)
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this)) 
				continue;
			if((Math.abs(-e.x-e.bound.x - e.bound.width/2 + x + bound.x + bound.width/2) < (e.bound.width + bound.width)/2) && e.isEnemy())
			{yintercross = true;xintercross = true;}
			else
			{
				xintercross = false;
				yintercross = false;
			}
			if(e.getCollisionBound(0f, 0f).intersects(getCollisionBound(xoffset, yoffset)))
				return true;
		}	
		return false;
	}
	public Rectangle getCollisionBound(float xOffset, float yOffset)
	{
		return new Rectangle((int)(x + bound.x +xOffset), (int)(y + bound.y + yOffset), bound.width, bound.height);
	}
	
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Rectangle getBound() {
		return bound;
	}
	public boolean isEnemy() {
		return enemy;
	}
	public boolean isHurt() {
		return hurt;
	}
	public void setHurt(boolean hurt) {
		this.hurt = hurt;
	}
	public int getHurtTime() {
		return hurtTime;
	}
	public void setHurtTime(int hurtTime) {
		this.hurtTime = hurtTime;
	}
	public void setCross(boolean cross) {
		this.cross = cross;
	}
	public float getSpawny() {
		return spawny;
	}
	public int getExpG() {
		return expG;
	}
}
