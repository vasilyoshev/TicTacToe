package logic;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class GameMain extends JPanel {
	// Named-constants for the game board
	public static final int ROWS = 3;
	public static final int COLS = 3;
	public static final int CELL_SIZE = 150; // cell width and height (square)
	public static final String TITLE = "Tic Tac Toe";
	private int resultX = 0;
	private int resultO = 0;

	protected Board board; // the game board
	protected State currentState; // the current state of the game
	protected Seed currentPlayer; // the current player
	protected Seed startingPlayer = Seed.CROSS;
	private JLabel resultLabel; // result sign
	private JButton changeTheme; // change theme button
	private JButton newGame; // new game button
	private JButton reset; // reset game button
	private JLabel names; // prints names of players
	private JLabel result; // prints current score
	public static String player1;
	public static String player2;
	
	protected int rowSelected;
	protected int colSelected;

	/** Constructor to setup the UI and game components */
	public GameMain() {

		setLayout(null); // use absolute layout
		setPreferredSize(new Dimension(700, 450));

		resultLabel = new JLabel("Result");
		resultLabel.setIcon(new ImageIcon("result.png"));
		resultLabel.setBounds(464, 26, 220, 65);
		add(resultLabel);

		changeTheme = new JButton("");
		changeTheme.setIcon(new ImageIcon("change theme.png"));
		changeTheme.setBounds(464, 291, 220, 65);
		changeTheme.setContentAreaFilled(false);
		changeTheme.setBorderPainted(false);
		add(changeTheme);
		changeTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO add functionality
			}
		});

		newGame = new JButton("");
		newGame.setIcon(new ImageIcon("new game.png"));
		newGame.setBounds(464, 374, 100, 65);
		newGame.setContentAreaFilled(false); // remove def img, leave only icon
		newGame.setBorderPainted(false); // remove borders of the button
		add(newGame);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initGame();
				repaint();
			}
		});

		reset = new JButton("");
		reset.setIcon(new ImageIcon("reset.png"));
		reset.setBounds(583, 374, 100, 65);
		reset.setContentAreaFilled(false);
		reset.setBorderPainted(false);
		add(reset);
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initGame();
				resultX = 0;
				resultO = 0;
				reset();
			}
		});
		names = new JLabel("<html>" + player1 + "<br><br>" + player2 + "</html>");
		names.setVerticalAlignment(SwingConstants.TOP);
		names.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		names.setBounds(464, 127, 220, 158);
		add(names);

		result = new JLabel("<html>0<br><br>0</html>", SwingConstants.RIGHT);
		result.setVerticalAlignment(SwingConstants.TOP);
		result.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		result.setBounds(604, 127, 80, 158);
		add(result);

		board = new Board(); // allocate the game-board
		initGame(); // Initialize the game variables

		// This JPanel fires MouseEvent
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // mouse-clicked handler
				click(e);
			}
		});
	}

	public void click(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		// Get the row and column clicked
		rowSelected = mouseY / CELL_SIZE;
		colSelected = mouseX / CELL_SIZE;

		if (currentState == State.PLAYING) {
			if (rowSelected >= 0 && rowSelected < ROWS && colSelected >= 0 && colSelected < COLS
					&& board.cells[rowSelected][colSelected].content == Seed.EMPTY) {
				board.cells[rowSelected][colSelected].content = currentPlayer; // move
				updateGame(currentPlayer, rowSelected, colSelected); // update
																		// currentState
				// Switch player
				currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
			}

			// Refresh the drawing canvas
			repaint(); // Call-back paintComponent().
		}
	}
	
	public void reset() {
		currentPlayer = Seed.CROSS;
		repaint();
	}

	/** Initialize the game-board contents and the current-state */
	public void initGame() {
		board.init();
		if (currentState == State.DRAW) {
			currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;
			startingPlayer = currentPlayer;
		} else if (currentState == State.CROSS_WON || currentState == State.NOUGHT_WON) {
			currentPlayer = (currentState == State.CROSS_WON) ? Seed.CROSS : Seed.NOUGHT;
			startingPlayer = currentPlayer;
		} else { // when State is PLAYING
			// currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT :
			// Seed.CROSS;
			currentPlayer = startingPlayer;
		}
		currentState = State.PLAYING;
	}

	/**
	 * Update the currentState after the player with "theSeed" has placed on
	 * (row, col)
	 */
	public void updateGame(Seed theSeed, int row, int col) {
		if (board.hasWon(theSeed, row, col)) { // check for win
			currentState = (theSeed == Seed.CROSS) ? State.CROSS_WON : State.NOUGHT_WON;
			if (currentState == State.CROSS_WON) {
				resultX++;
				names.setText("<html>" + player1 + "<br><br>" + player2 + "</html>");
			} else {
				resultO++;
				names.setText("<html>" + player1 + "<br><br>" + player2 + "</html>");
			}
		} else if (board.isDraw()) { // check for draw
			currentState = State.DRAW;
		}
		// Otherwise, no change to current state (PLAYING).
	}

	/** Custom painting codes on this JPanel */
	@Override
	public void paintComponent(Graphics g) { // invoke via repaint()
		super.paintComponent(g); // fill background
		result.setText("<html>" + resultX + "<br><br>" + resultO + "</html>");
		// add background image
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("background.png"));
		} catch (IOException e) {
			// TODO
		}
		g.drawImage(img, 0, 0, null);

		board.paint(g); // ask the game board to paint itself
	}
}