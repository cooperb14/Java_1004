Programming Project 4:
Cooper Bates
cbb2153


The Card class contains all of the standard methods, including a toString and CompareTo for easy printing and comparison. In addition it contains three helper methods for comparison.

The Deck class contains a constructor that initializes a deck array and shuffles it, a shuffle method to shuffle the array from top down, and a deal method to move a card one at a time from the top of the deck to the player’s hand. In addition, the class contains an instance variable top to keep track of the artificial top-of-the-deck.

The Player class contains all the methods for player actions including adding and removing cards, sorting the hand, checking for all possible poker combinations, and clearing hand or folding. The class also contains toString method to easily print players hand, as well as a getHand accessor method to easily retrieve current hand.
	Note: the Check_for_pairs uses boolean logic to return different value integers based on the combinations present, thus checking for several hand combinations in one method.

The Game class executes the poker game. It has two constructors, one for normal play and one for testing, as well as a check_hand method to see the player’s results, an ask_for_rejects method to switch out player’s cards, and a play method to execute the sequential steps of the game:


Additional Notes:
	No bugs noticed. Program expects intelligent input from the user at all stages based on the format given in lecture. Some of the functions may be a bit lengthy, but I did my best to encapsulate discrete functions in their own class method.