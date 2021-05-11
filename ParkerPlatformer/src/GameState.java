import java.awt.Graphics;

public class GameState extends State {

	private Hero hero;
	private World world;

	public GameState(Game game) {
		super(game);
		hero = new Hero(game, 100, 100);
		world = new World("");
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		world.tick();
		hero.tick();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		world.render(g);
		hero.render(g);
		
	}

}
