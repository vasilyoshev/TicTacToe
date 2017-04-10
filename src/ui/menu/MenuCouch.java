package ui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import ui.Image;
import ui.game.GameCouch;
import ui.game.GameUtils;

@SuppressWarnings("serial")
public class MenuCouch extends Menu {
	private JLabel player1Label;
	private JTextField player1Name;
	private JLabel player2Label;
	private JTextField player2Name;
	private JButton play;

	public MenuCouch() {
		setTitle("Couch Co-Op");

		player1Label = new JLabel("Player 1 (X):");
		player1Label.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		player1Label.setHorizontalAlignment(SwingConstants.CENTER);
		player1Label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		player1Label.setBounds(38, 38, 220, 20);

		player1Name = new JTextField();
		player1Name.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		player1Name.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		player1Name.setBounds(38, 69, 220, 20);
		player1Name.setColumns(10);
		player1Name.setOpaque(false);
		player1Name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		player2Label = new JLabel("Player 2 (O):");
		player2Label.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		player2Label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		player2Label.setHorizontalAlignment(SwingConstants.CENTER);
		player2Label.setBounds(28, 128, 220, 20);

		player2Name = new JTextField();
		player2Name.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		player2Name.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		player2Name.setBounds(38, 157, 220, 20);
		player2Name.setColumns(10);
		player2Name.setOpaque(false);
		player2Name.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		play = new JButton("");
		play.setBounds(38, 253, 220, 80);
		play.setFont(new Font("Century Gothic", Font.PLAIN, 38));
		play.setIcon(new ImageIcon(Image.getPlaylarge()));
		play.setPressedIcon(new ImageIcon(Image.getPlaylargepressed()));
		play.setRolloverIcon(new ImageIcon(Image.getPlayLargeHover()));
		play.setContentAreaFilled(false); // remove def img, leave only icon
		play.setBorderPainted(false); // remove borders of the button
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				GameUtils.setPlayerX(player1Name.getText());
				GameUtils.setPlayerO(player2Name.getText());

				JFrame frame = new JFrame("Couch Co-op");
				frame.setContentPane(new GameCouch());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.pack();
				frame.setLocationRelativeTo(null); // center the
													// application
				frame.setVisible(true); // show it

			}
		});

		panel.add(player1Label);
		panel.add(player1Name);
		panel.add(player2Label);
		panel.add(player2Name);
		panel.add(play);
	}
}
