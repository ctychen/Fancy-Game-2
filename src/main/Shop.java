package main;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JFrame implements ActionListener{
	private JPanel graphics;
	private JTextField b8;
	ShooterGame game;
	
	public Shop(ShooterGame g) {
		super("Shop");
		setBounds(0, 0, 630, 490);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		game=g;
		graphics = new JPanel(new GridLayout(6,8,10,10));
		
		JLabel a1=new JLabel("Upgrades:");
		JLabel a2=new JLabel("Level 2");
		JLabel a3=new JLabel("Level 3");
		JLabel a4=new JLabel("Level 4");
		JLabel a5=new JLabel("Level 5");
		JLabel a6=new JLabel("Max Level");
		JLabel a7=new JLabel("");
		JLabel a8=new JLabel("");
		//JLabel a9=new JLabel("");
		//JLabel a10=new JLabel("");
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
		//JLabel e9=new JLabel("");
		//JLabel e10=new JLabel("");
		
		JButton b2=new JButton("1000");
		b2.addActionListener(this);
		JButton b3=new JButton("2000");
		b3.addActionListener(this);
		JButton b4=new JButton("4000");
		b4.addActionListener(this);
		JButton b5=new JButton("8000");
		b5.addActionListener(this);
		JButton b6=new JButton("16000");
		b6.addActionListener(this);
		JLabel b7=new JLabel("Currency:");
		Font displayFont = new Font("Monospaced", Font.BOLD, 16);
		b8=new JTextField();
		b8.setText(String.valueOf(game.getCurrency()));
		b8.setFont(displayFont);
	    b8.setEditable(false);
		//JLabel b9=new JLabel("");
		//JLabel b10=new JLabel("");
		JButton c2=new JButton("1000");
		c2.addActionListener(this);
		JButton c3=new JButton("2000");
		c3.addActionListener(this);
		JButton c4=new JButton("4000");
		c4.addActionListener(this);
		JButton c5=new JButton("8000");
		c5.addActionListener(this);
		JButton c6=new JButton("16000");
		c6.addActionListener(this);
		JLabel c7=new JLabel("");
		JLabel c8=new JLabel("");
		//JLabel c9=new JLabel("");
		//JLabel c10=new JLabel("");
		JButton d2=new JButton("1000");
		d2.addActionListener(this);
		JButton d3=new JButton("2000");
		d3.addActionListener(this);
		JButton d4=new JButton("4000");
		d4.addActionListener(this);
		JButton d5=new JButton("8000");
		d5.addActionListener(this);
		JButton d6=new JButton("16000");
		d6.addActionListener(this);
		JLabel d7=new JLabel("");
		JLabel d8=new JLabel("");
		//JLabel d9=new JLabel("");
		//JLabel d10=new JLabel("");
		JLabel f1=new JLabel("");
		JButton f2=new JButton("1000");
		f2.addActionListener(this);
		JButton f3=new JButton("3000");
		f3.addActionListener(this);
		JButton f4=new JButton("5000");
		f4.addActionListener(this);
		JButton f5=new JButton("4000");
		f5.addActionListener(this);
		JButton f6=new JButton("1000");
		f6.addActionListener(this);
		JButton f7=new JButton("6000");
		f7.addActionListener(this);
		JButton f8=new JButton("10000");
		f8.addActionListener(this);
		//JLabel f9=new JLabel("");
		//JLabel f10=new JLabel("");
		
		graphics.add(a1);
		graphics.add(a2);
		graphics.add(a3);
		graphics.add(a4);
		graphics.add(a5);
		graphics.add(a6);
		graphics.add(a7);
		graphics.add(a8);
		//graphics.add(a9);
		//graphics.add(a10);	
		graphics.add(b1);
		graphics.add(b2);
		graphics.add(b3);
		graphics.add(b4);
		graphics.add(b5);
		graphics.add(b6);
		graphics.add(b7);
		graphics.add(b8);
		//graphics.add(b9);
		//graphics.add(b10);
		graphics.add(c1);
		graphics.add(c2);
		graphics.add(c3);
		graphics.add(c4);
		graphics.add(c5);
		graphics.add(c6);
		graphics.add(c7);
		graphics.add(c8);
		//graphics.add(c9);
		//graphics.add(c10);
		graphics.add(d1);
		graphics.add(d2);
		graphics.add(d3);
		graphics.add(d4);
		graphics.add(d5);
		graphics.add(d6);
		graphics.add(d7);
		graphics.add(d8);
		//graphics.add(d9);
		//graphics.add(d10);
		graphics.add(e1);
		graphics.add(e2);
		graphics.add(e3);
		graphics.add(e4);
		graphics.add(e5);
		graphics.add(e6);
		graphics.add(e7);
		graphics.add(e8);
		//graphics.add(e10);
		graphics.add(f1);
		graphics.add(f2);
		graphics.add(f3);
		graphics.add(f4);
		graphics.add(f5);
		graphics.add(f6);
		graphics.add(f7);
		graphics.add(f8);
		//graphics.add(f10);
		graphics.setVisible(true);
	    setBackground(Color.WHITE); //Doesnt do anything... REEEEE
	    add(graphics, BorderLayout.CENTER);
	    setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s=e.getSource().toString();
		String t=s.substring(s.indexOf("text=")+5,s.indexOf(',', s.indexOf("text=")));
		boolean success=game.spend(Integer.parseInt(t));
		if(!success) {
			JOptionPane pane = new JOptionPane("You do not have enough currency for this purchase.");
			JDialog d = pane.createDialog(new JFrame(), "Error");
			d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
			d.setVisible(true);
		}
		b8.setText(String.valueOf(game.getCurrency()));
		System.out.println(s);
		String sourcex = s.substring(s.indexOf(',')+1,s.indexOf(',',s.indexOf(',')+1));
		int x=Integer.parseInt(sourcex);
		String sourcey = s.substring(s.indexOf(',',s.indexOf(',')+1)+1,s.indexOf(',',s.indexOf(',',s.indexOf(',')+1)+1));
		int y=Integer.parseInt(sourcey);
		if(Math.abs(y-81) < 10)
		{
			if(game.getShip().hpLvl*(79+1)<x)
			{
				game.addCurrency(Integer.parseInt(t));
				JOptionPane pane = new JOptionPane("You must purchase lower level upgrades first.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);

			}
			else if(game.getShip().hpLvl*(79+1)>x)
			{			
				game.addCurrency(Integer.parseInt(t));
				JOptionPane pane = new JOptionPane("You have already purchased this upgrade.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);
			}
			else
			{
				game.getShip().upgradeHP();
			}
		}
		else if(Math.abs(y-160) < 10)
		{
			if(game.getShip().atkLvl*(79+1)<x)
			{
				game.addCurrency(Integer.parseInt(t));
				JOptionPane pane = new JOptionPane("You must purchase lower level upgrades first.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);
			}
			else if(game.getShip().atkLvl*(79+1)>x)
			{			
				game.addCurrency(Integer.parseInt(t));
				JOptionPane pane = new JOptionPane("You have already purchased this upgrade.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);			
			}
			else
			{
				game.getShip().upgradeAtk();
			}
		}
		else if(Math.abs(y-239) < 10) 
		{
			if(game.getShip().defLvl*(79+1)<x)
			{
				game.addCurrency(Integer.parseInt(t));
				JOptionPane pane = new JOptionPane("You must purchase lower level upgrades first.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);
			}
			else if(game.getShip().defLvl*(79+1)>x)
			{			
				game.addCurrency(Integer.parseInt(t));
				JOptionPane pane = new JOptionPane("You have already purchased this upgrade.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);
			}
			else
			{
				game.getShip().upgradeDef();
			}
		}
		else if(Math.abs(y-397) < 10)
		{
			int temp=(x-1)/79;
			System.out.println(temp);
			PowerUp p=new PowerUp(0);
			if(temp==1)
			{
				p=new PowerUp(0);
			}
			else if(temp==2) 
			{
				p=new PowerUp(1);
			}
			else if(temp==3) 
			{
				p=new PowerUp(2);
			}
			else if(temp==4) 
			{
				p=new PowerUp(5);
			}
			else if(temp==5) 
			{
				p=new PowerUp(6);
			}
			else if(temp==6) 
			{
				p=new PowerUp(7);
			}
			else if(temp==7) 
			{
				p=new PowerUp(8);
			}
			if(!game.getHotbar().addPowerUp(p))
			{
				game.addCurrency(Integer.parseInt(t));
				JOptionPane pane = new JOptionPane("Your power up hotbar is full.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);
			}
			else
			{
				JOptionPane pane = new JOptionPane("Purchase successful. You have "+game.getHotbar().spotsLeft()+" spots left.");
				JDialog d = pane.createDialog(new JFrame(), "Error");
				d.setLocation((int)(Math.random()*1200),(int)(Math.random()*600));
				d.setVisible(true);
			}
		}
	}
}
