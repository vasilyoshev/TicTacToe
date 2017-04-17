package logic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import ui.Image;
import ui.game.GameUtils;

/**
 * The Cell class models each individual cell of the game board.
 */
public class Cell {
	private Seed content;
	private int row, col; // row and column of this cell

	/**
	 * Constructor to initialize this cell with the specified row and column.
	 * 
	 * @param row
	 *            the row of this cell
	 * @param col
	 *            the column of this cell
	 */
	public Cell(int row, int col) {
		this.row = row;
		this.col = col;
		clear(); // clear content
	}

	/**
	 * Clears this cell's content to EMPTY.
	 */
	public void clear() {
		content = Seed.EMPTY;
	}

	/**
	 * Paints itself on the graphics canvas, given the Graphics context.
	 * 
	 * @param g
	 *            graphics context onto which can be drawn
	 */
	public void paint(Graphics g) {
		int x1 = col * GameUtils.getCellSize();
		int y1 = row * GameUtils.getCellSize();

		BufferedImage img = null;
		if (content == Seed.CROSS) {
			try {
				img = ImageIO.read(new File(Image.getCrossImg()));
			} catch (IOException e) {
				throw new RuntimeException("Cannot find Cross image.");
			}
		} else if (content == Seed.NOUGHT) {
			try {
				img = ImageIO.read(new File(Image.getNoughtImg()));
			} catch (IOException e) {
				throw new RuntimeException("Cannot find Nought image.");
			}
		}

		if (img != null)
			g.drawImage(img, x1, y1, null);
	}

	/**
	 * Getter for the content of the cell.
	 */
	public Seed getContent() {
		return content;
	}

	/**
	 * Setter for the content of the cell.
	 * 
	 * @param content
	 *            the content to be set
	 */
	public void setContent(Seed content) {
		this.content = content;
	}
}