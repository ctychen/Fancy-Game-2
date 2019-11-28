package projectiles;

public class Yeeter extends main.Projectile {

	public Yeeter(int x, int y, int k) {
		super(x, y, k);
		super.reset();
		super.addPoint(x, y-10);
		super.addPoint(x+10, y);
		super.addPoint(x, y+10);
		super.addPoint(x-10, y);
		
		//System.out.println("yeeter");
	}

	public Yeeter(int x, int y, int k, int atk) { 
		super(x, y, k, atk);
		super.reset();
		super.addPoint(x, y-10);
		super.addPoint(x+10, y);
		super.addPoint(x, y+10);
		super.addPoint(x-10, y);
		
		xC=x;
		yC=y;
		//v=k;
		spent=false;
		power=atk;
		effect=1;
		//System.out.println("yeeter");
	}
	
}
