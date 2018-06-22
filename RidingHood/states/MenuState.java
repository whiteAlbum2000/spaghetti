package RidingHood.states;

import java.awt.Graphics2D;

import RidingHood.Handler;
import RidingHood.gfx.Assets;
import RidingHood.ui.UIImageButton;
import RidingHood.ui.*;

public class MenuState extends State
{

	private UIManager uiManager;

	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(172, 466, 184, 48, 74, 421, 377, 127, Assets.start, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().mapState = new MapState(handler);
				State.setState(handler.getGame().mapState);
			}}
		));
		uiManager.addObject(new UIImageButton(574, 463, 174, 48, 467, 420, 377, 127, Assets.help, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().helpState = new HelpState(handler);
				State.setState(handler.getGame().helpState);
			}}
		));
		uiManager.addObject(new UIImageButton(964, 460, 174, 48, 857, 420, 377, 127, Assets.exit, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				System.exit(1);
			}}
		));
	}
	@Override
	public void tick() {
		uiManager.tick();
		
	}

	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(Assets.menuUse, 0, 0, 1296, 684, null);
		uiManager.render(g);
	}

}
