package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import logic.GameMulti;
import logic.GameSingle;

public class Server {
	protected int serverPort;
	protected ServerSocket serverSocket = null;
	protected Socket clientSocket = null;
	protected boolean isStopped = false;

	public Server(int port) {
		this.serverPort = port;
	}
	
	public void run() {
		openServerSocket();

		// while (!isStopped()) {
		try {
			clientSocket = this.serverSocket.accept();
		} catch (IOException e) {
			if (isStopped()) {
				System.out.println("Server Stopped.");
				return;
			}
			throw new RuntimeException("Error accepting client connection", e);
		}

		try {
			processClientRequest(clientSocket);
		} catch (IOException e) {
			// log exception and go on to next request.
		}
		// }
	}

	private void processClientRequest(Socket clientSocket) throws IOException {
		JFrame frame = new JFrame("Server Game");
		frame.setContentPane(new GameMulti());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null); // center the application
		frame.setVisible(true); // show it
	}

	private synchronized boolean isStopped() {
		return this.isStopped;
	}

	public synchronized void stop() {
		this.isStopped = true;
		try {
			this.serverSocket.close();
		} catch (IOException e) {
			throw new RuntimeException("Error closing server", e);
		}
	}

	private void openServerSocket() {
		try {
			this.serverSocket = new ServerSocket(this.serverPort);
		} catch (IOException e) {
			throw new RuntimeException("Cannot open port " + serverPort, e);
		}
	}

}
