package RidingHood.weapon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.image.BufferedImage;

import RidingHood.Handler;
import RidingHood.entities.Entity;
import RidingHood.entities.creature.Creature;
import RidingHood.entities.creature.Enemy;
import RidingHood.gfx.Assets;
import RidingHood.skill.Explosion;
import RidingHood.skill.Line;
import RidingHood.skill.Skill;

public class Bullet extends Weapon
{
	private Enemy enemy;
	private boolean canHurt = true, collide = false, die = false;
	private int id;
	private float xdelta, ydelta;
	private Skill line, explosion;
	private String type;
	private boolean fire =false;
	private BufferedImage currentF, exF;
	
	public Bullet(Handler handler, Enemy enemy, float xdelta, float ydelta, double xoff, double yoff, double width, double height, String type) 
	{
		super(handler);
		this.enemy = enemy;
		this.id = id;
		this.xdelta = xdelta;
		this.ydelta = ydelta;
		this.x = enemy.getX();
		this.y = enemy.getY();
		this.xoff = xoff;
		this.yoff = yoff;
		this.width = width;
		this.height = height;
		this.start = 0;
		this.delta = 360;
		this.rstart = 0;
		this.attackBound.setArc(x+xoff, y+yoff, width, height, start, delta, Arc2D.CHORD);
		this.line = new Line(handler, this, enemy, 120);
		explosion = new Explosion(handler, this, 250, 3);
		handler.addBullet(this);
		this.type = type;
		currentF = Assets.gbullet;
		attackCoe = handler.getPlayer().getRank();
	}
	public void tick() 
	{
		
		checkAttackBound();
		setBound(xoff, yoff, width, height,  start, delta);
		if(collide)
			explosion.skilling();
	}

	@Override
	public void checkAttackBound() 
	{

		if(y +yoff> 600 || y+yoff <0 || x + xoff < 0 || x + xoff > 1296*handler.getWorld().getWorldWidth())
		{
			
			canHurt = false;
			//width = 30;
			//height = 30;
			fire = false;
			collide = true;	
			
		}
		else if(attackBound.intersects(handler.getWorld().getEntityManager().getPlayer().getCollisionBound(0f,0f)) && canHurt)
		{
			
			canHurt = false;
			collide = true;
			handler.getWorld().getEntityManager().getPlayer().hurt(1);
			//width = 30;
			//height = 30;
			fire = false;
			
			System.out.println("bullet hurt");
		}
		else if(fire)
		{
			path();
			
		}
			
				
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	public void render(Graphics2D g)
	{
		g.drawImage(currentF, (int)(x+xoff-handler.getGameCamera().getxOffset()), (int)(y+yoff-handler.getGameCamera().getyOffset()), (int)width, (int)height, null);
		//g.setColor(Color.RED);
		//g.fill(attackBound);
		//g.fillArc((int)(x+xoff-handler.getGameCamera().getxOffset()), (int)(y+yoff-handler.getGameCamera().getyOffset()), (int)width, (int)height, (int)start, (int)delta);
	}
	
	public int getId() {
		return id;
	}
	public void path()
	{
		switch(type)
		{
			case "line":line.skilling();
		}
		
	}
	public float getXdelta() {
		return xdelta;
	}

	public float getYdelta() {
		return ydelta;
	}

	public boolean isCollide() {
		return collide;
	}
	public boolean isFire()
	{
		return fire;
	}
	public void setFire(boolean fire)
	{
		this.fire = fire;
	}
	public void setCurrentF(BufferedImage currentF) {
		this.currentF = currentF;
	}
	public BufferedImage getExF() {
		return exF;
	}
	public void setExF(BufferedImage exF) {
		this.exF = exF;
	}
	public boolean isDie() {
		return die;
	}
	public void setDie(boolean die) {
		this.die = die;
	}
	
}
