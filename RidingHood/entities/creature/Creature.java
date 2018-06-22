package RidingHood.entities.creature;

import RidingHood.Handler;
import RidingHood.entities.Entity;
import RidingHood.tiles.Tile;

public abstract class Creature extends Entity
{
	
	protected static final float DEFAULT_SPEED = 5.0f;
	public static final float DEFAULT_A = 130.0f;
	protected static final int CREATURE_WIDTH = 160, CREATURE_HEIGHT = 160;
	protected float speed, xMove, yMove;
	
	
	
	public Creature(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}
	public abstract void move();
	public void moveX()
	{
		if(xMove > 0)
		{
			if(x + xMove + width> 1296*handler.getWorld().getWorldWidth())
				x =  1296*handler.getWorld().getWorldWidth() - width;
			else
				x += xMove;
		}
		else if(xMove < 0)
		{
			if(x+xMove+bound.x < 0)
				x = 0;
			else
				x += xMove;
		}
	}
	public void moveY()
	{
		if(yMove > 0)
		{
			if(y+yMove > spawny)
				y = spawny;
			else
				y += yMove;
		}
		else if(yMove < 0)
		{
			if(y + yMove < 0)
				y = 0;
			else
				y += yMove;
		}
	}
	
	public float getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public float getSpeed() {
		return speed;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
}