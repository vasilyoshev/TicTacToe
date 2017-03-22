package logic;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Menu extends JFrame{ // TODO make other menus extend this class

	protected JPanel panel;
	
	public Menu() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 300, 400);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); // center the application
		setVisible(true);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 274, 349);
		getContentPane().add(panel);
	}
	
}
