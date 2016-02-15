public class SavingsAccount {

	public double balance;
	public double interest_rate;

	public SavingsAccount(double balance, double interest_rate) {
		this.balance = balance;
		this.interest_rate = interest_rate;
	}

	public void addInterest() {
		this.balance = this.balance * (1.0 + this.interest_rate);
	}
}