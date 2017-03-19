package logic;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CouchCoopFrame extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnGo;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public CouchCoopFrame() {
		getContentPane().setLayout(null);
		setTitle("Couch Co-Op");
		setBounds(100, 100, 300, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 264, 339);
		getContentPane().add(panel);

		JLabel lblEnterPlayer = new JLabel("Enter Player 1 name:");
		lblEnterPlayer.setBounds(10, 14, 101, 14);

		textField = new JTextField();
		textField.setBounds(121, 11, 86, 20);
		textField.setColumns(10);

		JLabel lblEnterPlayer_1 = new JLabel("Enter Player 2 name:");
		lblEnterPlayer_1.setBounds(10, 52, 101, 14);

		textField_1 = new JTextField();
		textField_1.setBounds(121, 49, 86, 20);
		textField_1.setColumns(10);

		JLabel lblPlayerMark = new JLabel("Player 1 mark:");
		lblPlayerMark.setBounds(10, 91, 69, 14);

		JRadioButton rdbtnX = new JRadioButton("X");
		rdbtnX.setBounds(85, 87, 39, 23);
		buttonGroup.add(rdbtnX);

		JRadioButton rdbtnO = new JRadioButton("O");
		rdbtnO.setBounds(124, 87, 39, 23);
		buttonGroup.add(rdbtnO);

		btnGo = new JButton("GO!");
		btnGo.setBounds(10, 131, 254, 208);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO JFrame f = new GameMain();
				// f.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 98));
		panel.setLayout(null);
		panel.add(lblEnterPlayer);
		panel.add(textField);
		panel.add(lblEnterPlayer_1);
		panel.add(textField_1);
		panel.add(lblPlayerMark);
		panel.add(rdbtnX);
		panel.add(rdbtnO);
		panel.add(btnGo);
	}
}
