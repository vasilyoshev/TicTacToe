package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

// final to prevent subclassing and improve efficiency at runtime
public final class IOUtils {
	public static DataInputStream input;
	public static DataOutputStream output;

	// private constructor to prevent instantiation
	private IOUtils() {
	}

	public static int[] receiveMove() {
		int[] move = new int[2];
		try {
			while (input.available() == 0)
				;
			for (int i = 0; i < 2; i++) {
				move[i] = input.readInt();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return move;
	}

	public static void sendMove(int row, int col) {
		try {
			output.writeInt(row);
			output.writeInt(col);
			output.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
