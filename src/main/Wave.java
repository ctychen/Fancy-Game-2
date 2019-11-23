package main;

import enemies.Boss0;
import enemies.Ninja;

public class Wave {
	private Enemy[] enemyList;
	private Enemy boss;
	private Obstacle[] obstacleList;
	private int maxEnemies, obsDelay;
	
	public Wave(int enemyNum, int obsNum, Enemy bossEnemy, int waveNum) {
		enemyList = new Enemy[enemyNum];
		obstacleList = new Obstacle[obsNum];
		for(int i=0;i<enemyNum;i++) {
			if (waveNum > Ninja.minDif && (int)(Math.random()*Ninja.nMod) == 0)
				enemyList[i] = new Ninja(15+(int)(Math.random()*600),70-(int)(Math.random()*20),5+waveNum/2);
			else
				enemyList[i]= new Enemy(15+(int)(Math.random()*600),70-(int)(Math.random()*20),10+waveNum/2);
		}
		for(int i=0;i<obsNum;i++) {
			int xC = (int) (Math.random() * 600);
			int yC = -50;
			int dx = (int) (Math.random() * 3);
			int dy = (int) (Math.random() * 4) + 1;
			int type = (int) (Math.random() * 3);
			Obstacle newObs = new Obstacle(xC, yC, dx, dy, type);
			obstacleList[i]= newObs;
		}
		maxEnemies=20;
		obsDelay=500;
		this.boss = new Boss0(15+(int)(Math.random()*600),70-(int)(Math.random()*20),60+waveNum);
	}
	public Wave(int waveNum) {
		
	}
	public int getMaxEnemies() {
		return maxEnemies;
	}
	public int getObsDelay() {
		return obsDelay;
	}
	public Enemy[] getEnemies() {
		return enemyList;
	}
	public Obstacle[] getObstacles() {
		return obstacleList;
	}
	public Enemy getBoss() {
		return boss;
	}
}
