package nameless.enumeration;

public enum EnumCardSuit
{
	SPADES("Spades"),
	DIAMONDS("Diamonds"),
	CLUBS("Clubs"),
	HEARTS("Hearts");
	
	public String displayName;
	
	EnumCardSuit(String dN)
	{
		displayName = dN;
	}
}
