package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class CandySkyTile extends Tile
{
	public CandySkyTile(int id) 
	{
		super(Assets.candySky, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
}
