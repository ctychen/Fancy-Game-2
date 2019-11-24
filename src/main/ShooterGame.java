package main;
//Primary contributor: Osman Wong
//Version Number: 8
//Date of completion: 5/17/18

import java.lang.reflect.Array;
import java.util.ArrayList;

import enemies.Ninja;

//game logic
public class ShooterGame {
	// Fields:
	// coords:
	private int width, height;
	// Player
	private Player ship;
	// Arraylists for:
	// Enemies
	private ArrayList<Enemy> enemies;
	// Obstacles
	private ArrayList<Obstacle> obstacles;
	//boosts
	private ArrayList<Boost> boosts;
	//projectiles
	private ArrayList<Projectile> playerProjectiles;
	private ArrayList<Projectile> enemyProjectiles;
	//powerUps
	private ArrayList<PowerUp> powerUps;
	//time
	private int time;
	//score, what it sounds like
	public int score = 0;
	//currency for buying in game items
	private int currency;
	//handles waves
	private int waveNum;
	private boolean waveDone;
	private Wave currentWave;
	private int enemyNum,obstacleCt,obsNum;
	private Hotbar hotbar;
	// Constructor:
	public ShooterGame(int t, Player s, int w, int h) {
		time = t;
		ship = s;
		width = 600;
		height = 400;
		// enemies=new Enemy[] {};
		enemies = new ArrayList<Enemy>();
		// obstacles=new Obstacle[] {};
		obstacles = new ArrayList<Obstacle>();
		boosts = new ArrayList<Boost>();
		// playerProjectiles=new Projectile[] {};
		// enemyProjectiles=new Projectile[] {};
		playerProjectiles = new ArrayList<Projectile>();
		enemyProjectiles = new ArrayList<Projectile>();
		powerUps=new ArrayList<PowerUp>();
		Enemy e=new Enemy(300,60,30);
		currentWave=new Wave(1);
		hotbar=new Hotbar();
	}

	// Returns 0 for alive, 1 for exploding, 2 for dead
	public int getShipStatus() {
		int hp = ship.getHP();
		if (hp > 0) {
			return 0;
		} else if (ship.getCount() < 60) {
			ship.incrementCount();
			return 1;
		} else {
			ship.incrementCount();
			return 2;
		}
	}

	// Checks if enemies are alive and removes them from the array if they are not
	// alive or exploding
	public void enemyStatusUpdate() {

		for (int i = 0; i < enemies.size(); i++) {
			int x = enemies.get(i).getHP();
			if(enemies.get(i).y>height+20) {
				enemies.remove(i);
				i--;
			}
			else if (x <= 0) {
				if (!this.explodingStatus(enemies.get(i))) {
					if((int)(Math.random()*4)==0)
					{
						powerUps.add(new PowerUp(enemies.get(i).x,enemies.get(i).y));
						//System.out.println("boi");
					}					
					score += 150 * (waveNum/5+1);
					currency+=50+10*(waveNum/5);
					enemies.remove(i);
					i--;
				}
			}
		}
	}

	// tests if boost is hit
	public void boostStatusUpdate() {
		for (int i = 0; i < boosts.size(); i++) {
			if (boosts.get(i).hit == true) {
				boosts.remove(i);
				ship.save();
				i--;
			}
			else if (boosts.get(i).y < -100) {
				boosts.remove(i);
				i--;
			}

		}
	}

	// tests if obstacles are alive
	public void obsStatusUpdate() {
		for (int i = 0; i < obstacles.size(); i++) {
			int x = obstacles.get(i).getHP();
			if (x <= 0) {
				if (!this.explodingStatus(obstacles.get(i))) {
					if((int)(Math.random()*4)==0)
					{
						powerUps.add(new PowerUp(obstacles.get(i).x,obstacles.get(i).y));
						//System.out.println("boi");
					}
					obstacles.remove(i);
					score += 100+10*waveNum;
					currency+=20+5*(waveNum/2);
					i--;
				} 
			}
			else if(obstacles.get(i).y>650)
			{
				obstacles.remove(i);
				i--;
			}

		}
	}

	// removes projectiles if they are spent
	public void ppsUpdate() {
		// System.out.println("l:"+playerProjectiles.size());

		for (int i = 0; i < playerProjectiles.size(); i++) {
			// System.out.println("i:"+i);
			Projectile p = playerProjectiles.get(i);// (Projectile)(Array.get(playerProjectiles, i));
			if (p.collisionStatus()||p.getY()<-200) {
				playerProjectiles.remove(i);
				i--;
			} else if (this.hitEnemy(p) || this.hitBoost(p)) {
				//p.collide();

			} else {

			}

		}

	}

	// same, but for enemy projectiles, also handles if it hits the player
	public void epsUpdate() {
		for (int i = 0; i < enemyProjectiles.size(); i++) {
			if (ship.contains(enemyProjectiles.get(i).getX(), enemyProjectiles.get(i).getY()) && ship.getHP() > 0) {
				if(ship.shieldHP>0)
				{
					(enemyProjectiles.get(i)).collide();
					ship.shieldHP--;
				}
				else
				{
					(enemyProjectiles.get(i)).collide();
					ship.damage(enemyProjectiles.get(i).getPower(),ship.def);
				}
			}
			if (enemyProjectiles.get(i).collisionStatus()||enemyProjectiles.get(i).getY()>550) {
				enemyProjectiles.remove(i);
				i--;
			}

		}
	}

	// increments time
	public void incrementTime() {
		time++;
	}

	// utility method for the enemy status method to determine if a ship is
	// exploding
	public boolean explodingStatus(Enemy e) {
		if (e.getCount() < 60) {
			return true;
		} else {
			return false;
		}
	}
	//same but with obstacles
	public boolean explodingStatus(Obstacle o) {
		if (o.getCount() < 60) {
			return true;
		} else {
			return false;
		}
	}

	// handles player projectile collisions with enemy
	public boolean hitEnemy(Projectile p) {
		for (int i = 0; i < enemies.size(); i++) {
			if (enemies.get(i).contains(p.getX(), p.getY())) {
				if(enemies.get(i).x-p.getX()<2&&enemies.get(i).x-p.getX()>-2)
				{
					enemies.get(i).explode();
					enemies.get(i).crit();
				}
				else
				{
					enemies.get(i).damage(p.getPower(),enemies.get(i).def);
				}
				p.collide();
				return true;
			} else {
				// return false;
			}
		}
		return false;
	}

	// handles projectile hitting a boost
	public boolean hitBoost(Projectile p) {
		for (int i = 0; i < boosts.size(); i++) {
			if (boosts.get(i).contains(p.getX(), p.getY())) {
				p.collide();
				boosts.get(i).hit = true;
				return true;
			} else {

			}
		}
		return false;
	}

	// tests for collisions with enemies and obstacles
	public void collisionTest() {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = (enemies.get(i));
			if ((enemy.contains(ship.x, ship.y) || enemy.contains(ship.x - 10, ship.y + 30)
					|| enemy.contains(ship.x + 10, ship.y + 30)) && ship.getHP() > 0&&enemy.getHP()>0) {
				if(ship.shieldHP>0)
				{
					ship.shieldHP-=5;
				}
				else if(enemy.getClass().toString().equals("class enemies.Ninja"))
				{
					ship.hp-=enemy.hp/2;
				}
				else
				{
				ship.explode();
				}
				enemy.explode();
			}
		}
		for (int i = 0; i < obstacles.size(); i++) {
			Obstacle obstacle = (obstacles.get(i));
			if ((obstacle.contains(ship.x, ship.y) || obstacle.contains(ship.x - 10, ship.y + 30)
					|| obstacle.contains(ship.x + 10, ship.y + 30)) && obstacle.getHP() > 0 && ship.getHP() > 0) {
				obstacle.explode();
				if(ship.shieldHP>0)
				{
					ship.shieldHP-=5;
				}
				else if(obstacle.getType()==1)
				{
					ship.explode();
				}
				else
				{
					ship.hp-=ship.maxHP/2;
				}
			} 
		}

	}

	// shoots for player and enemies
	public void enemyShot() {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = (enemies.get(i));
			if (enemy.timeToShoot()) {
				for (int j = 0; j < enemy.bulletCount; j++) {
					if(enemy.getClass().toString().equals("class enemies.Boss0"))
					{
						enemyProjectiles.add(enemy.shoot());
						enemyProjectiles.add(enemy.shoot(enemy.x-10));
					}
					else
					{
						//System.out.println(enemy.getClass().toString());
						Projectile p = enemy.shoot();
						enemyProjectiles.add(p);
					}
				}

			}
		}
	}
	
	public void playerShot() {
		ship.checkPowerUpStatus();
		//tests if the faster firing is active
		if(ship.rsCheck())
		{
			if(time%10==0&&ship.getHP()>0)
			{
				if(!ship.dsCheck()&&!ship.tsCheck())//if no other firing powerups
				{
					Projectile p=ship.shoot();
					playerProjectiles.add(p);
				}
				if(ship.tsCheck()==true)//if triple shooting
				{
					playerProjectiles.add(ship.shoot());
					playerProjectiles.add(ship.shoot(ship.x-18));
					playerProjectiles.add(ship.shoot(ship.x+18));
					ship.decrementTSCount();
				}
				else if(ship.dsCheck()==true)//if double, but not triple, shooting
				{
					playerProjectiles.add(ship.shoot(ship.x-7));
					playerProjectiles.add(ship.shoot(ship.x+7));
					ship.decrementDSCount();
				}
				ship.decrementRSCount();
			}
		}
		else
		{
			if(time%20==0&&ship.getHP()>0)
			{
				if(!ship.dsCheck()&&!ship.tsCheck())
				{
					Projectile p=ship.shoot();
					playerProjectiles.add(p);
				}
				if(ship.tsCheck()==true)
				{
					playerProjectiles.add(ship.shoot());
					playerProjectiles.add(ship.shoot(ship.x-18));
					playerProjectiles.add(ship.shoot(ship.x+18));
					ship.decrementTSCount();
				}
				else if(ship.dsCheck()==true)
				{
					playerProjectiles.add(ship.shoot(ship.x-7));
					playerProjectiles.add(ship.shoot(ship.x+7));
					ship.decrementDSCount();
				}
			}
		}
	}

	// makes new obstacles
	public void generateObstacle() {
		/*if ((int) (Math.random() * 1200 / (waveNum + 1)) == 10) {
			int xC = (int) (Math.random() * width);
			int yC = -50;
			int dx = (int) (Math.random() * 3);
			int dy = (int) (Math.random() * 4) + 1;
			int type = (int) (Math.random() * 3);
			if ((time % 7) % 2 == 1 && type != 1) {
				dx *= -1;
				xC += 150;
			}
			Obstacle newObs = new Obstacle(xC, yC, dx, dy, type);
			obstacles.add(newObs);
		}*/
		if(obstacleCt>=currentWave.getObsDelay()&&obsNum<currentWave.getObstacles().length)
		{
			obstacles.add(currentWave.getObstacles()[obsNum]);
			obsNum++;
			obstacleCt=0;
		}
		obstacleCt++;
	}

	// makes boosts
	public void generateBoost() {
		if ((int) (Math.random() * 1200 / (waveNum + 1)) == 10) {
			int x = (int) (300);
			int y = (int) (Math.random() * 100) + 20;
			Boost newBoost = new Boost(x, y);
			boosts.add(newBoost);
		}
	}

	// makes new enemies
	public void generateEnemy() {
		/*if ((int) (Math.random() * 2000 / (waveNum + 1)) == 10) {
			int x = (int) (Math.random() * 300) + 150;
			int y = (int) (Math.random() * 100) + 20;
			int k = (int) (Math.random() * 10) + 1;
			Enemy newEnemy;
			if (waveNum > Ninja.minDif && (int)(Math.random()*Ninja.nMod) == 0) 
				newEnemy = new Ninja(x, y, k);
			else
				newEnemy = new Enemy(x, y, k);
			enemies.add(newEnemy);
		}*/
		if(enemies.size()<currentWave.getMaxEnemies()&&enemyNum<currentWave.getEnemies().length)
		{
			enemies.add(currentWave.getEnemies()[enemyNum]);
			enemyNum++;
		}
		else if(enemyNum==currentWave.getEnemies().length&&enemies.size()==0)
		{
			enemies.add(currentWave.getBoss());
			enemyNum++;
		}
		else if(enemyNum>currentWave.getEnemies().length&&enemies.size()==0) {
			waveDone=true;
			enemyNum=0;
			obsNum=0;
		}
	}

	// moves all enemies
	public void moveEnemies() {
		for (int i = 0; i < enemies.size(); i++) {

			Enemy enemy = enemies.get(i);
			if(enemy!=null&&enemy.x<=0)
			{
				enemy.setDir(true);
			}
			else if(enemy!=null&&enemy.x>=width-20)
			{
				enemy.setDir(false);
			}
			if(enemy!=null) {enemy.act();}
		}
	}

	// moves all obstacles
	public void moveObstacles() {
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).getHP() > 0) {
				obstacles.get(i).move();
			}
			// System.out.println(obstacles.get(i).dxdt);
		}
	}

	// moves boosts
	public void moveBoosts() {
		for (int i = 0; i < boosts.size(); i++) {
			boosts.get(i).dxdt=boosts.get(i).x/2;
			boosts.get(i).dydt=boosts.get(i).y/2;
			boosts.get(i).move();
		}
	}

	// moves all projectiles
	public void moveProjectiles() {
		for (int i = 0; i < playerProjectiles.size(); i++) {
			playerProjectiles.get(i).move();
		}
		for (int i = 0; i < enemyProjectiles.size(); i++) {
			enemyProjectiles.get(i).move();
		}
	}

	// accessors
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public ArrayList<Boost> getBoosts() {
		return boosts;
	}

	public ArrayList<Projectile> getEnemyProj() {
		return enemyProjectiles;
	}

	public ArrayList<Projectile> getPlayerProj() {
		return playerProjectiles;
	}
	//updates boosts
	public void boostUpdate() {
		for (int i = 0; i < playerProjectiles.size(); i++) {
			Projectile p = playerProjectiles.get(i);
			if (p.collisionStatus()) {
				playerProjectiles.remove(i);
				i--;
			} else if (this.hitBoost(p)) {
				p.collide();
			} else {

			}
		}
	}

	// updates projectiles to test if they hit obstacles
	public void ppoUpdate() {
		for (int i = 0; i < playerProjectiles.size(); i++) {
			// System.out.println("i:"+i);
			Projectile p = playerProjectiles.get(i);// (Projectile)(Array.get(playerProjectiles, i));
			if (p.collisionStatus()) {
				playerProjectiles.remove(i);
				i--;
			} else if (this.hitObs(p)) {
				p.collide();

			} else {

			}

		}
	}
	//utility for ppoUpdate
	public boolean hitObs(Projectile p) {
		for (int i = 0; i < obstacles.size(); i++) {
			if (obstacles.get(i).contains(p.getX(), p.getY()) && obstacles.get(i).getHP() > 0) {
				// System.out.println(obstacles.get(i).getHP());
				obstacles.get(i).damage();
				p.collide();
				return true;
			} else {
				// return false;
			}
		}
		return false;
	}
	//moves powerUps, tests for player collisions, and initiates effects as required
	public void movePowerUps()
	{
		for(int i=0;i<powerUps.size();i++)
		{
			powerUps.get(i).move();
			if(ship.contains(powerUps.get(i).getX(),powerUps.get(i).getY()))
			{
				if(powerUps.get(i).getType()==0)
				{
					if(ship.getHP()<ship.maxHP*4/5)
					{
					ship.hp+=ship.maxHP/5;
					}
					else
					{
					ship.hp=ship.maxHP;
					}
				}
				else if(powerUps.get(i).getType()==2)
				{
					ship.setTS();
					ship.startTSCount();
				}
				else if(powerUps.get(i).getType()==1)
				{
					ship.setDS();
					ship.startDSCount();
				}
				else if(powerUps.get(i).getType()==3)
				{
					currency+=1000;
				}
				else if(powerUps.get(i).getType()==4)
				{
					currency+=2000;
				}
				else if(powerUps.get(i).getType()==5)
				{
					ship.setRS();
					ship.startRSCount();
				}
				else if(powerUps.get(i).getType()==6)
				{
					ship.setFM();
					ship.startFMCount();
				}
				else if(powerUps.get(i).getType()==7)
				{
					ship.shieldHP=10;
				}
				else if(powerUps.get(i).getType()==8)
				{
					for(Enemy e: enemies) {
						e.explode();
					}
					for(Obstacle o: obstacles)
					{
						o.explode();
					}
					enemyProjectiles = new ArrayList<Projectile>();
				}
				powerUps.remove(i);
				i--;
			}
			else if(powerUps.get(i).getY()>500)
			{
				powerUps.remove(i);
				i--;
			}
		}
	}
	//method to do stuff for powerups in hotbar
	public void applyPowerUp(int type) {
		if(type==0)
		{
			if(ship.getHP()<ship.maxHP*4/5)
			{
			ship.hp+=ship.maxHP/5;
			}
			else
			{
			ship.hp=ship.maxHP;
			}
		}
		else if(type==2)
		{
			ship.setTS();
			ship.startTSCount();
		}
		else if(type==1)
		{
			ship.setDS();
			ship.startDSCount();
		}
		else if(type==5)
		{
			ship.setRS();
			ship.startRSCount();
		}
		else if(type==6)
		{
			ship.setFM();
			ship.startFMCount();
		}
		else if(type==7)
		{
			ship.shieldHP=10;
		}
		else if(type==8)
		{
			for(Enemy e: enemies) {
				e.explode();
			}
			for(Obstacle o: obstacles)
			{
				o.explode();
			}
			enemyProjectiles = new ArrayList<Projectile>();
		}
	}
	//accessor for powerUps
	public ArrayList<PowerUp> getPowerUps()
	{
		return powerUps;
	}
	public int getWaveNum() {
		return waveNum;
	}
	public void nextWave() {
		waveNum++;
		currentWave=new Wave(waveNum);
		score+=waveNum*1000;
		currency+=100*waveNum;
		waveDone=false;
	}
	public void setWaveNum(int x) {
		currentWave=new Wave(x);
		waveNum=x;
	}
	public boolean getWaveStatus() {
		return waveDone;
	}
	public boolean spend(int amt) {
		if(amt<currency)
		{
			currency-=amt;
			return true;
		}
		else {
			return false;
		}
	}
	public int getCurrency() {
		return currency;
	}
	public void addCurrency(int amt) {
		currency+=amt;
	}
	public Player getShip() {
		return ship;
	}
	public Hotbar getHotbar() {
		return hotbar;
	}
}