package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.creature.Creature;
import RidingHood.weapon.Weapon;

public class Circle extends Skill
{
	private Handler handler;
	private Weapon weapon;
	private BufferedImage current;
	private float r, rx;
	private Creature creature;
	
	
	public Circle(Handler handler, Creature creature, long timerLimit, int tLimit, float r)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.weapon = weapon;
		this.r = r;
		this.creature = creature;
		
	}
	@Override
	public void skillDo() {
		if(t == 1)
			this.rx = creature.getxMove();
		creature.setyMove((float) (-r*Math.cos(2*Math.PI*t/tLimit)));
		creature.setxMove((float) (r*Math.sin(2*Math.PI*t/tLimit)));
		t++;
		tt++;
	}

	@Override
	public void skillEnd() {
		
		creature.setxMove(-rx);
	}

	@Override
	public BufferedImage getCurrentFrame() {
		// TODO Auto-generated method stub
		return null;
	}

}
