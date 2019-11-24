package main;
//Primary Contributor: Osman Wong
//Version Number: 1
//Date of Completion: 5/8/18

import java.awt.Graphics;
import java.awt.Polygon;
import java.lang.reflect.Array;
// Represents a projectile(or "Bullet" as it is commonly referred to as)
public class Projectile extends Polygon{
//Fields:
	public int xC,yC,v;//center coords and velocity
	protected int power;
	protected boolean spent;
	protected int effect;
//Constructor:
	public Projectile(int x,int y, int k)
	{
		super();
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y+10);
		super.addPoint(x-5, y+10);
		xC=x;
		yC=y;
		v=k;
		spent=false;
		power=0;
		effect=0;
	}
	public Projectile(int x,int y, int k, int atk)
	{
		super();
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y+10);
		super.addPoint(x-5, y+10);
		xC=x;
		yC=y;
		v=k;
		spent=false;
		power=atk;
		effect=0;
	}
//Returns the x and y centers
	public int getX()
	{
		return xC;
	}
	public int getY()
	{
		return yC;
	}
	//indicates it has hit something
	public void collide()
	{
		spent=true;
	}
	//returns whether it has already hit something
	public boolean collisionStatus()
	{
		return spent;
	}
	//moves it("Wow Sherlock!")
	public void move()
	{
		yC-=v;
		super.translate(0, -v);
	}
	//draws it(I wonder how you figured that out?)
	public void draw(Graphics g)
	{
		g.fillPolygon(this);
	}
	public int getPower() {
		return power;
	}
}
