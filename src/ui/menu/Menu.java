package ui.menu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.Image;

@SuppressWarnings("serial")
public abstract class Menu extends JFrame {

	protected JPanel panel;

	/**
	 * Default constructor for setting common rules for all menu frames.
	 */
	public Menu() {
		setBounds(100, 100, 300, 400); // set size of menu frame
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // center the application
		setVisible(true); // show the window

		panel = new JPanel() {
			// adds BG image to the frame
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);

				BufferedImage img = null;
				try {
					img = ImageIO.read(new File(Image.getMenuBG()));
				} catch (IOException e) {
					// TODO
				}

				g.drawImage(img, 0, 0, this);
			}
		};
		add(panel);
		// use absolute layout
		panel.setLayout(null);
	}
}
