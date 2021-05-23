import java.awt.Graphics;

public class enemy0 extends Creature {
	
	private int step;
	
	public enemy0(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		bounds.x = 0;
		bounds.y = 0;
		bounds.width = width;
		bounds.height = height;
		
		step = 0;
	}

	public void tick() {
		getInput();
		move();
		step++;
	}

	public void die() {

	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;

		int movementScale = 30;
		
		if(step < movementScale) {
			yMove = speed;
		} else if (step >= movementScale && step < movementScale*2) {
			yMove = 0;
		} else if (step >= movementScale*2 && step < movementScale*3) {
			xMove = speed;
		} else if (step >= movementScale*3 && step < movementScale*4) {
			xMove = 0;
		} else if (step >= movementScale*4 && step < movementScale*5) {
			yMove = -speed;
		} else if (step >= movementScale*5 && step < movementScale*6) {
			yMove = 0;
		} else if (step >= movementScale*6 && step < movementScale*7) {
			xMove = -speed;
		} else if (step >= movementScale*7 && step < movementScale*8) {
			xMove = 0;
		}
		if (step == movementScale*8) {
			step = 0;
		}
		
	}


	public void render(Graphics g) {
		g.drawImage(Assets.assetMap.get("enemy0"), (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), width, height, null);
	}

}
