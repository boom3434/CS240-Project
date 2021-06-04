//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//loads the first map into the game, actually starts the game for the user

package platformer.states;

import java.awt.Graphics;

import platformer.Handler;
import platformer.worlds.World;

public class GameState extends State {
	
	private World world;
	
	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
	}
	
	@Override
	public void tick() {
		world.tick();
	}

	@Override
	public void render(Graphics g) {
		world.render(g);
	}

}
