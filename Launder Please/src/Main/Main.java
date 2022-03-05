package Main;

import javax.swing.JFrame;

public class Main {
		
		public static void main(String [] args) {			
			JFrame window = new JFrame();
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setResizable(false);
			window.setTitle("Launder Please");
			
			GamePanel gamePanel = new GamePanel();
			window.add(gamePanel);
			
			window.pack();
			
			window.setVisible(true);
			window.setLocationRelativeTo(null);
			gamePanel.setupGame();
			
			gamePanel.startGameThread();
			// allowHackers = no;
		}
}
