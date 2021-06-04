//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//Defines any special attributes for the grass tile in the game 

package platformer.tiles;

import platformer.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(Assets.assetMap.get("grass"), id);
	}

}
