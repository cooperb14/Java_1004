import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
	
	private Card[] theDeck;
	private int top = 0; // the index of the top of the deck
	private final int[] SUITS = {1,2,3,4};
	private final int DECK_COUNT = 52;
	private final int SUIT_COUNT = 13;
	// add more instance variables if needed
	
	public Deck(){
		// make a 52 card deck here
		this.theDeck = new Card[DECK_COUNT];
		
		for(int suit: SUITS){
			for (int i=1;i<=SUIT_COUNT;i++){
				this.theDeck[this.top] = new Card(suit, i);
				this.top++;
			}
		}
		
		this.top = 0;
	}
	
	// could build it so that it suffles whatever the deck in hand happens to be
	public void shuffle(){
		// shuffle the deck here
		// using Fisher-Yates algorithm
		
	    Random thread = ThreadLocalRandom.current();
	    for (int i = this.theDeck.length - 1; i > 0; i--)
	    {
	      int index = thread.nextInt(i + 1);
	      Card temp = this.theDeck[index];
	      this.theDeck[index] = this.theDeck[i];
	      this.theDeck[i] = temp;
	    }
	    
	    this.top = 0;
	}
	
	public Card deal(){
		// deal the top card in the deck
		int temp = this.top;
		this.top++;
		
		return this.theDeck[temp];
	}
	
	// add more methods here if needed
	
	
	// temporary method for printing deck
	public String toString(){
		String result = "";
		for(Card c: this.theDeck){
			result += c.toString() + " ";
		}
		
		return result;
	}
}