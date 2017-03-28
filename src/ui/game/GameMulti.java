package ui.game;

import java.awt.event.MouseEvent;
import java.io.IOException;

import logic.Seed;
import network.Client;
import network.Server;
import network.Utils;

@SuppressWarnings("serial")
public class GameMulti extends Game {

	public boolean isMyTurn;
	private final Seed mySeed;

	public GameMulti(boolean isMyTurn) {
		super();
		this.isMyTurn = isMyTurn;
		mySeed = isMyTurn ? Seed.CROSS : Seed.NOUGHT;
	}

	@Override
	public void initGame() {
		super.initGame();
	}
	
	@Override
	public void click(MouseEvent e) {
		// super.click(e);
		int mouseX = e.getX();
		int mouseY = e.getY();
		// Get the row and column clicked
		rowSelected = mouseY / CELL_SIZE;
		colSelected = mouseX / CELL_SIZE;

		if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0 && colSelected < COLS
				&& board.cells[rowSelected][colSelected].content == Seed.EMPTY && isMyTurn) {
			board.cells[rowSelected][colSelected].content = currentPlayer; // move
			Utils.sendMove(rowSelected, colSelected);
			updateGame(currentPlayer, rowSelected, colSelected); // update
																	// currentState
		}
		// Refresh the drawing canvas
		repaint(); // Call-back paintComponent().
	}
	
	public void receiveMove(int[] move) {
		rowSelected = move[0];
		colSelected = move[1];
		board.cells[rowSelected][colSelected].content = currentPlayer;
		updateGame(currentPlayer, rowSelected, colSelected);
		repaint();
	}

	@Override
	public void updateGame(Seed theSeed, int row, int col) {
		super.updateGame(theSeed, row, col);
		isMyTurn = (mySeed == currentPlayer) ? true : false;
	}

	@Override
	protected void reset() {
		super.reset();
	}
}
