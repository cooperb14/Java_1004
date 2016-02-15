public class SavingsTester {

	public static void main(String[] args) {

		SavingsAccount cooper = new SavingsAccount(1000, 0.1);
		System.out.println(cooper.balance);
		cooper.addInterest();
		System.out.println(cooper.balance);
	}
}