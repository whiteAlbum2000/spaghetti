package RidingHood.tiles;

import java.awt.Graphics2D;

import RidingHood.gfx.Assets;

public class NightSkyB extends Tile
{
	public NightSkyB(int id) 
	{
		super(Assets.nightSkyB, id);
	}

	@Override
	public void render(Graphics2D g, int x, int y) 
	{
		g.drawImage(texture, x, y, null);
		
	}
}
