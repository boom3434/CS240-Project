package platformer.entities.creatures;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import platformer.Handler;
import platformer.entities.Entity;
import platformer.gfx.Animation;
import platformer.gfx.Assets;


public class enemy1 extends Creature {

	private int step, moveTimer, moveSelect, attackCounter;
	// Attack Timer
	
	private Animation enemy1;

	Rectangle cb = getCollisionBounds(0, 0);
	Rectangle arU = new Rectangle();
	Rectangle arD = new Rectangle();
	Rectangle arL = new Rectangle();
	Rectangle arR = new Rectangle();

	// Collision Rectangles

	public enemy1(Handler handler, float x, float y, int width, int height) {

		super(handler, x, y, width, height);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;

		step = 0;
		moveTimer = 0;
		moveSelect = 0;
		
		// Animations
		enemy1 = new Animation(500, Assets.enemy1);
	}

	public void tick() {
		enemy1.tick();
		getInput();
		move();
		checkAttacks();
		step++;
		moveTimer++;
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
						|| e.getCollisionBounds(0, 0).intersects(arL) || e.getCollisionBounds(0, 0).intersects(arR)) && attackCounter>=500) {
					System.out.println("Damage dealt");
					e.hurt(1);
					attackCounter=0;
					return;
				}
			}

	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if (moveTimer >= 10) {
			moveSelect = getMovePattern();
			moveTimer = 0;
		}
		int movementScale = 30;
		if (moveSelect == 0) {
			if (step < movementScale) {
				yMove = 10.0f;
			} else if (step >= movementScale && step < movementScale * 2) {
				yMove = 0;
			} else if (step >= movementScale * 2 && step < movementScale * 3) {
				xMove = 10.0f;
			} else if (step >= movementScale * 3 && step < movementScale * 4) {
				xMove = 0;
			} else if (step >= movementScale * 4 && step < movementScale * 5) {
				yMove = -10.0f;
			} else if (step >= movementScale * 5 && step < movementScale * 6) {
				yMove = 0;
			} else if (step >= movementScale * 6 && step < movementScale * 7) {
				xMove = -10.0f;
			} else if (step >= movementScale * 7 && step < movementScale * 8) {
				xMove = 0;
			}
			if (step == movementScale * 8) {
				step = 0;
			}
		} else if (moveSelect == 1) {
			if (step < movementScale) {
				yMove = -1.0f;
			} else if (step >= movementScale && step < movementScale * 2) {
				yMove = 0;
			} else if (step >= movementScale * 2 && step < movementScale * 3) {
				xMove = -1.0f;
			} else if (step >= movementScale * 3 && step < movementScale * 4) {
				xMove = 0;
			} else if (step >= movementScale * 4 && step < movementScale * 5) {
				yMove = 1.0f;
			} else if (step >= movementScale * 5 && step < movementScale * 6) {
				yMove = 0;
			} else if (step >= movementScale * 6 && step < movementScale * 7) {
				xMove = 1.0f;
			} else if (step >= movementScale * 7 && step < movementScale * 8) {
				xMove = 0;
			}
			if (step == movementScale * 8) {
				step = 0;
			}
		} else if (moveSelect == 2) {
			if (step < movementScale) {
				xMove = 0;
			} else if (step >= movementScale && step < movementScale * 2) {
				xMove = -5.0f;
			} else if (step >= movementScale * 2 && step < movementScale * 3) {
				yMove = 0;
			} else if (step >= movementScale * 3 && step < movementScale * 4) {
				yMove = -5.0f;
			} else if (step >= movementScale * 4 && step < movementScale * 5) {
				xMove = 0;
			} else if (step >= movementScale * 5 && step < movementScale * 6) {
				xMove = 5.0f;
			} else if (step >= movementScale * 6 && step < movementScale * 7) {
				yMove = 5.0f;
			} else if (step >= movementScale * 7 && step < movementScale * 8) {
				yMove = 0;
			}
			if (step == movementScale * 8) {
				step = 0;

			}
		} else if (moveSelect == 3) {
			if (step < movementScale) {
				yMove = -10.0f;
			} else if (step >= movementScale && step < movementScale * 2) {
				yMove = 0;
			} else if (step >= movementScale * 2 && step < movementScale * 3) {
				xMove = -10.0f;
			} else if (step >= movementScale * 3 && step < movementScale * 4) {
				xMove = 0;
			} else if (step >= movementScale * 4 && step < movementScale * 5) {
				yMove = 10.0f;
			} else if (step >= movementScale * 5 && step < movementScale * 6) {
				yMove = 0;
			} else if (step >= movementScale * 6 && step < movementScale * 7) {
				xMove = 10.0f;
			} else if (step >= movementScale * 7 && step < movementScale * 8) {
				xMove = 0;
			}
			if (step == movementScale * 8) {
				step = 0;

			}
		} else {
	
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

	}

	public int getMovePattern() {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < 4; i++) {
			Random rand = new Random();
			int upperbound = 5;
			int insert = rand.nextInt(upperbound);
			q.add(insert);
		}

		return q.remove();
	}

	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

	private BufferedImage getCurrentAnimationFrame() {

		return enemy1.getCurrentFrame();
	}

}
