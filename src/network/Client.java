package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;

import ui.game.GameMulti;
import ui.game.GameUtils;
import ui.menu.MenuMulti;

public class Client implements Runnable {
	protected String IP;
	protected int port;
	public Socket socket;
	protected Thread runningThread;

	public Client(String IP, int port) {
		this.IP = IP;
		this.port = port;
		socket = null;
		IOUtils.setInput(null);
		IOUtils.setOutput(null);
		runningThread = null;
	}

	public void run() {
		synchronized (this) { // TODO do I need this?
			runningThread = Thread.currentThread();
		}

		try {
			connectToServer();
			setupStreams();
			whileConnected();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	private void connectToServer() throws IOException {
		socket = new Socket(IP, port);
	}

	private void setupStreams() throws IOException {
		IOUtils.setOutput(new DataOutputStream(socket.getOutputStream()));
		IOUtils.getOutput().flush();
		IOUtils.setInput(new DataInputStream(socket.getInputStream()));
	}

	private void whileConnected() throws IOException {
		// initialize players and turns
		boolean isFirst = !IOUtils.receiveFirst();
		String opponentName = IOUtils.receiveName();
		IOUtils.sendName(MenuMulti.joinName.getText());
		GameUtils.setPlayerX(isFirst ? MenuMulti.joinName.getText() : opponentName);
		GameUtils.setPlayerO(isFirst ? opponentName : MenuMulti.joinName.getText());

		// initialize turns
		JFrame frame = new JFrame("Multiplayer game as Client");
		GameMulti game = new GameMulti(isFirst);
		frame.setContentPane(game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null); // center the application
		frame.setVisible(true);
		
		while (socket.isConnected()) {
			int[] move = IOUtils.receiveMove();
			game.receiveMove(move);
		}
	}

	public void closeConnection() {
		try {
			IOUtils.getOutput().close(); // Closes the output path to the client
			IOUtils.getInput().close(); // Closes the input path to the server
			socket.close(); // Closes the connection with the client
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
}
