package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.gfx.Assets;
import RidingHood.weapon.Weapon;

public class RightGeneralAttack extends Skill
{
	private Handler handler;
	private Weapon weapon;
	private BufferedImage current;
	private String type;
	private double[] xoff = {72, 72, 59, 44, 35}, yoff = {66, 66, 81, 74, 57}, angle = {125, 82, 45, 10, -28}
					,lxoff = {0, 0, 13, 42, 36}, lyoff = {66, 67, 79, 74,57}, langle = {55, 98, 135, 170, 208};
	
	public RightGeneralAttack(Handler handler,Weapon weapon, long timerLimit, int tLimit, String type)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.weapon = weapon;
		this.type = type;
	}
	@Override
	public void skillDo() {
		System.out.println("RightGeneralAttack:"+t);
		if(type == "right")
		{
			weapon.setXoff(xoff[t-1]);
			weapon.setYoff(yoff[t-1]);
			weapon.setStart(angle[t-1]);
			if(handler.getKeyManager().right)
				current = Assets.player_generalwork_right[t-1];
			else
				current = Assets.player_general_right[t-1];
			t++;
			if(handler.getWorld().getEntityManager().getPlayer().isSpaceDouble())
			{reset();weapon.reset();}
		}
		else
		{
			weapon.setXoff(lxoff[t-1]);
			weapon.setYoff(lyoff[t-1]);
			weapon.setStart(langle[t-1]);
			weapon.setDelta(50);
			if(handler.getKeyManager().left)
				current = Assets.player_generalwork_left[t-1];
			else
				current = Assets.player_general_left[t-1];
			t++;
			if(handler.getWorld().getEntityManager().getPlayer().isSpaceDouble())
			{reset();weapon.reset();}
		}
		
		
	}
	public void skillEnd()
	{
		handler.getWorld().getEntityManager().getPlayer().setSkilling(false);
		weapon.reset();
	}
	public BufferedImage getCurrentFrame()
	{
		return current;
	}
}
