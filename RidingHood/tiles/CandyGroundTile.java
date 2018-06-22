package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class CandyGroundTile extends Tile
{
	public CandyGroundTile(int id) 
	{
		super(Assets.candyGround, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
}
