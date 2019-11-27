package main;
//Primary Contributor: Osman Wong
//Version Number:5
//Date of Completion:5/17/18

//Represents the player
public class Player extends Shooter{
	//Fields:
	//booleans and counts for different powerups
	private boolean tripleShot,doubleShot,rapidShot,fastMovement, laserShot;
	private int tsCount,dsCount,rsCount,fmCount,lsCount;
	int shieldHP;
	int atkLvl,defLvl,hpLvl;
	//Constructor:
	public Player()
	{
		super(300,300,20,10,10);
		super.addPoint(x-5, y);
		super.addPoint(x+5, y);
		super.addPoint(x+5, y+20);
		//super.addPoint(x+8, y+20);
		super.addPoint(x+10, y+30);
		super.addPoint(x-10, y+30);
		//super.addPoint(x-8, y+20);
		super.addPoint(x-5, y+20);
		shieldHP=0;
		atkLvl=1;
		defLvl=1;
		hpLvl=1;
	}
//Checks powerUps
	public boolean tsCheck()
	{
		return tripleShot;
	}
	public boolean lsCheck()
	{
		return laserShot;
	}
	public boolean dsCheck()
	{
		return doubleShot;
	}
	public boolean rsCheck()
	{
		return rapidShot;
	}
//returns a projectile
	public Projectile shoot(int xC)
	{
		if (laserShot && lsCount > 0)
			return new projectiles.Laser(xC, y, 500, atk);
		else
			return new Projectile(xC,y,3,atk);
	}
	public Projectile shootLaser(int xC) {
		return new projectiles.Laser(xC, y, 500, atk);
	}
//sets the booleans for powerups, changes the counts, or starts the counts. See powerUp for more info on what each powerUp does.
	public void setTS()
	{
		tripleShot=true;
	}
	public void setDS()
	{
		doubleShot=true;
	}
	public void setLS()
	{
		laserShot=true;
	}
	public void decrementTSCount()
	{
		tsCount--;
	}
	public void startTSCount()
	{
		tsCount=40;
	}
	public void decrementDSCount()
	{
		dsCount--;
	}
	public void startDSCount()
	{
		dsCount=40;
	}
	public void startLSCount()
	{
		lsCount=40;
	}
	public void decrementLSCount()
	{
		lsCount--;
		if (lsCount <= 0)
			laserShot = false;
	}
//Checks the state of each powerUp
	public void checkPowerUpStatus()
	{
		if(dsCount==0)
		{
			doubleShot=false;
		}
		if(tsCount==0)
		{
			tripleShot=false;
		}
		if(rsCount==0)
		{
			rapidShot=false;
		}
		if(fmCount==0)
		{
			fastMovement=false;
		}
	}
//More powerUp stuff
	public void decrementRSCount()
	{
		rsCount--;
	}
	public void startRSCount()
	{
		rsCount=80;
	}
	public void setRS()
	{
		rapidShot=true;
	}
//faster movement, used when fastMovement is true
	public void accMoveLeft()
	{
		super.translate(-4, 0);
		super.checkBounds();
		x-=4;
	}
	public void accMoveRight()
	{
		super.translate(4, 0);
		super.checkBounds();
		x+=4;
	}
	public void accMoveUp()
	{
		super.translate(0,-4);
		super.checkBounds();
		y-=4;
	}
	public void accMoveDown()
	{
		super.translate(0,4);
		super.checkBounds();
		y+=4;
	}
//Everything related to the fast Movement powerup
//In order: Sets boolean, starts count, decrements count, returns if it is active or not
	public void setFM()
	{
		fastMovement=true;	
	}
	public void startFMCount()
	{
		fmCount=1000;
	}
	public void decrementFMCount()
	{
		fmCount--;
	}
	public boolean fmCheck()
	{
		return fastMovement;
	}
	public void upgradeHP()
	{
		hpLvl++;
		if(hpLvl<=5)
		{
			maxHP+=10;
			hp+=10;
		}
		else
		{
			maxHP+=10+2*hpLvl;
			hp+=10+2*hpLvl;
		}
	}
	public void upgradeAtk() {
		atkLvl++;
		if(atkLvl<=5)
		{
			atk+=5;
		}
		else
		{
			atk+=5+atkLvl;
		}
	}
	public void upgradeDef() {
		defLvl++;
		if(defLvl<=5)
		{
			def+=4;
		}
		else
		{
			def+=8;
		}
	}
}
