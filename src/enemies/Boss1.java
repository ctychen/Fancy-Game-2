package enemies;

import java.util.Random;

import java.awt.Graphics;

import main.Projectile;
import main.ShooterGraphics;

public class Boss1 extends main.Enemy {

	public static int minDif = 2; // minimum difficulty level required to spawn
	public static int nMod = 5; // 1/nMod = likelyhood of spawning
	public Boss1(int x, int y, int k) {
		super(x, y, k);
		// TODO Auto-generated constructor stub
		speed = 2;
		image = ShooterGraphics.boss1Image;
		bulletCount = 2;
	}
	
	public Boss1(int x, int y, int k,int attack, int defense) {
		super(x, y, k, attack, defense);
		speed = 2;
		image = ShooterGraphics.boss1Image;
		bulletCount = 2;
	}
	
	
	
	public void shapeMe() {
		super.addPoint(x, y+60);
		super.addPoint(x-42, y+42);
		super.addPoint(x-60, y);
		
		super.addPoint(x+60, y);
		super.addPoint(x+42, y+42);
		
	}
	
	//Creates and returns a projectile
	public Projectile shoot()
	{
		//System.out.println("YOINK!");
		shootCount=30;
		if ((int)(Math.random()*2)==0)
			return new projectiles.Laser(x+35,y,-500,atk);
		else
			return new projectiles.Laser(x-35,y,-500,atk);
	}
	
	//determines enemy movement
	public void act() {
		spookyCheckBounds();
		if ((int)(Math.random()*10)==0) {
			speed = Math.max(Math.min(speed+(int)(Math.random()*3)-1, 3), 0);
		}
		if (driftDir&&hp>0) {		
			driftRight();
		} else if (hp>0) {
			driftLeft();
		}
		if (driftDirVert&&hp>0) {		
			driftUp();
		}
		else if (hp>0) {		
			driftDown();
		}
		if((int)(Math.random()*20)==0) {
			driftDirVert=new Random().nextBoolean();
		}
		if (y > 200) {
			driftDirVert = true;
		}
		else if (y < 50) {
			driftDirVert = false;
		}
		shootCount--;
	}
	
	
}
