/*////////////////////////////////////////////
| Programming Project 2: E3.9
| written by Cooper Bates (cbb2153)
|
| This is file contains the Car class
*//////////////////////////////////////////////

public class Car {

	public double fuel_eff;
	public double gas;

	// main constructor method
	public Car(double fuel_eff) {
		this.fuel_eff = fuel_eff;
		this.gas = 0;
	}

	// drive method simulates driving car
	public void drive(double distance) {
		this.gas -= distance / this.fuel_eff;
	}

	// add gas to gas tank method
	public void addGas(double gas) {
		this.gas += gas;
	}

	// accessor method for gas variable
	public double getGasInTank() {
		return this.gas;
	}

} // end of class
