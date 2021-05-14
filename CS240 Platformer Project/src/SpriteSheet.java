//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Handles cropping the sprites out of the spritesheet and getting the spritesheet

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage sheet;

	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}

	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
	}
}
