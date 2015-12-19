//Ivan Ribeiro
//8 Dec 2015

package game.entity;

import java.util.ArrayList;

import game.item.Item;
import game.item.ItemWearable;
import game.item.ItemWearableChestplate;
import game.item.ItemWearableHelmet;
import game.map.Map;

public class EntityPlayer extends EntityLiving
{
	public EntityPlayer(Map map, int x, int y)
	{
		super(true, map, x, y, 100, 3);
	}

	public void printStats()
	{
		if (helmet != null)
		{
			System.out.print(helmet.getName() + " ");
		}
		if (chestplate != null)
		{
			System.out.print(chestplate.getName() + " ");
		}
		
		System.out.print(health + " " + damage + "\n");
	}
}
