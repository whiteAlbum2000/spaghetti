package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class NightGroundTile extends Tile
{
	public NightGroundTile(int id) 
	{
		super(Assets.nightGround, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
}
