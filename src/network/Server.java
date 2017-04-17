package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

import ui.game.GameMulti;
import ui.game.GameUtils;

public class Server implements Runnable {

	protected int port;
	protected ServerSocket serverSocket;
	protected Socket clientSocket;
	protected Thread runningThread;

	/**
	 * Default constructor.
	 */
	public Server(int port) {
		this.port = port;
		serverSocket = null;
		clientSocket = null;
		runningThread = null;
	}

	@Override
	public void run() {
		synchronized (this) {
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

	/**
	 * Creates new server socket with the given port.
	 */
	private void openServerSocket() throws IOException {
		serverSocket = new ServerSocket(port);
	}

	/**
	 * Waits until a client connects.
	 */
	private void waitForConnection() throws IOException {
		clientSocket = serverSocket.accept();
	}

	/**
	 * Sets up input and output streams.
	 */
	private void setupStreams() throws IOException {
		IOUtils.setOutput(new DataOutputStream(clientSocket.getOutputStream()));
		IOUtils.getOutput().flush();
		IOUtils.setInput(new DataInputStream(clientSocket.getInputStream()));
	}

	/**
	 * Implements interaction between the client and server.
	 */
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

	/**
	 * Closes streams and sockets.
	 */
	public void closeConnection() {
		try {
			IOUtils.getOutput().close(); // Closes the output path to the client
			IOUtils.getInput().close(); // Closes the input path to the server
			clientSocket.close(); // Closes the connection with the client
			serverSocket.close(); // Closes the server socket
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}