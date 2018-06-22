package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class CandyTreeTile extends Tile
{
	public CandyTreeTile(int id) 
	{
		super(Assets.candyTree, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
}
