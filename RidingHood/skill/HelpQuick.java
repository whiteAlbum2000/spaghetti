package RidingHood.skill;

import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.gfx.Assets;

public class HelpQuick extends Skill
{
	private Handler handler;
	public HelpQuick(Handler handler, long timerLimit, int tLimit)
	{
		this.handler = handler;
		this.timerLimit = timerLimit;
		this.tLimit = tLimit;
	}
	@Override
	public void skillDo() {
		t++;
		
	}

	@Override
	public void skillEnd() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage getCurrentFrame() {
		
		return Assets.player_quick_right;
	}

}
