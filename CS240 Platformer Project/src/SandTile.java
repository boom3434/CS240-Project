//Finn Parker
//CS240 - Project (Platformer)
//Ryan Parsons
//defines qualities of the sand tile.

public class SandTile extends Tile{

	public SandTile(int id) {
		super(Assets.assetMap.get("sand"), id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

}
