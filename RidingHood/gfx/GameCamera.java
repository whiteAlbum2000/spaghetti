package RidingHood.gfx;

import RidingHood.Handler;
import RidingHood.entities.Entity;
import RidingHood.tiles.Tile;

public class GameCamera 
{
	private float xOffset, yOffset;
	private Handler handler;
	public GameCamera(Handler handler, float xOffset, float yOffset)
	{
		this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.handler = handler;
	}
	public void checkBlankSpace()
	{
		if(xOffset < 0)
			xOffset = 0;
		else if(xOffset > handler.getWorld().getWorldWidth()*Tile.SKY_TILE_WIDTH - handler.getGameWidth())
			xOffset = handler.getWorld().getWorldWidth()*Tile.SKY_TILE_WIDTH - handler.getGameWidth();
		if(yOffset < 0)
			yOffset = 0;
		else if(yOffset > handler.getWorld().getWorldHeight()*Tile.SKY_TILE_HEIGHT - handler.getGameHeight())
			yOffset = handler.getWorld().getWorldHeight()*Tile.SKY_TILE_HEIGHT - handler.getGameHeight();
		
	}
	public void centerOnEntity(Entity e)
	{
		xOffset = e.getX() - handler.getGameWidth()/2 + e.getWidth()/2;
		yOffset = e.getY() - handler.getGameHeight()/2 + e.getHeight()/2;
		checkBlankSpace();
	}
	public void move(float xAmount, float yAmount)
	{
		xOffset += xAmount;
		yOffset += yAmount;
		checkBlankSpace();
	}
	public float getxOffset() {
		return xOffset;
	}
	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}
	public float getyOffset() {
		return yOffset;
	}
	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}
	
}
