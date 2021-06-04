//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//Handles everything that can be interacted with inside the game

package platformer.worlds;

import java.awt.Graphics;

import platformer.Handler;
import platformer.entities.EntityManager;
import platformer.entities.creatures.Hero;
import platformer.entities.creatures.enemy0;
import platformer.entities.creatures.enemy1;
import platformer.entities.statics.Rock;
import platformer.entities.statics.Tree;
import platformer.entities.statics.winFlag;
import platformer.tiles.Tile;
import platformer.utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	// Entities
	private EntityManager entityManager;

	int healthRemind = 0;

	public World(Handler handler, String path) {
		this.handler = handler;
		entityManager = new EntityManager(handler, new Hero(handler, 100, 100));
		
		entityManager.addEntity(new Tree(handler, 100, 250));
		entityManager.addEntity(new Rock(handler, 100, 450));
		entityManager.addEntity(new Rock(handler, 100, 700));
		entityManager.addEntity(new Tree(handler, 400, 600));

		loadWorld(path);

		entityManager.getPlayer().setX(150);
		entityManager.getPlayer().setY(150);
		// First enemies you see to upper right
		entityManager.addEntity(new enemy0(handler, 350, 150, 50, 50));
		entityManager.addEntity(new enemy0(handler, 550, 250, 50, 50));
		// Enemies in 'hallway' that travels south
		entityManager.addEntity(new enemy1(handler, 700, 200, 50, 50));
		entityManager.addEntity(new enemy1(handler, 700, 700, 50, 50));
		entityManager.addEntity(new enemy1(handler, 600, 500, 50, 50));
		entityManager.addEntity(new enemy0(handler, 850, 200, 50, 50));
		// Enemies in tree & rock area to lower left
		entityManager.addEntity(new enemy1(handler, 150, 800, 50, 50));
		entityManager.addEntity(new enemy1(handler, 300, 750, 50, 50));
		// Enemies in 'hallway' that travels north to winFlag
		entityManager.addEntity(new enemy0(handler, 1000, 300, 50, 50));
		entityManager.addEntity(new enemy0(handler, 1000, 500, 50, 50));
		entityManager.addEntity(new enemy0(handler, 1000, 700, 50, 50));
		entityManager.addEntity(new winFlag(handler, 1000, 100));

	}

	public void tick() {
		entityManager.tick();
		healthRemind++;
		if (healthRemind >= 100) {
			System.out.println("Your health is: " + entityManager.getHeroHealth());
			healthRemind = 0;
		}
	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		// Entities
		entityManager.render(g);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grassTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.dirtTile;
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}
