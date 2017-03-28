package ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MenuMain extends Menu {

	public MenuMain() {
		setTitle("Choose game mode");

		JLabel ticTacToeLabel = new JLabel("");
		panel.add(ticTacToeLabel);
		ticTacToeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ticTacToeLabel.setBounds(38, 11, 220, 80);
		ticTacToeLabel.setIcon(new ImageIcon("bgTheme/main/ticTacToe.png"));

		JButton singlePlayer = new JButton("");
		panel.add(singlePlayer);
		singlePlayer.setBounds(38, 91, 220, 80);
		singlePlayer.setIcon(new ImageIcon("bgTheme/main/single.png"));
		singlePlayer.setPressedIcon(new ImageIcon("bgTheme/main/singlePressed.png"));
		singlePlayer.setRolloverIcon(new ImageIcon("bgTheme/main/singleHover.png"));
		singlePlayer.setContentAreaFilled(false); // remove def img
		singlePlayer.setBorderPainted(false); // remove borders of the button
		singlePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JFrame f = new MenuSingle();
				f.setVisible(true);
			}
		});

		JButton multiplayer = new JButton("");
		panel.add(multiplayer);
		multiplayer.setBounds(38, 182, 220, 80);
		multiplayer.setIcon(new ImageIcon("bgTheme/main/multi.png"));
		multiplayer.setPressedIcon(new ImageIcon("bgTheme/main/multiPressed.png"));
		multiplayer.setRolloverIcon(new ImageIcon("bgTheme/main/multiHover.png"));
		multiplayer.setContentAreaFilled(false); // remove def img
		multiplayer.setBorderPainted(false); // remove borders of the button
		multiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				JFrame f = new MenuMulti();
				f.setVisible(true);
			}
		});

		JButton couchCoop = new JButton("");
		panel.add(couchCoop);
		couchCoop.setBounds(38, 273, 220, 80);
		couchCoop.setIcon(new ImageIcon("bgTheme/main/couch.png"));
		couchCoop.setPressedIcon(new ImageIcon("bgTheme/main/couchPressed.png"));
		couchCoop.setRolloverIcon(new ImageIcon("bgTheme/main/couchHover.png"));
		couchCoop.setContentAreaFilled(false); // remove def img
		couchCoop.setBorderPainted(false); // remove borders of the button
		couchCoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				JFrame f = new MenuCouch();
				f.setVisible(true);
			}
		});
	}
}
