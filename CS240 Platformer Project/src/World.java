//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Manages the world and keeps it lookin pretty

import java.awt.Graphics;
import java.util.ArrayList;

public class World {
	private Handler handler;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;

	// ENTITIES
	private EntityManager entityManager;

	public World(Handler handler, String path) {
		int entityCount = 0;
		this.handler = handler;
		entityManager = new EntityManager(handler, new Hero(handler, 200, 200));
		entityManager.addEntity(new enemy0(handler, 400, 300, 50, 50));
		entityManager.addEntity(new enemy0(handler,500,350,50,50));
		loadWorld(path);

		entityManager.getHero().setX(200);
		entityManager.getHero().setY(200);
		
		

	}

	public void tick() {
		entityManager.tick();
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
			return Tile.skyTile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null) {
			return Tile.grassTile;
		}
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

}
