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
	// Package access
	private Seed content; // Seed.EMPTY, Seed.CROSS, Seed.NOUGHT
	private int row, col; // row and column of this cell

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
		int x1 = col * GameUtils.getCellSize();
		int y1 = row * GameUtils.getCellSize();

		BufferedImage img = null;
		if (content == Seed.CROSS) {
			try {
				img = ImageIO.read(new File(Image.getCrossImg()));
			} catch (IOException e) {
				System.out.println("Cannot find Cross image.");
			}
		} else if (content == Seed.NOUGHT) {
			try {
				img = ImageIO.read(new File(Image.getNoughtImg()));
			} catch (IOException e) {
				System.out.println("Cannot find Nought image.");
			}
		}

		if (img != null)
			g.drawImage(img, x1, y1, null);
	}

	public Seed getContent() {
		return content;
	}

	public void setContent(Seed content) {
		this.content = content;
	}

}