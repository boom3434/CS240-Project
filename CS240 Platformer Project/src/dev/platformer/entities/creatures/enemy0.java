//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//Defines any special attributes of enemy0 (the red guy)

package platformer.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import platformer.Handler;
import platformer.entities.Entity;
import platformer.gfx.Animation;
import platformer.gfx.Assets;

public class enemy0 extends Creature {

	private int step, attackCounter;
	private Animation enemy0Attack, enemy0Still;

	Rectangle cb = getCollisionBounds(0, 0);
	Rectangle arU = new Rectangle();
	Rectangle arD = new Rectangle();
	Rectangle arL = new Rectangle();
	Rectangle arR = new Rectangle();

	// Collision Rectangles

	public enemy0(Handler handler, float x, float y, int width, int height) {

		super(handler, x, y, width, height);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;

		step = 0;
		attackCounter = 0;

		// Animations
		enemy0Attack = new Animation(500, Assets.enemy0_down);
		enemy0Still = new Animation(1000, Assets.enemy0_down);
	}

	public void tick() {
		checkAttacks();
		enemy0Attack.tick();
		enemy0Still.tick();

		getInput();
		move();

		step++;
		attackCounter++;

	}

	public void die() {

	}

	private void checkAttacks() {
	

		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle arU = new Rectangle();
		Rectangle arD = new Rectangle();
		Rectangle arL = new Rectangle();
		Rectangle arR = new Rectangle();
		int arSize = 35;
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
					|| e.getCollisionBounds(0, 0).intersects(arL) || e.getCollisionBounds(0, 0).intersects(arR)) && attackCounter>=350) {
				e.hurt(1);
				attackCounter=0;
				return;
			}
		}

	}


	

	private void getInput() {
		xMove = 0;
		yMove = 0;

		int movementScale = 30;

		if (step < movementScale) {
			yMove = speed;
		} else if (step >= movementScale && step < movementScale * 2) {
			yMove = 0;
		} else if (step >= movementScale * 2 && step < movementScale * 3) {
			xMove = speed;
		} else if (step >= movementScale * 3 && step < movementScale * 4) {
			xMove = 0;
		} else if (step >= movementScale * 4 && step < movementScale * 5) {
			yMove = -speed;
		} else if (step >= movementScale * 5 && step < movementScale * 6) {
			yMove = 0;
		} else if (step >= movementScale * 6 && step < movementScale * 7) {
			xMove = -speed;
		} else if (step >= movementScale * 7 && step < movementScale * 8) {
			xMove = 0;
		}
		if (step == movementScale * 8) {
			step = 0;
		}

	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	private BufferedImage getCurrentAnimationFrame() {

		return enemy0Still.getCurrentFrame();
	}

}
