public class Car {
	// fuel efficiency (measured in mph)
	// gas in tank, initalized to 0
	// fuel efficiency is specified in the constructor


	// modfier method, addGas
	// accesor method, getGasInTank

	public double fuel_eff;
	public double gas;

	// main constructor method
	public car(double fuel_eff) {
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
	public double getGasInTank(){
		return this.gas;
	}

}