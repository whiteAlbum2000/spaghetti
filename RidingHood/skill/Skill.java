package RidingHood.skill;

import java.awt.image.BufferedImage;

public abstract class Skill 
{
	protected long timer, lastTime, timerLimit;
	protected int skillTime, t = 1, tLimit, tt = 0;
	protected boolean skillHappen;
	public Skill()
	{
		
	}
	
	public void skilling()
	{
		skillHappen = true;
		if(skillTime == 0)
		{
			timer = 0;
			lastTime = System.currentTimeMillis();
			skillTime = 1;
		}
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		if(timer >= timerLimit)
		{
			skillDo();
			timer = 0;
		}
		
		if(t > tLimit)
		{reset();skillEnd();}
	}
	public abstract void skillDo();
	public abstract void skillEnd();
	public abstract BufferedImage getCurrentFrame();
	public boolean getSkillHappen() {return skillHappen;}
	public void reset()
	{
		t = 1;
		skillTime = 0;
		skillHappen = false;
		
		
	}
	public void stop()
	{
		t = tLimit+1;
		
		reset();
		skillEnd();
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public int gettLimit() {
		return tLimit;
	}

	public int getT() {
		return t;
	}
	
}
