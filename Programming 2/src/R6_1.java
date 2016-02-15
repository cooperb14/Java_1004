import java.util.Scanner;

public class R6_1 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter n for Program A: ");
		int n = input.nextInt();
		
		int i = 0;
		while ((i*i) < n) {
			System.out.println(i*i);
			i++;
		}
		System.out.println("Program A finished");
		
		System.out.println("Please enter n for Program B: ");
		n = input.nextInt();
		
		i = 1;
		while(i < n) {
			if(i%10 == 0)
				System.out.println(i);
			i++;
		}
		System.out.println("Program B finished");
		
		System.out.println("Please enter n for Program C: ");
		n = input.nextInt();
		
		i = 0;
		while(Math.pow(2,i) < n) {
			System.out.println((int)Math.pow(2, i));
			i++;
		}
		System.out.println("Program C finished");
		
		input.close();
		
	} // end of main method

} // end of class
