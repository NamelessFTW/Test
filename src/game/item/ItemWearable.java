//Ivan Ribeiro
//10 Dec 2015

package game.item;

public abstract class ItemWearable extends Item
{
	int defence;
	
	ItemWearable(String name, String ID, int defence)
	{
		super(name, ID);
		defence = 0;
	}
	
	public int getDefence()
	{
		return this.defence;
	}
}
