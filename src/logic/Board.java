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
	// package access TODO make setters and getters
	private Cell[][] cells; // composes of 2D array of ROWS-by-COLS Cell
							/** Constructor to initialize the game board */
	public Board() {
		setCells(new Cell[GameUtils.getRows()][GameUtils.getCols()]); // allocate the
															// array
		for (int row = 0; row < GameUtils.getRows(); ++row) {
			for (int col = 0; col < GameUtils.getCols(); ++col) {
				getCells()[row][col] = new Cell(row, col); // allocate element
															// of
															// array
			}
		}
	}

	/** Initialize (or re-initialize) the game board */
	public void init() {
		for (int row = 0; row < GameUtils.getRows(); ++row) {
			for (int col = 0; col < GameUtils.getCols(); ++col) {
				getCells()[row][col].clear(); // clear the cell content
			}
		}
	}

	/** Return true if it is a draw (i.e., no more EMPTY cell) */
	public boolean isDraw() {
		for (int row = 0; row < GameUtils.getRows(); ++row) {
			for (int col = 0; col < GameUtils.getCols(); ++col) {
				if (getCells()[row][col].getContent() == Seed.EMPTY) {
					return false; // an empty seed found, not a draw, exit
				}
			}
		}
		return true; // no empty cell, it's a draw
	}

	/**
	 * Return true if the player with "seed" has won after placing at (seedRow,
	 * seedCol)
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

	/** Paint itself on the graphics canvas, given the Graphics context */
	public void paint(Graphics g) {

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(Image.getGrid()));
		} catch (IOException e) {
			// TODO
		}
		g.drawImage(img, 0, 0, null);

		// Draw all the cells
		for (int row = 0; row < GameUtils.getRows(); ++row) {
			for (int col = 0; col < GameUtils.getCols(); ++col) {
				getCells()[row][col].paint(g); // ask the cell to paint itself
			}
		}
	}

	/**
	 * @return the cells
	 */
	public Cell[][] getCells() {
		return cells;
	}

	/**
	 * @param cells
	 *            the cells to set
	 */
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
}