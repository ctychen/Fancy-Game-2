package main;
//Primary Contributor: Carl "Comrade Lerdorf" Lerdorf
//Version Number: 2
//Date of completion: 5/17/18

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
//For the explosion gifs that when drawn in too large of a quantity cause my toaster of a machine to crash
public class Explosion extends JPanel implements ActionListener {
	//Fields:
	private int x,y,type, timeAlive, maxTime;
	Timer clock;
	Image explode;
	Image goodExplosion = ShooterGraphics.fastExplode;
	//Constructor:
	public Explosion(int type, int x, int y)
	{
		//System.out.println(type);
		this.type = type;
		this.x = x;
		this.y = y;
		/* Timer */ clock = new Timer(10, (ActionListener) this);
		clock.start();
		
		switch (type) {
			case 0:
				explode = ShooterGraphics.explode;
				maxTime = 70;
				break;
			case 1:
				explode = ShooterGraphics.explode2;
				maxTime = 200;
				break;
			case 2:
				explode = ShooterGraphics.explode3;
				maxTime = 80;
				break;
			case 3:
				explode = ShooterGraphics.explode4;
				maxTime = 150;
				break;
			case 4:
				explode = ShooterGraphics.explode5;
				maxTime = 200;
				break;
			case 5:
				explode = ShooterGraphics.explode6;
				maxTime = 340;
				break;
			case 6:
				explode = ShooterGraphics.explode7;
				maxTime = 100;
				break;
			case 7:
				explode = ShooterGraphics.explode8;
				maxTime = 200;
				break;
			case 8:
			case 9:
				explode = ShooterGraphics.explode9;
				maxTime = 500;
				break;
		}
		
	}
	//draws the explosion
	public void draw(Graphics g)
	{
		timeAlive++;
		//System.out.println("Boom?");
		if (ShooterGraphics.lowGraphics == 0) g.drawImage(explode,x-100,y-100,this);
		else if(ShooterGraphics.lowGraphics==1) g.drawImage(goodExplosion,x-100,y-100,this);
	}
	//repaints
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		//repaint();
		//System.out.println("Test2");
	}
	//Returns time the gif has been drawn and its length respectively
	public int getTimeAlive()
	{
		return timeAlive;
	}
	
	public int getMaxTime()
	{
		return maxTime;
	}
}
