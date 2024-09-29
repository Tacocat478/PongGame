package Pong;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import utilities.GDV5;

public class GameRunner extends GDV5{
	
	private Ball ball = new Ball(GDV5.getMaxWindowX()/2, GDV5.getMaxWindowY()/2, 20, 20);
	private Paddle paddleL = new Paddle(20, 350, 15, 180);
	private Paddle paddleR = new Paddle(1167, 350, 15, 180);
	private scoreboard score = new scoreboard();
	private splash screen = new splash();
	
	
	public static void main(String[] args) {
		GameRunner g = new GameRunner();
		g.start();
	}
	

	@Override
	public void update() {
		//refreshes at 60 fps
		// TODO Auto-generated method stub
		screen.changeWinScore();
		screen.changeScreen(score.leftWin(), score.rightWin());
		if (screen.screenSet.equals("twoPlay") || screen.screenSet.equals("singlePlay")) {
			paddleL.paddleRespawn(ball.x, ball.width);
			paddleR.paddleRespawn(ball.x, ball.width);
			ball.respawn();
			if (screen.screenSet.equals("twoPlay")) paddleL.paddleMoveL();
			if (screen.screenSet.equals("singlePlay")) paddleL.paddleAI(ball.x, ball.y);
			paddleR.paddleMoveR();
			ball.paddleLHit(paddleL.y, paddleL.x, paddleL.width, paddleL.height);
			ball.paddleRHit(paddleR.y, paddleR.x, ball.width, paddleR.height);
			ball.ballMove();
			score.scoreUpdate(ball.leftPoint(), ball.rightPoint());
		}
	}

	@Override
	public void draw(Graphics2D win) {
		//refreshers at the processor speed (approx. 3000 fps)
		// TODO Auto-generated method stub
		if (screen.screenSet.equals("splash")) {
			screen.displaySplash(win);
		}
		if (screen.screenSet.equals("twoPlay") || screen.screenSet.equals("singlePlay")) {
			ball.draw(win);
			paddleL.draw(win);
			paddleR.draw(win);
			score.displayScore(win);
		}
		if (screen.screenSet.equals("leftWin")) {
			screen.displayLeftWin(win);
			score.resetScores();
		}
		if (screen.screenSet.equals("rightWin")) {
			screen.displayRightWin(win);
			score.resetScores();
		}
	}
}
