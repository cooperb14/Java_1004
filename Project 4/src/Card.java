/*////////////////////////////////////////////
| Programming Project 4
| written by Cooper Bates (cbb2153)
|
| This is file contains the Card Class
*//////////////////////////////////////////////

public class Card implements Comparable<Card> {

	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1-13 to encode the value

	public Card(int s, int v) {
		// make a card with suit s and value v
		this.suit = s;
		this.value = v;
	}

	public int compareTo(Card c) {
		// use this method to compare cards so they
		// may be easily sorted

		if (this.compare_by_value(c) == 0) {
			return this.compare_by_suit(c);
		} else {
			return this.compare_by_value(c);
		}
	}

	public String toString() {
		// use this method to easily print a Card object

		String suit = null;

		switch (this.suit) {
		case 1:
			suit = "C";
			break;
		case 2:
			suit = "D";
			break;
		case 3:
			suit = "H";
			break;
		case 4:
			suit = "S";
			break;
		}

		return suit + Integer.toString(this.value);
	}

	// compares two cards based on their numeric value
	public int compare_by_value(Card c) {
		if (this.value < c.value) {
			return -1;
		} else if (this.value > c.value) {
			return 1;
		} else {
			return 0;
		}
	}

	// compares two cards alphabetically by their suit
	public int compare_by_suit(Card c) {
		if (this.suit < c.suit) {
			return -1;
		} else if (this.suit > c.suit) {
			return 1;
		} else {
			return 0;
		}
	}

	// determines whether two cards are numerically sequential
	public boolean is_sequential(Card c) {

		if (this.value + 1 == c.value) {
			return true;
		} else {
			return false;
		}
	}

}