//Ivan Ribeiro
//8 Dec 2015

package game.map;

import java.util.ArrayList;

import game.entity.Entity;
import game.entity.EntityEnemy;
import game.entity.EntityItem;
import game.entity.EntityPlayer;
import game.item.ItemWearable;
import game.map.tile.TILETYPE;
import game.map.tile.Tile;
import javafx.scene.shape.Rectangle;

public class Map
{
	Tile[][] tiles;
	ArrayList<Entity> entities = new ArrayList<Entity>();
	EntityPlayer player;
	
	public Map()
	{
		tiles = new Tile[45][25];
		for (int i = 0, iCond = tiles.length; i < iCond; i++)
		{
			for (int j = 0, jCond = tiles[i].length; j < jCond; j++)
			{
				if (i == 0 || i == iCond-1 || j == 0 || j == jCond-1)
				{
					tiles[i][j] = new Tile(TILETYPE.WALL);
				}
				else
				{
					tiles[i][j] = new Tile(TILETYPE.GRASS);
				}
			}
		}
	}
	
	public Rectangle[][] getMapAsRectArray()
	{
		Rectangle[][] rectArray = new Rectangle[tiles.length][tiles[0].length];
		
		for (int i = 0, iCond = rectArray.length; i < iCond; i++)
		{
			for (int j = 0, jCond = rectArray[i].length; j < jCond; j++)
			{
				rectArray[i][j] = tiles[i][j].getTileType().getRectangle();
			}
		}
		
		for (int i = 0, iCond = entities.size(); i < iCond; i++)
		{
			if (entities.get(i).getX() != -1 && entities.get(i).getY() != -1)
			{
				rectArray[entities.get(i).getX()][entities.get(i).getY()] =  entities.get(i).getRectangle();
			}
		}
		
		return rectArray;
	}
	
	public Tile getTileAt(int x, int y)
	{
		return this.tiles[x][y];
	}
	
	public EntityPlayer getPlayer()
	{
		return this.player;
	}
	
	public void addPlayer(EntityPlayer player)
	{
		this.player = player;
		addEntity(player);
	}
	
	public void addEntity(Entity entity)
	{
		entities.add(entity);
	}
	
	public Entity[] getEntities()
	{
		return (Entity[]) this.entities.toArray();
	}
	
	public void entityMoved(Entity entity, int x, int y)
	{
		if (entity instanceof EntityPlayer)
		{
			for (int i = 0, iCond = entities.size(); i < iCond; i++)
			{
				if (entities.get(i).getX() == x && entities.get(i).getY() == y)
				{
					if(entities.get(i) instanceof EntityItem)
					{
						player.addArmour((ItemWearable) ((EntityItem) entities.get(i)).getItem());
						entities.get(i).kill();
					}
					else if (entities.get(i) instanceof EntityEnemy)
					{
						EntityEnemy enemy = (EntityEnemy) entities.get(i);
						player.doDamage(((EntityEnemy)entities.get(i)).getDamage() - player.getArmour());
						enemy.doDamage(player.getDamage() - enemy.getArmour());
						player.undoMove();
					}
				}
			}
		}
	}
}
