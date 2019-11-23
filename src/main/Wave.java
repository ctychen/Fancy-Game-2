package main;

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
				enemyList[i] = new Ninja(300,81,10);
			else
				enemyList[i]= new Enemy(300,80,10);
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
		this.boss=bossEnemy;
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
