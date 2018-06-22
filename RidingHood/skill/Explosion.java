package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.gfx.Assets;
import RidingHood.weapon.Bullet;

public class Explosion extends Skill
{
	private Handler handler;
	private Bullet bullet;
	
	public Explosion(Handler handler, Bullet bullet, long timerLimit, int tLimit)
	{
		this.handler = handler;
		this.bullet = bullet;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
	}
	@Override
	public void skillDo() {
		
		
			bullet.setCurrentF(bullet.getExF());
			bullet.setHeight(bullet.getWidth()+10 - 5*t);
			bullet.setWidth(bullet.getHeight()+10 - 5*t);
		t++;
	}

	@Override
	public void skillEnd() {
		// TODO Auto-generated method stub
		bullet.setDie(true);;
	}

	@Override
	public BufferedImage getCurrentFrame() {
		// TODO Auto-generated method stub
		return null;
	}

}
