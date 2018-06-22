package RidingHood.skill;

import java.awt.image.BufferedImage;
import RidingHood.Handler;
import RidingHood.entities.creature.Enemy;
import RidingHood.weapon.Bullet;
public class Line extends Skill
{
	private Handler handler;
	private Bullet bullet;
	private Enemy enemy;

	
	
	public Line(Handler handler, Bullet bullet, Enemy enemy, long timerLimit)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = 2;
		this.bullet = bullet;
		this.enemy = enemy;
	}
	

	@Override
	public void skillDo()
	{
		if(enemy.isFire())
		{
			if(bullet != null)
			{
				bullet.setXoff(bullet.getXoff() + bullet.getXdelta()/20);
				bullet.setYoff(bullet.getYoff() + bullet.getYdelta()/20);
			}
			
		}
		
	}

	@Override
	public void skillEnd() {
		
		
	}

	@Override
	public BufferedImage getCurrentFrame() {
		
		return null;
	}
}
