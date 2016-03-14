//*******************************
//
// Combo Lock class
// written by Cooper Bates (cbb2153)
//
// class addressing Programming Project 8.1 of BigJava
//
//*******************************

public class ComboLock {

	private int position;
	private int secret1;
	private int secret2;
	private int secret3;
	private boolean pin1;
	private boolean pin2;
	private boolean pin3;

	private final int UPPER_LIMIT = 39;
	private final int LOWER_LIMIT = 0;
	private final int RANGE = 40;

	// initializes combo lock
	public ComboLock() {
		this.reset();
	}

	// initializes combo lock
	public ComboLock(int secret1, int secret2, int secret3) {
		if (secret1 >= LOWER_LIMIT && secret1 <= UPPER_LIMIT)
			this.secret1 = secret1;
		if (secret2 >= LOWER_LIMIT && secret2 <= UPPER_LIMIT)
			this.secret2 = secret2;
		if (secret3 >= LOWER_LIMIT && secret3 <= UPPER_LIMIT)
			this.secret3 = secret3;

		this.reset();
	}

	// resets dial position to 0
	public void reset() {
		this.position = 0;

		this.pin1 = false;
		this.pin2 = false;
		this.pin3 = false;
	}

	// turns dial to the right by number of ticks
	public void turnRight(int ticks) {
		this.position -= ticks;

		while (this.position < LOWER_LIMIT) {
			this.position += RANGE;
		}

		if (this.position == this.secret1)
			this.pin1 = true;
		else if (this.position == this.secret3 && this.pin2)
			this.pin3 = true;

	}

	// turns dial to the left by number of ticks
	public void turnLeft(int ticks) {
		this.position += ticks;

		while (this.position > UPPER_LIMIT) {
			this.position -= RANGE;
		}

		if (this.position == this.secret2 && this.pin1)
			this.pin2 = true;
	}

	// method to verify if lock is open
	public boolean open() {
		return (this.pin1 && this.pin2 && this.pin3);
	}

} // end of class
