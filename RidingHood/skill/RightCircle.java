package RidingHood.skill;

import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.Entity;
import RidingHood.gfx.Assets;
import RidingHood.weapon.Weapon;

public class RightCircle extends Skill
{
	private Handler handler;
	private Weapon weapon;
	protected Arc2D attackBound;
	private String type;
	
	public RightCircle(Handler handler, Weapon weapon, long timerLimit, int tLimit, String type)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.weapon = weapon;
		attackBound = new Arc2D.Double();
		this.type = type;
	}
	@Override
	public void skillDo() {
		System.out.println("RightCircle:"+t);
		tick();
		weapon.setXoff(10);
		weapon.setYoff(16);
		weapon.setWidth(136);
		weapon.setHeight(136);
		weapon.setStart(45 + 60*(t-1));
		weapon.setDelta(60*t);
		checkCircleBound();
		t++;
	}

	@Override
	public void skillEnd() {
		
		handler.getWorld().getEntityManager().getPlayer().setSkilling(false);
		weapon.reset();
	}

	@Override
	public BufferedImage getCurrentFrame() {
		if(type == "right")
			return Assets.player_right_c[t-1];
		else
			return Assets.player_left_c[t-1];
	}
	public void tick()
	{
		
		attackBound.setArc(handler.getWorld().getEntityManager().getPlayer().getX()+10, handler.getWorld().getEntityManager().getPlayer().getY()+16, 
				136, 136, 0, 360, Arc2D.CHORD);
	}
	public void checkCircleBound()
	{
		for(Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.isEnemy())
			{
				
				if(attackBound.intersects(e.getCollisionBound(0f,0f)))
				{
					handler.getWorld().getEntityManager().getPlayer().setyMove(- 10);
				}
				
					
			}
		}
	}

}
