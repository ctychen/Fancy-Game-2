//Primary Contributor: Osman Wong
//Version Number: 2
//Date of completion: 5/10/18

import java.awt.Polygon;

//Represents an Obstacle that kills the player if it hits
public class Obstacle extends Polygon{
	//Fields:
	 int x,y,dxdt,dydt;
	private int hp;
	private int count;
	//private SoundManager sound = new SoundManager();
	//private Polygon super;
	boolean blownUp = false;
	//Constructor:
	public Obstacle(int xC, int yC, int dx, int dy, int type)
	{
		super();
		x=xC;
		y=yC;
		dxdt=dx;
		dydt=dy;
		count=0;
		
		switch(type)
		{
		case 0://block
			super.addPoint(x-50,y-50);
			super.addPoint(x+50,y-50);
			super.addPoint(x+50,y+50);
			super.addPoint(x-50,y+50);
			hp=4;
			break;
		case 1://missile
			super.addPoint(x-25, y-50);
			super.addPoint(x+25, y-50);
			super.addPoint(x+18,y-40);
			super.addPoint(x+18,y+20);
			super.addPoint(x,y+30);
			super.addPoint(x-18, y+20);
			super.addPoint(x-18, y-40);
			hp=3;
			dxdt=0;
			break;
		case 2://asteroid
			super.addPoint(x-10,y-50);
			super.addPoint(x+33,y-40);
			super.addPoint(x+50,y-26);
			super.addPoint(x+32,y);
			super.addPoint(x+45,y+20);
			super.addPoint(x+18,y+63);
			super.addPoint(x-35, y+26);
			super.addPoint(x-46,y-6);
			super.addPoint(x-38,y-27);
			super.addPoint(x-24, y-37);
			hp=4;
			break;
			
		}
	}
	//moves it
	public void move()
	{
		super.translate(dxdt, dydt);
		x+=dxdt;
		y+=dydt;
	}
	//reduces its hp
	public void damage()
	{
		hp--;
		if (hp <=0) explode();
	}
	//kills it
	public void explode()
	{
		if (blownUp == false) ShooterGraphics.booms.add(new Explosion((int)(Math.random()*10), x, y));
		blownUp = true;
		hp=0;
		//sound.play(SoundManager.EXPLODE);
	}
	
	//gets its HP
	public int getHP()
	{
		return hp;
	}
	//For the counter for how long its explosion has been displayed
	public int getCount()
	{
		return count;
	}
	public void incrementCount()
	{
		count++;
	}
}
