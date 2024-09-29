package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import utilities.GDV5;


public class splash{
	
	public String screenSet = "splash";
	String prevScreenSet = "splash";
	public static int winScore = 1;
	
	public splash() {};
	
	public void changeScreen(boolean leftWin, boolean rightWin) {
		if (GDV5.KeysPressed[KeyEvent.VK_P]) screenSet = prevScreenSet;
		if (GDV5.KeysPressed[KeyEvent.VK_R]) screenSet = "splash";
		if (GDV5.KeysPressed[KeyEvent.VK_T]) screenSet = "twoPlay";
		if (GDV5.KeysPressed[KeyEvent.VK_O]) screenSet = "singlePlay";
		if (leftWin) {
			prevScreenSet = screenSet;
			screenSet = "leftWin";
		}
		if (rightWin) {
			prevScreenSet = screenSet;
			screenSet = "rightWin";
		}
	}
	
	public void changeWinScore() {
		if (GDV5.KeysPressed[KeyEvent.VK_1]) winScore = 1;
		if (GDV5.KeysPressed[KeyEvent.VK_2]) winScore = 2;
		if (GDV5.KeysPressed[KeyEvent.VK_3]) winScore = 3;
		if (GDV5.KeysPressed[KeyEvent.VK_4]) winScore = 4;
		if (GDV5.KeysPressed[KeyEvent.VK_5]) winScore = 5;
		if (GDV5.KeysPressed[KeyEvent.VK_6]) winScore = 6;
		if (GDV5.KeysPressed[KeyEvent.VK_7]) winScore = 7;
		if (GDV5.KeysPressed[KeyEvent.VK_8]) winScore = 8;
		if (GDV5.KeysPressed[KeyEvent.VK_9]) winScore = 9;
	}
	
	public void displaySplash(Graphics2D splash) {
		splash.setColor(Color.white);
		splash.setFont(new Font("SansSerif", Font.BOLD, 50));
		splash.drawString("WELCOME TO PONG", (GDV5.getMaxWindowX()/2 - 250), 100);
		splash.setFont(new Font("SansSerif", Font.BOLD, 25));
		splash.drawString("Made By Sasan Liaw", (GDV5.getMaxWindowX()/2 - 120), 130);
		splash.setFont(new Font("SansSerif", Font.BOLD, 200));
		splash.drawString("🏓", (GDV5.getMaxWindowX()/2 - 100), 370);
		splash.setFont(new Font("SansSerif", Font.BOLD, 40));
		splash.drawString("First To " + winScore + " Points Wins", (GDV5.getMaxWindowX()/2 - 200), 500);
		splash.setFont(new Font("SansSerif", Font.ITALIC, 25));
		splash.drawString("[Enter a Number 1-9]", (GDV5.getMaxWindowX()/2 - 112), 530);
		splash.setFont(new Font("SansSerif", Font.BOLD, 40));
		splash.drawString("Press T To Play Two Player", (GDV5.getMaxWindowX()/2 - 252), 620); //140
		splash.drawString("Press O To Play Single Player", (GDV5.getMaxWindowX()/2) - 270, 700);
		splash.setFont(new Font("SansSerif", Font.ITALIC, 25));
		splash.drawString("[You Are Player 2]", (GDV5.getMaxWindowX()/2 - 95), 730);
		
		splash.setFont(new Font("SansSerif", Font.BOLD, 30));
		splash.drawString("PLAYER 1", 100, 300); //left player
		splash.drawString("PLAYER 2", 940, 300); //right player
		
		splash.setFont(new Font("SansSerif", Font.BOLD, 25));
		splash.drawString("W Key: paddle up ", 70, 345);
		splash.drawString("S Key: paddle down", 62, 380);
		splash.drawString("UP Key: paddle up ", 900, 345);
		splash.drawString("DOWN Key: paddle down", 870, 380);
		
	}
	
	public void displayLeftWin(Graphics2D splash) {
		splash.setColor(Color.white);
		splash.setFont(new Font("SansSerif", Font.BOLD, 50));
		if (prevScreenSet == "twoPlay") splash.drawString("PLAYER 1 WINS!", 400, 200);
		if (prevScreenSet == "singlePlay") splash.drawString("COMPUTER WINS!", 375, 200);
		splash.setFont(new Font("SansSerif", Font.BOLD, 200));
		splash.drawString("🏆", (GDV5.getMaxWindowX()/2 - 100), 410);
		splash.setFont(new Font("SansSerif", Font.BOLD, 40));
		splash.drawString("Press R To Return To The Home Screen", 220, 500);
		splash.drawString("Press P To Play Again", 400, 570);
	}
	
	public void displayRightWin(Graphics2D splash) {
		splash.setColor(Color.white);
		splash.setFont(new Font("SansSerif", Font.BOLD, 50));
		splash.drawString("PLAYER 2 WINS!", (400), 200);
		splash.setFont(new Font("SansSerif", Font.BOLD, 200));
		splash.drawString("🏆", (GDV5.getMaxWindowX()/2 - 100), 410);
		splash.setFont(new Font("SansSerif", Font.BOLD, 40));
		splash.drawString("Press R To Return To The Home Screen", 220, 500);
		splash.drawString("Press P To Play Again", 400, 570);
	}
	
	

}
