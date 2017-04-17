package ui.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import network.Client;
import network.IOUtils;
import network.Server;
import ui.Image;
import ui.game.GameUtils;

@SuppressWarnings("serial")
public class MenuMulti extends Menu {

	private JRadioButton hostGameRadio;
	private JLabel enterPortHost;
	private JTextField portHost;
	private JCheckBox startFirstCheckbox;
	private JButton createServer;

	private JRadioButton joinGameRadio;
	private JLabel enterIP;
	private JTextField IP;
	private JLabel enterPortJoin;
	private JTextField portJoin;
	private JButton joinServer;

	// fields are public static since they are used in the network package
	public static JTextField hostName;
	public static JTextField joinName;

	/**
	 * Default constructor where elements of the frame are created.
	 */
	public MenuMulti() {
		setTitle("Multiplayer");

		ButtonGroup hostOrJoin = new ButtonGroup();

		// Creates Host Game radio button
		hostGameRadio = new JRadioButton("Host Game as");
		hostGameRadio.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		hostGameRadio.setFocusPainted(false);
		hostGameRadio.setFont(new Font("Century Gothic", Font.BOLD, 15));
		hostGameRadio.setBounds(17, 19, 130, 20);
		hostGameRadio.setContentAreaFilled(false);
		hostOrJoin.add(hostGameRadio); // add to group
		hostGameRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hostName.setEnabled(true);
				enterPortHost.setEnabled(true);
				portHost.setEnabled(true);
				startFirstCheckbox.setEnabled(true);
				createServer.setEnabled(true);
				joinName.setEnabled(false);
				IP.setEnabled(false);
				portJoin.setEnabled(false);
				joinServer.setEnabled(false);
				enterIP.setEnabled(false);
				enterPortJoin.setEnabled(false);
			}
		});

		// Creates Join Game radio button
		joinGameRadio = new JRadioButton("Join Game as");
		joinGameRadio.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		joinGameRadio.setFocusPainted(false);
		joinGameRadio.setFont(new Font("Century Gothic", Font.BOLD, 15));
		joinGameRadio.setBounds(17, 169, 130, 20);
		joinGameRadio.setContentAreaFilled(false);
		hostOrJoin.add(joinGameRadio); // add to group
		joinGameRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hostName.setEnabled(false);
				enterPortHost.setEnabled(false);
				portHost.setEnabled(false);
				startFirstCheckbox.setEnabled(false);
				createServer.setEnabled(false);
				joinName.setEnabled(true);
				IP.setEnabled(true);
				portJoin.setEnabled(true);
				joinServer.setEnabled(true);
				enterIP.setEnabled(true);
				enterPortJoin.setEnabled(true);
			}
		});

		// Text field for the name of the server
		hostName = new JTextField();
		hostName.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		hostName.setOpaque(false);
		hostName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		hostName.setEnabled(false);
		hostName.setColumns(10);
		hostName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		hostName.setBounds(143, 19, 110, 20);

		// Text field for the name of the client
		joinName = new JTextField();
		joinName.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		joinName.setOpaque(false);
		joinName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		joinName.setEnabled(false);
		joinName.setColumns(10);
		joinName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		joinName.setBounds(143, 171, 110, 20);

		// Label for entering port for server
		enterPortHost = new JLabel("Enter port:");
		enterPortHost.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		enterPortHost.setBounds(37, 46, 220, 20);
		enterPortHost.setHorizontalAlignment(SwingConstants.CENTER);
		enterPortHost.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		enterPortHost.setEnabled(false);

		// Text field for entering port for server
		portHost = new JTextField();
		portHost.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		portHost.setHorizontalAlignment(SwingConstants.CENTER);
		portHost.setBounds(37, 77, 220, 20);
		portHost.setText("8080");
		portHost.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		portHost.setColumns(10);
		portHost.setOpaque(false);
		portHost.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		portHost.setEnabled(false);

		// Check box for who starts first
		startFirstCheckbox = new JCheckBox("Start first");
		startFirstCheckbox.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		startFirstCheckbox.setSelected(true);
		startFirstCheckbox.setFocusPainted(false);
		startFirstCheckbox.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		startFirstCheckbox.setBounds(37, 104, 110, 20);
		startFirstCheckbox.setContentAreaFilled(false);
		startFirstCheckbox.setEnabled(false);

		// Button for starting a game as server
		createServer = new JButton("");
		createServer.setBounds(177, 108, 80, 40);
		createServer.setEnabled(false);
		createServer.setIcon(new ImageIcon(Image.getPlaySmall()));
		createServer.setPressedIcon(new ImageIcon(Image.getPlaySmallPressed()));
		createServer.setRolloverIcon(new ImageIcon(Image.getPlaySmallHover()));
		createServer.setContentAreaFilled(false);
		createServer.setBorderPainted(false);
		createServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();
				// set name
				if (startFirstCheckbox.isSelected())
					GameUtils.setPlayerX(hostName.getText());
				else
					GameUtils.setPlayerO(hostName.getText());

				new Thread(new Server(Integer.parseInt(portHost.getText()))).start();
				IOUtils.setServerFirst(startFirstCheckbox.isSelected());
			}
		});

		// Label for entering IP for client
		enterIP = new JLabel("Enter IP:");
		enterIP.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		enterIP.setBounds(37, 196, 220, 20);
		enterIP.setHorizontalAlignment(SwingConstants.CENTER);
		enterIP.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		enterIP.setEnabled(false);

		// Text field for entering IP for client
		IP = new JTextField();
		IP.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		IP.setHorizontalAlignment(SwingConstants.CENTER);
		IP.setBounds(37, 227, 220, 20);
		IP.setText("127.0.0.1");
		IP.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		IP.setOpaque(false);
		IP.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		IP.setColumns(10);
		IP.setEnabled(false);

		// Label for entering port for client
		enterPortJoin = new JLabel("Enter port:");
		enterPortJoin.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		enterPortJoin.setBounds(37, 258, 220, 20);
		enterPortJoin.setHorizontalAlignment(SwingConstants.CENTER);
		enterPortJoin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		enterPortJoin.setEnabled(false);
		enterPortJoin.setEnabled(false);

		// Text field for entering port for client
		portJoin = new JTextField();
		portJoin.setForeground(new Color(Image.getRed(), Image.getGreen(), Image.getBlue()));
		portJoin.setHorizontalAlignment(SwingConstants.CENTER);
		portJoin.setBounds(37, 289, 220, 20);
		portJoin.setText("8080");
		portJoin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		portJoin.setOpaque(false);
		portJoin.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		portJoin.setColumns(10);
		portJoin.setEnabled(false);

		// Button for starting game as client
		joinServer = new JButton("");
		joinServer.setBounds(177, 320, 80, 40);
		joinServer.setEnabled(false);
		joinServer.setIcon(new ImageIcon(Image.getPlaySmall()));
		joinServer.setPressedIcon(new ImageIcon(Image.getPlaySmallPressed()));
		joinServer.setRolloverIcon(new ImageIcon(Image.getPlaySmallHover()));
		joinServer.setContentAreaFilled(false);
		joinServer.setBorderPainted(false);
		joinServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new Thread(new Client(IP.getText(), Integer.parseInt(portJoin.getText()))).start();
			}
		});

		// add all elements to the panel
		panel.add(hostGameRadio);
		panel.add(joinGameRadio);
		panel.add(hostName);
		panel.add(joinName);
		panel.add(enterPortHost);
		panel.add(portHost);
		panel.add(startFirstCheckbox);
		panel.add(createServer);
		panel.add(enterIP);
		panel.add(IP);
		panel.add(enterPortJoin);
		panel.add(portJoin);
		panel.add(joinServer);
	}
}
