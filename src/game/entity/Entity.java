//Ivan Ribeiro
//8 Dec 2015

package game.entity;

import game.map.Map;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Entity
{
	int x, y;
	Map map;
	boolean isPlayer;
	Rectangle rectangle = new Rectangle();
	String lastmove = "";
	
	public Entity(boolean isPlayer, Map map, int x, int y)
	{
		this.isPlayer = isPlayer;
		this.x = x;
		this.y = y;
		this.map = map;
		this.map.addEntity(this);
		if (isPlayer)
		{
			this.map.addPlayer((EntityPlayer) this);
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public boolean moveRight()
	{
		if (!map.getTileAt(x+1, y).getTileType().getSolid())
		{
			lastmove = "right";
			x++;
			map.entityMoved(this, x, y);
			return true;
		}
		return false;
	}
	
	public boolean moveLeft()
	{
		if (!map.getTileAt(x-1, y).getTileType().getSolid())
		{
			lastmove = "left";
			x--;
			map.entityMoved(this, x, y);
			return true;
		}
		return false;
	}

	public boolean moveUp()
	{
		if (!map.getTileAt(x, y-1).getTileType().getSolid())
		{
			lastmove = "up";
			y--;
			map.entityMoved(this, x, y);
			return true;
		}
		return false;
	}

	public boolean moveDown()
	{
		if (!map.getTileAt(x, y+1).getTileType().getSolid())
		{
			lastmove = "down";
			y++;
			map.entityMoved(this, x, y);
			return true;
		}
		return false;
	}
	
	public void kill()
	{
		this.map = null;
		this.x = -1;
		this.y = -1;
	}
	
	public Rectangle getRectangle()
	{
		return rectangle;
	}
	
	public void undoMove()
	{
		switch (lastmove)
		{
		case "left":
			this.moveRight();
			break;
		case "right":
			this.moveLeft();
			break;
		case "up":
			this.moveDown();
			break;
		case "down":
			this.moveUp();
		}
	}
}
