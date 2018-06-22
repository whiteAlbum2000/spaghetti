package RidingHood.tiles;

import java.awt.Graphics2D;


import RidingHood.gfx.Assets;

public class BlueSkyTile extends Tile
{

	public BlueSkyTile(int id) 
	{
		super(Assets.blueSky, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
	

}
