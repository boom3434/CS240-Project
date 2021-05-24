//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Defines the hero of the game, handles movement

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Hero extends Creature {

	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;
	private Animation heroAttack, attackR, heroStill;

	public Hero(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		DEFAULT_HEALTH = 200;
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = 50;
		bounds.height = 50;
		// TODO Auto-generated constructor stub

		// Animations
		heroAttack = new Animation(500, Assets.heroAttack);
		attackR = new Animation(500, Assets.attackR);
		heroStill = new Animation(1000, Assets.heroStill);
	}

	@Override
	public void tick() {
		heroAttack.tick();
		attackR.tick();
		heroStill.tick();
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		checkAttacks();
		System.out.println("Your health: "+DEFAULT_HEALTH);
	}

	private void checkAttacks() {
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();

		if (attackTimer < attackCooldown)
			return;

		Rectangle cb = getCollisionBounds(0, 0);
		Rectangle ar = new Rectangle();
		int arSize = 20;
		ar.width = arSize;
		ar.height = arSize;
		// attacks to the right
		if (handler.getKeyManager().attack) {
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height / 2 - arSize / 2;
			
		} else {
			return;
		}

		attackTimer = 0;

		for (Entity e : handler.getWorld().getEntityManager().getEntities()) {
			if (e.equals(this))
				continue;
			if (e.getCollisionBounds(0, 0).intersects(ar)) {
				e.hurt(1);
				return;
			}
		}
	}

	public void die() {
		System.out.println("You lose");
	};

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getxOffset()), width, height, null);
		
		

	}

	private BufferedImage getCurrentAnimationFrame() {
		if (handler.getKeyManager().attack) {
			return heroAttack.getCurrentFrame();
		} else {
			return heroStill.getCurrentFrame();
		}
		
	}

}
