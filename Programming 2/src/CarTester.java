public class CarTester {

	public static void main(String[] args) {

		Car tessie = new Car(88.0);
		tessie.addGas(10.0);
		System.out.println(tessie.getGasInTank());
		tessie.drive(200.00);
		System.out.println(tessie.getGasInTank());

	}
}