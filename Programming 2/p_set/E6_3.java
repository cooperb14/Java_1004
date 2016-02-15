
/*////////////////////////////////////////////
| Programming Project 2: E6.3
| written by Cooper Bates (cbb2153)
|
| This program executes the programs described in Big
| Java E6.3
*//////////////////////////////////////////////
import java.util.Scanner;

public class E6_3 {

	public static void main(String[] args) {

		// gets input string
		Scanner input = new Scanner(System.in);
		System.out.println("Please input a string");
		String str = input.nextLine();
		input.close();

		// part A
		System.out.println("Part A: ");

		int length = str.length();
		for (int i = 0; i < length; i++) {
			if (Character.isUpperCase(str.charAt(i)))
				System.out.print(str.charAt(i));
		}
		System.out.println("\n");

		// part B
		System.out.println("Part B: ");
		for (int i = 0; i < length; i++) {
			if ((i % 2) == 1)
				System.out.print(str.charAt(i));
		}
		System.out.println("\n");

		// part C
		System.out.println("Part C: ");
		String noVowels = str.replaceAll("[aeiouAEIOU]", "_");
		System.out.println(noVowels + "\n");

		// part D
		System.out.println("Part D: ");
		int answer = length - str.replaceAll("[aeiouAEIOU]", "").length();
		System.out.println(answer + "\n");

		// part E
		System.out.println("Part E: ");

		char vowel = '_';
		int index = noVowels.indexOf(vowel);

		while (index >= 0) {
			System.out.println(index);
			index = noVowels.indexOf(vowel, index + 1);
		}

	} // end of main method
} // end of class
