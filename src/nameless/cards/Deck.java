package nameless.cards;

import java.util.Random;

public class Deck
{
	private Card[] deck;
	
	public Deck()
	{
		//this will generate our suit and card value
		Random generator = new Random();
		
		//this is our deck
		deck = new Card[52];
		
		int tempSuit;
		int tempValue;
		
		
		//cycle through the deck 52 times to make sure that 52 cards are assigned
		for (int i = 0; i < deck.length;)
		{
			tempSuit = generator.nextInt(4);
			tempValue = generator.nextInt(13);
			
			//cycle through the deck to make sure that the same card is not already in it
			for (int j = 0; j < deck.length; j++ )
			{
				//if the array slot is empty (the ones before would already have been checked to see if the card was already assigned) assign the card
				if (deck[j] == null)
				{
					deck[j] = new Card(tempSuit, tempValue);
					i++;
					// System.out.println(i); used for debugging
					break;
				}
				//if the card is already assigned, break out and get a new set of values
				else if(deck[j].suit == tempSuit && deck[j].value == tempValue)
				{
					break;
				}
			}
		}
	}
	
	public void printDeck()
	{
		for (int i = 0; i < deck.length; i++)
		{
			System.out.println(deck[i].enumNumber.displayName + deck[i].enumSuit.displayName);
		}
	}
	
}
