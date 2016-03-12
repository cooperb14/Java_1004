// change instnce variables to Private

public class ComboLock {

	public int position = 0;
	public int secret1;
	public int secret2;
	public int secret3;
	public boolean pin1;
	public boolean pin2 = false;
	public boolean pin3 = false;

	private int UPPER_LIMIT = 39;
	private int LOWER_LIMIT = 0;
	private int RANGE = 40;

	// initializes combo lock
	public ComboLock() {

	}

	// initializes combo lock
	public ComboLock(int secret1, int secret2, int secret3) {
		if (secret1 >= LOWER_LIMIT && secret1 <= UPPER_LIMIT)
			this.secret1 = secret1;
		if (secret2 >= LOWER_LIMIT && secret2 <= UPPER_LIMIT)
			this.secret2 = secret2;
		if (secret3 >= LOWER_LIMIT && secret3 <= UPPER_LIMIT)
			this.secret3 = secret3;
	}

	// resets dial position to 0
	public void reset() {
		this.position = 0;
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
