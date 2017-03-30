package ui.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.Timer;

import AI.AIPlayer;
import AI.AIPlayerTableLookup;
import logic.Seed;

@SuppressWarnings("serial")
public class GameSingle extends Game {

	private AIPlayer aiPlayer;
	public static boolean playerIsX = true;

	public GameSingle() {
		super();
		GameUtils.setMyMove(playerIsX ? true : false);
		initAI(); // TODO make initOpponent in Multi
	}

	@Override
	public void initGame() {
		super.initGame();
		// if AI is starts 1st and not initialized => it's AI's turn (first turn)
		if (!playerIsX && aiPlayer == null) {
			initAI();
			moveAI();
		}
	}

	private void initAI() {
		aiPlayer = new AIPlayerTableLookup(GameUtils.getBoard());
		aiPlayer.setSeed(playerIsX ? Seed.NOUGHT : Seed.CROSS);
	}

	@Override
	public void updateGame(Seed theSeed, int row, int col) {
		super.updateGame(theSeed, row, col);
		// if current player is AI move it
		if (GameUtils.getCurrentPlayer() == aiPlayer.getSeed()) {
			moveAI();
		}
	}
	
	@Override
	public void click(MouseEvent e) {
		super.click(e);
	}

	private void moveAI() {
		GameUtils.setMyMove(false);
		Timer timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				int[] computerMove = aiPlayer.move();
				GameUtils.setRow(computerMove[0]);
				GameUtils.setCol(computerMove[1]);
				GameUtils.getBoard().getCells()[GameUtils.getRow()][GameUtils.getCol()].setContent(GameUtils.getCurrentPlayer());
				GameUtils.setMyMove(true);
				updateGame(GameUtils.getCurrentPlayer(), GameUtils.getRow(), GameUtils.getCol());
				repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
}
