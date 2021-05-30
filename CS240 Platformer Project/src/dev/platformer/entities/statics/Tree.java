//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Defines the static entity house

import java.awt.Graphics;

public class House extends StaticEntity {

	public House(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT * 2);
		// Bounding box
		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	public void tick() {
		
	}

	public void die() {
	}

	public void render(Graphics g) {
		g.drawImage(Assets.assetMap.get("house"), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
