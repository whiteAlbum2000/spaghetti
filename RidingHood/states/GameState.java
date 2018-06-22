package RidingHood.states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import RidingHood.Handler;
import RidingHood.gfx.Assets;
import RidingHood.gfx.Text;
import RidingHood.ui.ClickListener;
import RidingHood.ui.UIImageButton;
import RidingHood.ui.UIManager;
import RidingHood.world.World;
public class GameState extends State 
{
	
	private World world;
	
	
	public GameState(Handler handler) 
	{
		super(handler);
		
		world = new World(handler, MapState.worldType);
		
		handler.setWorld(world);
		
		
		
	}
	
	@Override
	public void tick() 
	{
		world.tick();
		
		
	}

	@Override
	public void render(Graphics2D g) 
	{
		world.render(g);
		
	}

	

	

}
