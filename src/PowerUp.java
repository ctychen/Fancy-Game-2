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
	//8 is a nuke that kills everything
	private int type;
	//x and y coords
	private int x,y;
	//Constructor:
	public PowerUp(int xCoord, int yCoord)
	{
		x=xCoord;
		y=yCoord;
		type=(int)(Math.random()*9);
		
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
		else if(type==1)
		{
			g.setColor(Color.BLUE);
			g.fillOval(x-5, y,5 , 5);
			g.fillOval(x+3, y,5 , 5);
		}
		else if(type==2)
		{
			g.setColor(Color.BLUE);
			g.fillOval(x-10, y,5 , 5);
			g.fillOval(x-2, y,5 , 5);
			g.fillOval(x+6, y,5 , 5);
		}
		else if(type==3)
		{
			g.setColor(Color.WHITE);
			g.fillRect(x-2, y-8, 4, 16);
		}
		else if(type==4)
		{
			g.setColor(Color.WHITE);
			g.fillRect(x-4, y-10, 8, 2);
			g.fillRect(x+4, y-8, 2, 8);
			g.fillRect(x-4, y-2, 8, 2);
			g.fillRect(x-4, y, 2, 8);
			g.fillRect(x-4, y+8, 10, 2);
		}
		else if(type==5)
		{
			g.setColor(Color.ORANGE);
			g.fillOval(x-2, y-5,5 , 5);
			g.fillOval(x-2, y+3,5 , 5);
		}
		else if(type==6)
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
		else if(type==7)
		{
			g.setColor(Color.YELLOW);
			g.fillOval(x-8, y-8, 16, 16);
		}
		else if(type==8) {
			g.setColor(Color.YELLOW);
			g.drawOval(x-8, y-8, 16, 16);
			g.fillArc(x-8, y-8, 16, 16, 60, 60);
			g.fillArc(x-8, y-8, 16, 16, 180, 60);
			g.fillArc(x-8, y-8, 16, 16, 300, 60);
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
