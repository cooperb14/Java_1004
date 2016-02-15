
/*////////////////////////////////////////////
| Programming Project 2: E6.1
| written by Cooper Bates (cbb2153)
|
| This program executes loops described in Big
| Java E6.1
*//////////////////////////////////////////////
import java.util.Scanner;

public class E6_1 {

	public static void main(String[] args) {

		// part A
		System.out.println("Part A: ");
		int sum = 0;

		for (int i = 2; i <= 100; i++) {
			if ((i % 2) == 0)
				sum += i;
		}
		System.out.println(sum + "\n");

		// part B
		System.out.println("Part B: ");

		for (int i = 1; Math.pow(i, 2) <= 100; i++) {
			sum += (int) Math.pow(i, 2);
		}
		System.out.println(sum + "\n");

		// part C
		System.out.println("Part C: ");

		for (int i = 0; i <= 20; i++) {
			System.out.println((int) Math.pow(2, i));
		}
		System.out.println("\n");

		// part D
		System.out.println("Part D: ");

		Scanner input = new Scanner(System.in);
		System.out.println("input a and press ENTER");
		int a = input.nextInt();
		System.out.println("input b and press ENTER");
		int b = input.nextInt();

		a = Math.min(a, b);
		b = Math.max(a, b);
		sum = 0;

		for (int i = a; i <= b; i++) {
			if ((i % 2) == 1)
				sum += i;
		}
		System.out.println(sum + "\n");

		// part E
		System.out.println("Part E: ");

		System.out.println("please type input");
		int x = input.nextInt();
		int digit;
		sum = 0;

		while (x >= 1) {
			digit = x % 10;
			if (digit % 2 == 1)
				sum += digit;
			x = x / 10;
		}
		System.out.println(sum + "\n");

		input.close();

	} // end of main method

} // end of class
