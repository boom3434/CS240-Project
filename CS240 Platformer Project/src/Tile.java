
//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//This class allows you to import .txt files and build a world with them, each of the following Tile items correlate to the type of tyle that will be used from the .txt file (see res folder)
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	// STATIC STUFF HERE
	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile dirtTile = new DirtTile(1);
	public static Tile stoneTile = new StoneTile(2);
	public static Tile sandTile = new SandTile(3);
	public static Tile skyTile = new SkyTile(4);

	// CLASS
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}
}
