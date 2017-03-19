package logic;

import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		// Run GUI construction codes in Event-Dispatching thread for thread
		// safety
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame(GameMain.TITLE);
				// Set the content-pane of the JFrame to an instance of main
				// JPanel
				frame.setContentPane(new GameMain());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(false);
				frame.pack();
				frame.setLocationRelativeTo(null); // center the application
													// window
				frame.setVisible(true); // show it
			}
		});
	}
}
