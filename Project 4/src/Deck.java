
/*////////////////////////////////////////////
| Programming Project 4
| written by Cooper Bates (cbb2153)
|
| This is file contains the Deck Class
*//////////////////////////////////////////////

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

	private Card[] theDeck;
	private int top = 0; // the index of the top of the deck
	private final int[] SUITS = { 1, 2, 3, 4 }; // stores suit numbers
	private final int DECK_COUNT = 52; // 52 cards in a deck
	private final int SUIT_COUNT = 13; // 13 cards per suit

	// constructor that initializes shuffled Casino deck
	public Deck() {
		// make a 52 card deck here

		this.theDeck = new Card[this.DECK_COUNT];

		for (int suit : this.SUITS) {
			for (int i = 1; i <= this.SUIT_COUNT; i++) {
				this.theDeck[this.top] = new Card(suit, i);
				this.top++;
			}
		}

		this.top = 0;
		this.shuffle();
	}

	// shuffles deck using Fisher-Yates algorithm
	public void shuffle() {
		// shuffle the deck here

		Random thread = ThreadLocalRandom.current();
		for (int i = this.theDeck.length - 1; i > this.top; i--) {
			int index = thread.nextInt(i + 1);
			Card temp = this.theDeck[index];
			this.theDeck[index] = this.theDeck[i];
			this.theDeck[i] = temp;
		}
	}

	// accesses top card on deck
	public Card deal() {
		// deal the top card in the deck

		int temp = this.top;
		this.top++;

		return this.theDeck[temp];
	}
}