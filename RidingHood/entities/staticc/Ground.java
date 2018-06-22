package RidingHood.entities.staticc;

import java.awt.Graphics2D;

import RidingHood.Handler;
import RidingHood.gfx.Assets;
import RidingHood.tiles.Tile;
public class Ground extends StaticEntity 
{

	public Ground(Handler handler, int swidth) {
		super(handler, 0f, 516f, swidth, Tile.GROUND_TILE_HEIGHT);
		bound.x = 0;
		bound.y = 44;
		bound.width = swidth;
		bound.height = 88;
		enemy = false;
		ground = true;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		g.drawImage(Assets.nothing, (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.fillRect((int)(x+bound.x - handler.getGameCamera().getxOffset()), (int)(y+bound.y - handler.getGameCamera().getyOffset()), bound.width, bound.height);
	}

	@Override
	public void die() {
		// TODO Auto-generated method stub
		
	}
	
}
