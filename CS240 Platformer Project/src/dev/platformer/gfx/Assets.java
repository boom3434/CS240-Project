package platformer.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;

	public static Map<String, BufferedImage> assetMap = new Map<String, BufferedImage>();

	public static BufferedImage dirt, grass, stone, tree, rock;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] enemy0_down, enemy0_up, enemy0_left, enemy0_right;
	public static BufferedImage[] enemy1;
	public static BufferedImage[] btn_start;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));

		btn_start = new BufferedImage[2];
		btn_start[0] = sheet.crop(width * 6, height * 4, width * 2, height);
		btn_start[1] = sheet.crop(width * 6, height * 5, width * 2, height);

		player_down = new BufferedImage[2];
		player_up = new BufferedImage[2];
		player_left = new BufferedImage[2];
		player_right = new BufferedImage[2];

		player_down[0] = sheet.crop(width * 4, 0, width, height);
		player_down[1] = sheet.crop(width * 4, height * 1, width, height);
		player_up[0] = sheet.crop(width * 5, 0, width, height);
		player_up[1] = sheet.crop(width * 5, height * 1, width, height);
		player_right[0] = sheet.crop(width * 6, height, width, height);
		player_right[1] = sheet.crop(width * 6, height * 1, width, height);
		player_left[0] = sheet.crop(width * 7, height, width, height);
		player_left[1] = sheet.crop(width * 7, height * 1, width, height);

		enemy0_down = new BufferedImage[2];
		enemy0_up = new BufferedImage[2];
		enemy0_left = new BufferedImage[2];
		enemy0_right = new BufferedImage[2];

		enemy0_down[0] = sheet.crop(width * 4, height * 2, width, height);
		enemy0_down[1] = sheet.crop(width * 4, height * 3, width, height);
		enemy0_up[0] = sheet.crop(width * 5, height * 2, width, height);
		enemy0_up[1] = sheet.crop(width * 5, height * 3, width, height);
		enemy0_right[0] = sheet.crop(width * 6, height * 2, width, height);
		enemy0_right[1] = sheet.crop(width * 6, height * 3, width, height);
		enemy0_left[0] = sheet.crop(width * 7, height * 2, width, height);
		enemy0_left[1] = sheet.crop(width * 7, height * 3, width, height);

		dirt = sheet.crop(width, 0, width, height);
		assetMap.add("dirt", dirt);
		grass = sheet.crop(width * 2, 0, width, height);
		assetMap.add("grass", grass);
		stone = sheet.crop(width * 3, 0, width, height);
		assetMap.add("stone", stone);
		tree = sheet.crop(0, 0, width, height * 2);
		assetMap.add("tree", tree);
		rock = sheet.crop(0, height * 2, width, height);
		assetMap.add("rock", rock);
		
		enemy1 = new BufferedImage[2];
		enemy1[0] = sheet.crop(width, height, width, height);
		enemy1[1] = sheet.crop(width*2, height, width, height);
	}

}
