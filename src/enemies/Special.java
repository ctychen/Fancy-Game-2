package enemies;

import java.util.Random;

import java.awt.Graphics;

import main.Projectile;
import main.ShooterGraphics;

public class Special extends main.Enemy {

	public static int minDif = 3; // minimum difficulty level required to spawn
	public static int nMod = 8; // 1/nMod = likelyhood of spawning
	public Special(int x, int y, int k) {
		super(x, y, k);
		// TODO Auto-generated constructor stub
		speed = 2;
		image = ShooterGraphics.specialImage;
	}
	
	public Special(int x, int y, int k,int attack, int defense) {
		super(x, y, k, attack, defense);
		speed = 2;
		image = ShooterGraphics.specialImage;
	}
	
	
	
	public void shapeMe() {
		super.addPoint(x, y);//
		super.addPoint(x-4, y);//
		super.addPoint(x-4, y+24);//
		super.addPoint(x-12, y+8);//
		super.addPoint(x-4, y-16);//
		super.addPoint(x-30, y-16);//
		super.addPoint(x-4, y-40);//
		super.addPoint(x-4, y-24);//
		
		super.addPoint(x+4, y-24);
		super.addPoint(x+4, y-40);
		super.addPoint(x+30, y-16);
		super.addPoint(x+4, y-16);
		super.addPoint(x+12, y+8);
		super.addPoint(x+4, y+24);
		super.addPoint(x+4, y);
	}
	
	//Creates and returns a projectile
	public Projectile shoot()
	{
		shootCount=30;
		return new Projectile(x,y,-3);
	}
	
	//determines enemy movement
	public void act() {
		spookyCheckBounds();
		if ((int)(Math.random()*40)==0) {
			speed = Math.max(Math.min(speed+(int)(Math.random()*3)-1, 3), 1);
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
		if((int)(Math.random()*40)==0) {
			driftDir=new Random().nextBoolean();
		}
		if((int)(Math.random()*40)==0) {
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
