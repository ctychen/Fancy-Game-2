package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Hotbar {
	private ArrayList<PowerUp> powerups;
	public Hotbar() {
		powerups = new ArrayList<PowerUp>();
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(420, 420, 138, 30);
		g.setColor(Color.GRAY);
		g.drawString(" 1     2     3     4     5", 423, 420);
		g.drawRect(423,423,24,24);
		g.drawRect(450,423,24,24);
		g.drawRect(477,423,24,24);
		g.drawRect(504,423,24,24);
		g.drawRect(531,423,24,24);
		int x=435;
		int y=435;
		for(int i=0;i<powerups.size();i++)
		{
			int type=powerups.get(i).getType();
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
			x+=27;
		}
	}
	public void usePowerUp(ShooterGame g, int i)
	{
		if(powerups.size()>i)
		{
			g.applyPowerUp(powerups.get(i).getType());
			powerups.remove(i);
		}
	}
	public boolean addPowerUp(PowerUp p) {
		if(powerups.size()<5)
		{
			powerups.add(p);
			return true;
		}
		else
		{
			return false;
		}
	}
	public int spotsLeft() {
		return 5-powerups.size();
	}
}
