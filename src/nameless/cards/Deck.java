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
			System.out.println(deck[i].enumNumber.getDisplayName() + deck[i].enumSuit.getDisplayName() + " " + deck[i].getCardSortValue());
		}
	}
	
	public void printDeck(Card[] deck)
	{
		for (int i = 0; i < deck.length; i++)
		{
			System.out.println(deck[i].enumNumber.getDisplayName() + deck[i].enumSuit.getDisplayName() + " " + deck[i].getCardSortValue());
		}
	}
	
	public void sortDeck()
	{
		deck = mergeSort(deck);
	}
	
	public Card[] mergeSort(Card[] start)
	{
		Card[] left = new Card[start.length/2];
		Card[] right = new Card[start.length-left.length];
		Card[] sorted = new Card[start.length];
		
		for (int i = 0; i < left.length; i++)
		{
			left[i] = start[i];
		}
		for (int i = 0; i < right.length; i++)
		{
			right[i] = start[left.length + i];
		}
		
		if (left.length>1)
		{
			mergeSort(left);
		}
		if (right.length>1)
		{
			mergeSort(right);
		}
		
		sorted = merge(left, right);
		return sorted;
	}
	
	public Card[] merge(Card[] array1, Card[] array2)
	{
		Card[] merged = new Card[array1.length + array2.length];
		int index1 = 0;
		int index2 = 0;
		
		while (merged[merged.length-1] == null)
		{
			if(index1 < array1.length && index2 < array2.length && array1[index1].getCardSortValue() <= array2[index2].getCardSortValue())
			{
				System.out.println(array1[index1].getCardSortValue() + " " + array2[index2].getCardSortValue() + "  //  ");
				merged[index1 + index2] = array1[index1];
				index1++;
			}
			else if(index1 < array1.length && index2 < array2.length && array1[index1].getCardSortValue() >= array2[index2].getCardSortValue())
			{
				System.out.println(array1[index1].getCardSortValue() + " " + array2[index2].getCardSortValue() + "  \\\\  ");
				merged[index1 + index2] = array2[index2];
				index2++;
			}
			else if(index1>=array1.length)
			{
				merged[index1 + index2] = array2[index2];
				index2++;
			}
			else if(index2>=array2.length)
			{
				merged[index1 + index2] = array1[index1];
				index1++;
			}
			System.out.println(merged[index1 + index2-1].getCardSortValue() + "  ");
		}
		
		return merged;
	}
	
}
