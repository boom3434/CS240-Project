//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//Class to make the sprites easily accessible for Game.java, basically determines what all of the different entities will look like

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class Assets {

	private static final int width = 88, height = 88;

	private static BufferedImage heroStill0, enemy0Still0, enemy0Still1, enemy1, enemy2, powerUp0, health, powerUp1,
			grass, stone, house, sand, lava0, lava1, lava2, dirt, sky, START, SETTINGS, LEVELS, QUIT, START1, SETTINGS1,
			LEVELS1, QUIT1, heroAttack0, heroAttack1, attackTest, attackR0, attackR1, enemy0Attack0, enemy0Attack1,
			attackD0, attackD1, attackU0, attackU1, attackL0, attackL1, heroStill1;

	static Map<String, BufferedImage> assetMap = new Map<String, BufferedImage>();

	public static BufferedImage[] btn_start;
	public static BufferedImage[] btn_settings;
	public static BufferedImage[] btn_levels;
	public static BufferedImage[] btn_quit;
	public static BufferedImage[] heroAttack;
	public static BufferedImage[] enemy0Attack;
	public static BufferedImage[] attackR;
	public static BufferedImage[] attackL;
	public static BufferedImage[] attackD;
	public static BufferedImage[] attackU;
	public static BufferedImage[] heroStill;
	public static BufferedImage[] enemy0Still;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/spriteSheet.png"));

		// row1

		heroStill0 = sheet.crop(3, 3, width, height);

		enemy0Still0 = sheet.crop(96, 3, width, height);

		enemy1 = sheet.crop(190, 3, width, height);
		assetMap.add("enemy1", enemy1);
		enemy2 = sheet.crop(283, 3, width, height);
		assetMap.add("enemy2", enemy2);
		powerUp0 = sheet.crop(377, 3, width, height);
		assetMap.add("powerUp0", powerUp0);
		health = sheet.crop(470, 3, width, height);
		assetMap.add("health", health);
		powerUp1 = sheet.crop(565, 3, width, height);
		assetMap.add("grass", grass);
		grass = sheet.crop(659, 3, width, height);

		// row2
		stone = sheet.crop(3, 97, width, height);
		assetMap.add("stone", stone);
		house = sheet.crop(97, 97, width, height);
		assetMap.add("house", house);
		sand = sheet.crop(190, 97, width, height);
		assetMap.add("sand", sand);
		lava0 = sheet.crop(283, 97, width, height);
		assetMap.add("lava0", lava0);
		lava1 = sheet.crop(378, 97, width, height);
		assetMap.add("lava1", lava1);
		dirt = sheet.crop(470, 97, width, height);
		assetMap.add("dirt", dirt);
		lava2 = sheet.crop(565, 97, width, height);
		assetMap.add("lava2", lava2);
		START = sheet.crop(660, 97, width, height);

		// row3
		SETTINGS = sheet.crop(0, 190, width, height);
		LEVELS = sheet.crop(97, 190, width, height);
		QUIT = sheet.crop(190, 190, width, height);
		sky = sheet.crop(285, 190, width - 1, height - 1);
		assetMap.add("sky", sky);
		START1 = sheet.crop(378, 190, width, height);
		SETTINGS1 = sheet.crop(472, 190, width, height);
		LEVELS1 = sheet.crop(565, 190, width, height);
		QUIT1 = sheet.crop(660, 190, width, height);

		// row4
		heroAttack0 = sheet.crop(2, 283, width, height);
		attackTest = sheet.crop(97, 283, width, height);
		assetMap.add("attackTest", attackTest);
		attackR0 = sheet.crop(190, 283, width, height);
		enemy0Attack0 = sheet.crop(285, 283, width, height);
		attackD0 = sheet.crop(378, 283, width, height);
		attackU0 = sheet.crop(472, 283, width, height);
		attackL0 = sheet.crop(565, 283, width, height);
		attackR1 = sheet.crop(660, 283, width, height);

		// row5
		heroAttack1 = sheet.crop(1, 377, width, height);
		attackD1 = sheet.crop(96, 376, width, height);
		attackU1 = sheet.crop(190, 376, width, height);
		attackL1 = sheet.crop(285, 376, width, height);
		enemy0Attack1 = sheet.crop(378, 376, width, height);
		heroStill1 = sheet.crop(472, 376, width, height);
		enemy0Still1 = sheet.crop(565, 378, width, height);

		heroStill = new BufferedImage[2];
		heroStill[0] = heroStill0;
		heroStill[1] = heroStill1;

		heroAttack = new BufferedImage[2];
		heroAttack[0] = heroAttack0;
		heroAttack[1] = heroAttack1;

		attackR = new BufferedImage[2];
		attackR[0] = attackR0;
		attackR[1] = attackR1;

		enemy0Attack = new BufferedImage[2];
		enemy0Attack[0] = enemy0Attack0;
		enemy0Attack[1] = enemy0Attack1;

		attackD = new BufferedImage[2];
		attackD[0] = attackD0;
		attackD[1] = attackD1;

		attackU = new BufferedImage[2];
		attackU[0] = attackU0;
		attackU[1] = attackU1;

		attackL = new BufferedImage[2];
		attackL[0] = attackD0;
		attackL[1] = attackD1;

		enemy0Still = new BufferedImage[2];
		enemy0Still[0] = enemy0Still0;
		enemy0Still[1] = enemy0Still1;

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
