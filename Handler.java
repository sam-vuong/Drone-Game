import java.awt.Graphics;
import java.util.ArrayList;

// Handles all game objects (the drone and airplanes)
public class Handler {

	private Drone player;
	private ArrayList<Airplane> planes;
	
	public Handler(Drone player, ArrayList<Airplane> planes) {
		this.player = player;
		this.planes = planes;
	}
	
	//Calls the tick() method of the drone and all airplanes.
	public void tick() {
		player.tick();
		for (Airplane p : planes) {
			p.tick();
		}
		
	}
	
	//Calls the render() method of the drone and all airplanes.
	public void render(Graphics g) {
		player.render(g);
		for (Airplane p : planes) {
			p.render(g);
		}
	}
}
