package RidingHood.states;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Label;

import RidingHood.Handler;
import RidingHood.gfx.Assets;
import RidingHood.gfx.Text;
import RidingHood.ui.ClickListener;
import RidingHood.ui.UIImageButton;
import RidingHood.ui.UIManager;

public class MapState extends State
{
	private UIManager uiManager;
	private String select;
	public static String worldType = "res/world/greenForest.txt";
	
	public MapState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		select = "select a map";

		uiManager.addObject(new UIImageButton(124, 104, 405, 386, Assets.green, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				worldType = "res/world/greenForest.txt";
				handler.getGame().gameState = new GameState(handler);
				State.setState(handler.getGame().gameState);
			}}
		));
		uiManager.addObject(new UIImageButton(454, 257, 405, 386, Assets.candy, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				worldType = "res/world/candyForest.txt";
				handler.getGame().gameState = new GameState(handler);
				State.setState(handler.getGame().gameState);
			}}
		));
		uiManager.addObject(new UIImageButton(782, 111, 405, 386, Assets.night, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				worldType = "res/world/nightForest.txt";
				handler.getGame().gameState = new GameState(handler);
				State.setState(handler.getGame().gameState);
			}}
		));
		uiManager.addObject(new UIImageButton(5, 5, 69, 69, Assets.back, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().menuState = new MenuState(handler);
				State.setState(handler.getGame().menuState);
			}}
		));
	}

	@Override
	public void tick() {
		
		uiManager.tick();
		if(uiManager.getObjects().get(0).isHovering())
			select = "Green Forest";
		else if(uiManager.getObjects().get(1).isHovering())
			select = "Candy Forest";
		else if(uiManager.getObjects().get(2).isHovering())
			select = "Night Forest";
		else
			select = "Please Select A Map";
	}

	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(Assets.mapUse, 0, 0, 1296, 684, null);
		uiManager.render(g);
		Text.drawString(g, select, 648, 120, true, Color.orange, Assets.font40);
		
	}

}
