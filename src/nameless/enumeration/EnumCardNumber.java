package nameless.enumeration;

public enum EnumCardNumber
{
	ACE("Ace of ", 14),
	TWO("Two of ", 2),
	THREE("Three of ", 3),
	FOUR("Four of ", 4),
	FIVE("Five of ", 5),
	SIX("Six of ", 6),
	SEVEN("Seven of ", 7),
	EIGHT("Eight of ", 8),
	NINE("Nine of ", 9),
	TEN("Ten of ", 10),
	JACK("Jack of ", 11),
	QUEEN("Queen of ", 12),
	KING("King of ", 13);
	
	public String displayName;
	public int value;
	
	EnumCardNumber(String dN, int v)
	{
		displayName = dN;
		value = v;
	}
	
	
}
