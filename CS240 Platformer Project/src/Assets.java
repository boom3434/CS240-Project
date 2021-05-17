//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Class to make the sprites easily accessible for Game.java, basically determines what all of the different entities will look like

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Assets {

	private static final int width = 88, height = 88;

	private static BufferedImage hero, enemy0, enemy1, enemy2, powerUp0, health, powerUp1, grass, stone, house, sand,
			lava0, lava1, lava2, dirt, sky, START, SETTINGS, LEVELS, QUIT, START1, SETTINGS1, LEVELS1, QUIT1;
	
	static HashMap<String, BufferedImage> assetMap = new HashMap<String, BufferedImage> ();
	
	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_settings;
	public static BufferedImage[] btn_levels;
	public static BufferedImage[] btn_quit;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));

		// row1
		
		hero = sheet.crop(3, 3, width, height);
		assetMap.put("hero", hero);
		enemy0 = sheet.crop(96, 3, width, height);
		assetMap.put("enemy0", enemy0);
		enemy1 = sheet.crop(190, 3, width, height);
		assetMap.put("enemy1", enemy1);
		enemy2 = sheet.crop(283, 3, width, height);
		assetMap.put("enemy2", enemy2);
		powerUp0 = sheet.crop(377, 3, width, height);
		assetMap.put("powerUp0", powerUp0);
		health = sheet.crop(470, 3, width, height);
		assetMap.put("health", health);
		powerUp1 = sheet.crop(565, 3, width, height);
		assetMap.put("grass", grass);
		grass = sheet.crop(659, 3, width, height);

		// row2
		stone = sheet.crop(3, 97, width, height);
		assetMap.put("stone", stone);
		house = sheet.crop(97, 97, width, height);
		assetMap.put("house", house);
		sand = sheet.crop(190, 97, width, height);
		assetMap.put("sand", sand);
		lava0 = sheet.crop(283, 97, width, height);
		assetMap.put("lava0", lava0);
		lava1 = sheet.crop(378, 97, width, height);
		assetMap.put("lava1", lava1);
		dirt = sheet.crop(470, 97, width, height);
		assetMap.put("dirt", dirt);
		lava2 = sheet.crop(565, 97, width, height);
		assetMap.put("lava2", lava2);
		START = sheet.crop(660, 97, width, height);

		// row3
		SETTINGS = sheet.crop(0, 190, width, height);
		LEVELS = sheet.crop(97, 190, width, height);
		QUIT = sheet.crop(190, 190, width, height);
		sky = sheet.crop(285, 190, width-1, height-1);
		assetMap.put("sky", sky);
		START1 = sheet.crop(378, 190, width, height);
		SETTINGS1 = sheet.crop(472, 190, width, height);
		LEVELS1 = sheet.crop(565, 190, width, height);
		QUIT1 = sheet.crop(660, 190, width, height);

		btn_start = new BufferedImage[2];
		btn_start[0] = START;
		btn_start[1] = START1;

		btn_settings = new BufferedImage[2];
		btn_settings[0] = SETTINGS;
		btn_settings[1] = SETTINGS1;

		btn_levels = new BufferedImage[2];
		btn_levels[0] = LEVELS;
		btn_levels[1] = LEVELS1;

		btn_quit = new BufferedImage[2];
		btn_quit[0] = QUIT;
		btn_quit[1] = QUIT1;

	}
}
