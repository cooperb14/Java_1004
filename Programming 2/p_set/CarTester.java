/*////////////////////////////////////////////
| Programming Project 2: E3.9
| written by Cooper Bates (cbb2153)
|
| This is file contains a tester for the Car class
*//////////////////////////////////////////////

public class CarTester {

	public static void main(String[] args) {

		Car tessie = new Car(20.0); // 20 miles per Gallon
		tessie.addGas(10.0); // add 10 gallons
		tessie.drive(100.00); // drive 100 miles
		System.out.println(tessie.getGasInTank()); // get remaining gas

	} // end of main method

} // end of class
