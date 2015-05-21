package general;

import javax.swing.JFrame;

/**
 * @author Tony
 * @version 1.0
 */
public class Main {
	static JFrame end;

	// static OverwatchGUI end;

	public static void main(String[] args) {

		SelectGameGUI gui = new SelectGameGUI();

		gui.setSize(200, 350);
		gui.setResizable(false);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
