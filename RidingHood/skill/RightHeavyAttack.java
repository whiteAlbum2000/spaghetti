package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.creature.Creature;
import RidingHood.entities.creature.Player;
import RidingHood.gfx.Assets;
import RidingHood.weapon.Weapon;

public class RightHeavyAttack extends Skill
{
	private Handler handler;
	private double[] xoff = {6, 6, 6, 6, 9, 0, 0, 0, 0}, yoff = {33, 33, 33, 47, 59, 0, 0, 0, 0};
	private Weapon weapon;
	private BufferedImage current;
	private String type;
	
	public RightHeavyAttack(Handler handler, Weapon weapon, long timerLimit, int tLimit, String type)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.weapon = weapon;
		this.type = type;
	}
	@Override
	public void skillDo() {
		System.out.println("heavyAttack:"+t);
		handler.getWorld().getEntityManager().getPlayer().setCross(true);  
		weapon.setAttackCoe(handler.getPlayer().getRank()*5);
		if(type == "right")
		{
			if(t >= 5)
				current = Assets.player_right_h[2];
			else if(t == 4)
				current = Assets.player_right_h[1];
			else
				current = Assets.player_right_h[0];
		}
		else
		{
			if(t >= 5)
				current = Assets.player_left_h[2];
			else if(t == 4)
				current = Assets.player_left_h[1];
			else
				current = Assets.player_left_h[0];
		}
		if(handler.getWorld().getEntityManager().getPlayer().getY() + 40 <= handler.getWorld().getSpawnY() )
			handler.getWorld().getEntityManager().getPlayer().setyMove(40);
		else
			handler.getWorld().getEntityManager().getPlayer().setyMove(handler.getWorld().getSpawnY() - handler.getWorld().getEntityManager().getPlayer().getY());
		weapon.setStart(8);
		if(t <= 5)
			weapon.setXoff(xoff[t-1]);weapon.setYoff(yoff[t-1]);
		if(t > 5)
		{
			weapon.setXoff(xoff[3]);weapon.setYoff(yoff[3]);
		}
		if(t > 7)
			timerLimit = 350;
		if(t == 1)
			timerLimit = 100;
		if(t == 2)
			timerLimit = 5;
			
		
		t++;
		
	}
	public void skillEnd()
	{
		handler.getWorld().getEntityManager().getPlayer().setCross(false);
		handler.getWorld().getEntityManager().getPlayer().setSkilling(false);
		weapon.setAttackCoe(handler.getPlayer().getRank()*3);
		weapon.reset();
		timerLimit = 5;
	}
	@Override
	public BufferedImage getCurrentFrame() {
		
		return current;
	}
}
