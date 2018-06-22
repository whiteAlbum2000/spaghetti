package RidingHood.weapon;

import java.awt.geom.Arc2D;

import RidingHood.Handler;
import RidingHood.entities.Entity;

public class GeneralSword extends Weapon
{

	public GeneralSword(Handler handler, double x, double y) {
		super(handler);
		this.x = x;
		this.y = y;
		this.xoff = 34;
		this.yoff = 48;
		this.width = 86;
		this.height = 86;
		this.start = -45;
		this.delta = -50;
		this.rstart = -45;
		this.attackBound.setArc(x+xoff, y+yoff, width, height, start, delta, Arc2D.CHORD);
		this.attackCoe = 3;
		
	}
	public void tick() 
	{
		x = handler.getWorld().getEntityManager().getPlayer().getX();
		y = handler.getWorld().getEntityManager().getPlayer().getY();
		checkAttackBound();
		setBound(xoff, yoff, width, height,  start, delta);
		
	}
	public void reset()
	{
		this.xoff = 34;
		this.yoff = 48;
		this.width = 86;
		this.height = 86;
		this.start = -45;
		this.delta = -50;
		
	}
	public void checkAttackBound()
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.isEnemy())
			{
				
				if(attackBound.intersects(e.getCollisionBound(0f,0f)) && e.getHurtTime() == 0)
				{
					e.setHurt(true);
					e.setHurtTime(1);
					System.out.println("player hurt");
				}
				if(!attackBound.intersects(e.getCollisionBound(0f,0f)))
				{
					e.setHurtTime(0);
				}
					
			}
		}
		
	}
}
