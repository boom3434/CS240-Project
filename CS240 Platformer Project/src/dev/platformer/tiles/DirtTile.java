package platformer.tiles;

import platformer.gfx.Assets;

public class DirtTile extends Tile {

	public DirtTile(int id) {
		super(Assets.assetMap.get("dirt"), id);
	}

}
