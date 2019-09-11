import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

//A moving background image. This class is currently not being used.
public class MovingPlain extends JPanel {
	
	private BufferedImage background;
	
	public MovingPlain(BufferedImage background) {
		this.background = background;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background, 0, 0, null);
	}
}
