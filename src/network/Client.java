package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import logic.GameMulti;

public class Client {

	protected String IP;
	protected int port;
	public Socket socket;
	OutputStream out;
	InputStream in;
	GameMulti game;

	public Client(String IP, int port) {
		this.IP = IP;
		this.port = port;
	}
	
	public void run() {
		try {
			socket = new Socket(IP, port);
			
			GameMulti.setIsClient(true);
			JFrame frame = new JFrame("Client Game");
			frame.setContentPane(new GameMulti());
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
			frame.pack();
			frame.setLocationRelativeTo(null); // center the application
			frame.setVisible(true); // show it
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
