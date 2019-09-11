import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//Listens for keyboard events.
public class KeyInput extends KeyAdapter {
	
	private Drone drone;
	
	public KeyInput(Drone drone) {
		this.drone = drone;
	}
	
	//keyPressed is called whenever a key is pressed, and the specific key pressed is passed to it. 
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) drone.setUpPressed(true);
		if (key == KeyEvent.VK_DOWN) drone.setDownPressed(true);
		if (key == KeyEvent.VK_LEFT) drone.setLeftPressed(true);
		if (key == KeyEvent.VK_RIGHT) drone.setRightPressed(true);
	}
	//keyReleased is called whenever a key is released, and the specific key released is passed to it.
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP) drone.setUpPressed(false);
		if (key == KeyEvent.VK_DOWN) drone.setDownPressed(false);
		if (key == KeyEvent.VK_LEFT) drone.setLeftPressed(false);
		if (key == KeyEvent.VK_RIGHT) drone.setRightPressed(false);
	}
}