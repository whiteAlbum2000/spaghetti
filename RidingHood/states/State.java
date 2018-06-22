package RidingHood.states;

import java.awt.Graphics;
import java.awt.Graphics2D;

import RidingHood.Game;
import RidingHood.Handler;

public abstract class State 
{
	public static State currentState;
	
	public static void setState(State state)
	{
		currentState = state;
	}
	public static State getState()
	{
		return currentState;
	}
	protected Handler handler;
	public State (Handler handler) {this.handler = handler;}
	
		

	public abstract void tick();
	public abstract void render(Graphics2D g);
}

