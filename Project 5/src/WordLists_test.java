import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

//*************************************
//
//WordLists_test.java
//
//Class to test WordLists.java
//Programming Project 5, COMS W1004
//
//
//Your Name: Cooper Bates
//Your UNI: cbb2153
//**************************************

public class WordLists_test {

	public static void main(String[] args) {

		// constructs word list given a dictionary file name
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a dictonary file name");
		WordLists scrabble = new WordLists(input.nextLine());

		// constructs an output file to have the results written to
		System.out.println("Please enter an output file name");
		File outFile = new File(input.nextLine());

		try {
			PrintWriter output = new PrintWriter(outFile);

			// tests lengthN method
			output.println("5 characters long");
			output.println(format(scrabble.lengthN(5)));
			printWords(output, scrabble.lengthN(5));

			// tests startsWith method
			output.println("5 long, starting with A");
			output.println(format(scrabble.startsWith(5, 'a')));
			printWords(output, scrabble.startsWith(5, 'a'));

			// tests containsLetter method
			output.println("5 long, containing X");
			output.println(format(scrabble.containsLetter(5, 'x')));
			printWords(output, scrabble.containsLetter(5, 'x'));

			// tests vowelHeavy method
			output.println("5 long, with at least 2 vowels");
			output.println(format(scrabble.vowelHeavy(5, 2)));
			printWords(output, scrabble.vowelHeavy(5, 2));

			// tests multiLetter method
			output.println("With at least 3 D's");
			output.println(format(scrabble.multiLetter(3, 'd')));
			printWords(output, scrabble.multiLetter(3, 'd'));

			output.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occured, please try again");
		} finally {
			input.close();
		}

	}
	
	// helper method to format output string written to output file
	public static String format(String[] result) {
		
		// formats header
		int OPTIONS = 5;
		String output = "Some possibilities:\t";
		int index;
		
		// formats sample words
		for (int i = 1; i < OPTIONS; i++) {
			index = (int)(Math.random() * (result.length - 1));
			output += result[index] + ", ";
		}
		output += "\n\tThere are " + result.length + " possible words\n\n";
		
		return output;
	}
	
	// helper method to format all words matching the given criteria
	public static void printWords(PrintWriter out, String[] result){
		
		for(String element:result){
			out.print(element + ", ");
		}
		out.println("\n\n");
	}
}
