package ui.game;

import java.awt.event.MouseEvent;

import AI.AIPlayer;
import AI.AIPlayerTableLookup;
import logic.Seed;

@SuppressWarnings("serial")
public class GameSingle extends Game {

	private AIPlayer aiPlayer;
	public static boolean playerIsX = true;

	public GameSingle() {
		super();
		initAI(); // TODO make initOpponent in Multi
	}

	public void reset() {
		resultX = 0;
		resultO = 0;
		currentPlayer = Seed.CROSS;
		startingPlayer = currentPlayer;
		initGame();
		repaint();
	}

	public void initGame() {
		super.initGame();

		if (!playerIsX && aiPlayer != null && currentPlayer == aiPlayer.getSeed()) {
			moveAI();
		} else if (!playerIsX && aiPlayer == null) {
			initAI();
			if (currentPlayer == aiPlayer.getSeed()) {
				moveAI();
			}
		}
	}

	private void initAI() {
		aiPlayer = new AIPlayerTableLookup(board);
		aiPlayer.setSeed(playerIsX ? Seed.NOUGHT : Seed.CROSS);
	}

	public void updateGame(Seed theSeed, int row, int col) {
		super.updateGame(theSeed, row, col);
		// if current player is AI move it
		if (currentPlayer == aiPlayer.getSeed()) {
			moveAI();
		}
	}

	public void click(MouseEvent e) {
		super.click(e);
	}

	private void moveAI() {
		int[] computerMove = aiPlayer.move();
		rowSelected = computerMove[0];
		colSelected = computerMove[1];
		board.cells[rowSelected][colSelected].content = currentPlayer;
		updateGame(currentPlayer, rowSelected, colSelected);
	}
}
