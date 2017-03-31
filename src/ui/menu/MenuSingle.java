package ui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ui.Image;
import ui.game.GameSingle;
import ui.game.GameUtils;

@SuppressWarnings("serial")
public class MenuSingle extends Menu {
	private JTextField playerTextField;
	private JTextField computerTextField;
	private JButton play;
	private JCheckBox compStartsCheckBox;

	public MenuSingle() {
		setTitle("Singleplayer");

		JLabel playerLabel = new JLabel("Player (X):");
		playerLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		playerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		playerLabel.setBounds(38, 38, 220, 20);

		playerTextField = new JTextField();
		playerTextField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		playerTextField.setBounds(38, 69, 220, 20);
		playerTextField.setColumns(10);
		playerTextField.setOpaque(false);
		playerTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		JLabel computerLabel = new JLabel("Computer (O):");
		computerLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		computerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		computerLabel.setBounds(38, 128, 220, 20);

		computerTextField = new JTextField("Jarvis");
		computerTextField.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		computerTextField.setBounds(38, 157, 220, 20);
		computerTextField.setColumns(10);
		computerTextField.setOpaque(false);
		computerTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

		compStartsCheckBox = new JCheckBox("Computer starts first");
		compStartsCheckBox.setFont(new Font("Century Gothic", Font.ITALIC, 11));
		compStartsCheckBox.setBounds(38, 184, 220, 20);
		compStartsCheckBox.setContentAreaFilled(false);
		compStartsCheckBox.setFocusPainted(false);

		play = new JButton("");
		play.setBounds(38, 253, 220, 80);
		play.setIcon(new ImageIcon(Image.getPlaylarge()));
		play.setPressedIcon(new ImageIcon(Image.getPlaylargepressed()));
		play.setRolloverIcon(new ImageIcon(Image.getPlaylargehover()));
		play.setContentAreaFilled(false);
		play.setBorderPainted(false);
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				if (compStartsCheckBox.isSelected()) {
					GameSingle.playerIsX = false;
					GameUtils.setPlayerX(computerTextField.getText());
					GameUtils.setPlayerO(playerTextField.getText());
				} else {
					GameUtils.setPlayerX(playerTextField.getText());
					GameUtils.setPlayerO(computerTextField.getText());
				}
				JFrame frame = new JFrame("Single Game");
				frame.setContentPane(new GameSingle());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.pack();
				frame.setLocationRelativeTo(null); // center the application
				frame.setVisible(true); // show it

			}
		});

		panel.add(playerLabel);
		panel.add(playerTextField);
		panel.add(computerLabel);
		panel.add(computerTextField);
		panel.add(play);
		panel.add(compStartsCheckBox);
	}
}
