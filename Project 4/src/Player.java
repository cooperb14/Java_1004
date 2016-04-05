
/*////////////////////////////////////////////
| Programming Project 4
| written by Cooper Bates (cbb2153)
|
| This is file contains the Player Class
*//////////////////////////////////////////////

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> hand; // the player's cards
	// you will likely need more instance variables

	public Player() {
		// create a player here
		this.hand = new ArrayList<Card>();
	}

	public void addCard(Card c) {
		// add the card c to the player's hand
		hand.add(c);
	}

	public void removeCard(Card c) {
		// remove the card c from the player's hand
		hand.remove(c);
	}

	// player sorts cards
	public void sort_cards() {

		Card lowest_card;
		int comp;

		for (int i = 0; i < this.hand.size(); i++) {
			lowest_card = this.hand.get(i);

			for (int j = i + 1; j < this.hand.size(); j++) {
				comp = lowest_card.compareTo(this.hand.get(j));
				if (comp == -1) {
					lowest_card = this.hand.get(j);
				}
			}

			this.hand.remove(lowest_card);
			this.hand.add(0, lowest_card);
		}
	}

	// returns different integer values depending on type of pair combo
	public int check_for_pairs() {

		int result = 0;
		Card current, previous, next;

		for (int i = 0; i < this.hand.size() - 1; i++) {
			current = this.hand.get(i);
			next = this.hand.get(i + 1);

			if (current.compare_by_value(next) == 0) {
				result++;
			}
		}

		for (int i = 1; i < this.hand.size() - 1; i++) {
			current = this.hand.get(i);
			previous = this.hand.get(i - 1);
			next = this.hand.get(i + 1);

			if (current.compare_by_value(next) == 0) {
				if (current.compare_by_value(previous) == 0) {
					result++;
				}
			}
		}

		return result;
	}

	// checks if player's hand is a straight
	public boolean check_for_straight() {

		int result = 0;
		for (int i = 0; i < this.hand.size() - 1; i++) {
			if (this.hand.get(i).is_sequential(this.hand.get(i + 1))) {
				result++;
			}
		}

		// account for special case of the Ace
		Card ace = new Card(1, 1);
		Card king = new Card(1, 13);
		if (this.hand.get(0).compare_by_value(ace) == 0) {
			if (this.hand.get(4).compare_by_value(king) == 0) {
				result++;
			}
		}

		if (result == 4) {
			return true;
		} else {
			return false;
		}
	}

	// checks if player's hand is a flush
	public boolean check_for_flush() {
		int result = 0;

		for (int i = 0; i < this.hand.size() - 1; i++) {
			if (this.hand.get(i).compare_by_suit(this.hand.get(i + 1)) == 0) {
				result++;
			}
		}

		if (result == 4) {
			return true;
		} else {
			return false;
		}

	}

	// checks if player's hand is a royal flush
	public boolean check_for_royalflush() {

		Card ace = new Card(1, 1);
		if (this.check_for_straight() && this.check_for_flush()) {
			if (this.hand.get(0).compare_by_value(ace) == 0) {
				return true;
			}
		}
		return false;
	}

	// returns players hand
	public ArrayList<Card> getHand() {
		if (this.hand.size() == 0)
			return null;
		else
			return this.hand;
	}

	// clears players current hand
	public void clearHand() {
		this.hand.clear();
	}

	// prints players hand
	public String toString() {
		String result = "";
		for (Card card : this.hand) {
			result += card.toString() + " ";
		}
		return result;
	}
}
