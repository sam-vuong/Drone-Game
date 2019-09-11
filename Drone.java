import java.awt.Color;
import java.awt.Graphics;

//The player object. Its position is updated every tick(), and it is graphically re-rendered whenever possible. 
public class Drone {
	
	private int x, y;
	private int velX, velY;
	private boolean upPressed, downPressed, leftPressed, rightPressed;
	public static int spd = 5;
	
	public Drone() {
		x = 0; y = 0; velX = 0; velY = 0;
	}
	
	public void setUpPressed(boolean b) {
		this.upPressed = b;
	}
	public void setDownPressed(boolean b) {
		this.downPressed = b;
	}
	public void setLeftPressed(boolean b) {
		this.leftPressed = b;
	}
	public void setRightPressed(boolean b) {
		this.rightPressed = b;
	}
	
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	//Keyboard input. Every tick, the velocity of the drone is determined based on whether or not a key is pressed.
	//As long as a key is pressed, the drone moves in that direction; more specifically, the velocity changes and the drone's x or y position is updated. 
	public void tick() {
		if (upPressed) {
			this.setVelY(-spd);
		}
		if (!upPressed && !downPressed) {
			this.setVelY(0);
		}
		if (downPressed) {
			this.setVelY(spd);
		}
		if (!downPressed && !upPressed) {
			this.setVelY(0);
		}
		if (upPressed && downPressed) {
			this.setVelY(0);
		}
		if (leftPressed) {
			this.setVelX(-spd);
		}
		if (!leftPressed && !upPressed) {
			this.setVelX(0);
		}
		if (rightPressed) {
			this.setVelX(spd);
		}
		if (!rightPressed && !leftPressed) {
			this.setVelX(0);
		}
		if (leftPressed && rightPressed) {
			this.setVelX(0);
		}
		x += velX;
		y += velY;
	}
	
	//Repaints the drone whenever possible with updated positions
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, 32, 32);
	}
}
