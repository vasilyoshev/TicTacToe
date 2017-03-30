package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import ui.game.GameMulti;

public class Server implements Runnable {

	protected int port;
	protected ServerSocket serverSocket;
	protected Socket clientSocket;
	protected Thread runningThread;

	GameMulti p;
	JFrame f;

	public Server(int port) {
		this.port = port;
		serverSocket = null;
		clientSocket = null;
		runningThread = null;
	}

	public void run() {
		synchronized (this) { // TODO do I need this?
			runningThread = Thread.currentThread();
		}

		try {
			openServerSocket();
			waitForConnection();
			setupStreams();
			whileConnected();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private void openServerSocket() throws IOException {
		serverSocket = new ServerSocket(port);
	}

	private void waitForConnection() throws IOException {
		clientSocket = serverSocket.accept();
	}

	private void setupStreams() throws IOException {
		IOUtils.output = new DataOutputStream(clientSocket.getOutputStream());
		IOUtils.output.flush();
		IOUtils.input = new DataInputStream(clientSocket.getInputStream());
	}

	private void whileConnected() throws IOException {
		JFrame frame = new JFrame("Multiplayer game as Server");
		GameMulti game = new GameMulti(true);
		frame.setContentPane(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null); // center the application
		frame.setVisible(true); // show it

		while (clientSocket.isConnected()) {
			int[] move = IOUtils.receiveMove();
			game.receiveMove(move);
		}
	}

	public void closeConnection() {
		try {
			IOUtils.output.close(); // Closes the output path to the client
			IOUtils.input.close(); // Closes the input path to the server
			clientSocket.close(); // Closes the connection with the client
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}