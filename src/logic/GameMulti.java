package logic;

import java.awt.event.MouseEvent;

import network.Player;

@SuppressWarnings("serial")
public class GameMulti extends GameMain {
	private Player opponent;
	public static boolean clientStarts; // TODO
	private static boolean isClient;
	private boolean firstMove = true;

	public GameMulti() {
		super();
	}

	public void initOpponent() {
		opponent = new Player(board);
		opponent.setSeed(isClient ? Seed.CROSS : Seed.NOUGHT);
	}

	public void initGame() {
		super.initGame();

		if (isClient && !clientStarts) {
			if (opponent == null)
				initOpponent();
			currentPlayer = opponent.getSeed();
		} else if (!isClient && clientStarts) {
			if (opponent == null)
				initOpponent();
		} else {
			initOpponent();
		}
	}
	
	public void firstMove() {
		if (isClient && !clientStarts) {
			moveOpponent();
		} else if (!isClient && clientStarts) {
			moveOpponent();
		}
	}

	public void updateGame(Seed theSeed, int row, int col) {
		super.updateGame(theSeed, row, col);

		if (currentState == State.CROSS_WON || currentState == State.NOUGHT_WON) {
			if (currentPlayer == opponent.getSeed()) {
				if (isClient) {
					clientStarts = false;
				} else {
					clientStarts = true;
				}
			} else if (currentPlayer != opponent.getSeed()) {
				if (isClient) {
					clientStarts = true;
				} else {
					clientStarts = false;
				}
			}
		}
	}

	private void moveOpponent() {
		if (currentState == State.PLAYING) {
			int[] opponentMove = opponent.receiveMove(); // TODO move()
			rowSelected = opponentMove[0];
			colSelected = opponentMove[1];
			board.cells[rowSelected][colSelected].content = currentPlayer;
			updateGame(currentPlayer, rowSelected, colSelected);
			// Switch player
			currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
		}
	}

	public void click(MouseEvent e) {
		if (firstMove) {
			firstMove();
			firstMove = false;
		}
		
		int mouseX = e.getX();
		int mouseY = e.getY();
		// Get the row and column clicked
		rowSelected = mouseY / CELL_SIZE;
		colSelected = mouseX / CELL_SIZE;

		if (currentState == State.PLAYING) {
			if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0 && colSelected < COLS
					&& board.cells[rowSelected][colSelected].content == Seed.EMPTY) {
				board.cells[rowSelected][colSelected].content = currentPlayer; // move
				// TODO writes to out
				opponent.sendMove(rowSelected, colSelected);
				// TODO move needs to be read and answered, then continue
				updateGame(currentPlayer, rowSelected, colSelected); // update
					repaint();													// currentState
				// Switch player
				currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
				moveOpponent();
			}

			// Refresh the drawing canvas
			repaint(); // Call-back paintComponent().
		}
	}

	public static void setIsClient(boolean isClient) {
		GameMulti.isClient = isClient;
	}

	public static boolean getIsClient() {
		return isClient;
	}

	public void reset() {
		startingPlayer = Seed.CROSS;
		clientStarts = false;
		initGame();
		repaint();
	}
}
