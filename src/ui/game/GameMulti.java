package ui.game;

import java.awt.event.MouseEvent;

import logic.Seed;
import network.IOUtils;

@SuppressWarnings("serial")
public class GameMulti extends Game {

	private final Seed mySeed;

	/**
	 * Default constructor to setup the UI and game components.
	 */
	public GameMulti(boolean isMyTurn) {
		super();
		GameUtils.setIsMyMove(isMyTurn);
		mySeed = isMyTurn ? Seed.CROSS : Seed.NOUGHT;
		newGame.setEnabled(false);
	}

	@Override
	public void initGame() {
		super.initGame();
	}

	@Override
	public void click(MouseEvent e) {
		super.click(e);
	}

	/**
	 * Used on Server.java and Client.java to wait for a move.
	 */
	public void receiveMove(int[] move) {
		GameUtils.setRow(move[0]);
		GameUtils.setCol(move[1]);
		GameUtils.getBoard().getCells()[GameUtils.getRow()][GameUtils.getCol()]
				.setContent(GameUtils.getCurrentPlayer());
		updateGame(GameUtils.getCurrentPlayer(), GameUtils.getRow(), GameUtils.getCol());
		repaint();
	}

	@Override
	public void updateGame(Seed theSeed, int row, int col) {
		if (GameUtils.isMyMove())
			IOUtils.sendMove(GameUtils.getRow(), GameUtils.getCol());
		super.updateGame(theSeed, row, col);
		GameUtils.setIsMyMove((mySeed == GameUtils.getCurrentPlayer()) ? true : false);
	}
}