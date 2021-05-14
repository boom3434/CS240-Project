//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Imports the world, keeps it lookin pretty

import java.awt.Graphics;

public class GameState extends State {

	private World world;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);

	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);

	}

}
