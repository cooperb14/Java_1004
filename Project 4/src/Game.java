
/*////////////////////////////////////////////
| Programming Project 4
| written by Cooper Bates (cbb2153)
|
| This is file contains the Game class, designed
| to play game outlined in P7.7
*//////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	private Player p;
	private Deck cards;

	public Game(String[] testHand) {
		// This constructor is to help test your code

		this.cards = new Deck();
		this.p = new Player();

		int suit;
		int value;
		Card c;

		for (String element : testHand) {

			switch (element.trim().toUpperCase().charAt(0)) {
			case 'C':
				suit = 1;
				break;
			case 'D':
				suit = 2;
				break;
			case 'H':
				suit = 3;
				break;
			case 'S':
				suit = 4;
				break;
			default:
				suit = 0;
				break;
			}

			value = Integer.valueOf(element.substring(1, element.length()));
			c = new Card(suit, value);
			this.p.addCard(c);
		}

		this.p.sort_cards();
	}

	public Game() {
		// This constructor is to actually play a normal game

		this.cards = new Deck();
		this.p = new Player();
	}

	public void play() {
		// this method should play the game

		// check if player already has a hand
		if (this.p.getHand() == null) {

			// deal cards to player
			this.deal_5_cards();

			// ask player for swaps
			this.ask_for_rejects();

			// check and print hand and result
			String combo = this.checkHand(this.p.getHand());
			System.out.println(this.p);
			System.out.println("Congrats! You have " + combo);

			// ask player if they would like to play again
			Scanner input = new Scanner(System.in);
			System.out.println("Would you like to play another hand: y/n?");
			if (input.nextLine().toLowerCase().equals("y")) {
				this.p.clearHand();
				this.play();
			}
			input.close();
		} else {
			// check and print hand and result
			String combo = this.checkHand(this.p.getHand());
			System.out.println(this.p);
			System.out.println("Congrats! You have " + combo);
		}
	}

	public String checkHand(ArrayList<Card> hand) {
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String

		if (this.p.check_for_royalflush()) {
			return "a Royal Flush\n\tpayout: 250";
		}

		if (this.p.check_for_straight() && this.p.check_for_flush()) {
			return "a Straight Flush\n\tpayout: 50";
		}

		switch (this.p.check_for_pairs()) {
		case 4:
			return "a Full House\n\tpayout: 6";
		case 5:
			return "4 of a Kind\n\tpayout: 25";
		}

		if (this.p.check_for_flush()) {
			return "a Flush\n\tpayout: 5";
		}

		if (this.p.check_for_straight()) {
			return "a Straight\n\tpayout: 4";
		}

		switch (this.p.check_for_pairs()) {
		case 1:
			return "1 Pair\n\tpayout: 1";
		case 2:
			return "2 Pair\n\tpayout: 2";
		case 3:
			return "3 of a Kind\n\tpayout: 3";
		default:
			return "Absolutely Nothing";
		}
	}

	// deals 5 cards to player
	public void deal_5_cards() {

		for (int i = 0; i < 5; i++) {
			this.p.addCard(this.cards.deal());
		}

		this.p.sort_cards();
	}

	// this method asks player for rejected cards
	public void ask_for_rejects() {

		// build in malicious user precautions

		System.out.println("Would you like to reject any of your cards?");
		for (int i = 0; i < this.p.getHand().size(); i++) {
			System.out.println((i + 1) + " " + this.p.getHand().get(i));
		}

		Scanner int_input = new Scanner(System.in);
		Scanner str_input = new Scanner(System.in);

		System.out.println(" ");
		System.out.println("Would you like to reject cards: y/n?");
		String cont = str_input.nextLine();
		System.out.println(" ");

		while (cont.toLowerCase().equals("y")) {
			System.out.println("Enter the card's corresponding number: ");
			this.swap_rejects(int_input.nextInt() - 1);

			System.out.print("Do you want to reject another card y/n?");
			cont = str_input.nextLine();
		}

		this.p.sort_cards();
	}

	public void swap_rejects(int index) {

		this.p.removeCard(this.p.getHand().get(index));
		this.p.addCard(this.cards.deal());
	}
}