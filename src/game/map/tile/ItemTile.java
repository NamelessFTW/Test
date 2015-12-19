//Ivan Ribeiro
//10 Dec 2015

package game.map.tile;

import game.item.Item;

public class ItemTile extends Tile
{
	private Item item;
	
	public ItemTile(TILETYPE type, Item item)
	{
		super(type);
	}
	
	public Item getItem()
	{
		return this.item;
	}
}
