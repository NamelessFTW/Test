//Ivan Ribeiro
//17 Dec 2015

package game.entity;

import game.map.Map;

public class EntityEnemy extends EntityLiving
{
	public EntityEnemy(MONSTERTYPE type, Map map, int x, int y)
	{
		super(false, map, x, y, type.getHealth(), type.getDamage());
	}
}
