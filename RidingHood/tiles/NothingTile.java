package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class NothingTile extends Tile
{

	public NothingTile(int id) 
	{
		super(Assets.nothing, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(Graphics2D g, int x, int y)
	{
		// TODO Auto-generated method stub
		g.drawImage(texture, x, y, null);
	}

}
