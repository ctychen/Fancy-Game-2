package projectiles;

public class Laser extends main.Projectile {

	private int t = 0;
	private int lt = 4;
	public Laser(int x, int y, int k) {
		super(x, y, 0);
		super.reset();
		super.addPoint(x, y);
		super.addPoint(x-2, y-k/20);
		super.addPoint(x-2, y-k-k/10);
		super.addPoint(x, y-k);
		
		super.addPoint(x+2, y-k-k/10);
		super.addPoint(x+2, y-k/20);
		// TODO Auto-generated constructor stub
	}

	public Laser(int x, int y, int k, int atk) { //k is actually the length
		super(x, y, 0, atk);
		super.reset();
		super.addPoint(x, y);
		super.addPoint(x-2, y-k/20);
		super.addPoint(x-2, y-k+k/10);
		super.addPoint(x, y-k);
		
		super.addPoint(x+2, y-k+k/10);
		super.addPoint(x+2, y-k/20);
		
		xC=x;
		yC=y;
		//v=k;
		spent=false;
		power=atk;
		effect=0;
	}
	
	public void setLifeTime(int lt) {
		this.lt = lt;
	}
	
	//moves it("Wow Sherlock!")
	public void move()
	{
		t++;
		if (t > 20) {
			yC-=1000;
			super.translate(0, -1000);
		}
	}
}