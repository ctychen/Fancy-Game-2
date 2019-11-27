package main;

import enemies.Boss0;
import enemies.Ninja;

public class Wave {
	private Enemy[] enemyList;
	private Enemy boss;
	private Obstacle[] obstacleList;
	private int maxEnemies, obsDelay;
	
	public void wave(int[] enemyNum, int obsNum, Enemy bossEnemy, int maxEnemies, int obsDelay, int hp, int atk, int def) {
		enemyList = new Enemy[enemyNum[0]+enemyNum[1]+enemyNum[2]];
		obstacleList = new Obstacle[obsNum];int i=0;
		while(i<enemyList.length) {
			double p0=enemyNum[0]/(double)enemyList.length;
			double p1=enemyNum[1]/(double)enemyList.length;
			double p2=enemyNum[2]/(double)enemyList.length;
			int num0=0,num1=0,num2=0;
			double d=Math.random();
			if(d<p0)
			{
				if(num0<enemyNum[0])
				{
					int xC = (int)(Math.random()*500+50);
					int yC = (int)(Math.random()*70+20);
					int hpstat = (int)((Math.random()*hp*0.2)+0.9*hp);
					int atkstat = (int)((Math.random()*atk*0.2)+0.9*atk);
					int defstat = (int)((Math.random()*def*0.2)+0.9*def);
					enemyList[i] = new Enemy(xC,yC,hpstat,atkstat,defstat);
					num0++;
					i++;
				}
			}
			else if(d<p0+p1)
			{
				if(num1<enemyNum[1])
				{
					int xC = (int)(Math.random()*500+50);
					int yC = (int)(Math.random()*70+20);
					int hpstat = (int)((Math.random()*hp*0.2)+0.9*hp);
					int atkstat = (int)((Math.random()*atk*0.2)+0.9*atk);
					int defstat = (int)((Math.random()*def*0.2)+0.9*def);
					enemyList[i] = new enemies.Special(xC,yC,hpstat,atkstat,defstat);
					num1++;
					i++;
				}
			}
			else
			{
				if(num2<enemyNum[2])
				{
					int xC = (int)(Math.random()*500+50);
					int yC = (int)(Math.random()*70+20);
					int hpstat = (int)((Math.random()*hp*0.2)+0.9*hp);
					int atkstat = (int)((Math.random()*atk*0.2)+0.9*atk);
					int defstat = (int)((Math.random()*def*0.2)+0.9*def);
					enemyList[i] = new enemies.Ninja(xC,yC,hpstat/2,atkstat,defstat*3/4);
					num2++;
					i++;
				}
			}
			/*if (waveNum > enemies.Special.minDif && (int)(Math.random()*enemies.Special.nMod) == 0)
				enemyList[i] = new enemies.Special(15+(int)(Math.random()*600),70-(int)(Math.random()*20),15+waveNum/2);
			else if (waveNum > Ninja.minDif && (int)(Math.random()*Ninja.nMod) == 0)
				enemyList[i] = new Ninja(15+(int)(Math.random()*600),70-(int)(Math.random()*20),5+waveNum/2);
			else
				enemyList[i]= new Enemy(15+(int)(Math.random()*600),70-(int)(Math.random()*20),10+waveNum/2);*/
		}
		for(int j=0;j<obsNum;j++) {
			int xC = (int) (Math.random() * 600);
			int yC = -50;
			int dx = (int) (Math.random() * 3);
			int dy = (int) (Math.random() * 4) + 1;
			int type = (int) (Math.random() * 3);
			Obstacle newObs = new Obstacle(xC, yC, dx, dy, type);
			obstacleList[j]= newObs;
		}
		this.maxEnemies=maxEnemies;
		this.obsDelay=obsDelay;
		boss=bossEnemy;
		//this.boss = new enemies.Boss1(15+(int)(Math.random()*600),70-(int)(Math.random()*20),60+waveNum);
	}
	public Wave(int waveNum) {
		switch(waveNum){
		case 1:
			int[] e1 = {10,0,0};
			wave(e1,10,new Enemy(300,50,20,11,9),5,500,10,10,8);
			break;
		case 2:
			int[] e2 = {15,0,0};
			wave(e2,10,new enemies.Special(300,50,20,11,9),5,500,10,10,8);
			break;
		case 3:
			int[] e3 = {13,2,0};
			wave(e3,15,new enemies.Ninja(300,50,10,11,9),7,500,10,10,8);
			break;
		case 4:
			int[] e4 = {15,3,2};
			wave(e4,20,new enemies.Boss0(300,50,20,11,9),10,500,10,10,8);
			break;
		case 5:
			int[] e = {17,5,3};
			wave(e,20,new enemies.Boss1(300,50,20,12,9),10,500,12,11,8);
			break;
		}
		if(waveNum>5) {
			int[] e = {15+waveNum,5+waveNum/2,3+waveNum/2};
			Enemy bossEnemy;
			Double d = Math.random();
			if(d<0.5) {
				bossEnemy=new enemies.Boss0(300+(int)((Math.random()-0.5)*500), 50+(int)((Math.random()-0.5)*50),5020*waveNum*7/5,12*waveNum*7/5,9*waveNum*7/5);
			}
			else
			{
				bossEnemy=new enemies.Boss1(300+(int)((Math.random()-0.5)*500), 50+(int)((Math.random()-0.5)*50),5020*waveNum*7/5,12*waveNum*7/5,9*waveNum*7/5);
			}
			if (Math.random() < 0.1) {
				e[0] = 0;
				e[1] = 0;
				e[2] = 1;
				wave(e, 100+8*waveNum, bossEnemy, 2, (int)(30/Math.log(waveNum)), 12*waveNum*7/5,11*waveNum*4/5,8+waveNum*3/4);
			}
			else
				wave(e,10+2*waveNum,bossEnemy,(int)(10+2*Math.log(waveNum)),(int)(800/Math.log(waveNum)),12*waveNum*7/5,11*waveNum*4/5,8+waveNum*3/4);
		}
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
