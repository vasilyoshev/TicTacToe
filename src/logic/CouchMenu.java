package logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CouchMenu extends JFrame {
	private JTextField player1;
	private JTextField player2;
	private JButton go;

	public CouchMenu() {
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

		JLabel enterPlayer2 = new JLabel("Player 2(O):");
		enterPlayer2.setBounds(10, 52, 101, 14);

		player2 = new JTextField();
		player2.setBounds(121, 49, 86, 20);
		player2.setColumns(10);

		go = new JButton("GO!");
		go.setBounds(10, 131, 254, 208);
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameMain.player1 = player1.getText();
				GameMain.player2 = player2.getText();
				JFrame frame = new JFrame("Couch Co-op");
				frame.setContentPane(new GameCouch());
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
	}
}
