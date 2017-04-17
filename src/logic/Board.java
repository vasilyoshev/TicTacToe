package logic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ui.Image;
import ui.game.GameUtils;

/**
 * The Board class models the ROWS-by-COLS game-board.
 */
public class Board {
	private Cell[][] cells; // composes of 2D array of ROWS-by-COLS Cell

	/**
	 * Constructor to initialize the game board.
	 */
	public Board() {
		// allocate the array
		setCells(new Cell[GameUtils.getRows()][GameUtils.getCols()]);
		for (int row = 0; row < GameUtils.getRows(); ++row) {
			for (int col = 0; col < GameUtils.getCols(); ++col) {
				// allocate element of array
				getCells()[row][col] = new Cell(row, col);
			}
		}
	}

	/**
	 * Initialize (or re-initialize) the game board
	 */
	public void init() {
		for (int row = 0; row < GameUtils.getRows(); ++row) {
			for (int col = 0; col < GameUtils.getCols(); ++col) {
				getCells()[row][col].clear(); // clear the cell content
			}
		}
	}

	/**
	 * @return true if it is a draw
	 */
	public boolean isDraw() {
		for (int row = 0; row < GameUtils.getRows(); row++) {
			for (int col = 0; col < GameUtils.getCols(); col++) {
				if (getCells()[row][col].getContent() == Seed.EMPTY) {
					return false; // an empty seed found, not a draw
				}
			}
		}
		return true; // no empty cell, it's a draw
	}

	/**
	 * @param seed
	 *            the current player
	 * @param seedRow
	 *            Y coordinate of click
	 * @param seedCol
	 *            X coordinate of click
	 * @return true if the player with "seed" has won after placing at (seedRow,
	 *         seedCol)
	 */
	public boolean hasWon(Seed seed, int seedRow, int seedCol) {
		return (getCells()[seedRow][0].getContent() == seed // 3-in-the-row
				&& getCells()[seedRow][1].getContent() == seed && getCells()[seedRow][2].getContent() == seed
				|| getCells()[0][seedCol].getContent() == seed // 3-in-the-column
						&& getCells()[1][seedCol].getContent() == seed && getCells()[2][seedCol].getContent() == seed
				|| seedRow == seedCol // 3-in-the-diagonal
						&& getCells()[0][0].getContent() == seed && getCells()[1][1].getContent() == seed
						&& getCells()[2][2].getContent() == seed
				|| seedRow + seedCol == 2 // 3-in-the-opposite-diagonal
						&& getCells()[0][2].getContent() == seed && getCells()[1][1].getContent() == seed
						&& getCells()[2][0].getContent() == seed);
	}

	/**
	 * Paints itself on the graphics canvas, given the Graphics context.
	 * 
	 * @param g
	 *            graphics context onto which can be drawn
	 */
	public void paint(Graphics g) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(Image.getGrid()));
		} catch (IOException e) {
			throw new RuntimeException("Cannot find Grid image.");
		}
		g.drawImage(img, 0, 0, null);

		// draw all the cells
		for (int row = 0; row < GameUtils.getRows(); ++row) {
			for (int col = 0; col < GameUtils.getCols(); ++col) {
				getCells()[row][col].paint(g); // ask the cell to paint itself
			}
		}
	}

	/**
	 * Getter for cells field.
	 * 
	 * @return the cells
	 */
	public Cell[][] getCells() {
		return cells;
	}

	/**
	 * Setter for cells field.
	 * 
	 * @param cells
	 *            the cells to set
	 */
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
}