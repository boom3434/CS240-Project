package platformer.tiles;

import platformer.gfx.Assets;

public class GrassTile extends Tile {

	public GrassTile(int id) {
		super(Assets.assetMap.get("grass"), id);
	}

}
