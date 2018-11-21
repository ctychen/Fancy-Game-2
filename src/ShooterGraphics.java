//Primary contributor: Claire Chen
//Version Number:7
//Date of completion: 5/17/18

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.ImageObserver;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ShooterGraphics extends JPanel implements ActionListener, KeyListener {
	//Fields:
	private int time, time2;
	private Player ship;
	private ShooterGame game;
	private ProgressBar healthBar;
	//Images:
	//private Image explosion = new ImageIcon("explosion.gif").getImage();
	private Image start = new ImageIcon("startscreen.png").getImage();
	private Image instructions = new ImageIcon("instructions.PNG").getImage();
	private Image endscreen = new ImageIcon("endscreen.png").getImage();
	//private Image fancyColors = new ImageIcon("fancyColors.gif").getImage();
	private Image playerImage = new ImageIcon("vi.png").getImage();
	private Image enemyImage = new ImageIcon("ei.png").getImage();
	private Image choose = new ImageIcon("choose.png").getImage();
	private Image bg1 = new ImageIcon("bkgd1.png").getImage();
	private Image bg2 = new ImageIcon("bkgd2.png").getImage();
	private Image bg3 = new ImageIcon("bkgd3.png").getImage();
	private Image spark = new ImageIcon("Spark.gif").getImage();
	private Image lg = new ImageIcon("LowGraphics.png").getImage();
	private Image rg = new ImageIcon("reducedGraphics.png").getImage();
	Timer clock;
	int timesRestarted = 0;
	SidePanel panel;
	int[] movement = new int[] { 0, 0 ,0,0};
	int[] thrust = new int[] { 0, 0 };
	private static int[] scores = new int[10];
	//for the menu decision actions
	public boolean fKey = false;
	boolean iKey = false;
	public static boolean gameStart = false;
	boolean key1 = false, key2 = false, key3 = false,gKey=false;;
	public static boolean choiceMade = false;
	int loops = 0;
	JLabel hpLabel;
	public static int lowGraphics=0;//0=regular,1=reduced,2=minimal
	
	//Explosion Images:
	public static Image explode = new ImageIcon("explosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image goodExplosion = new ImageIcon("goodExplosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode2 =new ImageIcon("sketchynuke.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode3 =new ImageIcon("ani-boom.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode4 =new ImageIcon("FancyBlueExplosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode5 =new ImageIcon("FancyCartoonExplosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode6 =new ImageIcon("FancyOrangeExplosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode7 =new ImageIcon("SparklyExplosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode8 =new ImageIcon("spicyexplosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image explode9 =new ImageIcon("SuperFancyExplosion.gif").getImage().getScaledInstance(200, 200, Image.SCALE_FAST);
	public static Image fastExplode  = new ImageIcon("goodExplosion.gif").getImage();

	public static ArrayList<Explosion> booms;
	//constructors
	public ShooterGraphics() {
		gameStart = false;
		choiceMade = false;
		booms = new ArrayList<Explosion>();
		healthBar = new ProgressBar(10, 100, 10, 20, 20, 5, Color.ORANGE, Color.BLACK);
		this.setLayout(null);
		hpLabel= new JLabel("HP re m a i n i n g:");
		hpLabel.setLocation(20, 3);
		hpLabel.setSize(120, 20);
		time = 0;
		time2 = 5;
		ship = new Player();
		panel = new SidePanel();
		game = new ShooterGame(time, ship, 600, 400);
		/* Timer */ clock = new Timer(10, (ActionListener) this);
		clock.start();

		KeyListener listener = new KeyListener() {

			public void keyTyped(KeyEvent e) {

			}

			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyboardInput.UP)
				{
					movement[0]=1;
				}
				
				if (e.getKeyCode() == KeyboardInput.LEFT)
				{
					movement[1]=1;
				}
				
				if (e.getKeyCode() == KeyboardInput.RIGHT)
				{
					movement[2]=1;
				}
				
				if (e.getKeyCode() == KeyboardInput.DOWN)
				{
					movement[3]=1;
				}
				if (e.getKeyCode() == KeyboardInput.F) {
					fKey = true;
				}
				if (e.getKeyCode() == KeyboardInput.I) {
					iKey = true;
				}
				if (e.getKeyCode() == KeyboardInput.S) {
					gameStart = true;
				}
				if (e.getKeyCode() == KeyboardInput.ONE) {
					key1 = true;
				}
				if (e.getKeyCode() == KeyboardInput.TWO) {
					key2 = true;
				}
				if (e.getKeyCode() == KeyboardInput.THREE) {
					key3 = true;
				}
				if (e.getKeyCode() == KeyboardInput.G) {
					gKey = true;
				}
				if (e.getKeyCode() == KeyboardInput.L) {
					if (lowGraphics == 0) lowGraphics = 1;
					else if(lowGraphics==1) lowGraphics = 2;
					else lowGraphics=0;
				}
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyboardInput.UP)
				{
					movement[0]=0;
				}
				
				if (e.getKeyCode() == KeyboardInput.LEFT)
				{
					movement[1]=0;
				}
				
				if (e.getKeyCode() == KeyboardInput.RIGHT)
				{
					movement[2]=0;
				}
				
				if (e.getKeyCode() == KeyboardInput.DOWN)
				{
					movement[3]=0;
				}
				if (e.getKeyCode() == KeyboardInput.S) {
					gameStart = true;
				}
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}
	//paint method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//hnadles menus
		if (gameStart == false) {
			g.drawImage(start, 0, 0, null);
		}
		if (iKey == true)
		{
			g.drawImage(instructions, 0, 0, null);
			if (loops > 1500) iKey = false;
		}
		if (gameStart == true
				&& (ShooterGame.difficulty != 1 || ShooterGame.difficulty != 2 || ShooterGame.difficulty != 3)) {
			g.drawImage(choose, 0, 0, null);
			if (key1 == true && choiceMade == false) {
				ShooterGame.difficulty = 1;
				choiceMade = true;
			} else if (key2 == true && choiceMade == false) {
				ShooterGame.difficulty = 2;
				choiceMade = true;
			} else if (key3 == true && choiceMade == false) {
				ShooterGame.difficulty = 3;
				choiceMade = true;
			} else if (gKey == true && choiceMade == false) {
				ShooterGame.difficulty = 27;
				choiceMade = true;
			}
		}
		if (ShooterGame.difficulty >= 1 && gameStart == true) {
			if(game.difficulty<26)//for lower difficulty background
			{
				Color bgc = new Color((30*ShooterGame.difficulty)%255, (255-10*ShooterGame.difficulty)%255, 100);
				g.setColor(bgc);
				g.fillRect(0, 0, 1000, 500);
			}
			else//for the rainbow background when difficulty gets high enough
			{
				int x = 600;
			    int y = 490;
			    int xCount=0,yCount=0;
			    int randInt=(int)(Math.random()*4);
			    int boxWidth=160;
			    if (randInt==0)boxWidth=40;
			    if (randInt==1)boxWidth=80;
			    if (randInt==2)boxWidth=120;
			    if (randInt==3)boxWidth=160;
			    g.setColor(Color.CYAN);
			    //Grids and squares in back
			    while(xCount<=x)
			    {
			    	while(yCount<=y)
			    	{
			    		int color=(int)(Math.random()*12);
			    		if(color==1)g.setColor(Color.PINK);
			    		if(color==2)g.setColor(Color.RED);
			    		if(color==3)g.setColor(Color.ORANGE);
			    		if(color==4)g.setColor(Color.YELLOW);
			    		if(color==5)g.setColor(Color.GREEN);
			    		if(color==6)g.setColor(Color.CYAN);
			    		if(color==7)g.setColor(Color.BLUE);
			    		if(color==8)g.setColor(Color.MAGENTA);
			    		if(color==9)g.setColor(Color.WHITE);
			    		if(color==10)g.setColor(Color.CYAN);
			    		if(color==11)g.setColor(Color.RED);
			    		if(color==0)g.setColor(Color.BLACK);
			    		
			    		for(int f=0;f<20;f++)
			    		{
			    			int rectCount=(int)(Math.random()*400);
			    			if(rectCount%7==3||rectCount%7==6)
			    			{
			    				g.drawRect((int)(Math.random()*x), (int)(Math.random()*y), (int)(Math.random()*x), (int)(Math.random()*y));
			    			}
			    		}
			    		g.fillRect(xCount, yCount, boxWidth, boxWidth);
			    		//System.out.println("y="+y);
			        	//System.out.println("yCount="+yCount);
			    		yCount+=boxWidth;
			    		
			    	}
			    	//System.out.println("x="+x);
			    	//System.out.println("xCount="+xCount);
			    	xCount+=boxWidth;
			    	yCount=0;
			    }
			    //For the rainbows
int degrees=45 - (int)(45 * Math.cos(0.016* Math.PI * time));
			    
			    int largeRadius1=((5-(int)(5 * Math.cos(0.016* Math.PI * time)))*x)/40+80;
			    int largeRadius=((5-(int)(5 * Math.cos(0.016* Math.PI * time)))*x)/40+80;
			    //System.out.println(time);
			    Color color1=null;
			    Color color2=null;
			    Color color3=null;
			    Color color4=null;
			    Color color5=null;
			    Color color6=null;
			    
			    int tCount=(3*time)%60;
			    
			    if(tCount<10)color1=Color.RED;
			    if(tCount>=10&&tCount<20)color1=Color.ORANGE;
			    if(tCount>=20&&tCount<30)color1=Color.YELLOW;
			    if(tCount>=30&&tCount<40)color1=Color.GREEN;
			    if(tCount>=40&&tCount<50)color1=Color.BLUE;
			    if(tCount>=50)color1=Color.MAGENTA;
			    
			    if(tCount>=50)color2=Color.RED;
			    if(tCount<10)color2=Color.ORANGE;
			    if(tCount>=10&&tCount<20)color2=Color.YELLOW;
			    if(tCount>=20&&tCount<30)color2=Color.GREEN;
			    if(tCount>=30&&tCount<40)color2=Color.BLUE;
			    if(tCount>=40&&tCount<50)color2=Color.MAGENTA;
			    
			    if(tCount>=40&&tCount<50)color3=Color.RED;
			    if(tCount>=50)color3=Color.ORANGE;
			    if(tCount<10)color3=Color.YELLOW;
			    if(tCount>=10&&tCount<20)color3=Color.GREEN;
			    if(tCount>=20&&tCount<30)color3=Color.BLUE;
			    if(tCount>=30&&tCount<40)color3=Color.MAGENTA;
			    
			    if(tCount>=30&&tCount<40)color4=Color.RED;
			    if(tCount>=40&&tCount<50)color4=Color.ORANGE;
			    if(tCount>=50)color4=Color.YELLOW;
			    if(tCount<10)color4=Color.GREEN;
			    if(tCount>=10&&tCount<20)color4=Color.BLUE;
			    if(tCount>=20&&tCount<30)color4=Color.MAGENTA;
			    
			    if(tCount>=20&&tCount<30)color5=Color.RED;
			    if(tCount>=30&&tCount<40)color5=Color.ORANGE;
			    if(tCount>=40&&tCount<50)color5=Color.YELLOW;
			    if(tCount>=50)color5=Color.GREEN;
			    if(tCount<10)color5=Color.BLUE;
			    if(tCount>=10&&tCount<20)color5=Color.MAGENTA;
			    
			    if(tCount>=10&&tCount<20)color6=Color.RED;
			    if(tCount>=20&&tCount<30)color6=Color.ORANGE;
			    if(tCount>=30&&tCount<40)color6=Color.YELLOW;
			    if(tCount>=40&&tCount<50)color6=Color.GREEN;
			    if(tCount>=50)color6=Color.BLUE;
			    if(tCount<10)color6=Color.MAGENTA;

			    g.setColor(color1);
			    g.fillArc(0-largeRadius,0-largeRadius,2*largeRadius1,2*largeRadius1,270,degrees);
			    g.setColor(color2);
			    g.fillArc(0-7*largeRadius/8,0-7*largeRadius/8,7*largeRadius1/4,7*largeRadius1/4,270,degrees);
			    g.setColor(color3);
			    g.fillArc(0-3*largeRadius/4,0-3*largeRadius/4,3*largeRadius1/2,3*largeRadius1/2,270,degrees);
			    g.setColor(color4);
			    g.fillArc(0-5*largeRadius/8,0-5*largeRadius/8,5*largeRadius1/4,5*largeRadius1/4,270,degrees);
			    g.setColor(color5);
			    g.fillArc(0-largeRadius/2,0-largeRadius/2,largeRadius1,largeRadius1,270,degrees);
			    g.setColor(color6);
			    g.fillArc(0-3*largeRadius/8,0-3*largeRadius/8,3*largeRadius1/4,3*largeRadius1/4,270,degrees);
			    g.setColor(Color.CYAN);
			    g.fillArc(0-largeRadius/4,0-largeRadius/4,largeRadius1/2,largeRadius1/2,270,degrees);
			    
			    g.setColor(color1);
			    g.fillArc(0-largeRadius,y-largeRadius,2*largeRadius1,2*largeRadius1,0,degrees);
			    g.setColor(color2);
			    g.fillArc(0-7*largeRadius/8,y-7*largeRadius/8,7*largeRadius1/4,7*largeRadius1/4,0,degrees);
			    g.setColor(color3);
			    g.fillArc(0-3*largeRadius/4,y-3*largeRadius/4,3*largeRadius1/2,3*largeRadius1/2,0,degrees);
			    g.setColor(color4);
			    g.fillArc(0-5*largeRadius/8,y-5*largeRadius/8,5*largeRadius1/4,5*largeRadius1/4,0,degrees);
			    g.setColor(color5);
			    g.fillArc(0-largeRadius/2,y-largeRadius/2,largeRadius1,largeRadius1,0,degrees);
			    g.setColor(color6);
			    g.fillArc(0-3*largeRadius/8,y-3*largeRadius/8,3*largeRadius1/4,3*largeRadius1/4,0,degrees);
			    g.setColor(Color.CYAN);
			    g.fillArc(0-largeRadius/4,y-largeRadius/4,largeRadius1/2,largeRadius1/2,0,degrees);
			    
			    g.setColor(color1);
			    g.fillArc(x-largeRadius,y-largeRadius,2*largeRadius1,2*largeRadius1,90,degrees);
			    g.setColor(color2);
			    g.fillArc(x-7*largeRadius/8,y-7*largeRadius/8,7*largeRadius1/4,7*largeRadius1/4,90,degrees);
			    g.setColor(color3);
			    g.fillArc(x-3*largeRadius/4,y-3*largeRadius/4,3*largeRadius1/2,3*largeRadius1/2,90,degrees);
			    g.setColor(color4);
			    g.fillArc(x-5*largeRadius/8,y-5*largeRadius/8,5*largeRadius1/4,5*largeRadius1/4,90,degrees);
			    g.setColor(color5);
			    g.fillArc(x-largeRadius/2,y-largeRadius/2,largeRadius1,largeRadius1,90,degrees);
			    g.setColor(color6);
			    g.fillArc(x-3*largeRadius/8,y-3*largeRadius/8,3*largeRadius1/4,3*largeRadius1/4,90,degrees);
			    g.setColor(Color.CYAN);
			    g.fillArc(x-largeRadius/4,y-largeRadius/4,largeRadius1/2,largeRadius1/2,90,degrees);
			    g.setColor(color1);
			    g.fillArc(x-largeRadius,0-largeRadius,2*largeRadius1,2*largeRadius1,180,degrees);
			    g.setColor(color2);
			    g.fillArc(x-7*largeRadius/8,0-7*largeRadius/8,7*largeRadius1/4,7*largeRadius1/4,180,degrees);
			    g.setColor(color3);
			    g.fillArc(x-3*largeRadius/4,0-3*largeRadius/4,3*largeRadius1/2,3*largeRadius1/2,180,degrees);
			    g.setColor(color4);
			    g.fillArc(x-5*largeRadius/8,0-5*largeRadius/8,5*largeRadius1/4,5*largeRadius1/4,180,degrees);
			    g.setColor(color5);
			    g.fillArc(x-largeRadius/2,0-largeRadius/2,largeRadius1,largeRadius1,180,degrees);
			    g.setColor(color6);
			    g.fillArc(x-3*largeRadius/8,0-3*largeRadius/8,3*largeRadius1/4,3*largeRadius1/4,180,degrees);
			    g.setColor(Color.CYAN);
			    g.fillArc(x-largeRadius/4,0-largeRadius/4,largeRadius1/2,largeRadius1/2,180,degrees);
			}
			//updates side panel
			if(ship.getHP()>0)
			{
				panel.update(ship.getHP(), ShooterGame.score, ShooterGame.difficulty);
			}
			//game methods called to update various statuses
			game.moveEnemies();
			game.moveObstacles();
			game.moveBoosts();
			game.ppsUpdate();
			game.epsUpdate();
			game.ppoUpdate();
			game.boostUpdate();
			game.moveProjectiles();
			game.enemyStatusUpdate();
			game.obsStatusUpdate();
			game.boostStatusUpdate();
			game.collisionTest();
			game.generateEnemy();
			game.generateObstacle();
			game.generateBoost();
			if(ship.getHP()>0)
			{
				game.enemyShot();
				game.playerShot();
			}
			game.movePowerUps();
			g.setColor(Color.BLACK);
			//draws Ship
			if (game.getShipStatus() == 0) {
				// g.fillPolygon(ship);
				if(ship.shieldHP>5)
				{
					g.setColor(Color.YELLOW);
					g.fillOval(ship.x-50, ship.y-40, 100, 100);
				}
				else if(ship.shieldHP>0) 
				{
					g.setColor(Color.YELLOW);
					g.drawOval(ship.x-50, ship.y-40, 100, 100);
				}
				g.setColor(Color.BLACK);
				if (lowGraphics == 0||lowGraphics==1) g.drawImage(playerImage, ship.x - 304, ship.y - 200, null);
				else g.fillPolygon(ship);
				if (ship.damaged == true)
					if (lowGraphics == 0||lowGraphics==1) g.drawImage(spark, ship.x - 90, ship.y - 100, null);
					else {g.setColor(Color.ORANGE); g.fillOval(ship.x-25, ship.y-15, 50, 50); g.setColor(Color.BLACK);}
				if ((int) (Math.random() * 20.0) == 1)
					ship.damaged = false;
			} else if (game.getShipStatus() == 1) {
				//g.drawImage(explosion, ship.x - 100, ship.y - 100, null);
				if (lowGraphics == 2) {g.setColor(Color.RED); g.fillOval(ship.x-100, ship.y-100, 200, 200); g.setColor(Color.BLACK); }
			} else if (ship.getCount() > 160) {
				g.drawImage(endscreen, 0, 0, null);
				if (fKey == true) {
					scores[0 + timesRestarted] = ShooterGame.score;
					clock.stop();
					if (checkHighScore() == true)
						System.out.println("Congrats, new high score!/n You got " + ShooterGame.score);
					this.setVisible(false); // you can't see me!
					this.restartGame(g);
				}
			}
			iKey = false;
			fKey = false;
			ArrayList<Enemy> eList = game.getEnemies();
			ArrayList<Obstacle> oList = game.getObstacles();
			ArrayList<Projectile> ppList = game.getPlayerProj();
			ArrayList<Projectile> epList = game.getEnemyProj();
			ArrayList<Boost> bList = game.getBoosts();
			ArrayList<PowerUp> powerUpList=game.getPowerUps();
			//draws explosions
			for (int i = 0; i < booms.size(); i++)
			{
				if (booms.get(i).getTimeAlive() < booms.get(i).getMaxTime()) booms.get(i).draw(g);
				else booms.remove(i);
			}
			//draws enemies
			for (int i = 0; i < eList.size(); i++) {
				if (eList.get(i).getHP() > 0) {
					// g.fillPolygon(eList.get(i));
					if(ship.getHP()>0)
					{
						if (lowGraphics == 0||lowGraphics==1) g.drawImage(enemyImage, (eList.get(i)).x - 300, (eList.get(i)).y - 220, null);
						else {g.setColor(new Color(100, 100, 0)); g.fillPolygon(eList.get(i)); g.setColor(Color.BLACK);}
					}
					if (eList.get(i).damaged == true)
						if (lowGraphics == 0||lowGraphics==1) g.drawImage(spark, eList.get(i).x - 90, eList.get(i).y - 100, null);
						else {g.setColor(Color.ORANGE); g.fillOval(eList.get(i).x-25, eList.get(i).y-50, 50, 50); g.setColor(Color.BLACK);}
					if ((int) (Math.random() * 20.0) == 1)
						eList.get(i).damaged = false;
				} else {
					if (eList.get(i).getCount() < 60) {
						if (lowGraphics == 2) {g.setColor(Color.RED); g.fillOval((eList.get(i)).x - 75,  (eList.get(i)).y - 75, 150, 150); g.setColor(Color.BLACK);}
						//g.drawImage(explosion, (eList.get(i)).x - 100, (eList.get(i)).y - 100, null);
						eList.get(i).incrementCount();
					}
				}
			}
			//draws obstacles
			for (int i = 0; i < oList.size(); i++) {
				if (oList.get(i).getHP() > 0&&ship.getHP()>0) {
					g.fillPolygon(oList.get(i));
				} else {
					if (oList.get(i).getCount() < 60) {
						if (lowGraphics == 2) {g.setColor(Color.RED); g.fillOval((oList.get(i)).x - 75,  (oList.get(i)).y - 75, 150, 150); g.setColor(Color.BLACK);}
						//g.drawImage(explosion, (oList.get(i)).x - 100, (oList.get(i)).y - 100, null);
						oList.get(i).incrementCount();
						// System.out.println(oList.get(i).getCount());
					}
				}
			}
			//draws boosts
			g.setColor(Color.YELLOW);
			for (int i = 0; i < bList.size(); i++) {
				if (bList.get(i).hit == false&&ship.getHP()>0) {
					g.fillPolygon(bList.get(i));
				} else {
					if (bList.get(i).getCount() < 30) {
						bList.get(i).incrementCount();
					}
				}
				if (bList.get(i).hit == true) {

				}
			}
			//draws projectiles
			g.setColor(Color.BLUE);
			for (int i = 0; i < ppList.size(); i++) {

				g.fillPolygon(ppList.get(i));
			}
			g.setColor(Color.RED);
			for (int i = 0; i < epList.size(); i++) {
				if(ship.getHP()>0)
				{
					g.fillPolygon(epList.get(i));
				}
			}
			//draws powerUps
			for(int i=0;i<powerUpList.size();i++)
			{
				powerUpList.get(i).draw(g);
			}
			//draws Health bar and corresponding label
			healthBar.set(ship.getHP());
			healthBar.draw(g);
			//panel.setLayout(null);
			//JLabel hpLabel= new JLabel("HP re m a i n i n g:");
			add(hpLabel);
			//hpLabel.setLocation(20, 3);
			//hpLabel.setSize(120, 20);
		}
		if(lowGraphics == 1) g.drawImage(rg, 450, 10, this);
		if (lowGraphics == 2) g.drawImage(lg, 420, -25, null);
	}
	//restarts the game
	public void restartGame(Graphics g) {
		fKey = false;
		timesRestarted++;
		g.drawImage(endscreen, 0, 0, null);
		try {
			Thread.sleep(20);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		gameStart = false;
		fKey = false;
		ShooterGame.difficulty = 0;
		ShooterGame.score = 0;
		GameWindow newGame = new GameWindow();
		GameWindow.main(null);
	}
	//for highscore functions
	public boolean checkHighScore() {
		boolean isGreatest = true;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] < ShooterGame.score)
				return false;
		}
		return isGreatest;
	}
	//override methods
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	//For each time the timer fires, increments time, repaints, moves the player, and may increase difficulty and/or score
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		game.incrementTime();
		repaint();
		if (gameStart == true && choiceMade == true) moveStuff();
		if ((int) (Math.random() * 1200) == 1&&ship.getHP()>0 && gameStart == true && choiceMade == true) {
			ShooterGame.difficulty++;
			ShooterGame.score += 150 * ShooterGame.difficulty;
		}
		if (time % 10 == 0&&ship.getHP()>0 && gameStart == true && choiceMade == true) {
			ShooterGame.score++;
		}
	}
	//for moving the player
	private void moveStuff() {
		if (movement[0]==1)
		{
			if(ship.fmCheck())
			{
				ship.accMoveUp();
			}
			else
			{
				ship.moveUp();
			}
		}
		if (movement[1]==1)
		{
			if(ship.fmCheck())
			{
				ship.accMoveLeft();
			}
			else
			{
				ship.moveLeft();
			}
		}
		if (movement[2]==1)
		{
			if(ship.fmCheck())
			{
				ship.accMoveRight();
			}
			else
			{
				ship.moveRight();
			}
		}
		if (movement[3]==1)
		{
			if(ship.fmCheck())
			{
				ship.accMoveDown();
			}
			else
			{
				ship.moveDown();
			}
		}
	}
}