//Finn Parker - Jonathan Steger - Bryce Johnston
//CS240 Project
//Instructor: Ryan Parsons
//Defines any special attributes of the dirt tile within the game

package platformer.tiles;

import platformer.gfx.Assets;

public class DirtTile extends Tile {

	public DirtTile(int id) {
		super(Assets.assetMap.get("dirt"), id);
	}

}
