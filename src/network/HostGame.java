package network;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import logic.Menu;

@SuppressWarnings("serial")
public class HostGame extends Menu {
	
	private JTextField port;
	static Server server; 

	public HostGame() {
		super();
		setTitle("Host Game");

		JLabel enterPort = new JLabel("Enter port:");
		enterPort.setHorizontalAlignment(SwingConstants.CENTER);
		enterPort.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		enterPort.setBounds(75, 31, 125, 30);
		panel.add(enterPort);

		port = new JTextField();
		port.setText("8080");
		port.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		port.setColumns(10);
		port.setBounds(75, 72, 125, 20);
		panel.add(port);

		JButton createServer = new JButton("Create server");
		createServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				server = new Server(Integer.parseInt(port.getText()));
				server.run();
			}
		});
		createServer.setBounds(10, 242, 254, 96);
		panel.add(createServer);
	}
}
