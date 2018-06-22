package RidingHood.entities.creature;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.gfx.Animation;
import RidingHood.gfx.Assets;
import RidingHood.skill.Jump;
import RidingHood.skill.RightCircle;
import RidingHood.skill.RightGeneralAttack;
import RidingHood.skill.RightHeavyAttack;
import RidingHood.skill.RightQuickAttack;
import RidingHood.skill.Skill;
import RidingHood.states.GameState;
import RidingHood.states.MapState;
import RidingHood.states.State;
import RidingHood.ui.ClickListener;
import RidingHood.ui.UIImageButton;
import RidingHood.weapon.Bullet;
import RidingHood.weapon.GeneralSword;
import RidingHood.weapon.Weapon;


public class Player extends Creature
{
	private Animation player_stand_right, player_work_right, player_jump_right, player_stand_left, player_work_left, player_jump_left;
	private boolean isgeneral = false, isjump = false, spaceDouble = false, spaceSingle = false, 
			rightDouble = false, rightSingle = false, leftDouble = false, leftSingle = false, skilling = false, rightG = false
			, rightQ = false, rightH = false, rightC = false, leftG = false, leftH = false, leftC = false, leftQ = false;
	private Skill jump, rightGeneralAttack, rightHeavyAttack, rightQuickAttack, rightCircle, leftGeneralAttack, leftHeavyAttack, leftCircle, leftQuickAttack;
	
	private Weapon weapon;
	private int exp = 0, rank = 1, expL = 100, healthL, amt;
	
	
	public Player(Handler handler, float x, float y)
	{
		super(handler, x, y, Creature.CREATURE_WIDTH, Creature.CREATURE_HEIGHT);
		bound.x = 47;
		bound.y = 26;
		bound.width = 70;
		bound.height = 118;
		enemy = false;
		health = 100;
		healthL = 100;
		player_stand_right = new Animation(250, Assets.player_stand_right);
		player_work_right = new Animation(200, Assets.player_work_right);
		player_jump_right = new Animation(167, Assets.player_jump_right);
		
		player_stand_left = new Animation(250, Assets.player_stand_left);
		player_work_left = new Animation(200, Assets.player_work_left);
		player_jump_left = new Animation(167, Assets.player_jump_left);
		amt = 3;
		weapon = new GeneralSword(handler, x, y);
		
		jump = new Jump(handler, this, 15, 100, 25);
		rightGeneralAttack = new RightGeneralAttack(handler, weapon, 100, 5,"right");
		leftGeneralAttack = new RightGeneralAttack(handler, weapon, 100, 5,"left");
		rightHeavyAttack = new RightHeavyAttack(handler, weapon, 5, 9, "right");
		leftHeavyAttack = new RightHeavyAttack(handler, weapon, 5, 9, "left");
		rightQuickAttack = new RightQuickAttack(handler, weapon, 1, 10, "right");
		leftQuickAttack = new RightQuickAttack(handler, weapon, 1, 10, "left");
		rightCircle = new RightCircle(handler, weapon, 100, 6, "right");
		leftCircle = new RightCircle(handler, weapon, 100, 6, "left");
		
	}
	public void tick()
	{
		player_stand_right.tick();
		player_work_right.tick();
		player_jump_right.tick();
		player_stand_left.tick();
		player_work_left.tick();
		player_jump_left.tick();
		weapon.tick();
		getInput();
		keyGather();
		move();
		handler.getGameCamera().centerOnEntity(this);
		rankUp();
	}
	public void move()
	{
		if(!checkPlayerCollision(xMove, 0f) || cross || xintercross)
			moveX();
		if(!checkPlayerCollision(0f, yMove) || cross || yintercross)
			moveY();
	}
	private void getInput()
	{
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up)
		{
			
			isjump = true;
		}
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
		if(y < handler.getWorld().getSpawnY() && !isjump)
		{
			yMove = speed;
		}
		if(spaceSingle && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_RIGHT && y >= handler.getWorld().getSpawnY())
		{
			rightG = true;
			spaceSingle = false;
				
		}
		if(spaceSingle && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_LEFT && y >= handler.getWorld().getSpawnY())
		{
			leftG = true;
			spaceSingle = false;
				
		}
		if(spaceDouble && y < handler.getWorld().getSpawnY() && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_RIGHT)
		{
			rightH = true;
			spaceDouble = false;
		}
		if(spaceDouble && y < handler.getWorld().getSpawnY() && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_LEFT)
		{
			leftH = true;
			spaceDouble = false;
		}
		if(spaceDouble && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_RIGHT && y >= handler.getWorld().getSpawnY())
		{
			rightQ = true;
			spaceDouble = false;
		}
		if(spaceDouble && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_LEFT && y >= handler.getWorld().getSpawnY())
		{
			leftQ = true;
			spaceDouble = false;
		}
		if(spaceSingle && y < handler.getWorld().getSpawnY() && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_RIGHT)
		{
			rightC = true;
			spaceSingle = false;
		}
		if(spaceSingle && y < handler.getWorld().getSpawnY() && handler.getKeyManager().getCurrentKey() == KeyEvent.VK_LEFT)
		{
			leftC = true;
			spaceSingle = false;
		}
	}
	public void render(Graphics2D g) 
	{
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), (int)(y - handler.getGameCamera().getyOffset()), width, height, null);
		//g.fillRect((int)(x + bound.x - handler.getGameCamera().getxOffset()), (int)(y + bound.y - handler.getGameCamera().getyOffset()), bound.width, bound.height);
		//g.setColor(Color.RED);
		//g.fillArc((int)(weapon.getXoff() + x - handler.getGameCamera().getxOffset()), (int)(weapon.getYoff()+y- handler.getGameCamera().getyOffset()), (int)weapon.getWidth(), (int)weapon.getHeight(), (int)weapon.getStart(), (int)weapon.getDelta());
		
		//g.fill(weapon.getAttackBound());
		for(Bullet b :handler.getBullet())
		{
			b.render(g);
		}
		
	}
	public BufferedImage getCurrentAnimationFrame() 
	{
		if(handler.getKeyManager().getCurrentKey() == KeyEvent.VK_RIGHT)
		{
			if(skilling)
			{
				if(rightG && !rightQ)
					return rightGeneralAttack.getCurrentFrame();
				if(rightQ)
					return Assets.player_quick_right;
				if(rightH)
					return rightHeavyAttack.getCurrentFrame();
				if(rightC)
					return rightCircle.getCurrentFrame();
					
			}
			else if(isjump)
				return player_jump_right.getCurrentFrame();
			else if(handler.getKeyManager().right)
				return player_work_right.getCurrentFrame();
			else
				return player_stand_right.getCurrentFrame();
		}
		else if(handler.getKeyManager().getCurrentKey() == KeyEvent.VK_LEFT)
		{
			if(skilling)
			{
				if(leftG && !leftQ)
					return leftGeneralAttack.getCurrentFrame();
				if(leftH)
					return leftHeavyAttack.getCurrentFrame();
				if(leftC)
					return leftCircle.getCurrentFrame();
				if(leftQ)
					return Assets.player_quick_left;
			}
			else if(isjump)
				return player_jump_left.getCurrentFrame();
			else if(handler.getKeyManager().left)
				return player_work_left.getCurrentFrame();
			else
				return player_stand_left.getCurrentFrame();
		}
		return player_stand_right.getCurrentFrame();
	}
	
	public void keyGather()
	{
		if(isjump) 
		{
			jump.skilling();
			if(!jump.getSkillHappen())
				isjump = false;
		}
		if(rightG && !rightQ)
		{
			rightGeneralAttack.skilling();
			skilling = true;
			if(!rightGeneralAttack.getSkillHappen())
			{
				rightG = false;
			}
				
		}
		if(rightH)
		{
			jump.reset();
			isjump = false;
			rightCircle.reset();
			rightC = false;
			skilling = true;
			rightHeavyAttack.skilling();
			if(!rightHeavyAttack.getSkillHappen())
				rightH = false;
		}
		if(rightQ)
		{
			rightGeneralAttack.reset();
			rightG = false;
			skilling = true;
			rightQuickAttack.skilling();
			if(!rightQuickAttack.getSkillHappen())
				rightQ = false;
		}
		if(rightC && !rightH)
		{
			skilling = true;
			rightCircle.skilling();
			if(!rightCircle.getSkillHappen())
				rightC =false;
		}
		if(leftG && !leftQ)
		{
			leftGeneralAttack.skilling();
			skilling = true;
			if(!leftGeneralAttack.getSkillHappen())
			{
				leftG = false;
			}
				
		}	
		if(leftH)
		{
			jump.reset();
			isjump = false;
			leftCircle.reset();
			leftC = false;
			skilling = true;
			leftHeavyAttack.skilling();
			if(!leftHeavyAttack.getSkillHappen())
				leftH = false;
		}
		if(leftQ)
		{
			leftGeneralAttack.reset();
			leftG = false;
			skilling = true;
			leftQuickAttack.skilling();
			if(!leftQuickAttack.getSkillHappen())
				leftQ = false;
		}
		if(leftC && !leftH)
		{
			skilling = true;
			leftCircle.skilling();
			if(!leftCircle.getSkillHappen())
				leftC =false;
		}
		
		if(!skilling)
		{
			spaceSingle = false;
			spaceDouble = false;
		}
			
	}
	
	public void rankUp()
	{
		if(exp >= expL)
		{
			rank++;
			expL = rank*100;
			exp = 0;
			healthL += 50;
			amt += 2;
		}
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	public boolean isSpaceDouble() {
		return spaceDouble;
	}
	public boolean isSpaceSingle() {
		return spaceSingle;
	}
	public void setSpaceDouble(boolean spaceDouble) {
		this.spaceDouble = spaceDouble;
	}
	public void setSpaceSingle(boolean spaceSingle) {
		this.spaceSingle = spaceSingle;
	}
	@Override
	public void die() 
	{
		handler.getMouseManager().getUiManager().addObject(new UIImageButton(515, 400, 437/2, 153/2, Assets.playAgain, new ClickListener() {
			@Override
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				handler.getGame().gameState = new GameState(handler);
				State.setState(handler.getGame().gameState);
			}}
		));
		
	}
	public boolean isRightDouble() {
		return rightDouble;
	}
	public void setRightDouble(boolean rightDouble) {
		this.rightDouble = rightDouble;
	}
	public void setRightSingle(boolean rigthSingle) {
		this.rightSingle = rigthSingle;
	}
	public boolean isLeftDouble() {
		return leftDouble;
	}
	public void setLeftDouble(boolean leftDouble) {
		this.leftDouble = leftDouble;
	}
	public boolean isLeftSingle() {
		return leftSingle;
	}
	public void setLeftSingle(boolean leftSingle) {
		this.leftSingle = leftSingle;
	}
	public boolean isSkilling() {
		return skilling;
	}
	public void setSkilling(boolean skilling) {
		this.skilling = skilling;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getHealthL() {
		return healthL;
	}
	public int getAmt() {
		return amt;
	}
	public void setAmt(int amt) {
		this.amt = amt;
	}
	public int getExpL() {
		return expL;
	}
	
}
