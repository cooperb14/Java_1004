//************************************
//
//  ComboTest class
//
//  This is a test class for the ComboLock class.
//  Your ComboLock class must work with this class.
//  Do not alter this class
//
//*************************************

public class ComboTest {

	public static void main(String[] args) {
		ComboLock lock = new ComboLock(2, 29, 16);
		lock.reset();
		lock.turnRight(2);
		lock.turnLeft(29);
		lock.turnRight(16);

		if (lock.open()) {
			System.out.println("First attempt is a success!");
		} else {
			System.out.println("First attempt failed!");
		}

		lock.reset();
		lock.turnRight(38);
		lock.turnLeft(27);
		lock.turnRight(13);

		if (lock.open()) {
			System.out.println("Second attempt is a success!");
		} else {
			System.out.println("Second attempt failed!");
		}

	}
}
