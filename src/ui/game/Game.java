package ui.game;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import logic.Board;
import logic.Seed;
import logic.State;
import ui.Image;

@SuppressWarnings("serial")
public abstract class Game extends JPanel {

	private JLabel resultLabel; // result sign
	private JButton changeTheme; // change theme button
	protected JButton newGame; // new game button
	private JLabel names; // prints names of players
	private JLabel result; // prints current score
	private JDialog end;

	/** Constructor to setup the UI and game components */
	public Game() {

		setLayout(null); // use absolute layout
		setPreferredSize(new Dimension(700, 450));

		resultLabel = new JLabel("Result");
		resultLabel.setIcon(new ImageIcon(Image.getResult()));
		resultLabel.setBounds(464, 26, 220, 65);
		add(resultLabel);

		changeTheme = new JButton("");
		changeTheme.setIcon(new ImageIcon(Image.getTheme()));
		changeTheme.setBounds(464, 291, 220, 65);
		changeTheme.setContentAreaFilled(false);
		changeTheme.setBorderPainted(false);
		changeTheme.setEnabled(false);
		add(changeTheme);
		changeTheme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO add functionality
			}
		});

		newGame = new JButton("");
		newGame.setIcon(new ImageIcon(Image.getNewgame()));
		newGame.setBounds(464, 374, 220, 65);
		newGame.setContentAreaFilled(false); // remove def img, leave only icon
		newGame.setBorderPainted(false); // remove borders of the button
		add(newGame);
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newGame();
			}
		});

		names = new JLabel("<html>" + GameUtils.getPlayerX() + "<br><br>" + GameUtils.getPlayerO() + "</html>");
		names.setVerticalAlignment(SwingConstants.TOP);
		names.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		names.setBounds(464, 127, 220, 158);
		add(names);

		result = new JLabel("<html>0<br><br>0</html>", SwingConstants.RIGHT);
		result.setVerticalAlignment(SwingConstants.TOP);
		result.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		result.setBounds(604, 127, 80, 158);
		add(result);

		// This JPanel fires MouseEvent
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // mouse-clicked handler
				click(e);
			}
		});

		GameUtils.setBoard(new Board()); // allocate the game-board
		initGame(); // Initialize the game variables
	}

	protected void click(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		// Get the row and column clicked
		GameUtils.setRow(mouseY / GameUtils.getCellSize());
		GameUtils.setCol(mouseX / GameUtils.getCellSize());

		if (GameUtils.getRow() >= 0 && GameUtils.getRow() < GameUtils.getRows() && GameUtils.getCol() >= 0
				&& GameUtils.getCol() < GameUtils.getCols()
				&& GameUtils.getBoard().getCells()[GameUtils.getRow()][GameUtils.getCol()].getContent() == Seed.EMPTY
				&& GameUtils.isMyMove()) {
			GameUtils.getBoard().getCells()[GameUtils.getRow()][GameUtils.getCol()]
					.setContent(GameUtils.getCurrentPlayer()); // move
			updateGame(GameUtils.getCurrentPlayer(), GameUtils.getRow(), GameUtils.getCol()); // update
			// currentState
		}
		// Refresh the drawing canvas
		repaint(); // Call-back paintComponent().
	}

	protected void newGame() {
		GameUtils.setResultX(0);
		GameUtils.setResultO(0);
		initGame();
		GameUtils.setCurrentPlayer(Seed.CROSS);
		GameUtils.setStartingPlayer(GameUtils.getCurrentPlayer());
		repaint();
	}

	/** Initialize the game-board contents and the current-state */
	public void initGame() {
		Timer timer = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GameUtils.getBoard().init();
				repaint();
			}
		});
		timer.setRepeats(false);
		timer.start();

		if (GameUtils.getCurrentState() == State.CROSS_WON || GameUtils.getCurrentState() == State.NOUGHT_WON) {
			GameUtils.setCurrentPlayer((GameUtils.getCurrentState() == State.CROSS_WON) ? Seed.CROSS : Seed.NOUGHT);
			GameUtils.setStartingPlayer(GameUtils.getCurrentPlayer());

		} else { // when State is PLAYING
			GameUtils.setCurrentPlayer(GameUtils.getStartingPlayer());
		}
		GameUtils.setCurrentState(State.PLAYING);
	}

	/**
	 * Update the currentState after the player with "theSeed" has placed on
	 * (row, col)
	 */
	public void updateGame(Seed theSeed, int row, int col) {
		if (GameUtils.getBoard().hasWon(theSeed, row, col)) { // check for win
			GameUtils.setCurrentState((theSeed == Seed.CROSS) ? State.CROSS_WON : State.NOUGHT_WON);
			
			end = new JDialog();
			end.setResizable(false);
			end.setLocationRelativeTo(SwingUtilities.getWindowAncestor(this));
			// removes frame
			end.setUndecorated(true);
			
			if (GameUtils.getCurrentState() == State.CROSS_WON) {
				end.add(new JLabel(new ImageIcon(Image.getCouchcoop()))); 
				// TODO add X won
				end.pack();
				end.setVisible(true);
				
				GameUtils.setResultX(GameUtils.getResultX() + 1);
				names.setText("<html>" + GameUtils.getPlayerX() + "<br><br>" + GameUtils.getPlayerO() + "</html>");
			} else {
				end.add(new JLabel(new ImageIcon(Image.getCouchcoop()))); 
				// TODO add O won
				end.pack();
				end.setVisible(true);
				
				GameUtils.setResultO(GameUtils.getResultO() + 1);
				names.setText("<html>" + GameUtils.getPlayerX() + "<br><br>" + GameUtils.getPlayerO() + "</html>");
			}
			
			Timer timer = new Timer(1000, new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					end.dispose();
				}
			});
			timer.setRepeats(false);
			timer.start();
			// TODO Display crossed triple
			initGame();
		} else if (GameUtils.getBoard().isDraw()) { // check for draw
			GameUtils.setCurrentState(State.DRAW);
			end = new JDialog();
			end.setResizable(false);
			end.setLocation(460, 330);
			end.setUndecorated(true);
			end.add(new JLabel(new ImageIcon(Image.getCouchcoop()))); 
			// TODO add draw
			end.pack();
			end.setVisible(true);
			// TODO display DRAW message
			initGame();
		} else { // PLAYING
			// Switch player
			GameUtils.setCurrentState(State.PLAYING);
			GameUtils.setCurrentPlayer((GameUtils.getCurrentPlayer() == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS);
		}
	}

	/** Custom painting codes on this JPanel */
	@Override
	public void paintComponent(Graphics g) { // invoke via repaint()
		super.paintComponent(g); // fill background
		result.setText("<html>" + GameUtils.getResultX() + "<br><br>" + GameUtils.getResultO() + "</html>");
		// add background image
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(Image.getGamebg()));
		} catch (IOException e) {
			// TODO
		}
		g.drawImage(img, 0, 0, null);

		GameUtils.getBoard().paint(g); // ask the game board to paint itself
	}
}