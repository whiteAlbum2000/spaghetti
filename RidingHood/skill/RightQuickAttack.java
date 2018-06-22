package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.creature.Creature;
import RidingHood.entities.creature.Player;
import RidingHood.weapon.Weapon;

public class RightQuickAttack extends Skill
{
	private Handler handler;
	private Weapon weapon;
	private String type;
	
	public RightQuickAttack(Handler handler, Weapon weapon, long timerLimit, int tLimit, String type)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
		this.weapon = weapon;
		this.type = type;
	}
	@Override
	public void skillDo() {
		System.out.println("RightQuickAttack:"+t);
		handler.getWorld().getEntityManager().getPlayer().setCross(true);
		weapon.setAttackCoe(handler.getPlayer().getRank()*2);
		
		if(type == "right")
		{
			handler.getWorld().getEntityManager().getPlayer().setxMove(handler.getWorld().getEntityManager().getPlayer().getxMove() + 30);
			weapon.setXoff(51);
			weapon.setYoff(20);
			weapon.setStart(-73);
		}
		else
		{
			handler.getWorld().getEntityManager().getPlayer().setxMove(handler.getWorld().getEntityManager().getPlayer().getxMove() - 30);
			weapon.setXoff(22);
			weapon.setYoff(21);
			weapon.setStart(-107);
			weapon.setDelta(50);
		}
		t++;
		
	}
	
	public void skillEnd()
	{
		handler.getWorld().getEntityManager().getPlayer().setCross(false);
		handler.getWorld().getEntityManager().getPlayer().setSkilling(false);
		weapon.setAttackCoe(handler.getPlayer().getRank()*3);
		weapon.reset();
	}
	@Override
	public BufferedImage getCurrentFrame() {
		// TODO Auto-generated method stub
		return null;
	}
}
