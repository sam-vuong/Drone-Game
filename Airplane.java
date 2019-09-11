import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

//Represents an enemy airplane that goes from left to right on the screen
public class Airplane {
	
	private int x, y;
	private int width;
	private int velX;
	
	public Airplane(int x, int y, int width) {
		this.x = x;
		this.y = y;
		this.width = width;
		velX = 1;
	}
	
	//Every 1/60th of a second, the airplane's x position is decremented by 1. Need to make it so that this happens once every 100 to 1000ms.
	public void tick() {
		x -= velX;
	}
	
	//Repaints the airplane whenever possible. Need to flip the airplane around (currently, its tail is where the nose should be).
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double body = new Ellipse2D.Double(x, y + width / 3, width - 1, width / 6);
        Ellipse2D.Double wings = new Ellipse2D.Double(x + width / 2, y, width / 6, width - width / 6);
        Ellipse2D.Double nose = new Ellipse2D.Double(x + width - 1, y + width / 3 + width / 18 + 1, width / 24, width / 24);
        Ellipse2D.Double tail = new Ellipse2D.Double(x, y + width / 4, width / 12, width / 3);

        g2.setColor(Color.GRAY);
        g2.fill(wings);
        g2.draw(wings);
        g2.setColor(Color.BLACK);
        g2.fill(body);
        g2.draw(body);
        g2.setColor(Color.YELLOW);
        g2.fill(nose);
        g2.draw(nose);
        g2.setColor(Color.GRAY);
        g2.fill(tail);
        g2.draw(tail);
	}
}
