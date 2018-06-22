package RidingHood.states;

import java.awt.Graphics2D;

import RidingHood.Handler;
import RidingHood.gfx.Animation;
import RidingHood.gfx.Assets;
import RidingHood.skill.HelpQuick;
import RidingHood.skill.Skill;
import RidingHood.ui.ClickListener;
import RidingHood.ui.UIImageButton;
import RidingHood.ui.UIManager;

public class HelpState extends State
{
	private Animation player_right_c, player_right_h, player_general_right;
	private Skill helpQuick;
	private UIManager uiManager;
	
	public HelpState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		player_right_c = new Animation(200, Assets.player_right_c);
		player_right_h = new Animation(200, Assets.player_right_h);
		player_general_right = new Animation(200, Assets.player_general_right);
		helpQuick = new HelpQuick(handler, 200, 3);
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
		player_general_right.tick();
		player_right_c.tick();
		player_right_h.tick();
		helpQuick.skilling();
	}

	@Override
	public void render(Graphics2D g) {
		
		g.drawImage(Assets.helpUse, 0, 0, 1296, 648, null);
		g.drawImage(player_general_right.getCurrentFrame(), 69, 406, 160, 160, null);
		g.drawImage(helpQuick.getCurrentFrame(), 341+30*helpQuick.getT(), 406, 160, 160, null);
		g.drawImage(player_right_c.getCurrentFrame(), 738, 406, 160, 160, null);
		g.drawImage(player_right_h.getCurrentFrame(), 1033, 406, 160, 160, null);
		uiManager.render(g);
	}

}
