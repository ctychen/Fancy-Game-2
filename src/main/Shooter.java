package main;
//Primary Contributor: Osman Wong
//Version Number: 3
//Date of completion:5/15/18
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;

import javax.swing.JFrame;
//represents a "shooter"
public class Shooter extends Polygon{
//Fields:
	protected int x,y;
	protected int hp;
	int atk;
	int def;
	boolean blownUp;
	protected int explosionCount;
	boolean damaged = false;
//Constructor:
	//default
	public Shooter(int xCoord,int yCoord)
	{
		hp=10;
		atk=0;
		def=0;
		x=xCoord;
		y=yCoord;
		blownUp=false;
		explosionCount=0;
		
	}
	//if you want a specific hp
	public Shooter(int xCoord,int yCoord, int k)
	{
		hp=k;
		atk=0;
		def=0;
		x=xCoord;
		y=yCoord;
		blownUp=false;
		explosionCount=0;
		
	}
	public Shooter(int xCoord, int yCoord, int k, int attack, int defense) {
		hp=k;
		atk=attack;
		def=defense;
		x=xCoord;
		y=yCoord;
		blownUp=false;
		explosionCount=0;
	}
//	public void draw(Graphics g)
//	{
//		g.setColor(Color.BLUE);
//		g.fillPolygon(this);
//	}
	//general shoot method, actually not entirely sure why it's here, but I'm afraid to remove it
	//because I really don't want to break anything
	public Projectile shoot()
	{
		return new Projectile(x,y,3,atk);
	}
	//moves the shooter, used for default player movements
	public void moveLeft()
	{
		super.translate(-3, 0);
		checkBounds();
		x-=3;
	}
	public void moveRight()
	{
		super.translate(3, 0);
		checkBounds();
		x+=3;
	}
	public void moveUp()
	{
		super.translate(0,-3);
		checkBounds();
		y-=3;
	}
	public void moveDown()
	{
		super.translate(0,3);
		checkBounds();
		y+=3;
	}
	//moves a specific amount each way
	public void move(int x, int y)
	{
		super.translate(x, y);
		checkBounds();
		this.x+=x;
		this.y+=y;
	}
	//gets the HP
	public int getHP()
	{
		return hp;
	}
	//when you hit a boost, may increase HP beyond the ordinary maximum
	public void save() {
		hp+=2;
	}
	//reduces the HP
	public void damage()
	{
		hp--;
		damaged = true;
		if(hp<=0)
		{
			explode();
		}
	}
	public void damage(int attack, int defense){
		int dmg=0;
		if(attack<defense) {
			
		}
		else
		{
			dmg=attack-defense+1;
		}
		if(dmg>hp) {
			explode();
		}
		else
		{
			hp-=dmg;
		}
	}
	//blows up the player instantly
	public void explode()
	{
		if (blownUp == false) ShooterGraphics.booms.add(new Explosion((int)(Math.random()*10), x, y));
		blownUp=true;
		hp=0;
	}
	//gets and increments the explosion count respectively
	public int getCount()
	{
		return explosionCount;
	}
	public void incrementCount()
	{
		explosionCount++;
	}
	//teleports it to the other side if you go off screen to prevent cheesing of the entire game
	public void checkBounds()
	{
		if (x > 605)
		{
			super.translate(-600,0);
			x -= 600;
		}
		else if (x < -5)
		{
			super.translate(600,0);
			x += 600;
		}
		if (y > 495)
		{
			super.translate(0,-490);
			y -= 490;
		}
		else if (y < -5)
		{
			super.translate(0,400);
			y += 400;
		}
	}
	
	protected void spookyCheckBounds() {
		checkBounds();
	}
	
}
