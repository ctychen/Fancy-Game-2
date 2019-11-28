package projectiles;

import main.Projectile;

public class AreaDamage extends Projectile {

	private int t = 0;
	private int lt = 10;
	
	public AreaDamage(int x, int y, int k) { // k is actually the radius
		super(x, y, 0);
		// TODO Auto-generated constructor stub
		super.reset();
		for (float i = 0; i < Math.PI*2; i += (float)Math.PI/8) {
			super.addPoint(x+(int)(k*Math.sin(i)), y+(int)(k*Math.cos(i)));
		}
		
	}

	public AreaDamage(int x, int y, int k, int atk) { // k is actually the radius
		super(x, y, 0, atk);
		// TODO Auto-generated constructor stub
		super.reset();
		
		for (float i = 0; i < Math.PI*2; i += (float)Math.PI/8) {
			super.addPoint(x+(int)(k*Math.sin(i)), y+(int)(k*Math.cos(i)));
		}
		
		
	}
	
	public AreaDamage(int x, int y, int k, int atk, int lt) { // k is actually the radius
		super(x, y, 0, atk);
		// TODO Auto-generated constructor stub
		super.reset();
		for (float i = 0; i < Math.PI*2; i += (float)Math.PI/8) {
			super.addPoint((int)(k*Math.sin(i)), (int)(k*Math.cos(i)));
		}
		
		this.lt = lt;
	}
	
	
	public void setLifeTime(int lt) {
		this.lt = lt;
	}
	
	public boolean collisionStatus()
	{
		return t > lt;
	}
	
	//moves it("Wow Sherlock!")
	public void move()
	{
		t++;
		if (t > lt) {
			yC-=1000;
			super.translate(0, -1000);
		}
	}
}
