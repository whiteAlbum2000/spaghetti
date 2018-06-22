package RidingHood.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import RidingHood.Handler;
import RidingHood.entities.creature.Player;

public class KeyManager implements KeyListener 
{
	
	private boolean[] keys;
	public boolean up, space, left, right, up2;
	private int e = KeyEvent.VK_RIGHT, u = 0, ut = 0, r = 0, rt = 0, l =0, lt = 0;
	private Handler handler;
	public KeyManager(Handler handler)
	{
		keys = new boolean[256];
		this.handler = handler;
	
	}
	public void tick()
	{
		up = keys[KeyEvent.VK_UP];
		space = keys[KeyEvent.VK_SPACE];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		spaceDoubleKey();
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) 
	{
		keys[arg0.getKeyCode()] = true;
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT || arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			e = arg0.getKeyCode();
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		keys[arg0.getKeyCode()] = false;
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		         
	}
	public int getCurrentKey() {return e;}
	public void spaceDoubleKey()
	{
		if(handler.getWorld() != null)
		{
			if(space && u == 0 && !handler.getWorld().getEntityManager().getPlayer().isSpaceDouble())
			{
				u++;
				handler.getWorld().getEntityManager().getPlayer().setSpaceSingle(true);
			}
			if(!space && u == 1)
			{
				u++;
				
			}
			if(space && u == 2)
			{
				u++;
				handler.getWorld().getEntityManager().getPlayer().setSpaceSingle(false);
			}
			if(!space && u == 3)
			{
				handler.getWorld().getEntityManager().getPlayer().setSpaceDouble(true);
				u = 0;
				ut = 0;
			}
			if(ut == 40)
			{
				ut = 0;
				u = 0;
			}
			ut++;
		}
		
	}
	
	
}
