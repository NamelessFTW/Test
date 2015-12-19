//Ivan Ribeiro
//8 Dec 2015

package game.map.tile;

public class Tile
{
	TILETYPE type;
	
	public Tile(TILETYPE type)
	{
		this.type = type;
	}
	
	public TILETYPE getTileType()
	{
		return type;
	}
}
