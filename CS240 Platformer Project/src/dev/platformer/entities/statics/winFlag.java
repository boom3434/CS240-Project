package platformer.entities.statics;

import java.awt.Graphics;
import java.awt.Rectangle;

import platformer.Handler;
import platformer.gfx.Assets;
import platformer.tiles.Tile;
import platformer.entities.*;

public class winFlag extends StaticEntity {

	public winFlag(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

		bounds.x = 10;
		bounds.y = (int) (height / 1.5f);
		bounds.width = width - 20;
		bounds.height = (int) (height - height / 1.5f);
	}

	@Override
	public void tick() {
		checkWin();
	}

	@Override
	public void die() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.assetMap.get("winFlag"), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	public void checkWin() {
		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle arU = new Rectangle();
		Rectangle arD = new Rectangle();
		Rectangle arL = new Rectangle();
		Rectangle arR = new Rectangle();
		int arSize = 20;
		arU.width = arSize;
		arU.height = arSize;
		arD.width = arSize;
		arD.height = arSize;
		arL.width = arSize;
		arL.height = arSize;
		arR.width = arSize;
		arR.height = arSize;

		// up
		arU.x = cb.x + cb.width / 2 - arSize / 2;
		arU.y = cb.y - arSize;

		// down
		arD.x = cb.x + cb.width / 2 - arSize / 2;
		arD.y = cb.y + arSize;

		// left
		arL.x = cb.x - arSize;
		arL.y = cb.y + cb.height / 2 - arSize / 2;

		// right
		arR.x = cb.x + cb.width;
		arR.y = cb.y + cb.height / 2 - arSize / 2;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this)) {
				continue;
			}
			if ((e.getCollisionBounds(0, 0).intersects(arU) || e.getCollisionBounds(0, 0).intersects(arD)
					|| e.getCollisionBounds(0, 0).intersects(arL) || e.getCollisionBounds(0, 0).intersects(arR))) {
				System.out.println("You win!");

				return;
			} else {
				return;
			}
		}

	}

}
