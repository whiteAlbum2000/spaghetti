package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.creature.Boss;
import RidingHood.gfx.Assets;

public class BossAttack extends Skill
{
	private Handler handler;
	private Boss boss;

	
	public BossAttack(Handler handler, Boss boss, long timerLimit)
	{
		this.handler = handler;
		this.boss = boss;
		this.timerLimit = timerLimit;
		this.tLimit = 25;
	}
	@Override
	public void skillDo() 
	{
		t++;
	}

	@Override
	public void skillEnd() {
		boss.bigA();
		
		
	}

	@Override
	public BufferedImage getCurrentFrame() 
	{
		if(boss.getX() > handler.getWorld().getEntityManager().getPlayer().getX())
		{
			if(t >= 2 && t<= 6)
				return Assets.left_onionBossA[1];
			else if(t >= 7 && t <= 10)
				return Assets.left_onionBossA[t-5];
			else if(t >= 11 && t <= 14)
				return Assets.left_onionBossA[5];
			else if(t >= 15 && t <= 16)
				return Assets.left_onionBossA[t-9];
			else if(t >= 17 && t<= 21)
				return Assets.left_onionBossA[8];
			else if(t >= 22 && t <= 24)
				return Assets.left_onionBossA[9];
			else if(t == 25)
				return Assets.left_onionBossA[10];
			else
				return Assets.left_onionBossA[t-1];
		}
			
		else
		{

			if(t >= 2 && t<= 6)
				return Assets.right_onionBossA[1];
			else if(t >= 7 && t <= 10)
				return Assets.right_onionBossA[t-5];
			else if(t >= 11 && t <= 14)
				return Assets.right_onionBossA[5];
			else if(t >= 15 && t <= 16)
				return Assets.right_onionBossA[t-9];
			else if(t >= 17 && t<= 21)
				return Assets.right_onionBossA[8];
			else if(t >= 22 && t <= 24)
				return Assets.right_onionBossA[9];
			else if(t == 25)
				return Assets.right_onionBossA[10];
			else
				return Assets.right_onionBossA[t-1];
		}
			
		
	}

}
