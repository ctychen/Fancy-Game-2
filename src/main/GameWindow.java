package main;
//Primary contributor: Osman Wong
//Version number:2
//Date of completion: 5/11/18

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
//Makes the JFrame and adds ShooterGraphics and its respective SidePanel
public class GameWindow extends JFrame{
	//Field:
	public static ShooterGraphics graphics;
	//Constructor:
	public GameWindow()
	{
		super("Fancy Game");
		graphics = new ShooterGraphics();
		Container c = getContentPane();
	    c.setBackground(Color.WHITE);
	    c.add(graphics.panel,BorderLayout.EAST);
	    c.add(graphics, BorderLayout.CENTER);
	}
	//Main method:
	public static void main(String[] args)
	{
		GameWindow window = new GameWindow();
		window.setBounds(0, 0, 630, 490);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);
	}

}
