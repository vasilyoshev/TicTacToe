package logic;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainMenuFrame extends JFrame{
	
	public MainMenuFrame() {
		getContentPane().setLayout(null);
		setTitle("Tic-tac-toe");
		setBounds(100, 100, 300, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 111, 264, 239);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnSingleplayer = new JButton("Singleplayer");
		panel.add(btnSingleplayer);
		
		JButton btnMultiplayer = new JButton("Multiplayer");
		panel.add(btnMultiplayer);
		
		JButton btnCouchCoop = new JButton("Couch Co-Op");
		btnCouchCoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new CouchCoopFrame();
				f.setVisible(true);
				setVisible(false);
				dispose();
				
			}
		});
		panel.add(btnCouchCoop);

		JLabel lblTictactoe = new JLabel("Tic-tac-toe");
		lblTictactoe.setFont(new Font("Monospaced", Font.PLAIN, 20));
		lblTictactoe.setHorizontalAlignment(SwingConstants.CENTER);
		lblTictactoe.setBounds(10, 22, 264, 67);
		getContentPane().add(lblTictactoe);
	}
}
