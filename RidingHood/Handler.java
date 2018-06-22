package RidingHood;

import java.util.ArrayList;

import RidingHood.entities.creature.Player;
import RidingHood.gfx.GameCamera;
import RidingHood.input.KeyManager;
import RidingHood.input.MouseManager;
import RidingHood.weapon.Bullet;
import RidingHood.world.World;

public class Handler 
{
	private Game game;
	private World world;
	private Player player;
	private ArrayList<Bullet> bullet;
	
	public Handler(Game game)
	{
		this.game = game;
		bullet = new ArrayList<Bullet>();
	}
	public World getWorld() {return world;}
	public void setWorld(World world) {this.world = world;}
	public int getGameWidth() {return game.getGameWidth();}
	public int getGameHeight() {return game.getGameHeight();}
	public GameCamera getGameCamera() {return game.getGameCamera();}
	public KeyManager getKeyManager() {return game.getKeyManager();}
	public void addBullet(Bullet bullet) {this.bullet.add(bullet);}
	public ArrayList<Bullet> getBullet(){return bullet;}
	public MouseManager getMouseManager() {return game.getMouseManager();}
	public Game getGame() {return game;}
	public void setPlayer(Player player) {this.player = player;}
	public Player getPlayer() {return player;}
}
