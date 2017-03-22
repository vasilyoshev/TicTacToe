package network;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logic.GameMulti;
import logic.Menu;

@SuppressWarnings("serial")
public class JoinGame extends Menu {
	private JTextField IP;
	private JTextField port;
	static Client client;

	public JoinGame() {
		super();
		setTitle("Join Game");
		
		JCheckBox startFirst = new JCheckBox("Start first");
		startFirst.setBounds(104, 189, 97, 23);
		panel.add(startFirst);
		
		JLabel enterIP = new JLabel("Enter IP:");
		enterIP.setHorizontalAlignment(SwingConstants.CENTER);
		enterIP.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		enterIP.setBounds(76, 11, 125, 30);
		panel.add(enterIP);
		
		IP = new JTextField();
		IP.setText("127.0.0.1");
		IP.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		IP.setBounds(76, 52, 125, 20);
		panel.add(IP);
		IP.setColumns(10);
		
		JLabel enterPort = new JLabel("Enter port:");
		enterPort.setHorizontalAlignment(SwingConstants.CENTER);
		enterPort.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		enterPort.setBounds(76, 101, 125, 23);
		panel.add(enterPort);
		
		
		port = new JTextField();
		port.setText("8080");
		port.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		port.setColumns(10);
		port.setBounds(76, 135, 125, 20);
		panel.add(port);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				client = new Client(IP.getText(), Integer.parseInt(port.getText()));
				client.run();
			}
		});
		search.setBounds(10, 242, 254, 96);
		panel.add(search);
	}
}
