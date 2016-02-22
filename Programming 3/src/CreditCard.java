/*////////////////////////////////////////////
| Programming Project 2
| written by Cooper Bates (cbb2153)
|
| This is file contains the CreditCard class
*//////////////////////////////////////////////

public class CreditCard {

	// class instance variables
	public String card_number;
	public int errorCode;
	public boolean validity;

	private int first_digit;
	private int second_digit;
	private int fourth_digit;
	private int fifth_digit;
	private int seventh_digit;
	private int eigth_digit;
	private int ninth_digit;

	// constructor method for credit card
	public CreditCard(String card_number) {
		this.card_number = card_number;
		this.errorCode = 0;

		// converts characters in card_number to respective integers
		this.first_digit = Integer.parseInt(this.card_number.substring(0, 1));
		this.second_digit = Integer.parseInt(this.card_number.substring(1, 2));
		this.fourth_digit = Integer.parseInt(this.card_number.substring(3, 4));
		this.fifth_digit = Integer.parseInt(this.card_number.substring(4, 5));
		this.seventh_digit = Integer.parseInt(this.card_number.substring(6, 7));
		this.eigth_digit = Integer.parseInt(this.card_number.substring(7, 8));
		this.ninth_digit = Integer.parseInt(this.card_number.substring(8, 9));
	}

	// checks first number is 4
	private boolean check1() {

		return (this.first_digit != 4);
	}

	// checks fourth number is one more than fifth
	private boolean check2() {

		return (this.fourth_digit != (this.fifth_digit + 1));
	}

	// checks product of first, fifth, and ninth digits are 24
	private boolean check3() {

		return ((this.first_digit * this.fifth_digit 
				* this.ninth_digit) != 24);
	}

	// checks the sum of all numbers is divisible by 4
	private boolean check4() {

		String num = this.card_number;

		// sums up the all of the digits in card_number
		int sum = 0;
		for (int i = 0; i < this.card_number.length(); i++) {
			sum += Integer.parseInt(Character.toString(num.charAt(i)));
		}

		return ((sum % 4) != 0);
	}

	// checks that sum of first for digits is one less than sum of last four
	private boolean check5() {

		String num = this.card_number;

		// sums up the first 4 digits in card_number
		int sum_1 = 0;
		for (int i = 0; i < 4; i++) {
			sum_1 += Integer.parseInt(Character.toString(num.charAt(i)));
		}

		// sums up the last 4 digits in card_number
		int sum_2 = 0;
		for (int i = 8; i < 12; i++) {
			sum_2 += Integer.parseInt(Character.toString(num.charAt(i)));
		}

		return ((sum_1 + 1) != sum_2);
	}

	// checks that sum of first number pair and 7-8th digit number pair is 100
	private boolean check6() {

		return (((this.first_digit * 10) + this.second_digit) 
				+ ((this.seventh_digit * 10) + this.eigth_digit) != 100);
	}

	// mutator method to check card's validity
	public void check() {

		// steps 1 - 6 of the checking algorithm
		if (check1()) {
			this.errorCode = 1;
		} else if (check2()) {
			this.errorCode = 2;
		} else if (check3()) {
			this.errorCode = 3;
		} else if (check4()) {
			this.errorCode = 4;
		} else if (check5()) {
			this.errorCode = 5;
		} else if (check6()) {
			this.errorCode = 6;
		}

		// uses errorCode to check actual validity of card
		if (this.errorCode == 0) {
			this.validity = true;
		} else {
			this.validity = false;
		}
	}

	// accessor method to return validity status
	public boolean isValid() {
		return this.validity;
	}

	// accessor method to return error code
	public int getErrorCode() {
		return this.errorCode;
	}

} // end of class
