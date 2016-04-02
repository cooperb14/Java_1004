import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private Player p;
	private Deck cards;
	// you'll probably need some more here
	
	
	public Game(String[] testHand){
		// This constructor is to help test your code
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		
		// build in malicious user precautions
		int suit;
		int value;
		Card c;
		for(String element: testHand){
			switch(element.trim().toUpperCase().charAt(0)){
				case 'C': suit = 1;
				case 'D': suit = 2;
				case 'H': suit = 3;
				case 'S': suit = 4;
				default: suit = 0;
			}
			value = (int)element.trim().toUpperCase().charAt(1);
			c = new Card(suit, value);
			p.addCard(c);
		}
	}
	
	public Game(){
		// This constructor is to actually play a normal game
		this.cards = new Deck();
		this.p = new Player();
		
	}
	
	public void play(){
		// this method should play the game	
		this.cards.shuffle();
		
		// deal 5 cards to player
		this.deal_5_cards();
		
		// ask player for swaps
		this.ask_for_rejects();
		
		// check hand for combos and print result
		System.out.println(this.p);
		System.out.println(this.checkHand(p.getHand()));
	}
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
				
		if(p.check_for_straight()){
			if(p.check_for_flush()){
				return "Straight Flush\n\tpayout: 50";
			}
			else{
				return "Straight\n\tpayout: 4";
			}
		}
		if(p.check_for_flush()){
			return "Flush\n\tpayout: 5";
		}
		if(p.check_for_royalflush()){
			return "Royal Flush\n\tpayout: 250";
		}
		switch (p.check_for_pairs()){
			case 2: return "1 Pair\n\tpayout: 1";
			case 4: return "2 Pair\n\tpayout: 2";
			case 5: return "3 of a Kind\n\tpayout: 3";
			case 7: return "Full House\n\tpayout: 6";
			case 8: return "4 of a Kind\n\tpayout: 25";
			default: return "";
		}
	}
	
	// deals 5 cards to player
	public void deal_5_cards(){
		
		for(int i=0;i<5;i++){
			p.addCard(this.cards.deal());
		}

		this.p.sort_cards();
	}

	// this method asks player for rejected cards
	public void ask_for_rejects(){
		
		
		// build in malicious user precautions

		System.out.println("Would you like to reject any of your cards?");
		for(int i=0; i < p.getHand().size()-1; i++){
			System.out.println(i + " " + p.getHand().get(i));
		}
		
		System.out.println(" ");
		System.out.print("If so, please enter corresponding numbers below--");
		System.out.println(" ");
		
		Scanner input = new Scanner(System.in);		
		int card_index;
		int cont = 1;
		
		while (cont == 1){
			System.out.println("Enter the card's number: ");
			card_index = input.nextInt();
			this.swap_rejects(card_index);
			
			System.out.print("To reject another card enter 1, ");
			System.out.println("otherwise enter 0: ");
			cont = input.nextInt();
		}
		
		input.close();
		this.p.sort_cards();
	}
	
	public void swap_rejects(int index){
		
		p.removeCard(p.getHand().get(index));
		p.addCard(this.cards.deal());
	}
	// you will likely want many more methods here
	// see discussion in class
}