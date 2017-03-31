package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import ui.game.GameMulti;
import ui.game.GameUtils;
import ui.menu.MenuMulti;

public class Server implements Runnable {

	protected int port;
	protected ServerSocket serverSocket;
	protected Socket clientSocket;
	protected Thread runningThread;
	


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
		IOUtils.setOutput(new DataOutputStream(clientSocket.getOutputStream()));
		IOUtils.getOutput().flush();
		IOUtils.setInput(new DataInputStream(clientSocket.getInputStream()));
	}

	private void whileConnected() throws IOException {
		// initialize players and turns
		IOUtils.sendFirst(IOUtils.isServerFirst());
		IOUtils.sendName(GameUtils.getPlayerX() != null ? GameUtils.getPlayerX() : GameUtils.getPlayerO());
		if (GameUtils.getPlayerX() == null)
			GameUtils.setPlayerX(IOUtils.receiveName());
		else
			GameUtils.setPlayerO(IOUtils.receiveName());
		
		// initialize game
		JFrame frame = new JFrame("Multiplayer game as Server");
		GameMulti game = new GameMulti(IOUtils.isServerFirst());
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
			IOUtils.getOutput().close(); // Closes the output path to the client
			IOUtils.getInput().close(); // Closes the input path to the server
			clientSocket.close(); // Closes the connection with the client
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}