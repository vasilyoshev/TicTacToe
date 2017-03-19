package logic;

import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class GameCouch extends GameMain {

	GameCouch() {
		super();
	}

	public void click(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		// Get the row and column clicked
		int rowSelected = mouseY / CELL_SIZE;
		int colSelected = mouseX / CELL_SIZE;

		if (currentState == State.PLAYING) {
			if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0 && colSelected < COLS
					&& board.cells[rowSelected][colSelected].content == Seed.EMPTY) {
				board.cells[rowSelected][colSelected].content = currentPlayer; // move
				updateGame(currentPlayer, rowSelected, colSelected); // update
																		// currentState
				// Switch player
				currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
			}

			// Refresh the drawing canvas
			repaint(); // Call-back paintComponent().
		}
	}
}
