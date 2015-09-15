package nameless.cards;

import nameless.enumeration.EnumCardNumber;
import nameless.enumeration.EnumCardSuit;

public class Card
{
	public int suit;
	public int value;
	public EnumCardNumber enumNumber;
	public EnumCardSuit enumSuit;
	
	public Card(int tempSuit, int value)
	{
		this.suit = tempSuit;
		this.value = value;
		enumSuit = numberToEnumSuit();
		enumNumber = numberToEnumNumber();
	}

	//This will convert from an int to the enumeration value in order to easily access display names
	public EnumCardNumber numberToEnumNumber()
	{
		switch (value)
		{
		case 0: return EnumCardNumber.ACE;
		case 1: return EnumCardNumber.TWO;
		case 2: return EnumCardNumber.THREE;
		case 3: return EnumCardNumber.FOUR;
		case 4: return EnumCardNumber.FIVE;
		case 5: return EnumCardNumber.SIX;
		case 6: return EnumCardNumber.SEVEN;
		case 7: return EnumCardNumber.EIGHT;
		case 8: return EnumCardNumber.NINE;
		case 9: return EnumCardNumber.TEN;
		case 10: return EnumCardNumber.JACK;
		case 11: return EnumCardNumber.QUEEN;
		case 12: return EnumCardNumber.KING;
		default: return EnumCardNumber.ACE;
		}
	}

	//This will convert from an int to the enumeration value in order to easily access display name
	public EnumCardSuit numberToEnumSuit()
	{
		switch (suit)
		{
		case 0: return EnumCardSuit.SPADES;
		case 1: return EnumCardSuit.DIAMONDS;
		case 2: return EnumCardSuit.CLUBS;
		case 3: return EnumCardSuit.HEARTS;
		default: return EnumCardSuit.SPADES;
		}
	}
}
