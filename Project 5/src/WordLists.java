import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//*************************************
//
//  WordLists.java
//
//  Class to aid with Scrabble
//  Programming Project 5, COMS W1004
//
//
//  Your Name: Cooper Bates
//  Your UNI: cbb2153
//**************************************

public class WordLists {

	public File dict;

	// constructs WordList, setting dictionary file
	public WordLists(String fileName) {

		this.dict = new File(fileName);
	}
	
	// returns array of words with specific length
	public String[] lengthN(int n) {

		try {

			Scanner input = new Scanner(this.dict);

			ArrayList<String> words = new ArrayList<String>();

			String temp;
			while (input.hasNext()) {

				temp = input.nextLine();
				if (temp.length() == n) {
					words.add(temp);
				}

			}
			input.close();

			return convert_to_array(words);

		} catch (FileNotFoundException e) {

			System.out.println("Invalid input file name: File does not exist");
			return null;
		}

	}
	
	// returns array of words with specific length and start letter
	public String[] startsWith(int n, char firstLetter) {

		try {

			Scanner input = new Scanner(this.dict);

			ArrayList<String> words = new ArrayList<String>();

			String temp;
			while (input.hasNext()) {

				temp = input.nextLine();
				if (temp.charAt(0) == firstLetter && temp.length() == n) {
					words.add(temp);
				}

			}
			input.close();

			return convert_to_array(words);

		} catch (FileNotFoundException e) {

			System.out.println("Invalid input file name: File does not exist");
			return null;
		}

	}

	// returns array of words with specific length and included letter
	public String[] containsLetter(int n, char included) {

		try {

			Scanner input = new Scanner(this.dict);

			ArrayList<String> words = new ArrayList<String>();

			String temp;
			while (input.hasNext()) {
				String c = Character.toString(included);
				temp = input.nextLine();
				if (temp.substring(1, temp.length()).contains(c) 
					&& temp.length() == n) {
					words.add(temp);
				}

			}
			input.close();

			return convert_to_array(words);

		} catch (FileNotFoundException e) {

			System.out.println("Invalid input file name: File does not exist");
			return null;
		}

	}

	// returns array of words with specific length and number of vowels
	public String[] vowelHeavy(int n, int m) {

		try {
			Scanner input = new Scanner(this.dict);

			ArrayList<String> words = new ArrayList<String>();

			String temp;
			while (input.hasNext()) {

				temp = input.nextLine();
				if (temp.replaceAll("a|e|i|o|u", "").length() >= m 
					&& temp.length() == n) {
					words.add(temp);
				}

			}
			input.close();

			return convert_to_array(words);

		} catch (FileNotFoundException e) {

			System.out.println("Invalid input file name: File does not exist");
			return null;
		}

	}

	// returns array of words with specific length and number of letters
	public String[] multiLetter(int m, char included) {

		try {
			Scanner input = new Scanner(this.dict);

			ArrayList<String> words = new ArrayList<String>();

			String temp;
			int counter;
			while (input.hasNext()) {

				temp = input.nextLine();
				counter = 0;
				for( int i=0; i<temp.length(); i++ ) {
				    if( temp.charAt(i) == included ) {
				        counter++;
				    } 
				}
				
				if ( counter >= m) {
					words.add(temp);
				}

			}
			input.close();

			return convert_to_array(words);

		} catch (FileNotFoundException e) {

			System.out.println("Invalid input file name: File does not exist");
			return null;
		}
	}

	// helper method to convert arrays lists to arrays
	public String[] convert_to_array(ArrayList<String> wordList) {

		String[] wordArray = new String[wordList.size()];
		return wordList.toArray(wordArray);
	}

} // end of class
