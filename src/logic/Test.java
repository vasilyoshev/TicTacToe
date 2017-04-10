package logic;

import javax.swing.SwingUtilities;

import ui.menu.MenuMain;

public class Test {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuMain().setVisible(true);
			}
		});
	}
}
