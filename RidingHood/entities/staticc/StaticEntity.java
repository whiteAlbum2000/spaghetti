package RidingHood.entities.staticc;

import RidingHood.Handler;
import RidingHood.entities.Entity;

public abstract class StaticEntity extends Entity
{
	protected static final int STATIC_WIDTH = 64, STATIC_HEIGHT = 64;
	public StaticEntity(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
	}
}
