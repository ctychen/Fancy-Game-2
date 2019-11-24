package main;
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
import java.awt.geom.Point2D;
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
	private Image start = new ImageIcon("startscreen.png").getImage();
	private Image instructions = new ImageIcon("instructions.PNG").getImage();
	private Image endscreen = new ImageIcon("endscreen.png").getImage();
	private Image playerImage = new ImageIcon("vi.png").getImage();
	private Image playerImageR = new ImageIcon("vir.png").getImage();
	private Image playerImageL = new ImageIcon("vil.png").getImage();
	public static Image enemyImage = new ImageIcon("ei.png").getImage();
	public static Image ninjaImage = new ImageIcon("ni.png").getImage();
	public static Image boss0Image = new ImageIcon("b0i.png").getImage();
	public static Image boss1Image = new ImageIcon("b1i.png").getImage();
	public static Image specialImage = new ImageIcon("si.png").getImage();
	private Image choose = new ImageIcon("choose.png").getImage();
	private Image bg1 = new ImageIcon("bkgd1.png").getImage();
	private Image bg2 = new ImageIcon("bkgd2.png").getImage();
	private Image bg3 = new ImageIcon("bkgd3.png").getImage();
	private Image spark = new ImageIcon("Spark.gif").getImage();
	private Image lg = new ImageIcon("LowGraphics.png").getImage();
	private Image rg = new ImageIcon("reducedGraphics.png").getImage();
	private Image critImg = new ImageIcon("crit.png").getImage();
	private Image bullet = new ImageIcon("bulleti.png").getImage();
	private Image ebullet = new ImageIcon("ebulleti.png").getImage();
	private Image asteroidImg = new ImageIcon("asteroidi.png").getImage();
	private Image missileImg = new ImageIcon("missilei.png").getImage();
	private ArrayList<Point2D> stars = new ArrayList<Point2D>();
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
	boolean key1 = false, key2 = false, key3 = false,key4=false,key5=false,gKey=false;
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
	
	int[] indexes = new int[200];
	Color[] colors = new Color[200];
	
	private boolean paused = false;
	
	//constructors
	public ShooterGraphics() {
		for (int k = 0; k < colors.length; k++) {
			colors[k] = new Color(0, 0, 0);
			indexes[k] = k;
			
		}
		gameStart = false;
		choiceMade = false;
		booms = new ArrayList<Explosion>();
		healthBar = new ProgressBar(20, 130, 10, 20, 20, 5, Color.ORANGE, Color.BLACK);
		this.setLayout(null);
		hpLabel= new JLabel("HP re m a i n i n g:");
		hpLabel.setLocation(20, 3);
		hpLabel.setSize(150, 20);
		time = 0;
		time2 = 5;
		ship = new Player();
		panel = new SidePanel();
		game = new ShooterGame(time, ship, 600, 400);
		clock = new Timer(10, (ActionListener) this);
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
					if (paused) {
						paused = false;
						game.nextWave();
						if(ship.maxHP!=healthBar.max)
						{
							healthBar.setMax(ship.maxHP);
						}
					}
				}
				if (e.getKeyCode() == KeyboardInput.SPACE) {
					if (paused) {
						Shop shop=new Shop(game);
					}
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
				&& !choiceMade) {
			g.drawImage(choose, 0, 0, null);
			if (key1 == true && choiceMade == false) {
				game.setWaveNum(1);
				choiceMade = true;
				key1=false;
			} else if (key2 == true && choiceMade == false) {
				game.setWaveNum(2);
				choiceMade = true;
				key2=false;
			} else if (key3 == true && choiceMade == false) {
				game.setWaveNum(3);
				choiceMade = true;
				key3=false;
			} else if (gKey == true && choiceMade == false) {
				game.setWaveNum(27);
				choiceMade = true;
				key4=false;
			}
			
		}
		if (game.getWaveStatus()) {
			paused = true;
		}
		if (paused) { //# = getWaveNum()/5
			rainbow(g, this.getWidth(), this.getHeight());
			g.setFont(new java.awt.Font("serif", java.awt.Font.PLAIN, 30));
			g.drawString("Congratulations", this.getWidth()/20, this.getHeight()/4);
			g.drawString("You completed wave " + (game.getWaveNum()), this.getWidth()/20, this.getHeight()/3);
			g.drawString("Press 'S' to start next wave", this.getWidth()/20, (int)(this.getHeight()/2.6));
			g.setFont(new java.awt.Font("serif", java.awt.Font.PLAIN, 18));
			g.drawString("Press space to purchase from shop", this.getWidth()/20, (int)(this.getHeight()/2.4));
			panel.update(ship.getHP(), game.score, game.getWaveNum(),game.getCurrency());
		}
		else if (game.getWaveNum() >= 1 && gameStart == true) {
			if (key1 == true&&choiceMade) {
				game.getHotbar().usePowerUp(game,0);
				key1=false;
			} else if (key2 == true&&choiceMade) {
				game.getHotbar().usePowerUp(game,1);
				key2=false;
			} else if (key3 == true&&choiceMade) {
				game.getHotbar().usePowerUp(game,2);
				key3=false;
			} else if (key4 == true&&choiceMade) {
				game.getHotbar().usePowerUp(game,3);
				key4=false;
			}else if (key4 == true&&choiceMade) {
				game.getHotbar().usePowerUp(game,4);
				key5=false;
			}
			if(game.getWaveNum()<26)//for lower getWaveNum() background
			{
				Color bgc = new Color((30*game.getWaveNum())%255, (255-10*game.getWaveNum())%255, 100);
				Color bgcm;
				g.setColor(bgc);
				g.fillRect(0, 0, 1000, 500);
				
				if (lowGraphics < 2) {
					for (int i = 0; i < 100; i++) {
						int y = i + (int)( this.getHeight()*(((float)time%100)/75)-this.getHeight()*0.2 );
						if (i < 50) {
							bgcm = new Color(Math.min(bgc.getRed()+i, 255), Math.min(bgc.getGreen()+i, 255), Math.min(bgc.getBlue()+i, 255));
						}
						else {
							bgcm = new Color(Math.min(255, Math.max(bgc.getRed()+100-i, bgc.getRed())), Math.min(255, Math.max(bgc.getGreen()+100-i, bgc.getGreen())), Math.min(255, Math.max(bgc.getBlue()+100-i, bgc.getBlue())));
						}
						g.setColor(bgcm);
						g.fillRect(0, y, this.getWidth(), 2);
						
					}
				}
				
				if (lowGraphics < 1) {
					g.setColor(new Color(Math.min(255, 350-bgc.getRed()), Math.min(255, 350-bgc.getGreen()), Math.min(255, 350-bgc.getBlue())));
					if ((int)(Math.random()*5) == 0) {
						stars.add(new Point2D.Float((int)(Math.random()*this.getWidth()), -1));
					}
					for (int i = 0; i < stars.size(); i++) {
						stars.get(i).setLocation(stars.get(i).getX(), stars.get(i).getY()+2);
						int s = (int)(Math.random()*3)+1;
						g.fillRect((int)stars.get(i).getX(), (int)stars.get(i).getY(), s, s);
						if (stars.get(i).getY() > this.getHeight())
							stars.remove(i);
					}
				}
				
			}
			else//for the rainbow background when getWaveNum() gets high enough
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
				panel.update(ship.getHP(), game.score, game.getWaveNum(),game.getCurrency());
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
			game.getHotbar().draw(g);
			g.setColor(Color.BLACK);
			//draws Ship
			if (game.getShipStatus() == 0) {
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
				if (lowGraphics == 0||lowGraphics==1) {
					if (movement[1]==1)
						g.drawImage(playerImageL, ship.x - 304, ship.y - 200, null);
					else if (movement[2]==1)
						g.drawImage(playerImageR, ship.x - 304, ship.y - 200, null);
					else
						g.drawImage(playerImage, ship.x - 304, ship.y - 200, null);
				}
				else g.fillPolygon(ship);
				if (ship.damaged == true)
					if (lowGraphics == 0||lowGraphics==1) g.drawImage(spark, ship.x - 90, ship.y - 100, null);
					else {g.setColor(Color.ORANGE); g.fillOval(ship.x-25, ship.y-15, 50, 50); g.setColor(Color.BLACK);}
				if ((int) (Math.random() * 20.0) == 1)
					ship.damaged = false;
			} else if (game.getShipStatus() == 1) {
				if (lowGraphics == 2) {g.setColor(Color.RED); g.fillOval(ship.x-100, ship.y-100, 200, 200); g.setColor(Color.BLACK); }
			} else if (ship.getCount() > 160) {
				g.drawImage(endscreen, 0, 0, null);
				if (fKey == true) {
					scores[0 + timesRestarted] = game.score;
					clock.stop();
					if (checkHighScore() == true)
						System.out.println("Congrats, new high score!/n You got " + game.score);
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
				if (lowGraphics == 1 && booms.get(i).getTimeAlive() > 80) booms.remove(i);
			}
			//draws enemies
			for (int i = 0; i < eList.size(); i++) {
				if (eList.get(i).getHP() > 0) {
					// g.fillPolygon(eList.get(i));
					if(ship.getHP()>0)
					{
						if (lowGraphics == 0||lowGraphics==1) eList.get(i).draw(g);
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
						eList.get(i).incrementCount();
					}
					if (eList.get(i).getCount() < 60&&eList.get(i).critStatus()) {
						g.drawImage(critImg,eList.get(i).x-50,eList.get(i).y-10,null);
					}
				}
			}
			//draws obstacles
			for (int i = 0; i < oList.size(); i++) {
				if (oList.get(i).getHP() > 0&&ship.getHP()>0) {
					if(lowGraphics < 2 && oList.get(i).getType() == 2) g.drawImage(asteroidImg, oList.get(i).x-304, oList.get(i).y-200, null);					
					else if(lowGraphics < 2 && oList.get(i).getType() == 1) g.drawImage(missileImg, oList.get(i).x-304, oList.get(i).y-200, null);
					else g.fillPolygon(oList.get(i));
				} else {
					if (oList.get(i).getCount() < 60) {
						if (lowGraphics == 2) {g.setColor(Color.RED); g.fillOval((oList.get(i)).x - 75,  (oList.get(i)).y - 75, 150, 150); g.setColor(Color.BLACK);}
						oList.get(i).incrementCount();
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

				if (lowGraphics > 0)
					g.fillPolygon(ppList.get(i));
				else
					g.drawImage(bullet, ppList.get(i).xC - 308, ppList.get(i).yC - 220, null);
			}
			g.setColor(Color.RED);
			for (int i = 0; i < epList.size(); i++) {
				if(ship.getHP()>0)
				{
					if (lowGraphics > 0 || epList.get(i).getClass().toString().equals("class projectiles.Laser"))
						g.fillPolygon(epList.get(i));
					else
						g.drawImage(ebullet, epList.get(i).xC - 300, epList.get(i).yC - 220, null);
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
			hpLabel.setText("HP r e m a i n i n g: "+ship.hp+"/"+ship.maxHP);
			add(hpLabel);
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
		reinit();
	}
	
	public void reinit() {
		booms = new ArrayList<Explosion>();
		healthBar = new ProgressBar(20, 100, 10, 20, 20, 5, Color.ORANGE, Color.BLACK);
		this.setLayout(null);
		hpLabel= new JLabel("HP re m a i n i n g:");
		hpLabel.setLocation(20, 3);
		hpLabel.setSize(120, 20);
		time = 0;
		time2 = 5;
		ship = new Player();
		game = new ShooterGame(time, ship, 600, 400);
		gameStart = false;
		choiceMade = false;
		key1=false;
		key2=false;
		key3=false;
		gKey=false;
		clock.start();
	}
	//for highscore functions
	public boolean checkHighScore() {
		for (int i = 0; i < scores.length; i++) {
			if (scores[i] < game.score)
				return false;
		}
		return true;
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
	//For each time the timer fires, increments time, repaints, moves the player, and may increase getWaveNum() and/or score
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		time++;
		game.incrementTime();
		repaint();
		if (gameStart == true && choiceMade == true&&ship.getHP()>0) moveStuff();
		/*if ((int) (Math.random() * 1200) == 0&&ship.getHP()>0 && gameStart == true && choiceMade == true) {
			game.getWaveNum()++;
			game.score += 150 * game.getWaveNum();
		}*/
		if (time % 10 == 0&&ship.getHP()>0 && gameStart == true && choiceMade == true&&!paused) {
			game.score++;
			//System.out.println(time);
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
	
	private void rainbow(Graphics g, int width, int height) {
		int s = (int)((float)width/colors.length+0.5);
		for (int j = 0; j < colors.length; j++) {
			changeColors(g, j);
			g.fillRect(j*s, 0, s, height);
			//line(width/2, height/2, width/2 + (int)(1000*Math.cos(j* (colors.length/(2*3.14)))), height/2 + (int)(1000*Math.sin(j* (colors.length/(2*3.14)))));
			
		}
		
	}
	
	private void changeColors(Graphics gr, int index) {
		
		int i = indexes[index];
		int l = 4;
		int r = colors[index].getRed();
		int g = colors[index].getGreen();
		int b = colors[index].getBlue();
		if ( (double)((int)(System.currentTimeMillis()/10)) % 1 == 0) {
			
			//Starts with green
			if (i==0) {
				r = 100;
				g = 255;
				b = 100;
			}
			//Adds red to make yellow
			else if (i < 155/l) {
				r+=l;
				g=255;
				b=100;
			}
			//Removes green to make red
			else if (i < 2*155/l) {
				r=255;
				g-=l;
				b=100;
			}
			//Adds blue to make purple
			else if (i < 3*155/l) {
				r=255;
				g=100;
				b+=l;
			}	
			//Removes the red to make blue
			else if (i < 4*155/l) {
				r-=l;
				g=100;
				b=255;
			}
			//Adds green to make turquoise
			else if (i < 5*155/l) {
				r=100;
				g+=l;
				b=255;
			}
			//Removes blue to get back to green
			else if (i < 6*155/l) {
				r=100;
				g=255;
				b-=l;
				//if(index == 0 ) System.out.println(r + " " + g + " " + b);
			}
			else if (i >= 6*155/l) indexes[index] = -1;
			
			//Makes all colors lighter
			if (r < 100) r = 100;
			if (g < 100) g = 100;
			if (b < 100) b = 100;
			
			//Makes sure no value gets above 255
			if (r > 255) r = 255;
			if (g > 255) g = 255;
			if (b > 255) b = 255;
			
			//Makes sure no value is negative
			r = Math.abs(r);
			g = Math.abs(g);
			b = Math.abs(b);
			indexes[index]++;
		}
		//System.out.println(r + " " + g + " " + b);
		//g.fill(r, g, b);
		gr.setColor(new Color(r, g, b));
		colors[index] = new Color(r, g, b);
	}
}