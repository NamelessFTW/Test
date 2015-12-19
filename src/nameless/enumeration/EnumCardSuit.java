package nameless.enumeration;

public enum EnumCardSuit
{
	SPADES("Spades", 1),
	DIAMONDS("Diamonds", 2),
	CLUBS("Clubs", 3),
	HEARTS("Hearts", 4);
	
	private String displayName;
	private int sortValue;
	
	EnumCardSuit(String dN, int sortValue)
	{
		this.displayName = dN;
		this.sortValue = sortValue;
	}
	
	public String getDisplayName()
	{
		return displayName;
	}
	
	public int getSortValue()
	{
		return sortValue;
	}
}
