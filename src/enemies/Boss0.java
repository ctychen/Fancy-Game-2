package enemies;

import java.util.Random;

import java.awt.Graphics;

import main.Projectile;
import main.ShooterGraphics;

public class Boss0 extends main.Enemy {

	public static int minDif = 2; // minimum difficulty level required to spawn
	public static int nMod = 5; // 1/nMod = likelyhood of spawning
	public Boss0(int x, int y, int k) {
		super(x, y, k);
		// TODO Auto-generated constructor stub
		speed = 1;
		image = ShooterGraphics.boss0Image;
	}
	
	public Boss0(int x, int y, int k,int attack, int defense) {
		super(x, y, k, attack, defense);
		speed = 1;
		image = ShooterGraphics.boss0Image;
	}
	
	
	
	public void shapeMe() {
		super.addPoint(x-12, y);
		super.addPoint(x+12, y);
		super.addPoint(x+12, y-60);
		super.addPoint(x+30, y-60);
		super.addPoint(x+15, y-83);
		super.addPoint(x-15, y-83);
		super.addPoint(x-30, y-60);
		super.addPoint(x-12, y-60);
	}
	
	//Creates and returns a projectile
	public Projectile shoot()
	{
		shootCount=60;
		return new Projectile(x,y,-1);
	}
	
	//determines enemy movement
	public void act() {
		spookyCheckBounds();
		if ((int)(Math.random()*10)==0) {
			speed = Math.max(Math.min(speed+(int)(Math.random()*3)-1, 2), 0);
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
