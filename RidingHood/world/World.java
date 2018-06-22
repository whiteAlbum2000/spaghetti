package RidingHood.world;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Iterator;

import RidingHood.Handler;
import RidingHood.entities.EntityManager;
import RidingHood.entities.creature.Boss;
import RidingHood.entities.creature.FlyEnemy;
import RidingHood.entities.creature.Player;
import RidingHood.entities.creature.WalkEnemy;
import RidingHood.tiles.Tile;
import RidingHood.ui.ClickListener;
import RidingHood.ui.UIImageButton;
import RidingHood.ui.UIManager;
import RidingHood.utils.Utils;
import RidingHood.weapon.Bullet;
import RidingHood.entities.staticc.Ground;
import RidingHood.gfx.Assets;
import RidingHood.gfx.Text;
//import RidingHood.entities.staticc.TestEnemy;
import RidingHood.states.GameState;
import RidingHood.states.MapState;
import RidingHood.states.State;


public class World 
{
	private EntityManager entityManager;
	private Handler handler;
	private String info;
	private UIManager uiManager;
	private int kill, enemy;
	
	public World(Handler handler, String path)
	{
		loadWorld(path);
		this.handler = handler; 
		if(handler.getPlayer() != null)
		{
			entityManager = new EntityManager(handler, handler.getPlayer());
		}
		else
		{
			entityManager = new EntityManager(handler, new Player(handler, 0, 410));
			handler.setPlayer(entityManager.getPlayer());
		}
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		uiManager.addObject(new UIImageButton(1200, 552, 96, 96, Assets.info, new ClickListener() {
			@Override
			public void onClick() {
				
			}}
		));
		uiManager.addObject(new UIImageButton(5, 5, 69, 69, Assets.back, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().mapState = new MapState(handler);
				State.setState(handler.getGame().mapState);
			}}
		));
		entityManager.addEntity(new Ground(handler, Tile.SKY_TILE_WIDTH*3));
		//entityManager.addEntity(new TestEnemy(handler, 648, 450, 100, 100));
		//entityManager.addEntity(new WalkEnemy(handler, 648, 430, 160, 160, 3, 0, 20, 200, "onion"));
		//entityManager.addEntity(new WalkEnemy(handler, 848, 410, 160, 160, 3, 0, 25, 200, "onion"));
		//entityManager.addEntity(new FlyEnemy(handler, 648, 150, 150, 150, 1, 0, 50, 200, "onion"));
		//entityManager.addEntity(new FlyEnemy(handler, 848, 150, 80, 80, 1, 0, 25, 200, "onion"));
		//entityManager.addEntity(new Boss(handler, 848, 200, 350, 350, 1, 0, 50, 200, "onion"));
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
		entityManager.getPlayer().setHealth(entityManager.getPlayer().getHealthL());
		entityManager.getPlayer().setActive(true);
		kill = 0;
		addEnemy();
	}
	
	private int width, height, spawnX, spawnY;
	private int[] skyTile, treeTile, groundTile;
	
	public void render(Graphics2D g)
	{
		int sxStart = Math.max(0, (int)(handler.getGameCamera().getxOffset()/Tile.SKY_TILE_WIDTH));
		int sxEnd = Math.min(width, (int)((handler.getGameCamera().getxOffset() + handler.getGameWidth())/Tile.SKY_TILE_WIDTH) + 1);
		int gxStart = Math.max(0, (int)(handler.getGameCamera().getxOffset()/Tile.GROUND_TILE_WIDTH));
		int gxEnd = Math.min(width*2, (int)((handler.getGameCamera().getxOffset() + handler.getGameWidth())/Tile.GROUND_TILE_WIDTH) + 1);
		int txStart = Math.max(0, (int)(handler.getGameCamera().getxOffset()/Tile.TREE_TILE_WIDTH));
		int txEnd = Math.min(width*2, (int)((handler.getGameCamera().getxOffset() + handler.getGameWidth())/Tile.TREE_TILE_WIDTH) + 1);
		for(int x = sxStart;x < sxEnd;x++)
			getSkyTile(x).render(g, (int)(x*Tile.SKY_TILE_WIDTH - handler.getGameCamera().getxOffset()), 0);
		for(int x = gxStart;x < gxEnd;x++)
			getGroundTile(x).render(g, (int)(x*Tile.GROUND_TILE_WIDTH - handler.getGameCamera().getxOffset()), 516);
		for(int x = txStart;x < txEnd;x++)
			getTreeTile(x).render(g, (int)(x*Tile.TREE_TILE_WIDTH - handler.getGameCamera().getxOffset()), 0);
		
		entityManager.render(g);
		g.drawImage(Assets.hp, 0, 560, 192, 67, null);
		Text.drawString(g, "HP:"+entityManager.getPlayer().getHealth(), 110, 600, true, Color.orange, Assets.font30);
		uiManager.render(g);
		infoRender(g);
		lose(g);
		win(g);
	}
	public void tick() 
	{
		entityManager.tick();
		uiManager.tick();
		Iterator<Bullet> it = handler.getBullet().iterator();
		while(it.hasNext())
		{
			Bullet b = it.next();
			b.tick();
			if(b.isDie())
				it.remove();
		}
		info = "Rank: " + handler.getPlayer().getRank() +"    exp: "+ handler.getPlayer().getExp()+"/"+handler.getPlayer().getExpL()
				+"   ATK: "+handler.getPlayer().getWeapon().getAttackCoe()*handler.getPlayer().getRank();
	}
	public Tile getSkyTile(int x)
	{
		if(x < 0 || x >= width)
			return Tile.blueSkyTile;
		Tile t = Tile.tile[skyTile[x]];
		if(t == null)
			return Tile.blueSkyTile;
		return t;
	}
	public Tile getTreeTile(int x)
	{
		if(x < 0 || x >= width*2)
			return Tile.greenTreeTile;
		Tile t = Tile.tile[treeTile[x]];
		if(t == null)
			return Tile.greenTreeTile;
		return t;
	}
	public Tile getGroundTile(int x)
	{
		if(x < 0 || x >= width*2)
			return Tile.greenGroundTile;
		Tile t = Tile.tile[groundTile[x]];
		if(t == null)
			return Tile.greenGroundTile;
		return t;
	}
	
	private void loadWorld(String path) 
	{
		String file = Utils.LoadFileAsString(path);
		String[] token = file.split("\\s+");
		width = Utils.parseInt(token[0]);
		height = Utils.parseInt(token[1]);
		spawnX = Utils.parseInt(token[2]);
		spawnY = Utils.parseInt(token[3]);
		enemy = Utils.parseInt(token[4]);
		System.out.println("width:"+width);
		skyTile = new int[width];
		treeTile = new int[width*2];
		groundTile = new int[width*2];
		for(int i = 0;i < width;i++)
		{
			skyTile[i] = Utils.parseInt(token[i+4]);
		}
		for(int i = 0;i < width*2;i++)
		{
			treeTile[i] = Utils.parseInt(token[i+4+width]);
		}
		for(int i = 0;i < width*2;i++)
		{
			groundTile[i] = Utils.parseInt(token[i+4+width*3]);
		}
	}
	public void addEnemy()
	{
		if(enemy == 0)
		{
			for(int j = 1;j < 7;j++)
			{
				for(int i = 0;i < 3;i++,kill++)
					entityManager.addEntity(new WalkEnemy(handler, (float)((Math.random()*1000+(j-1)*1000)), spawnY, 160-i*5, 160-i*5,
						3, 2, (int)(20+Math.random()*30), (int)(100+Math.random()*50), "onion"));
			}
			
		}
		else if(enemy == 3)
		{
			for(int j = 1;j < 7;j++)
			{
				for(int i = 0;i < 2;i++,kill++)
					entityManager.addEntity(new WalkEnemy(handler, (float)((Math.random()*1000+(j-1)*1000)), spawnY, 160-i*5, 160-i*5,
						3, 2, (int)(20+Math.random()*30), (int)(100+Math.random()*50), "onion"));
				for(int i = 0;i < 2;i++,kill++)
					entityManager.addEntity(new FlyEnemy(handler, (float)(348+(Math.random()*1000+(j-1)*1000)), (int)(150+Math.random()*10), 150-i*5, 150-i*5,
							1, 2, (int)(50+Math.random()*20), (int)(100+Math.random()*50), "onion"));
			}
		}
		else
		{
			for(int j = 1;j < 7;j++)
			{
				for(int i = 0;i < 2;i++,kill++)
					entityManager.addEntity(new WalkEnemy(handler, (float)((Math.random()*1000+(j-1)*1000)), spawnY, 160-i*5, 160-i*5,
						3, 2, (int)(20+Math.random()*30), (int)(100+Math.random()*50), "onion"));
				for(int i = 0;i < 2;i++,kill++)
					entityManager.addEntity(new FlyEnemy(handler, (float)(348+(Math.random()*1000+(j-1)*1000)), (int)(150+Math.random()*10), 150-i*5, 150-i*5,
							1, 2, (int)(50+Math.random()*20), (int)(100+Math.random()*50), "onion"));
			}
			entityManager.addEntity(new Boss(handler, Tile.SKY_TILE_WIDTH*(width-1/2), 200, 350, 350, 1, 5, 50, 200, "onion"));
			kill++;
		}
		
		
		System.out.println("kill:"+kill);
	}
	public void infoRender(Graphics2D g)
	{
		if(uiManager.getObjects().get(0).isHovering())
		{
			g.setColor(Color.ORANGE.darker().darker().darker());
			g.fillRect((int)(759), (int)(580), 430, 50);
			Text.drawString(g, info, 974, 600, true, Color.orange, Assets.font30);
		}
		
	}
	public void lose(Graphics2D g)
	{
		if(!handler.getPlayer().isActive())
			g.drawImage(Assets.lose, 400, 200, 437, 153, null);
	}
	public void win(Graphics2D g)
	{
		if(kill == entityManager.getKilled())
		{
			g.drawImage(Assets.win, 400, 200, 437, 153, null);
			uiManager.addObject(new UIImageButton(515, 400, 437/2, 153/2, Assets.playAgain, new ClickListener() {
			@Override
				public void onClick() {
					handler.getMouseManager().setUIManager(null);
					handler.getGame().gameState = new GameState(handler);
					State.setState(handler.getGame().gameState);
				}}
			));
		}
			
	}
	public int getWorldWidth()
	{
		return width;
	}
	public int getWorldHeight()
	{
		return height;
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public int getSpawnY() {
		return spawnY;
	}
}
