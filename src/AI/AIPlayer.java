package AI;

import logic.Board;
import logic.Cell;
import logic.GameMain;
import logic.Seed;

/**
 * Abstract superclass for all AI players with different strategies. To
 * construct an AI player: 1. Construct an instance (of its subclass) with the
 * game Board 2. Call setSeed() to set the computer's seed 3. Call move() which
 * returns the next move in an int[2] array of {row, col}.
 *
 * The implementation subclasses need to override abstract method move(). They
 * shall not modify Cell[][], i.e., no side effect expected. Assume that next
 * move is available, i.e., not game-over yet.
 */
public abstract class AIPlayer {
	protected int ROWS = GameMain.ROWS; // number of rows
	protected int COLS = GameMain.COLS; // number of columns

	protected Cell[][] cells; // the board's ROWS-by-COLS array of Cells
	protected Seed mySeed; // computer's seed
	protected Seed oppSeed; // opponent's seed

	/** Constructor with reference to game board */
	public AIPlayer(Board board) {
		cells = board.cells;
	}

	/** Set/change the seed used by computer and opponent */
	public void setSeed(Seed seed) {
		this.mySeed = seed;
		oppSeed = (mySeed == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
}
	
	public Seed getSeed() {
		return mySeed;
	}

/** Abstract method to get next move. Return int[2] of {row, col} */
   public abstract int[] move(); // to be implemented by subclasses
}