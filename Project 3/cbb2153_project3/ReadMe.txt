Cooper Bates
cbb2153

Programming Project 3

For ComboLock class, included instance variables to hold the combination values, current position of the dial, and the states of the lock pins to verify that the correct turn direction(right, left, then right again).

For methods I overloaded the constructer, reset all the values upon construction, and verified the user’s input for combination values. The turnRight and turnLeft methods subtract and add ticks to the position accordingly. The open method determines if the lock will open based on the given states of the pins.


For the zip code class, included two constructors, one for a given barcode input and one for a given zip code input. The inputs are checked for their validity, both in their length and, in the case of the bar code, the correct “check digit” before any operations take place. These check methods are “valid_bar”, “valid_bar_length”, and “valid_zip_length”, and are private helper functions to the class. In addition to the constructor there are two accessor methods to retrieve the data from the instance variables.


Note:
While both classes have checks against user inputs, they are not built to withstand ALL malicious user input.