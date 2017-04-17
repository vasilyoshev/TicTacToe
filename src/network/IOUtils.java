package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

// final to prevent subclassing and improve efficiency at runtime
public final class IOUtils {
	private static DataInputStream input;
	private static DataOutputStream output;
	private static boolean serverIsFirst;

	/**
	 * Private constructor to prevent instantiation.
	 */
	private IOUtils() {
	}

	/**
	 * Receives move from input stream.
	 */
	public static int[] receiveMove() {
		int[] move = new int[2];
		try {
			// while there is no input wait
			while (getInput().available() == 0)
				;
			for (int i = 0; i < 2; i++) {
				move[i] = getInput().readInt();
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(); // in case of improper usage of code
		}
		return move;
	}

	/**
	 * Sends move to output stream and flushes stream.
	 */
	public static void sendMove(int row, int col) {
		try {
			getOutput().writeInt(row);
			getOutput().writeInt(col);
			getOutput().flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(); // in case of improper usage of code
		}
	}

	/**
	 * Sends name to output stream.
	 */
	public static void sendName(String name) {
		try {
			getOutput().writeUTF(name);
			getOutput().flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(); // in case of improper usage of code
		}
	}

	/**
	 * Receives name from input stream.
	 */
	public static String receiveName() {
		try {
			return getInput().readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(); // in case of improper usage of code
		}
	}

	/**
	 * Sends who starts first to output stream.
	 */
	public static void sendFirst(boolean serverIsFirst) {
		try {
			getOutput().writeBoolean(isServerFirst());
			getOutput().flush();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(); // in case of improper usage of code
		}
	}

	/**
	 * Receive who starts first from input stream.
	 */
	public static boolean receiveFirst() {
		try {
			return getInput().readBoolean();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(); // in case of improper usage of code
		}
	}

	/**
	 * @return the input
	 */
	public static DataInputStream getInput() {
		return input;
	}

	/**
	 * @param input
	 *            the input to set
	 */
	public static void setInput(DataInputStream input) {
		IOUtils.input = input;
	}

	/**
	 * @return the output
	 */
	public static DataOutputStream getOutput() {
		return output;
	}

	/**
	 * @param output
	 *            the output to set
	 */
	public static void setOutput(DataOutputStream output) {
		IOUtils.output = output;
	}

	/**
	 * @return the serverIsFirst
	 */
	public static boolean isServerFirst() {
		return serverIsFirst;
	}

	/**
	 * @param serverIsFirst
	 *            the serverIsFirst to set
	 */
	public static void setServerFirst(boolean serverIsFirst) {
		IOUtils.serverIsFirst = serverIsFirst;
	}
}
