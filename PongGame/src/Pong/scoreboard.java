package Pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import utilities.GDV5;

public class scoreboard{
	int scoreLeft = 0;
	int scoreRight = 0;
	
	public scoreboard() {}
	
	public void scoreUpdate(boolean leftPoint, boolean rightPoint) {
		if (leftPoint) {
			scoreLeft += 1;
		}
		if (rightPoint) {
			scoreRight += 1;
		}
	}
	
	public void displayScore(Graphics2D score) {
		score.setColor(Color.white);
		score.setFont(new Font("SansSerif", Font.BOLD, 50));
		score.drawString(scoreLeft + "   " + scoreRight, (GDV5.getMaxWindowX()/2 - 44), 50);
		score.drawString("|", (GDV5.getMaxWindowX()/2), 45);
	}
	
	public boolean leftWin() {
		if (scoreLeft == splash.winScore) {
			return true;
		}
		return false;
	}
	
	public boolean rightWin() {
		if (scoreRight == splash.winScore) {
			return true;
		}
		return false;
	}
	
public void resetScores() {
		scoreLeft = 0;
		scoreRight = 0;
	}
}
