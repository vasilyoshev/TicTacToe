package ui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import ui.Image;

@SuppressWarnings("serial")
public class MenuMain extends Menu {

	public MenuMain() {
		setTitle("Choose game mode");

		JLabel ticTacToeLabel = new JLabel("");
		panel.add(ticTacToeLabel);
		ticTacToeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ticTacToeLabel.setBounds(38, 11, 220, 80);
		ticTacToeLabel.setIcon(new ImageIcon(Image.getTttmain()));

		JButton singlePlayer = new JButton("");
		panel.add(singlePlayer);
		singlePlayer.setBounds(38, 91, 220, 80);
		singlePlayer.setIcon(new ImageIcon(Image.getSingleplayer()));
		singlePlayer.setPressedIcon(new ImageIcon(Image.getSingleplayerpressed()));
		singlePlayer.setRolloverIcon(new ImageIcon(Image.getSingleplayerhover()));
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
		multiplayer.setIcon(new ImageIcon(Image.getMultiplayer()));
		multiplayer.setPressedIcon(new ImageIcon(Image.getMultiplayerpressed()));
		multiplayer.setRolloverIcon(new ImageIcon(Image.getMultiplayerhover()));
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
		couchCoop.setIcon(new ImageIcon(Image.getCouchcoop()));
		couchCoop.setPressedIcon(new ImageIcon(Image.getCouchcooppressed()));
		couchCoop.setRolloverIcon(new ImageIcon(Image.getCouchcoophover()));
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
