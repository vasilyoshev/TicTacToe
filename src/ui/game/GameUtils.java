package ui.game;

import logic.Board;
import logic.Seed;
import logic.State;

public final class GameUtils {

	// constants
	private static final int ROWS = 3;
	private static final int COLS = 3;
	private static final int CELL_SIZE = 150; // cell width and height (square)

	// variables for result table
	private static String playerX;
	private static String playerO;
	private static int resultX = 0;
	private static int resultO = 0;

	private static Board board; // the game board
	private static int row; // row selected
	private static int col; // col selected

	private static State currentState; // the current state of the game
	private static Seed currentPlayer; // the current player
	private static Seed startingPlayer = Seed.CROSS;
	private static boolean isMyMove = true; // used in multi and single

	// private constructor to prevent initialization
	private GameUtils() {
	}

	/**
	 * @return the rows
	 */
	public static int getRows() {
		return ROWS;
	}

	/**
	 * @return the cols
	 */
	public static int getCols() {
		return COLS;
	}

	/**
	 * @return the cellSize
	 */
	public static int getCellSize() {
		return CELL_SIZE;
	}

	/**
	 * @return the playerX
	 */
	public static String getPlayerX() {
		return playerX;
	}

	/**
	 * @return the playerO
	 */
	public static String getPlayerO() {
		return playerO;
	}

	/**
	 * @param playerO
	 *            the playerO to set
	 */
	public static void setPlayerO(String playerO) {
		GameUtils.playerO = playerO;
	}

	/**
	 * @param playerX
	 *            the playerX to set
	 */
	public static void setPlayerX(String playerX) {
		GameUtils.playerX = playerX;
	}

	/**
	 * @return the resultX
	 */
	protected static int getResultX() {
		return resultX;
	}

	/**
	 * @param resultX
	 *            the resultX to set
	 */
	protected static void setResultX(int resultX) {
		GameUtils.resultX = resultX;
	}

	/**
	 * @return the resultO
	 */
	protected static int getResultO() {
		return resultO;
	}

	/**
	 * @param resultO
	 *            the resultO to set
	 */
	protected static void setResultO(int resultO) {
		GameUtils.resultO = resultO;
	}

	/**
	 * @return the board
	 */
	static Board getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
	 */
	static void setBoard(Board board) {
		GameUtils.board = board;
	}

	/**
	 * @return the row
	 */
	protected static int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	protected static void setRow(int row) {
		GameUtils.row = row;
	}

	/**
	 * @return the col
	 */
	protected static int getCol() {
		return col;
	}

	/**
	 * @param col
	 *            the col to set
	 */
	protected static void setCol(int col) {
		GameUtils.col = col;
	}

	/**
	 * @return the currentState
	 */
	protected static State getCurrentState() {
		return currentState;
	}

	/**
	 * @param currentState
	 *            the currentState to set
	 */
	protected static void setCurrentState(State currentState) {
		GameUtils.currentState = currentState;
	}

	/**
	 * @return the currentPlayer
	 */
	protected static Seed getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * @param currentPlayer
	 *            the currentPlayer to set
	 */
	protected static void setCurrentPlayer(Seed currentPlayer) {
		GameUtils.currentPlayer = currentPlayer;
	}

	/**
	 * @return the startingPlayer
	 */
	protected static Seed getStartingPlayer() {
		return startingPlayer;
	}

	/**
	 * @param startingPlayer
	 *            the startingPlayer to set
	 */
	protected static void setStartingPlayer(Seed startingPlayer) {
		GameUtils.startingPlayer = startingPlayer;
	}

	/**
	 * @return the isMyMove
	 */
	protected static boolean isMyMove() {
		return isMyMove;
	}

	/**
	 * @param isMyMove
	 *            the isMyMove to set
	 */
	protected static void setIsMyMove(boolean isMyMove) {
		GameUtils.isMyMove = isMyMove;
	}
}
