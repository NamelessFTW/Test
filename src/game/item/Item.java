//Ivan Ribeiro
//10 Dec 2015

package game.item;

public abstract class Item
{
	private String name = "///////";
	private String ID = "";
	
	Item(String name, String ID)
	{
		this.name = name;
		this.ID = ID;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getID()
	{
		return ID;
	}
}
