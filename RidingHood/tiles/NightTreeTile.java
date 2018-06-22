package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class NightTreeTile extends Tile
{
	public NightTreeTile(int id) 
	{
		super(Assets.nightTree, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
}
