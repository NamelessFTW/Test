//Ivan Ribeiro
//17 Dec 2015

package game.entity;

import game.item.ItemWearable;
import game.item.ItemWearableChestplate;
import game.item.ItemWearableHelmet;
import game.map.Map;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EntityLiving extends Entity
{
	int health;
	int damage;
	protected ItemWearableChestplate chestplate;
	protected ItemWearableHelmet helmet;
	
	public EntityLiving(boolean isPlayer, Map map, int x, int y, int health, int damage)
	{
		super(isPlayer, map, x, y);
		rectangle = new Rectangle(16, 16, Color.RED);
		this.health = health;
		this.damage = damage;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public void doDamage(int damage)
	{
		this.health -= damage;
		if (health <= 0)
		{
			this.kill();
		}
	}
	
	public int getArmour()
	{
		int total = 0;
		if (chestplate != null)
		{
			total += chestplate.getDefence();
		}
		
		if (helmet != null)
		{
			total += helmet.getDefence();
		}
		
		return total;
	}
	
	public void addArmour(ItemWearable item)
	{
		if (item instanceof ItemWearableHelmet)
		{
			helmet = (ItemWearableHelmet) item;
		}
		else if (item instanceof ItemWearableChestplate)
		{
			chestplate = (ItemWearableChestplate) item;
		}
	}
}
