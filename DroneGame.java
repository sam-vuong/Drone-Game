import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


//The main class
public class DroneGame extends Canvas implements Runnable {
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = WIDTH/16 * 9; //720
	public static final int AIRPLANE_WIDTH = 100;
	
	private Thread thread;
	private boolean running = false;
	private Handler handler;
	
	private BufferedImage background = null; 
	
	//Constructs an instance of this game
	public DroneGame() {
		//BufferedImage image = null;
		try {
			background = ImageIO.read(new File("res/sky.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//MovingPlain background = new MovingPlain(image);
		new Window(WIDTH, HEIGHT, "Drone Game", this);
		Drone player = new Drone();
		ArrayList<Airplane> planes = new ArrayList<>();
		//add airplanes to the list
		planes.add(new Airplane(WIDTH - 200, 40, AIRPLANE_WIDTH));
		handler = new Handler(player, planes);
		this.addKeyListener(new KeyInput(player));
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double numberOfTicks = 60.0;
		double ns = 1000000000 / numberOfTicks;
		double delta = 0; 
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			//does the following every 1/60th of a second
			while (delta >= 1) {
				tick();
				delta--;
			}
			//always trying to call render()
			if (running)
				render();
			
			frames++;
			
			//does the following every ~1 second
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}

	//tick is called in the run() method every 1/60th of a second
	private void tick() {
		handler.tick();
	}
	
	//Repaints all objects based on their positions whenever possible (called during run())
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.drawImage(background, 0, 0, null);
		g.setColor(Color.WHITE);
		handler.render(g);
		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		new DroneGame();
	}
}
