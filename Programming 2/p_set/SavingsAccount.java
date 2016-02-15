/*////////////////////////////////////////////
| Programming Project 2: E3.5
| written by Cooper Bates (cbb2153)
|
| This is file contains the Savings Account class
*//////////////////////////////////////////////

public class SavingsAccount {

	public double balance;
	public double interest;

	// constructor method with balance and interest
	public SavingsAccount(double balance, double interest) {
		this.balance = balance;
		this.interest = interest;
	}

	// non-parameter interest adding method
	public void addInterest() {
		this.balance = this.balance * (1.0 + this.interest);
	}

} // end of class
