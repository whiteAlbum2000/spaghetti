package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.creature.Creature;
import RidingHood.weapon.Weapon;

public class Sin extends Skill
{
	private Handler handler;
	private Weapon weapon;
	private BufferedImage current;
	private float a, w;
	private Creature creature;
	private String tri;
	
	
	public Sin(Handler handler, Creature creature, long timerLimit, int tLimit, float a, String tri)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.weapon = weapon;
		this.a = a;
		this.w = w;
		this.creature = creature;
		this.tri = tri;
	}
	@Override
	public void skillDo() 
	{
		if(tri == "cos")
			creature.setyMove((float)- Math.sin(2*Math.PI*t/tLimit)*a);
		else
			creature.setyMove((float) Math.cos(2*Math.PI*t/tLimit)*a);
		//System.out.println("sin: "+t);
		t++;
		tt++;
	}

	@Override
	public void skillEnd() 
	{
		creature.setY(creature.getSpawny());;
		
	}

	@Override
	public BufferedImage getCurrentFrame() {
		
		return null;
	}

}
