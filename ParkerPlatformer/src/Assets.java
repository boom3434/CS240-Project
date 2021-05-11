//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Class to make the sprites easily accessible for Game.java

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 88, height = 88;

	public static BufferedImage hero, enemy0, enemy1, enemy2, powerUp0, health, powerUp1, grass, stone, house, sand,
			lava0, lava1, lava2, dirt, sky;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));

		// row1
		hero = sheet.crop(3, 3, width, height);
		enemy0 = sheet.crop(96, 3, width, height);
		enemy1 = sheet.crop(190, 3, width, height);
		enemy2 = sheet.crop(283, 3, width, height);
		powerUp0 = sheet.crop(377, 3, width, height);
		health = sheet.crop(470, 3, width, height);
		powerUp1 = sheet.crop(565, 3, width, height);
		grass = sheet.crop(659, 3, width, height);

		// row2
		stone = sheet.crop(3, 97, width, height);
		house = sheet.crop(97, 97, width, height);
		sand = sheet.crop(190, 97, width, height);
		lava0 = sheet.crop(283, 97, width, height);
		lava1 = sheet.crop(378, 97, width, height);
		dirt = sheet.crop(470, 97, width, height);
		lava2 = sheet.crop(565, 97, width, height);
		sky = sheet.crop(658, 97, width, height);

	}
}
