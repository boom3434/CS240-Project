
//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Distincts the specific qualities of a dirt tile
import java.awt.image.BufferedImage;

public class DirtTile extends Tile {

	public DirtTile(int id) {
		super(Assets.dirt, id);
		// TODO Auto-generated constructor stub
	}

	public boolean isSolid() {
		return false;
	}

}
