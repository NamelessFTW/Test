//Ivan Ribeiro
//15 Dec 2015

package game.entity;

import game.item.Item;
import game.map.Map;
import game.map.tile.TILETYPE;
import javafx.scene.shape.Rectangle;

public class EntityItem extends Entity
{
	Item item;
	
	public EntityItem()
	{
		super(false, null, -1, -1);
		rectangle = TILETYPE.OTHER.getRectangle();
	}
	
	public EntityItem(Item item, Map map, int x, int y)
	{
		super(false, map, x, y);
		this.item = item;
	}
	
	public Item getItem()
	{
		return item;
	}
	
	@Override
	public Rectangle getRectangle()
	{
		return TILETYPE.OTHER.getRectangle();
	}
}
