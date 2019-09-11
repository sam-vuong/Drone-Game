import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window extends Canvas {
	
	private JFrame frame;
	
	public Window(int width, int height, String title, DroneGame game) {
		frame = new JFrame(title);
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.setLocationRelativeTo(null); //window is placed at the center of the screen
		//frame.add(background);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
}
