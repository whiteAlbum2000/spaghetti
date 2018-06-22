package RidingHood.entities.staticc;

import java.awt.Graphics2D;

import RidingHood.Handler;

public class TestEnemy extends StaticEntity{

	public TestEnemy(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		// TODO Auto-generated constructor stub
		bound.x = 0;
		bound.y = 0;
		bound.width = 100;
		bound.height = 100;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(hurt)
		{
			hurt(0);
			
		}
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.fillRect((int)(x+bound.x - handler.getGameCamera().getxOffset()), (int)(y+bound.y - handler.getGameCamera().getyOffset()), bound.width, bound.height);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}

}
