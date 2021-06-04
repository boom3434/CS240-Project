//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//defines special attributes of the static rock entity

package platformer.entities.statics;

import java.awt.Graphics;

import platformer.Handler;
import platformer.gfx.Assets;
import platformer.tiles.Tile;

public class Rock extends StaticEntity {

	public Rock(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		bounds.x = 3;
		bounds.y = (int) (height / 2f);
		bounds.width = width - 6;
		bounds.height = (int) (height - height / 2f);
	}

	@Override
	public void tick() {

	}

	@Override
	public void die() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.assetMap.get("rock"), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
