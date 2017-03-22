package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import logic.Board;
import logic.Cell;
import logic.GameMain;
import logic.GameMulti;
import logic.Seed;

public class Player {
	protected int ROWS = GameMain.ROWS; // number of rows
	protected int COLS = GameMain.COLS; // number of columns

	protected Cell[][] cells; // the board's ROWS-by-COLS array of Cells
	protected Seed mySeed; // computer's seed
	protected Seed oppSeed; // opponent's seed

	Server server;
	Client client;

	DataInputStream in;
	DataOutputStream out;

	public Player(Board board) {
		cells = board.cells;
		server = HostGame.server;
		client = JoinGame.client;
	}

	/** Set/change the seed used by computer and opponent */
	public void setSeed(Seed seed) {
		this.mySeed = seed;
		oppSeed = (mySeed == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
	}

	public Seed getSeed() {
		return mySeed;
	}

	// player uses this to READ opponent move
	public int[] receiveMove() {
		// TODO wait for output from other side
		try { // TODO separate client server plaer in subclasses
			if (!GameMulti.getIsClient()) {
				in = new DataInputStream(server.clientSocket.getInputStream());
			} else {
				in = new DataInputStream(client.socket.getInputStream());
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int[] move = new int[2];
			try {
				while (in.available() == 0); // wait for input
				for (int i = 0; i < 2; i++) {
				move[i] = in.readInt();
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return move;
	}

	// player uses this to WRITE made move
	public void sendMove(int row, int col) {
		try {
			if (!GameMulti.getIsClient())
				out = new DataOutputStream(server.clientSocket.getOutputStream());
			else
				out = new DataOutputStream(client.socket.getOutputStream());
			out.writeInt(row);
			out.writeInt(col);
			out.flush(); // TODO ?
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
