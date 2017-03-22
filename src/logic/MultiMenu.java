package logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import network.HostGame;
import network.JoinGame;

@SuppressWarnings("serial")
public class MultiMenu extends Menu {
	private JButton joinGame;
	private JButton hostGame;
	

	public MultiMenu() {
		setTitle("Online Game");

		joinGame = new JButton("Join Game");
		joinGame.setBounds(10, 188, 254, 150);
		panel.add(joinGame);
		joinGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGame();
				setVisible(false);
				dispose();
			}
		});

		hostGame = new JButton("Host Game");
		hostGame.setBounds(10, 11, 254, 150);
		panel.add(hostGame);
		hostGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new HostGame();
				setVisible(false);
				dispose();
			}
		});
	}
}
