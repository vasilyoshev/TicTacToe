package ui;

public final class Image {

	// Game window
	private static String gameBG = "bgTheme/game/gameBG.png";
	private static String result = "bgTheme/game/result.png";
	private static String theme = "bgTheme/game/ChangeTheme.png";
	private static String themePressed = "bgTheme/game/ChangeThemeSelected.png";
	private static String themeHover = "bgTheme/game/ChangeThemeHover.png";
	private static String newGame = "bgTheme/game/NewGame.png";
	private static String newGamePressed = "bgTheme/game/NewGameSelected.png";
	private static String newGameHover = "bgTheme/game/newGameHover.png";
	private static String grid = "bgTheme/game/grid.png";
	private static String crossImg = "bgTheme/game/X.png";
	private static String noughtImg = "bgTheme/game/O.png";
	private static String xWins = "bgTheme/game/xWins.png";
	private static String oWins = "bgTheme/game/oWins.png";
	private static String draw = "bgTheme/game/draw.png";

	// Menu windows
	private static String menuBG = "bgTheme/menu/menuBG.png";
	private static String TTTMain = "bgTheme/menu/main/ticTacToe.png";
	private static String playLarge = "bgTheme/menu/playL.png";
	private static String playLargePressed = "bgTheme/menu/playLPressed.png";
	private static String playLargeHover = "bgTheme/menu/playLHover.png";
	private static String singlePlayer = "bgTheme/menu/main/single.png";
	private static String singlePlayerPressed = "bgTheme/menu/main/singlePressed.png";
	private static String singlePlayerHover = "bgTheme/menu/main/singleHover.png";
	private static String multiPlayer = "bgTheme/menu/main/multi.png";
	private static String multiPlayerPressed = "bgTheme/menu/main/multiPressed.png";
	private static String multiPlayerHover = "bgTheme/menu/main/multiHover.png";
	private static String couchCoOp = "bgTheme/menu/main/couch.png";
	private static String couchCoOpPressed = "bgTheme/menu/main/couchPressed.png";
	private static String couchCoOpHover = "bgTheme/menu/main/couchHover.png";
	private static String playSmall = "bgTheme/menu/playS.png";
	private static String playSmallPressed = "bgTheme/menu/playSPressed.png";
	private static String playSmallHover = "bgTheme/menu/playSHover.png";

	// text color
	private static int red = 49;
	private static int green = 149;
	private static int blue = 210;

	private Image() {
	}

	public static void changeTheme(String theme) {
		switch (theme) {
		case "default":
			applyDefault();
			break;
		case "second":
			applySecond();
			break;
		}
	}

	private static void applyDefault() {
		gameBG = "bgTheme/game/gameBG.png";
		result = "bgTheme/game/result.png";
		theme = "bgTheme/game/ChangeTheme.png";
		themePressed = "bgTheme/game/ChangeThemeSelected.png";
		themeHover = "bgTheme/game/ChangeThemeHover.png";
		newGame = "bgTheme/game/NewGame.png";
		newGamePressed = "bgTheme/game/NewGameSelected.png";
		newGameHover = "bgTheme/game/newGameHover.png";
		grid = "bgTheme/game/grid.png";
		crossImg = "bgTheme/game/X.png";
		noughtImg = "bgTheme/game/O.png";

		// Menu windows
		menuBG = "bgTheme/menu/menuBG.png";
		TTTMain = "bgTheme/menu/main/ticTacToe.png";
		playLarge = "bgTheme/menu/playL.png";
		playLargePressed = "bgTheme/menu/playLPressed.png";
		playLargeHover = "bgTheme/menu/playLHover.png";
		singlePlayer = "bgTheme/menu/main/single.png";
		singlePlayerPressed = "bgTheme/menu/main/singlePressed.png";
		singlePlayerHover = "bgTheme/menu/main/singleHover.png";
		multiPlayer = "bgTheme/menu/main/multi.png";
		multiPlayerPressed = "bgTheme/menu/main/multiPressed.png";
		multiPlayerHover = "bgTheme/menu/main/multiHover.png";
		couchCoOp = "bgTheme/menu/main/couch.png";
		couchCoOpPressed = "bgTheme/menu/main/couchPressed.png";
		couchCoOpHover = "bgTheme/menu/main/couchHover.png";
		playSmall = "bgTheme/menu/playS.png";
		playSmallPressed = "bgTheme/menu/main/playSPressed.png";
		playSmallHover = "bgTheme/menu/main/playSHover.png";
		// instances

		// text color
		red = 49;
		green = 149;
		blue = 210;
	}

	private static void applySecond() {
		gameBG = "bgTheme/game/gameBG.png";
		result = "bgTheme/game/result.png";
		theme = "bgTheme/game/ChangeTheme.png";
		themePressed = "bgTheme/game/ChangeThemeSelected.png";
		themeHover = ""; // TODO
		newGame = "bgTheme/game/NewGame.png";
		newGamePressed = "bgTheme/game/NewGameSelected.png";
		newGameHover = ""; // TODO
		grid = "bgTheme/game/grid.png";
		crossImg = "bgTheme/game/X.png";
		noughtImg = "bgTheme/game/O.png";

		// Menu windows
		menuBG = "bgTheme/menu/menuBG.png";
		TTTMain = "bgTheme/menu/main/ticTacToe.png";
		playLarge = "bgTheme/menu/playL.png";
		playLargePressed = "bgTheme/menu/playLPressed.png";
		playLargeHover = "bgTheme/menu/playLHover.png";
		singlePlayer = "bgTheme/menu/main/single.png";
		singlePlayerPressed = "bgTheme/menu/main/singlePressed.png";
		singlePlayerHover = "bgTheme/menu/main/singleHover.png";
		multiPlayer = "bgTheme/menu/main/multi.png";
		multiPlayerPressed = "bgTheme/menu/main/multiPressed.png";
		multiPlayerHover = "bgTheme/menu/main/multiHover.png";
		couchCoOp = "bgTheme/menu/main/couch.png";
		couchCoOpPressed = "bgTheme/menu/main/couchPressed.png";
		couchCoOpHover = "bgTheme/menu/main/couchHover.png";
		playSmall = "bgTheme/menu/playS.png";
		playSmallPressed = "bgTheme/menu/main/playSPressed.png";
		playSmallHover = "bgTheme/menu/main/playSHover.png"; // TODO
		// instances

		// text color
		red = 49;
		green = 149;
		blue = 210;
	}

	// Getters and setters

	/**
	 * @return the game background
	 */
	public static String getGameBG() {
		return gameBG;
	}

	/**
	 * @param gameBG
	 *            the game background to set
	 */
	private static void setGameBG(String gameBG) {
		Image.gameBG = gameBG;
	}

	/**
	 * @return the result
	 */

	public static String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	private static void setResult(String result) {
		Image.result = result;
	}

	/**
	 * @return the theme
	 */
	public static String getTheme() {
		return theme;
	}

	/**
	 * @param theme
	 *            the theme to set
	 */
	public static void setTheme(String theme) {
		Image.theme = theme;
	}

	/**
	 * @return the themePressed
	 */
	public static String getThemePressed() {
		return themePressed;
	}

	/**
	 * @param themePressed
	 *            the themePressed to set
	 */
	public static void setThemePressed(String themePressed) {
		Image.themePressed = themePressed;
	}

	/**
	 * @return the themeHover
	 */
	public static String getThemeHover() {
		return themeHover;
	}

	/**
	 * @param themeHover
	 *            the themeHover to set
	 */
	public static void setThemeHover(String themeHover) {
		Image.themeHover = themeHover;
	}

	/**
	 * @return the newgame
	 */
	public static String getNewGame() {
		return newGame;
	}

	/**
	 * @param newGame
	 *            the newGame to set
	 */
	public static void setNewGame(String newGame) {
		Image.newGame = newGame;
	}

	/**
	 * @return the newgamepressed
	 */
	public static String getNewGamePressed() {
		return newGamePressed;
	}

	/**
	 * @param newGamePressed
	 *            the newGamePressed to set
	 */
	public static void setNewGamePressed(String newGamePressed) {
		Image.newGamePressed = newGamePressed;
	}

	/**
	 * @return the newgamehover
	 */
	public static String getNewGameHover() {
		return newGameHover;
	}

	/**
	 * @param newGameHover
	 *            the newGameHover to set
	 */
	private static void setNewGameHover(String newGameHover) {
		Image.newGameHover = newGameHover;
	}

	/**
	 * @return the grid
	 */
	public static String getGrid() {
		return grid;
	}

	/**
	 * @param grid
	 *            the grid to set
	 */
	private static void setGrid(String grid) {
		Image.grid = grid;
	}

	/**
	 * @return the crossimg
	 */
	public static String getCrossImg() {
		return crossImg;
	}

	/**
	 * @param crossImg
	 *            the crossImg to set
	 */
	private static void setCrossImg(String crossImg) {
		Image.crossImg = crossImg;
	}

	/**
	 * @return the noughtimg
	 */
	public static String getNoughtImg() {
		return noughtImg;
	}

	/**
	 * @param noughtImg
	 *            the noughtImg to set
	 */
	private static void setNoughtImg(String noughtImg) {
		Image.noughtImg = noughtImg;
	}

	/**
	 * @return the xWins
	 */
	public static String getxWins() {
		return xWins;
	}

	/**
	 * @param xWins the xWins to set
	 */
	private static void setxWins(String xWins) {
		Image.xWins = xWins;
	}

	/**
	 * @return the oWins
	 */
	public static String getoWins() {
		return oWins;
	}

	/**
	 * @param oWins the oWins to set
	 */
	private static void setoWins(String oWins) {
		Image.oWins = oWins;
	}

	/**
	 * @return the draw
	 */
	public static String getDraw() {
		return draw;
	}

	/**
	 * @param draw the draw to set
	 */
	private static void setDraw(String draw) {
		Image.draw = draw;
	}

	/**
	 * @return the menubg
	 */
	public static String getMenuBG() {
		return menuBG;
	}

	public static void setMenuBG(String menuBG) {
		Image.menuBG = menuBG;
	}

	/**
	 * @return the playlarge
	 */
	public static String getPlaylarge() {
		return playLarge;
	}

	public static void setPlayLarge(String playLarge) {
		Image.playLarge = playLarge;
	}

	/**
	 * @return the playlargepressed
	 */
	public static String getPlaylargepressed() {
		return playLargePressed;
	}

	public static void setPlayLargePressed(String playLargePressed) {
		Image.playLargePressed = playLargePressed;
	}

	/**
	 * @return the playlargehover
	 */
	public static String getPlayLargeHover() {
		return playLargeHover;
	}

	public static void setPlayLargeHover(String playLargeHover) {
		Image.playLargeHover = playLargeHover;
	}

	/**
	 * @return the tttmain
	 */
	public static String getTTTMain() {
		return TTTMain;
	}

	public static void setTTTMain(String tTTMain) {
		TTTMain = tTTMain;
	}

	/**
	 * @return the singleplayer
	 */
	public static String getSinglePlayer() {
		return singlePlayer;
	}

	public static void setSinglePlayer(String singlePlayer) {
		Image.singlePlayer = singlePlayer;
	}

	/**
	 * @return the singleplayerpressed
	 */
	public static String getSingleplayerPressed() {
		return singlePlayerPressed;
	}

	public static void setSinglePlayerPressed(String singlePlayerPressed) {
		Image.singlePlayerPressed = singlePlayerPressed;
	}

	/**
	 * @return the singleplayerhover
	 */
	public static String getSinglePlayerHover() {
		return singlePlayerHover;
	}

	public static void setSinglePlayerHover(String singlePlayerHover) {
		Image.singlePlayerHover = singlePlayerHover;
	}

	/**
	 * @return the multiplayer
	 */
	public static String getMultiPlayer() {
		return multiPlayer;
	}

	public static void setMultiPlayer(String multiPlayer) {
		Image.multiPlayer = multiPlayer;
	}

	/**
	 * @return the multiplayerpressed
	 */
	public static String getMultiPlayerPressed() {
		return multiPlayerPressed;
	}

	public static void setMultiPlayerPressed(String multiPlayerPressed) {
		Image.multiPlayerPressed = multiPlayerPressed;
	}

	/**
	 * @return the multiplayerhover
	 */
	public static String getMultiPlayerHover() {
		return multiPlayerHover;
	}

	public static void setMultiPlayerHover(String multiPlayerHover) {
		Image.multiPlayerHover = multiPlayerHover;
	}

	/**
	 * @return the couchcoop
	 */
	public static String getCouchCoOp() {
		return couchCoOp;
	}

	public static void setCouchCoOp(String couchCoOp) {
		Image.couchCoOp = couchCoOp;
	}

	/**
	 * @return the couchcooppressed
	 */
	public static String getCouchCoOpPressed() {
		return couchCoOpPressed;
	}

	public static void setCouchCoOpPressed(String couchCoOpPressed) {
		Image.couchCoOpPressed = couchCoOpPressed;
	}

	/**
	 * @return the couchcoophover
	 */
	public static String getCouchCoOpHover() {
		return couchCoOpHover;
	}

	public static void setCouchCoOpHover(String couchCoOpHover) {
		Image.couchCoOpHover = couchCoOpHover;
	}

	/**
	 * @return the playsmall
	 */
	public static String getPlaySmall() {
		return playSmall;
	}

	public static void setPlaySmall(String playSmall) {
		Image.playSmall = playSmall;
	}

	/**
	 * @return the playsmallpressed
	 */
	public static String getPlaySmallPressed() {
		return playSmallPressed;
	}

	public static void setPlaySmallPressed(String playSmallPressed) {
		Image.playSmallPressed = playSmallPressed;
	}

	/**
	 * @return the playsmallhover
	 */
	public static String getPlaySmallHover() {
		return playSmallHover;
	}

	public static void setPlaySmallHover(String playSmallHover) {
		Image.playSmallHover = playSmallHover;
	}

	/**
	 * @return the red
	 */
	public static int getRed() {
		return red;
	}

	/**
	 * @param red
	 *            the red to set
	 */
	public static void setRed(int red) {
		Image.red = red;
	}

	/**
	 * @return the green
	 */
	public static int getGreen() {
		return green;
	}

	/**
	 * @param green
	 *            the green to set
	 */
	public static void setGreen(int green) {
		Image.green = green;
	}

	/**
	 * @return the blue
	 */
	public static int getBlue() {
		return blue;
	}

	/**
	 * @param blue
	 *            the blue to set
	 */
	public static void setBlue(int blue) {
		Image.blue = blue;
	}
}