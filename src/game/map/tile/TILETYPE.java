//Ivan Ribeiro
//8 Dec 2015

package game.map.tile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import game.reference.Reference;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public enum TILETYPE
{
	GRASS(Color.GREEN, false, "/grass.png"),
	WALL(Color.GRAY, true, "/wall.png"),
	OTHER(Color.WHITE, false, "/other.png");
	
	private Rectangle rectangle;
	private boolean isSolid;
	private Image image;
	
	TILETYPE(Color colour, boolean isSolid, String location)
	{
		rectangle = new Rectangle(16, 16, colour);
		this.isSolid = isSolid;
		try
		{
			Image image = new Image(Reference.baseImageLocation + location);
		}
		catch (Exception e)
		{
			try
			{
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Reference.baseImageLocation + location)));
				writer.write("In here");
			}
			catch (Exception f)
			{
				f.printStackTrace();
			}
		}
	}
	
	public Rectangle getRectangle()
	{
		return this.rectangle;
	}
	
	public boolean getSolid()
	{
		return this.isSolid;
	}
	
	public Image getImage()
	{
		return this.image;
	}
}
