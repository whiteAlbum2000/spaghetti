package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;


public class GreenTreeTile extends Tile
{

	public GreenTreeTile(int id) 
	{
		super(Assets.greenTree, id);
		
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
	}

}
