//*******************************
//
// Zip code class
// written by Cooper Bates (cbb2153)
// This is a template from the zip code class supplied by assignment
//
// class addressing Programming Project 8.3 of BigJava
//*******************************

public class Zipcode {

	private String zipcode;
	private String barcode;

	private final int ZIP_LENGTH = 5;
	private final int BAR_LENGTH = 32;

	// construct a zip code given a numeric zip number
	public Zipcode(int zip_number) {
		String zip = Integer.toString(zip_number);

		// checks inputed zip code validity
		if (valid_zip_length(zip)) {
			this.zipcode = zip;

			// determine check digit
			int sum = 0;
			for (int i = 0; i < zip.length(); i++) {
				sum += Character.getNumericValue(zip.charAt(i));
			}
			int check_digit;
			if (sum % 10 == 0)
				check_digit = 0;
			else
				check_digit = 10 - (sum % 10);

			// add check digit to zip code
			zip += Integer.toString(check_digit);

			// convert numbers to bar code
			zip = Num2Bar(zip);

			// add frame bars
			zip = "|" + zip + "|";

			this.barcode = zip;

		} else {
			this.zipcode = "Invalid zip code";
			this.barcode = "Invalid zip code";
		}

	}

	// construct zip code given a bar code
	public Zipcode(String bar) {
		String result = "";

		if (valid_bar_length(bar) && valid_bar(result)) {
			// strip frame bars
			String zip = bar.substring(1, bar.length() - 1);

			// parse coded numbers and convert to integers
			for (int i = 0; i < zip.length(); i += 5) {
				result = result + Bar2Num(zip.substring(i, i + 5));
			}

			// remove check digit
			this.zipcode = result.substring(0, result.length() - 1);
			this.barcode = bar;
		} else {
			this.zipcode = "Invalid bar code";
			this.barcode = "Invalid bar code";
		}

	}

	// accessor method to retrieve numeric zip code
	public String getZipcode() {
		return zipcode;
	}

	// accessor method to retrieve barcode
	public String getBarcode() {
		return barcode;
	}

	// helper method to transform number to bar code
	private String Num2Bar(String num_string) {

		num_string = num_string.replace("1", ":::||");
		num_string = num_string.replace("2", "::|:|");
		num_string = num_string.replace("3", "::|||");
		num_string = num_string.replace("4", ":|:::");
		num_string = num_string.replace("5", ":|:||");
		num_string = num_string.replace("6", ":||::");
		num_string = num_string.replace("7", "|::::");
		num_string = num_string.replace("8", "|::||");
		num_string = num_string.replace("9", "|:|::");
		num_string = num_string.replace("0", "||:::");

		return num_string;
	}

	// helper method to transform bar code to corresponding number
	private String Bar2Num(String bar) {
		bar = bar.replace(":", "0");
		bar = bar.replace("|", "1");

		int sum = 0;
		sum += Character.getNumericValue(bar.charAt(0)) * 7;
		sum += Character.getNumericValue(bar.charAt(1)) * 4;
		sum += Character.getNumericValue(bar.charAt(2)) * 2;
		sum += Character.getNumericValue(bar.charAt(3)) * 1;
		sum += Character.getNumericValue(bar.charAt(4)) * 0;

		// account for 0 exception
		if (sum == 11)
			return "0";
		else
			return Integer.toString(sum);
	}

	// method to check if zip code is proper length
	private boolean valid_zip_length(String num) {
		return (num.length() == ZIP_LENGTH);
	}

	// method to check if bar code is proper length
	private boolean valid_bar_length(String bar) {
		return (bar.length() == BAR_LENGTH);
	}

	// method to check the validity of bar code
	private boolean valid_bar(String num) {

		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			sum += Character.getNumericValue(num.charAt(i));
		}

		// check if check digit is correct
		if (sum % 10 == 0)
			return true;
		else
			return false;

	}

} // end of class
