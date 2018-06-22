package RidingHood.weapon;

import java.awt.Rectangle;
import java.awt.geom.Arc2D;

import RidingHood.Handler;
import RidingHood.entities.Entity;

public abstract class Weapon 
{
	protected float attackCoe;
	protected Arc2D attackBound;
	protected Handler handler;
	protected double x, y, width, height, start, rstart,  delta, xoff, yoff;
	private int r = 0;
	
	public Weapon(Handler handler)
	{
		this.handler = handler;
		attackBound = new Arc2D.Double();
	}
	public abstract void tick() ;

	public abstract void checkAttackBound();
	
	
	public void setBound(double xoff, double yoff,double width, double height, double start, double delta)
	{
		attackBound.setArc(x+xoff, y+yoff, width, height, start, delta, Arc2D.CHORD);
		
	}
	
	public abstract void reset();
	public Arc2D getAttackBound() {return attackBound;}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public double getStart() {
		return start;
	}
	public double getDelta() {
		return delta;
	}
	public void setStart(double start) {
		this.start = start;
	}
	public void setXoff(double xoff) {
		this.xoff = xoff;
	}
	public void setYoff(double yoff) {
		this.yoff = yoff;
	}
	public double getXoff() {
		return xoff;
	}
	public double getYoff() {
		return yoff;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void setDelta(double delta) {
		this.delta = delta;
	}
	public float getAttackCoe() {
		return attackCoe;
	}
	public void setAttackCoe(float attackCoe) {
		this.attackCoe = attackCoe;
	}
	
}
