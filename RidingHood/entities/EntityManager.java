package RidingHood.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import RidingHood.Handler;
import RidingHood.entities.creature.Player;



public class EntityManager 
{
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private int killed;
	
	public EntityManager(Handler handler, Player player)
	{
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);
		killed = 0;
	}
	private Comparator<Entity> renderSorter = new Comparator<Entity>()
	{
		public int compare(Entity a, Entity b)
		{
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			return 1;
		}
	};
	public void tick() 
	{
		Iterator<Entity> it = entities.iterator();
		while(it.hasNext()){
			Entity e = it.next();
			e.tick();
			if(!e.isActive())
			{
				player.setExp(player.getExp()+e.getExpG());
				if(e.isEnemy())
				{
					killed++;
					System.out.println("killed:"+killed);
				}
				it.remove();
			}
				
		}
		entities.sort(renderSorter);
	}
	public void render(Graphics2D g) 
	{
		for(Entity e : entities)
		{
			e.render(g);
		}
	}
	public void addEntity(Entity e)
	{
		 entities.add(e);
	}
	public Handler getHandler() {
		return handler;
	}
	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	public int getKilled() {
		return killed;
	}
}
