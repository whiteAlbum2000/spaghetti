package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.creature.Creature;
import RidingHood.gfx.Assets;
import RidingHood.weapon.Weapon;

public class HurtPlayer extends Skill
{
	private Handler handler;
	private int attackt, amt;
	private String type;
	private BufferedImage[] imageList, imageRist;
	private Creature creature;
	
	public HurtPlayer(Handler handler, Creature creature, long timerLimit, int tLimit, int amt, String type)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.creature = creature;
		this.amt = amt;
		this.type = type;
		decideType();
	}
	@Override
	public void skillDo() {
		if(t == attackt)
		{
			handler.getWorld().getEntityManager().getPlayer().hurt(amt);
			handler.getWorld().getEntityManager().getPlayer().setHurt(true);
			System.out.println("walk hurt");
		}
		else
			handler.getWorld().getEntityManager().getPlayer().setHurt(false);
		t++;
	}

	@Override
	public void skillEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage getCurrentFrame() {
		
		if(creature.getX() > handler.getWorld().getEntityManager().getPlayer().getX())
		{
			if(t < attackt+1)
			{
				if(imageList[t-1] != null)
					return imageList[t-1];
				
			}
			else
					return imageList[0];
		}
		
		else if (creature.getX() < handler.getWorld().getEntityManager().getPlayer().getX())
		{
			if(t < attackt+1)
			{
				if(imageRist[t-1] != null)
					return imageRist[t-1];
			}
			
			else
				return imageRist[0];
		}
		return imageRist[0];
	}
	public void decideType()
	{
		switch(type)
		{
			case "onion":attackt = 3;this.imageList = Assets.walkOnionLA;this.imageRist = Assets.walkOnionRA;
			case "boss": attackt =2;this.imageList = Assets.left_onionBoss;this.imageRist = Assets.right_onionBoss;
		}
	}
}
