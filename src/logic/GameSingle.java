package logic;

import java.awt.event.MouseEvent;

import AI.AIPlayer;
import AI.AIPlayerTableLookup;

@SuppressWarnings("serial")
public class GameSingle extends GameMain {

	private AIPlayer aiPlayer;
	public static boolean playerFirstChosen = true;
	public static boolean playerStarts = playerFirstChosen;

	GameSingle() {
		super();
		playerStarts = playerFirstChosen;
		initAI();
	}

	public void reset() {
		playerStarts = playerFirstChosen;
		startingPlayer = Seed.CROSS;
		initGame();
		repaint();
	}

	public void initGame() {
		super.initGame();

		if (!playerStarts && aiPlayer != null) {
			currentPlayer = aiPlayer.getSeed();
			moveAI();
		} else if (!playerStarts) {
			initAI();
			moveAI();
		}
	}

	private void initAI() {
		aiPlayer = new AIPlayerTableLookup(board);
		aiPlayer.setSeed(playerStarts ? Seed.NOUGHT : Seed.CROSS);
	}

	public void updateGame(Seed theSeed, int row, int col) {
		super.updateGame(theSeed, row, col);

		if (currentState == State.CROSS_WON || currentState == State.NOUGHT_WON) {
			if (currentPlayer == aiPlayer.getSeed()) {
				playerStarts = false;
			} else {
				playerStarts = true;
			}
		}
	}

	public void click(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		// Get the row and column clicked
		rowSelected = mouseY / CELL_SIZE;
		colSelected = mouseX / CELL_SIZE;

		if (currentState == State.PLAYING) {
			if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0 && colSelected < COLS
					&& board.cells[rowSelected][colSelected].content == Seed.EMPTY) {
				board.cells[rowSelected][colSelected].content = currentPlayer; // move
				updateGame(currentPlayer, rowSelected, colSelected); // update
				 // currentState
				// Switch player
				currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
				moveAI();
			}

			// Refresh the drawing canvas
			repaint(); // Call-back paintComponent().
		}
	}

	private void moveAI() {
		if (currentState == State.PLAYING) {
			int[] computerMove = aiPlayer.move();
			rowSelected = computerMove[0];
			colSelected = computerMove[1];
			try {
				Thread.sleep(1000); // TODO 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			board.cells[rowSelected][colSelected].content = currentPlayer;
			updateGame(currentPlayer, rowSelected, colSelected);
			// Switch player
			currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
		}
	}
}
