package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;

public class Shop extends JFrame{
	private JPanel graphics;
	
	public Shop() {
		super("Shop");
		setBounds(0, 0, 630, 490);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		graphics = new JPanel(new GridLayout(6,10,10,10));
		
		JLabel a1=new JLabel("Upgrade Stats:");
		JLabel a2=new JLabel("Level 2");
		JLabel a3=new JLabel("Level 3");
		JLabel a4=new JLabel("Level 4");
		JLabel a5=new JLabel("Level 5");
		JLabel a6=new JLabel("Max Level");
		JLabel a7=new JLabel("");
		JLabel a8=new JLabel("");
		JLabel a9=new JLabel("");
		JLabel a10=new JLabel("");
		JLabel b1=new JLabel("HP:");
		JLabel c1=new JLabel("Attack:");
		JLabel d1=new JLabel("Defense:");
		JLabel e1=new JLabel("PowerUps:");
		JLabel e2=new JLabel("Health Boost:");
		JLabel e3=new JLabel("Double Shot:");
		JLabel e4=new JLabel("Triple Shot:");
		JLabel e5=new JLabel("Rapid Fire:");
		JLabel e6=new JLabel("Fast movement:");
		JLabel e7=new JLabel("Shield:");
		JLabel e8=new JLabel("Nuke");
		JLabel e9=new JLabel("");
		JLabel e10=new JLabel("");
		
		JButton b2=new JButton("1000");
		JButton b3=new JButton("2000");
		JButton b4=new JButton("4000");
		JButton b5=new JButton("8000");
		JButton b6=new JButton("16000");
		JButton b7=new JButton("32000");
		JLabel b8=new JLabel("");
		JLabel b9=new JLabel("");
		JLabel b10=new JLabel("");
		JButton c2=new JButton("1000");
		JButton c3=new JButton("2000");
		JButton c4=new JButton("4000");
		JButton c5=new JButton("8000");
		JButton c6=new JButton("16000");
		JButton c7=new JButton("32000");
		JLabel c8=new JLabel("");
		JLabel c9=new JLabel("");
		JLabel c10=new JLabel("");
		JButton d2=new JButton("1000");
		JButton d3=new JButton("2000");
		JButton d4=new JButton("4000");
		JButton d5=new JButton("8000");
		JButton d6=new JButton("16000");
		JButton d7=new JButton("32000");
		JLabel d8=new JLabel("");
		JLabel d9=new JLabel("");
		JLabel d10=new JLabel("");
		JLabel f1=new JLabel("");
		JButton f2=new JButton("1000");
		JButton f3=new JButton("3000");
		JButton f4=new JButton("5000");
		JButton f5=new JButton("4000");
		JButton f6=new JButton("1000");
		JButton f7=new JButton("6000");
		JButton f8=new JButton("10000");
		JLabel f9=new JLabel("");
		JLabel f10=new JLabel("");
		
		graphics.add(a1);
		graphics.add(a2);
		graphics.add(a3);
		graphics.add(a4);
		graphics.add(a5);
		graphics.add(a6);
		graphics.add(a7);
		graphics.add(a8);
		graphics.add(a9);
		graphics.add(a10);	
		graphics.add(b1);
		graphics.add(b2);
		graphics.add(b3);
		graphics.add(b4);
		graphics.add(b5);
		graphics.add(b6);
		graphics.add(b7);
		graphics.add(b8);
		graphics.add(b9);
		graphics.add(b10);
		graphics.add(c1);
		graphics.add(c2);
		graphics.add(c3);
		graphics.add(c4);
		graphics.add(c5);
		graphics.add(c6);
		graphics.add(c7);
		graphics.add(c8);
		graphics.add(c9);
		graphics.add(c10);
		graphics.add(d1);
		graphics.add(d2);
		graphics.add(d3);
		graphics.add(d4);
		graphics.add(d5);
		graphics.add(d6);
		graphics.add(d7);
		graphics.add(d8);
		graphics.add(d9);
		graphics.add(d10);
		graphics.add(e1);
		graphics.add(e2);
		graphics.add(e3);
		graphics.add(e4);
		graphics.add(e5);
		graphics.add(e6);
		graphics.add(e7);
		graphics.add(e8);
		graphics.add(e9);
		graphics.add(e10);
		graphics.add(f1);
		graphics.add(f2);
		graphics.add(f3);
		graphics.add(f4);
		graphics.add(f5);
		graphics.add(f6);
		graphics.add(f7);
		graphics.add(f8);
		graphics.add(f9);
		graphics.add(f10);
		graphics.setVisible(true);
	    setBackground(Color.WHITE); //Doesnt do anything... REEEEE
	    add(graphics, BorderLayout.CENTER);
	    setVisible(true);
	    //repaint();
	}
	
	public static void main(String[] args)
	{
		Shop shop = new Shop();
	}
}
