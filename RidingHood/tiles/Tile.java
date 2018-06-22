package RidingHood.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public abstract class Tile 
{
	public static Tile[] tile = new Tile[10];
	public static Tile blueSkyTile = new BlueSkyTile(0);
	public static Tile greenTreeTile = new GreenTreeTile(1);
	public static Tile greenGroundTile = new GreenGroundTile(2);
	public static Tile candySkyTile = new CandySkyTile(3);
	public static Tile candyTreeTile = new CandyTreeTile(4);
	public static Tile candyGroundTile = new CandyGroundTile(5);
	public static Tile nightSkyA = new NightSkyA(6);
	public static Tile nightSkyB = new NightSkyB(7);
	public static Tile nightTreeTile = new NightTreeTile(8);
	public static Tile nightGroundTile = new NightGroundTile(9);
	
	public static final int SKY_TILE_WIDTH = 1296, SKY_TILE_HEIGHT = 648;
	public static final int TREE_TILE_WIDTH = 648, TREE_TILE_HEIGHT = 648;
	public static final int GROUND_TILE_WIDTH = 648, GROUND_TILE_HEIGHT = 132;
	
	protected BufferedImage texture;
	protected final int id;
	public Tile(BufferedImage texture, int id)
	{
		this.texture = texture;
		this.id = id;
		tile[id] = this;
	}
	public abstract void render(Graphics2D g, int x, int y);
	public int getId() {return id;}
	public boolean isSolid() {return false;}
	
}
