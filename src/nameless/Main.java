package nameless;

import nameless.cards.Deck;

public class Main
{
	public static void main(String[] args)
	{
		Deck testdeck = new Deck();
		testdeck.printDeck();
		testdeck.sortDeck();
		System.out.println(" ");
		testdeck.printDeck();
	}
}
