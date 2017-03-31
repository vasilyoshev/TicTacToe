package network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

// final to prevent subclassing and improve efficiency at runtime
public final class IOUtils {
	private static DataInputStream input;
	private static DataOutputStream output;
	private static boolean serverIsFirst;

	// private constructor to prevent instantiation
	private IOUtils() {
	}

	public static int[] receiveMove() {
		int[] move = new int[2];
		try {
			while (getInput().available() == 0)
				;
			for (int i = 0; i < 2; i++) {
				move[i] = getInput().readInt();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return move;
	}

	public static void sendMove(int row, int col) {
		try {
			getOutput().writeInt(row);
			getOutput().writeInt(col);
			getOutput().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void sendName(String name) {
		try {
			getOutput().writeUTF(name);
			getOutput().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String receiveName() {
		try {
			return getInput().readUTF();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void sendFirst(boolean serverIsFirst) {
		try {
			getOutput().writeBoolean(isServerFirst());
			getOutput().flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean receiveFirst() {
		try {
			return getInput().readBoolean();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	 * @param input the input to set
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
	 * @param output the output to set
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
	 * @param serverIsFirst the serverIsFirst to set
	 */
	public static void setServerFirst(boolean serverIsFirst) {
		IOUtils.serverIsFirst = serverIsFirst;
	}
}
