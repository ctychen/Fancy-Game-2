package main;
//Primary Contributor: Osman Wong
//Version Number:2
//Date of Completion:5/11/18


import java.util.Random;
//Represents an enemy
public class Enemy extends Shooter{
	//Fields:
	private boolean driftDir, blownUp=false, crit=false;
	private int shootCount;
	public int rMod = 3; // 1/rMod = the chance of increasing the difficulty by killing this, put 0 to guarrantee it
	//Constructor:
	public Enemy(int x, int y, int k)
	{
		super(x,y,k);
		driftDir=new Random().nextBoolean();
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y-8);
		super.addPoint(x+30, y-30);
		super.addPoint(x-30, y-30);
		super.addPoint(x-5, y-8);
		shootCount=160;
		
	}
	public Enemy(int x, int y, int k,int attack, int defense)
	{
		super(x,y,k,attack,defense);
		driftDir=new Random().nextBoolean();
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y-8);
		super.addPoint(x+30, y-30);
		super.addPoint(x-30, y-30);
		super.addPoint(x-5, y-8);
		shootCount=160;
		
	}
	public void setRMod(int rMod) {
		this.rMod = rMod;
	}
	//returns true if it's time for the enemy to shoot
	public boolean timeToShoot() {
		if(shootCount<=0) {
			return true;
		}
		else
		{
			return false;
		}
	}
	//Creates and returns a projectile
	public Projectile shoot()
	{
		shootCount=160;
		return new Projectile(x,y,-1);
	}
	//determines enemy movement
	public void act() {
		if (driftDir&&hp>0) {		
			driftRight();
		} else if (hp>0) {
			driftLeft();
		}
		if((int)(Math.random()*10)==0)
		{
			driftDown();
		}
		shootCount--;
	}
	//Drifts Right and Left respectively at a slow pace
	public void driftRight()
	{
			super.translate(1,0);
			super.x++;
	}
	public void driftLeft()
	{
			super.translate(-1,0);
			super.x--;
	}
	//Drifts downwards small amounts randomly
	public void driftDown() {
		super.translate(0, 1);
		super.y++;
	}
	//Returns and sets the direction of drift respectively
	public boolean getDriftDir()
	{
		return driftDir;
	}
	public void setDir(boolean d)
	{
		
		driftDir=d;
	}
	//blows the enemy up
	public void explode()
	{
		if (blownUp == false) ShooterGraphics.booms.add(new Explosion((int)(Math.random()*10), x, y));
		blownUp = true;
		hp = 0;
	}
	//changes boolean indicating whether it died by critical hit
	public void crit() {
		crit=true;
	}
	//returns whether it died by critical hit
	public boolean critStatus() {
		return crit;
	}
}
