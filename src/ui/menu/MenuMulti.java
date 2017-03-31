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
	public static JTextField hostName; // TODO not public static
	public static JTextField joinName; // TODO not public static

	public MenuMulti() {
		setTitle("Online Game");
		
		ButtonGroup hostOrJoin = new ButtonGroup();
		
		hostGameRadio = new JRadioButton("Host Game as");
		hostGameRadio.setFocusPainted(false);
		hostOrJoin.add(hostGameRadio);
		hostGameRadio.setFont(new Font("Century Gothic", Font.BOLD, 15));
		hostGameRadio.setBounds(17, 19, 130, 20);
		hostGameRadio.setContentAreaFilled(false);
		hostGameRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hostName.setEnabled(true);
				joinName.setEnabled(false);
				portHost.setEnabled(true);
				startFirstCheckbox.setEnabled(true);
				createServer.setEnabled(true);
				IP.setEnabled(false);
				portJoin.setEnabled(false);
				joinServer.setEnabled(false);
			}
		});
		
		joinGameRadio = new JRadioButton("Join Game as");
		joinGameRadio.setFocusPainted(false);
		hostOrJoin.add(joinGameRadio);
		joinGameRadio.setFont(new Font("Century Gothic", Font.BOLD, 15));
		joinGameRadio.setBounds(17, 169, 130, 20);
		joinGameRadio.setContentAreaFilled(false);
		joinGameRadio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hostName.setEnabled(false);
				joinName.setEnabled(true);
				portHost.setEnabled(false);
				startFirstCheckbox.setEnabled(false);
				createServer.setEnabled(false);
				IP.setEnabled(true);
				portJoin.setEnabled(true);
				joinServer.setEnabled(true);
			}
		});

		hostName = new JTextField();
		hostName.setOpaque(false);
		hostName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		hostName.setEnabled(false);
		hostName.setColumns(10);
		hostName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		hostName.setBounds(143, 19, 110, 20);

		joinName = new JTextField();
		joinName.setOpaque(false);
		joinName.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		joinName.setEnabled(false);
		joinName.setColumns(10);
		joinName.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		joinName.setBounds(143, 171, 110, 20);
		
		enterPortHost = new JLabel("Enter port:");
		enterPortHost.setBounds(37, 46, 220, 20);
		enterPortHost.setHorizontalAlignment(SwingConstants.CENTER);
		enterPortHost.setFont(new Font("Century Gothic", Font.PLAIN, 15));

		portHost = new JTextField();
		portHost.setHorizontalAlignment(SwingConstants.CENTER);
		portHost.setBounds(37, 77, 220, 20);
		portHost.setText("8080");
		portHost.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		portHost.setColumns(10);
		portHost.setOpaque(false);
		portHost.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		portHost.setEnabled(false);
		
		startFirstCheckbox = new JCheckBox("Start first");
		startFirstCheckbox.setSelected(true);
		startFirstCheckbox.setFocusPainted(false);
		startFirstCheckbox.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		startFirstCheckbox.setBounds(37, 104, 110, 20);
		startFirstCheckbox.setContentAreaFilled(false);
		startFirstCheckbox.setEnabled(false);
		
		panel.add(startFirstCheckbox);
		
		createServer = new JButton("");
		createServer.setBounds(177, 108, 80, 40);
		createServer.setEnabled(false);
		createServer.setIcon(new ImageIcon(Image.getPlaysmall()));
		createServer.setPressedIcon(new ImageIcon(Image.getPlaysmallpressed()));
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
		
		enterIP = new JLabel("Enter IP:");
		enterIP.setBounds(37, 196, 220, 20);
		enterIP.setHorizontalAlignment(SwingConstants.CENTER);
		enterIP.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		IP = new JTextField();
		IP.setHorizontalAlignment(SwingConstants.CENTER);
		IP.setBounds(37, 227, 220, 20);
		IP.setText("127.0.0.1");
		IP.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		IP.setOpaque(false);
		IP.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		IP.setColumns(10);
		IP.setEnabled(false);
		
		enterPortJoin = new JLabel("Enter port:");
		enterPortJoin.setBounds(37, 258, 220, 20);
		enterPortJoin.setHorizontalAlignment(SwingConstants.CENTER);
		enterPortJoin.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		
		portJoin = new JTextField();
		portJoin.setHorizontalAlignment(SwingConstants.CENTER);
		portJoin.setBounds(37, 289, 220, 20);
		portJoin.setText("8080");
		portJoin.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		portJoin.setOpaque(false);
		portJoin.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		portJoin.setColumns(10);
		portJoin.setEnabled(false);
		
		joinServer = new JButton("");
		joinServer.setBounds(177, 320, 80, 40);
		joinServer.setEnabled(false);
		joinServer.setIcon(new ImageIcon(Image.getPlaysmall()));
		joinServer.setPressedIcon(new ImageIcon(Image.getPlaysmallpressed()));
		joinServer.setContentAreaFilled(false);
		joinServer.setBorderPainted(false);
		joinServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				new Thread(new Client(IP.getText(), Integer.parseInt(portJoin.getText()))).start();
			}
		});
		
		panel.add(hostGameRadio);
		panel.add(joinGameRadio);
		panel.add(hostName);
		panel.add(joinName);
		panel.add(enterPortHost);
		panel.add(portHost);
		panel.add(createServer);
		panel.add(enterIP);
		panel.add(IP);
		panel.add(enterPortJoin);
		panel.add(portJoin);
		panel.add(joinServer);
	}
}
