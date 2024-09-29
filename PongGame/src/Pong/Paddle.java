package Pong;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class Paddle extends Rectangle{
	public Paddle(int x, int y, int width, int height) {
		super(x,y,width,height);
	}
	
	int paddleSpeed = 7;
	
	public void draw(Graphics2D pb) {
		pb.setColor(Color.white);
		pb.draw(this);
		pb.fill(this);
	}
	
	public void paddleMoveL() {
		if(GDV5.KeysPressed[KeyEvent.VK_W] && y >= 0) {
			y = y - paddleSpeed;
		}
		if(GDV5.KeysPressed[KeyEvent.VK_S] && y <= (GDV5.getMaxWindowY() - height)) {
			y = y + paddleSpeed;
		}
	}
	
	public void paddleMoveR() {
		if(GDV5.KeysPressed[KeyEvent.VK_UP] && y >= 0) {
			y = y - paddleSpeed;
		}
		if(GDV5.KeysPressed[KeyEvent.VK_DOWN] && y <= (GDV5.getMaxWindowY() - height)) {
			y = y + paddleSpeed;
		}
	}
	
	public void paddleAI(int ballX, int ballY) {
		if (ballX < GDV5.getMaxWindowX()/2) {
			if (y + (height/2) < ballY && y <= (GDV5.getMaxWindowY() - height)) {
				y = y + paddleSpeed;
			}
			if (y + (height/2) > ballY && y >= 0) {
				y = y - paddleSpeed;
			}
		}
	}
	
	public void paddleRespawn(int ballX, int ballWidth) {
		if (ballX >= (GDV5.getMaxWindowX()- ballWidth) || ballX <= 0) y = 350;
	}
	
}
