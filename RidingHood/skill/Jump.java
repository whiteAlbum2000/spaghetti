package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.Entity;
import RidingHood.entities.creature.Creature;
import RidingHood.entities.creature.Player;

public class Jump extends Skill
{
	
	private float jump, a, yMove;
	private Handler handler;
	private Creature creature;
	
	public Jump(Handler handler, Creature creature, long timerLimit, int tLimit, float a) 
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.a = a;
		this.jump = a/2;
		this.creature = creature;
	
	}

	@Override
	public void skillDo() 
	{
		//if(creature.getY() -jump + a*t/tLimit <= creature.getSpawny())
		{
			//if(t == tLimit)
			{
				//creature.setyMove(0);
				//creature.setY(creature.getSpawny());
			}
			//else
				creature.setyMove(-jump + a*t/tLimit);
		}
			
		//else
		{
			//creature.setyMove(0);
			//creature.setY(creature.getSpawny());
			//System.out.println("jumpt:"+t+"  "+creature.getY() + "  "+(-jump) + "  "+ a*t/tLimit);
		}
			
		
		t++;
		tt++;
	}
	public void skillEnd()
	{
		//creature.setyMove(0);
	}

	@Override
	public BufferedImage getCurrentFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
