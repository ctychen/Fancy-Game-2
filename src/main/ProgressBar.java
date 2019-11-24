package main;
//Primary Contributor: Carl Lerdorf
//Version Number: 1
//Date of completion: 5/12/18

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JPanel;
//Is a progress bar, used for HP of the player only(not for enemies because often there are too many)
public class ProgressBar extends Component{
//Fields:
	int max, width, height, x, y, roundness, health;
	Color c1, c2;
	boolean upwards = false;
//Constructors:
	public ProgressBar (int max, int width, int height, int x, int y, int roundness, Color c1, Color c2)
	{
		this.max = max;
		this.height = height;
		this.width = width;
		this.roundness = roundness;
		this.x = x;
		this.y = y;
		this.c1 = c1;
		this.c2 = c2;
		this.health = max;
	}
	//apparently to make it vertical
	public ProgressBar (int max, int width, int height, int x, int y, int roundness, Color c1, Color c2, boolean upwards)
	{
		this.max = max;
		this.height = height;
		this.width = width;
		this.roundness = roundness;
		this.x = x;
		this.y = y;
		this.c1 = c1;
		this.c2 = c2;
		this.health = max;
		this.upwards = upwards;
	}
	//changes the progress(or hp for this game's purposes)
	public void change (int amount)
	{
		if (health + amount > max) health = max;
		else if (health + amount < 0) health = 0;
		else health += amount;
	}
	//sets it at a spec amount
	public void set (int health)
	{
		this.health = health;
		if (health < 0) health = 0;
		else if (health > max) health = max;
	}
	public void setMax(int health) {
		max=health;
	}
	//draws it(duh?)
	public void draw (Graphics g)
	{
		g.setColor(c2);
		g.fillRoundRect(x, y, width, height, roundness, roundness);
		g.setColor(c1);
		if (upwards == false) g.fillRoundRect(x, y, (int)(width*((double)health/max)), height, roundness, roundness);
		else g.fillRoundRect(x, y, width, (int)(height*((double)health/max)), roundness, roundness);
	}
	
}
