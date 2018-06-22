package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class NightSkyA extends Tile
{
	public NightSkyA(int id) 
	{
		super(Assets.nightSkyA, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
}
