/*////////////////////////////////////////////
| Programming Project 2: E3.5
| written by Cooper Bates (cbb2153)
|
| This is file contains a tester for the Savings
| Account class
*//////////////////////////////////////////////

public class SavingsAccountTester {

	public static void main(String[] args) {

		SavingsAccount cooper = new SavingsAccount(1000, 0.1); // constructs
																// account
		cooper.addInterest(); // adds interest
		System.out.println(cooper.balance); // prints new balance
		System.out.println("Expected Result: 1100"); // prints expected balance

	} // end of main method

} // end of class
