Fancy Game 2
Written November 23-24,2019, by Carl Lerdorf and Osman Wong, with contributions from Claire Chen

Introduction:

This program is basically a shooter game which would hopefully solve two problems:
boredom and lack of knowledge or creativity for game design. 
To elaborate on that, if some random person with free time happens to be bored, 
that person could run this program and the boredom would cease to exist. 
Other people could look at this program for both inspiration and to help understand 
certain concepts crucial for game development that this program relies on.
Primarily, this program is a game. The goal of the game is to last through as many 
waves of enemies as possible, avoiding death by obstacle or enemy projectiles.
The player moves up/down/left/right by using the arrow keys. Ammo is infinite.
Shooting an obstacle causes it to explode.
The player could also die if it is hit by an enemy's bullet. 
The player destroys enemies by hitting them. 

<img width="627" alt="Screen Shot 2021-01-18 at 10 10 48 PM" src="https://user-images.githubusercontent.com/50178083/104995062-83911c80-59da-11eb-9587-5e83de5cef9e.png">

<img width="1260" alt="Screen Shot 2021-01-18 at 10 11 34 PM" src="https://user-images.githubusercontent.com/50178083/104995162-b1766100-59da-11eb-840a-05ee52ae2bda.png">

<img width="637" alt="Screen Shot 2021-01-18 at 10 13 52 PM" src="https://user-images.githubusercontent.com/50178083/104995210-c81cb800-59da-11eb-9135-cac57915423e.png">

Instructions:

Run GameWindow.java to open the game. Press S to start immediately, or press i to see the instructions first.
Pressing S while on that screen will start the game.
After starting, select a starting difficulty of 1, 2, or 3(or preview "GOD MODE", which starts at wave 27.
At any time before or during the game, the L key can be pressed to enable/disable low quality graphics.
The game starts here. Use the arrow keys to move the player. The user has limited Health Points (HP), which are
displayed in the bar at the top left corner. Orange represents how much you have left; black is HP lost. You die
if all your HP is lost. You can lose HP by getting hit by an enemy's bullet, or by colliding with an obstacle.
Your goal is to last through as many waves as possible before you die. You get points and currency
by shooting enemies, obstacles, and for staying alive. In each wave, you must defeat numerous enemies, as well
as a boss that appears after all others are defeated. The game's difficulty increases with each wave, meaning 
that there will be more obstacles and stronger enemies the longer you stay alive for. Hitting Boosts and PowerUps can restore HP 
or give other beneficial effects. Well placed "critical hits" kill the enemy instantly. 
At the end of each wave, you can use a currency that you earn through 
defeating enemies to upgrade your attack, defense, and hp stats, or buy power ups that
can be toggled during future waves. If you die, press F to restart the game (and pay respects).

Classes:

ShooterGame.java contains the logic and mechanics for the game.
ShooterGraphics.java draws the objects in the game, and handles everything graphics-related.
KeyboardInput.java has the codes for commonly used keys; it makes getting key inputs easier.
GameWindow.java contains the main method; run it to open the game.
Shooter.java represents a shooter object; that is, something that can move around and fire projectiles.
	- Player.java represents the character the user plays as. It is a shooter.
	- Enemy.java represents an enemy, which shoots down at the player. It is also a shooter.
		-Boss0, Boss1, Ninja, and Special are subclasses of Enemy.
Projectile.java represents something that's a projectile. It is used to represent the bullets which the user and enemies shoot.
	-Laser.java is a subclass representing a laser-like attack usable by enemies and the player(through power ups).
Obstacle.java represents obstacles, which destroy the player if they come into contact. There are 3 different kinds of obstacles, which are all represented by this class.
Boost.java represents things which give the player extra health points if they are hit.
PowerUp.java is similar to Boost.java, but introduces other kinds of power-ups as well.
Hotbar.java is the side panel that holds power ups saved for future use.
Shop.java represents the shop that can be opened between waves to upgrade stats and buy power ups.
Wave.java represents a wave of enemies.
SidePanel.java represents a panel in the frame, which displays the player's score and the current game difficulty.
Explosion.java is for drawing an explosion gif; its job here is to make things easier when we handle things getting blown up.
ProgressBar.java represents a progress bar (OH REALLY?! HOW DID YOU KNOW?!!) which can be used to display remaining health points.

Resources:

Image sources: codepen.io, Google.
Art made using Krita and MS Paint (when Krita broke).
Ships made using blender and fusion.
Inspiration from Bullethead, Space Invaders, Asteroids.
Thanks Mr. Taylor for random suggestions, tolerating our spam, and providing gifs.
Visual VM used for profiling.


