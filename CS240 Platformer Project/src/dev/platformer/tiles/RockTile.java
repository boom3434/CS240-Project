package platformer.tiles;

import platformer.gfx.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.assetMap.get("stone"), id);
	}

	@Override
	public boolean isSolid() {
		return true;
	}

}
