//Primary contributor: Osman Wong
//Version Number: 3
//Date of completion:5/17/18

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class PowerUp {
	//indicates what the power up does:
	//0 is a healing type, 1 doubles the bullets fired per turn, 2 triples it, 3 and 4 give points
	//5 speeds up firing speed, 6 speeds up movement, 7 creates a shield to absorb hits for the player
	private int type;
	//x and y coords
	private int x,y;
	//Constructor:
	public PowerUp(int xCoord, int yCoord)
	{
		x=xCoord;
		y=yCoord;
		int t=(int)(Math.random()*8);
		switch(t)
		{
		case 0:
			type=0;
			break;
		case 1:
			type=1;
			break;
		case 2:
			type=2;
			break;
		case 3:
			type=3;
			break;
		case 4:
			type=4;
			break;
		case 5:
			type=5;
			break;
		case 6:
			type=6;
			break;
		case 7:
			type=7;
			break;
		}
		//type=7;
		//System.out.println(type+""+t);
	}
	//moves the power up
	public void move()
	{
		y+=1;
	}
	//draws the power up
	public void draw(Graphics g)
	{
		g.setColor(Color.GRAY);
		//System.out.println(type);
		g.fillRect(x-12, y-12, 24, 24);
		if(type==0)
		{
			g.setColor(Color.RED);
			g.fillRect(x-3, y-9, 6, 18);
			g.fillRect(x-9, y-3, 18, 6);
		}
		if(type==1)
		{
			g.setColor(Color.BLUE);
			g.fillOval(x-5, y,5 , 5);
			g.fillOval(x+3, y,5 , 5);
		}
		if(type==2)
		{
			g.setColor(Color.BLUE);
			g.fillOval(x-10, y,5 , 5);
			g.fillOval(x-2, y,5 , 5);
			g.fillOval(x+6, y,5 , 5);
		}
		if(type==3)
		{
			g.setColor(Color.WHITE);
			g.fillRect(x-2, y-8, 4, 16);
		}
		if(type==4)
		{
			g.setColor(Color.WHITE);
			g.fillRect(x-4, y-10, 8, 2);
			g.fillRect(x+4, y-8, 2, 8);
			g.fillRect(x-4, y-2, 8, 2);
			g.fillRect(x-4, y, 2, 8);
			g.fillRect(x-4, y+8, 10, 2);
		}
		if(type==5)
		{
			g.setColor(Color.ORANGE);
			g.fillOval(x-2, y-5,5 , 5);
			g.fillOval(x-2, y+3,5 , 5);
		}
		if(type==6)
		{
			g.setColor(Color.CYAN);
			Polygon arrow = new Polygon();
			arrow.addPoint(x-8,y-8);
			arrow.addPoint(x-5,y-8);
			arrow.addPoint(x+8, y);
			arrow.addPoint(x-5, y+8);
			arrow.addPoint(x-8, y+8);
			arrow.addPoint(x+5, y);
			g.fillPolygon(arrow);
		}
		if(type==7)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(x-8, y-8, 16, 16);
		}
		
	}
	//returns x, y, and type
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public int getType()
	{
		return type;
	}
}
