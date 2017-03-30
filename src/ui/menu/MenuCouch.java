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

import ui.game.GameCouch;
import ui.game.GameUtils;

@SuppressWarnings("serial")
public class MenuCouch extends Menu {
	private JLabel player1Label;
	private JTextField player1TextField;
	private JLabel player2Label;
	private JTextField player2TextField;
	private JButton play;

	public MenuCouch() {
		setTitle("Couch Co-Op");

		player1Label = new JLabel("Player 1 (X):");
		player1Label.setHorizontalAlignment(SwingConstants.CENTER);
		player1Label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		player1Label.setBounds(38, 38, 220, 20);

		player1TextField = new JTextField();
		player1TextField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		player1TextField.setBounds(38, 69, 220, 20);
		player1TextField.setColumns(10);
		player1TextField.setOpaque(false);
		player1TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		player2Label = new JLabel("Player 2 (O):");
		player2Label.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		player2Label.setHorizontalAlignment(SwingConstants.CENTER);
		player2Label.setBounds(28, 128, 220, 20);

		player2TextField = new JTextField();
		player2TextField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		player2TextField.setBounds(38, 157, 220, 20);
		player2TextField.setColumns(10);
		player2TextField.setOpaque(false);
		player2TextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		play = new JButton("");
		play.setBounds(38, 253, 220, 80);
		play.setFont(new Font("Century Gothic", Font.PLAIN, 38));
		play.setIcon(new ImageIcon("bgTheme/couch/play.png"));
		play.setPressedIcon(new ImageIcon("bgTheme/couch/playPressed.png"));
		play.setContentAreaFilled(false); // remove def img, leave only icon
		play.setBorderPainted(false); // remove borders of the button
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				GameUtils.setPlayerX(player1TextField.getText());
				GameUtils.setPlayerO(player2TextField.getText());
				JFrame frame = new JFrame("Couch Co-op");
				frame.setContentPane(new GameCouch());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.pack();
				frame.setLocationRelativeTo(null); // center the application
				frame.setVisible(true); // show it
			}
		});

		panel.add(player1Label);
		panel.add(player1TextField);
		panel.add(player2Label);
		panel.add(player2TextField);
		panel.add(play);
	}
}
