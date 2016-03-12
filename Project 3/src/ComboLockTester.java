
public class ComboLockTester {
	public static void main(String[] args) {

		ComboLock test = new ComboLock(10, 20, 30);

		test.turnRight(30);
		System.out.println(test.secret1);
		System.out.println(test.position);
		test.turnLeft(10);
		System.out.println(test.pin2);
		test.turnRight(30);
		System.out.println(test.pin3);
		System.out.println(test.open());
	}

}
