package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Ball extends Rectangle{
	boolean moveUp = true;
	int velocityY = 1;
	int velocityX = 9;
	int regVelocityY = velocityY;
	int regVelocityX = velocityX;
	int smashVelocityY = 3;
	int smashVelocityX = 12;
	boolean smashToggle = false;
	
	public Ball(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	public void draw(Graphics2D pb) {
		pb.drawOval(x, y, width, height);
		if (Math.abs(velocityX) == smashVelocityX) {
			if ((int)(Math.random()*3) == 0) {
				pb.setColor(Color.red);
			}
			if ((int)(Math.random()*3) == 1) {
				pb.setColor(Color.cyan);
			}
			if ((int)(Math.random()*3) == 2) {
				pb.setColor(Color.yellow);
			}
		}
		else {
			pb.setColor(Color.white);
		}
		pb.fillOval(x, y, width, height);
	}
	
	public void randY() {
		if ((int)(Math.random()*4) == 0) {
			velocityY = -regVelocityY;
		}
		if ((int)(Math.random()*4) == 1) {
			velocityY = regVelocityY;
		}
		if ((int)(Math.random()*4) == 2) {
			velocityY = -regVelocityY - 1;
		}
		if ((int)(Math.random()*4) == 3) {
			velocityY = regVelocityY + 1;
		}
	}
	
	public void ballMove() {
		x += velocityX;
		y += velocityY;
		if (y >= (GDV5.getMaxWindowY()-height) || y <= 0) {
			velocityY = -velocityY;
		}
	}
	
	public void paddleLHit(int paddleLY, int paddleLX, int paddleLWidth, int paddleLHeight) {
		if (y >= paddleLY && y <= (paddleLY + paddleLHeight) && x <= (paddleLX + paddleLWidth)) {
			if (GDV5.KeysPressed[KeyEvent.VK_S]) { //smash count
				velocityY = smashVelocityY;
				velocityX = smashVelocityX;
			}
			else {
				velocityX = regVelocityX;
				randY();
			}
		}
	}
	
	public void paddleRHit(int paddleRY, int paddleRX, int ballWidth, int paddleRHeight) {
		if (y >= paddleRY && y <= (paddleRY + paddleRHeight) && x >= (paddleRX - ballWidth)) {
			if (GDV5.KeysPressed[KeyEvent.VK_DOWN]) {
				velocityY = smashVelocityY;
				velocityX = -smashVelocityX;
			}
			else {
				velocityX = -regVelocityX;
				randY();
			}
		}
	}
	
	public void respawn() {
		if (x >= (GDV5.getMaxWindowX()-width) || x <= 0) {
			x = GDV5.getMaxWindowX()/2;
			y = GDV5.getMaxWindowY()/2;
			if (velocityX > 0) {
				velocityX = regVelocityX;
			}
			else {
				velocityX = -regVelocityX;
			}
		}
	}
	
	public boolean leftPoint() {
		if (x >= GDV5.getMaxWindowX()-width) {
			return true;
		}
		return false;
	}
	
	public boolean rightPoint() {
		if (x <= 0) {
			return true;
		}
		return false;
	}
	
	
	
}
