package logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

@SuppressWarnings("serial")
public class SingleMenu extends JFrame {
	private JTextField player1;
	private JTextField player2;
	private JButton go;
	private JCheckBox compStarts;

	public SingleMenu() {
		getContentPane().setLayout(null);
		setTitle("Couch Co-Op");
		setBounds(100, 100, 300, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 264, 339);
		getContentPane().add(panel);

		JLabel enterPlayer1 = new JLabel("Player 1 (X):");
		enterPlayer1.setBounds(10, 14, 101, 14);

		player1 = new JTextField();
		player1.setBounds(121, 11, 86, 20);
		player1.setColumns(10);

		JLabel enterPlayer2 = new JLabel("Computer (O)");
		enterPlayer2.setBounds(10, 52, 101, 14);

		player2 = new JTextField("Jarvis");
		player2.setBounds(121, 49, 86, 20);
		player2.setColumns(10);

		go = new JButton("GO!");
		go.setBounds(10, 131, 254, 208);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (compStarts.isSelected()) {
					GameSingle.playerFirstChosen = false;
					GameSingle.playerStarts = false;
					GameMain.player1 = player2.getText();
					GameMain.player2 = player1.getText();
				} else {
					GameMain.player1 = player1.getText();
					GameMain.player2 = player2.getText();
				}
				JFrame frame = new JFrame("Couch Co-op");
				frame.setContentPane(new GameSingle());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.pack();
				frame.setLocationRelativeTo(null); // center the application
				frame.setVisible(true); // show it

				setVisible(false);
				dispose();
			}
		});
		go.setFont(new Font("Tahoma", Font.PLAIN, 98));
		panel.setLayout(null);
		panel.add(enterPlayer1);
		panel.add(player1);
		panel.add(enterPlayer2);
		panel.add(player2);
		panel.add(go);

		compStarts = new JCheckBox("Computer starts first");
		compStarts.setBounds(14, 85, 138, 23);
		panel.add(compStarts);
	}
}
