import java.awt.Graphics;

public class enemy0 extends Creature {
	public enemy0(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
	}

	public void tick() {
		getInput();
		move();
	}

	public void die() {

	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		
			yMove = -speed;
		if (this.checkEntityCollisions(0, 10))
			yMove = speed;
		
	}


	public void render(Graphics g) {
		g.drawImage(Assets.assetMap.get("enemy0"), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
