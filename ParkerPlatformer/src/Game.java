//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Controls flow of the game (Start, stop)
//Draws assets to the screen
//Handles buffering and framerate

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

	private Display display;
	public int width, height;
	private boolean running = false;
	private Thread thread;
	public String title;

	private BufferStrategy bs;
	private Graphics g;
	
	//Input
	private KeyManager keyManager;
	
	//States
	private State gameState;
	private State menuState;
	private State settingState;

	private BufferedImage test;
	private SpriteSheet sheet;

	// temp
	private BufferedImage testImage;

	// creator for game window
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	// helps game run well. don't touch
	private void init() {
		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		settingState = new SettingState(this);
		State.setState(gameState);
	}


	// helps game run well. don't touch
	private void tick() {
		keyManager.tick();
		if(State.getState() != null) {
			State.getState().tick();
		}
	}

	// this method physcially adds graphics to the game window, this is where you
	// 'draw' the graphics
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();
		// Clear screen
		g.clearRect(0, 0, width, height);
		// Draw here
		
		if(State.getState() != null) {
			State.getState().render(g);
		}
	
		// End drawing
		bs.show();
		g.dispose();
	}

	// this method ensures that the game is running well on the computer, don't
	// change it
	public void run() {

		init();

		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}

		stop();
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}

	// starts the game. don't touch
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	// stops the game. Don't touch
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
