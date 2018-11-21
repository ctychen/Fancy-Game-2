//Primary Contributor: Osman Wong
//Version Number:2
//Date of Completion:5/11/18


import java.util.Random;
//Represents an enemy
public class Enemy extends Shooter{
	//Fields:
	private boolean driftDir, blownUp=false;
	//Constructor:
	public Enemy(int x, int y, int k)
	{
		super(x,y,k);
		driftDir=new Random().nextBoolean();
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y-8);
		//super.addPoint(x+8, y+20);
		super.addPoint(x+30, y-30);
		super.addPoint(x-30, y-30);
		//super.addPoint(x-8, y+20);
		super.addPoint(x-5, y-8);
		
	}
	//Creates and returns a projectile
	public Projectile shoot()
	{
		//System.out.print("*");
		return new Projectile(x,y,-1);
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
}
