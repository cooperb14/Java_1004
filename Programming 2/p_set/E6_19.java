/*////////////////////////////////////////////
| Programming Project 2: E6.19
| written by Cooper Bates (cbb2153)
|
| This program executes the programs described in Big
| Java E6.19
*//////////////////////////////////////////////

public class E6_19 {

	public static void main(String[] args) {

		final double TRIALS = 1000;
		double success;
		int stay = 0;
		int swap = 0;

		for (int i = 0; i < TRIALS; i++) {

			// assign random doors
			int car = (int) (Math.random() * 3 + 1);
			int choice = (int) (Math.random() * 3 + 1);

			// verify that host's choice is not car or guest's
			int goat = (int) (Math.random() * 3 + 1);
			while (goat == choice || goat == car) {
				goat = (int) (Math.random() * 3 + 1);
			}

			// count the "stay" tactic as a success
			if (choice == car)
				stay++;

			// sum holds info of goat & choice to easily deduce new choice
			int sum = goat + choice;
			if (sum == 4) {
				choice = 2;
			} else if (sum == 5) {
				choice = 1;
			} else if (sum == 3) {
				choice = 3;
			}

			// count the "swap" tactic as a success
			if (choice == car)
				swap++;

		}

		// calculate success and display results
		success = stay / TRIALS;
		System.out.println("Probability of success staying: " + success);
		success = swap / TRIALS;
		System.out.println("Probability of success swapping: " + success);

	} // end of main method

} // end of class
