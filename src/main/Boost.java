package main;
//Primary Contributor: Claire Chen
//Version Number:1
//Date of Completion: 5/14/18 


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
//Represents a square that increases your health(possibly past the max) when hit
public class Boost extends Polygon {
//Fields:
	int x, y, dxdt, dydt;
	boolean hit;
	private int count;
//Constructor:
	public Boost(int xCoord, int yCoord) {
		x = xCoord;
		y = yCoord;
		hit = false;
		count=0;
		super.addPoint(x - 40, y - 25);
		super.addPoint(x + 40, y - 25);
		super.addPoint(x + 40, y + 25);
		super.addPoint(x - 40, y + 25);
	}

//Moves the boost
	public void move()
	{
		super.translate(dxdt, dydt);
		x+=2*dxdt;
		y+=2*dydt;
	}
//Indicates the boost has been hit
	public void explode() {
		hit = true;
	}
//Gets/ increments a count showing how long its been there respectively
	public int getCount()
	{
		return count;
	}
	public void incrementCount()
	{
		count++;
	}
}
