//******************************************
//
// class: ArrayMethods
// 
// name: Cooper Bates (cbb2153)
//
// Practice Exercise E7.2
//******************************************

public class ArrayMethods {

	private int[] values;

	public ArrayMethods(int[] initialValues) {

		// do not alter this method

		values = initialValues;
	}

	public void swapFirstAndLast() {

		// your code here: part a
		int temp = values[values.length - 1];
		values[values.length - 1] = values[0];
		values[0] = temp;

	}

	public void shiftRight() {

		// your code here: part b
		int temp = values[values.length - 1];
		for (int i = values.length - 1; i > 0; i--) {
			values[i] = values[i - 1];
		}
		values[0] = temp;
	}

	public void replaceEven() {

		// your code here: part c
		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				values[i] = 0;
			}
		}

	}

	public void replaceByLarger() {

		// your code here: part d
		int[] temp = new int[values.length];
		temp[0] = values[0];
		temp[temp.length - 1] = values[values.length - 1];
		for (int i = 1; i < values.length - 1; i++) {
			temp[i] = Math.max(values[i + 1], values[i - 1]);
		}
		values = temp;
	}

	public void removeMiddle() {

		// your code here: part e
		int pos;
		int[] temp;
		if (values.length % 2 == 0) {
			pos = values.length / 2;
			temp = new int[values.length - 2];
			for (int i = pos; i < values.length - 1; i++) {
				values[i - 1] = values[i + 1];
			}
			for (int i = 0; i < temp.length; i++) {
				temp[i] = values[i];
			}
		} else {
			pos = values.length / 2;
			temp = new int[values.length - 1];
			for (int i = pos; i < values.length - 1; i++) {
				values[i] = values[i + 1];
			}
			for (int i = 0; i < temp.length; i++) {
				temp[i] = values[i];
			}
		}
		values = temp;
	}

	public void evenToFront() {

		// your code here: part f
		int[] temp = new int[values.length];
		int counter = 0;

		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 0) {
				temp[counter] = values[i];
				counter++;
			}
		}

		for (int i = 0; i < values.length; i++) {
			if (values[i] % 2 == 1) {
				temp[counter] = values[i];
				counter++;
			}
		}
		values = temp;
	}

	public int getSecondLargest() {

		// your code here: part g
		int largest = values[0];
		int secondLargest = values[0];
		for (int i = 0; i < values.length; i++) {
			if (values[i] > largest) {
				secondLargest = largest;
				largest = values[i];
			} else {
				if (values[i] > secondLargest) {
					secondLargest = values[i];
				}
			}
		}

		return secondLargest;

	}

	public boolean isSorted() {

		// your code here: part h
		int counter = 1;
		for (int i = 1; i < values.length; i++) {
			if (values[i] > values[i - 1]) {
				counter++;
			}
		}

		return (counter == values.length);

	}

	public boolean closeDuplicates() {

		// your code here: part i
		boolean result = false;
		for (int i = 1; i < values.length - 1; i++) {
			if (values[i] == values[i + 1] || values[i] == values[i - 1]) {
				result = true;
			}
		}

		return result;
	}

	public boolean anyDuplicates() {

		// your code here: part j
		boolean result = false;
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] == values[j]) {
					result = true;
				}
			}
		}

		return result;
	}

	public int[] getValues() {

		// do not alter this method

		return values;
	}

} // end class
