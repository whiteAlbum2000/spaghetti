package RidingHood;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import RidingHood.display.Display;
import RidingHood.gfx.Assets;
import RidingHood.gfx.GameCamera;
import RidingHood.input.KeyManager;
import RidingHood.input.MouseManager;
import RidingHood.states.GameState;
import RidingHood.states.HelpState;
import RidingHood.states.MapState;
import RidingHood.states.MenuState;
import RidingHood.states.State;

public class Game implements Runnable
{
	private Handler handler;
	private Display display;
	
	private BufferStrategy bs;
	private Graphics2D g;
	
	private Thread thread;
	private boolean running;
	
	private String title;
	private int width, height;
	
	private KeyManager keyManager;
	private MouseManager mouseManager;
	
	private GameCamera gameCamera;
	
	public State gameState, helpState, mapState, menuState;
	
	public Game(String title, int width, int height) 
	{
		this.title = title;
		this.width = width;
		this.height = height;
		handler = new Handler(this);
		keyManager = new KeyManager(handler);
		mouseManager = new MouseManager();
	}
	
	public void init() 
	{
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		
		
		Assets.init();
		
		
		helpState = new HelpState(handler);
		menuState = new MenuState(handler);
		
		State.setState(menuState);
		
		gameCamera = new GameCamera(handler, 0, 0);
	}
	
	public void tick() 
	{
		keyManager.tick();
		if(State.getState() != null)
		{
			State.getState().tick();
		}
	}
	
	public void render() 
	{
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		
		if(State.getState() != null)
		{
			State.getState().render(g);
			
		}
		bs.show();
		g.dispose();
	}
	
	public void run() 
	{
		init();
		int fps = 60, ticks = 0;
		double delta = 0, timePerTick = 1000000000/fps;
		long now, lastTime = System.nanoTime(), timer = 0;
		
		while(running)
		{
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += (now - lastTime);
			lastTime = now;
			if(delta >= 1)
			{
				tick();
				render();
				delta--;
				ticks++;
			}
			if(timer >= 1000000000)
			{
				System.out.println("times of tick: " + ticks);
				timer = 0;
				ticks = 0;
			}
			
		}
		stop();
	}
	
	public synchronized void start()
	{
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop()
	{
		if(!running)
			return;
		running = false;
		try {thread.join();}
		catch(InterruptedException e) {e.printStackTrace();}
	}
	
	public int getGameWidth()
	{
		return width;
	}
	public int getGameHeight()
	{
		return height;
	}
	public KeyManager getKeyManager(){return keyManager;}
	public MouseManager getMouseManager(){return mouseManager;}
	public GameCamera getGameCamera() {return gameCamera;}
	public State getGameState() {return gameState;}
}
