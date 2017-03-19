package logic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The Cell class models each individual cell of the game board.
 */
public class Cell {
	// Package access
	public Seed content; // Seed.EMPTY, Seed.CROSS, Seed.NOUGHT
	public int row, col; // row and column of this cell

	/** Constructor to initialize this cell with the specified row and col */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear(); // clear content
	}

	/** Clear this cell's content to EMPTY */
	public void clear() {
		content = Seed.EMPTY;
	}

	/** Paint itself on the graphics canvas, given the Graphics context */
	public void paint(Graphics g) {
		int x1 = col * GameMain.CELL_SIZE;
		int y1 = row * GameMain.CELL_SIZE;

		BufferedImage img = null;
		if (content == Seed.CROSS) {
			try {
				img = ImageIO.read(new File("x150.png"));
			} catch (IOException e) {
				// TODO
			}
		} else if (content == Seed.NOUGHT) {
			try {
				img = ImageIO.read(new File("o150.png"));
			} catch (IOException e) {
				// TODO
			}
		}

		if (img != null)
			g.drawImage(img, x1, y1, null);
	}
}