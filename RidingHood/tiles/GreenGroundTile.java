package RidingHood.tiles;

import java.awt.Graphics2D;


import RidingHood.gfx.Assets;

public class GreenGroundTile extends Tile
{

	public GreenGroundTile(int id) 
	{
		super(Assets.greenGround, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
	}

}
