
Programming Project 5:
Cooper Bates
cbb2153


The WordLists class contains a constructor which sets the instance variable of type File to the dictionary file provided by the user. There is then a single method for each search criteria listed in the assignment. Each of these methods contains a try catch statement to ensure the dictionary file actually exists before it is scanned and searched. These methods return string arrays of the search results based on specific criteria.

The WorldLists_tester class is designed to test the functionality of the WordList class. The tester class allows the user to specify files for dictionary input and result output, but all search parameters are hard wired into the program and serve to merely display the functionality of the class methods. The results of each search are written out to a file, in addition to the number of results generated.


Additional Notes:

	Program does not consider capitalization of letters and words in dictionary. Thus any difference in capitalization will not be a match. The file name for the dictionary file must be that of a file in the current directory.