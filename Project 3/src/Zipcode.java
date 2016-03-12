//*******************************
//
// Zip code class
//
// This is a template from the zip code class supplied by assignment
// class addressing Programming Project 8.3 of BigJava
//
//*******************************

public class Zipcode {

	private String zipcode;
	private String barcode;

	// construct a zip code given a numeric zip number
	public Zipcode(int zip_number) {
		String zip = Integer.toString(zip_number);

		this.zipcode = zip;

		// determine check digit
		int sum = 0;
		for (int i = 0; i < zip.length(); i++) {
			sum += (int) zip.charAt(i);
		}
		int check_digit = 10 - (sum % 10);

		// add check digit to zip code
		zip += Integer.toString(check_digit);

		// convert numbers to bar code
		zip = Num2Bar(zip);

		// add frame bars
		zip = "|" + zip + "|";

		this.barcode = zip;
	}

	// construct zip code given a bar code
	public Zipcode(String bar) {
		this.barcode = bar;

		// strip frame bars
		String zip = bar.substring(1, bar.length() - 1);

		// strip check digit
		zip = zip.substring(0, zip.length() - 5);

		// parse coded numbers and convert to integers
		String result = "";
		for (int i = 0; i < zip.length(); i += 5) {
			result = result + Bar2Num(zip.substring(i, i + 5));
		}

		this.zipcode = result;
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

}
