// import statements
import java.util.Scanner;
/**
 * This class inherits from Event and only adds the function to let the user
 * enter a shift length in hours as an integer.
 * @author Richard Barney
 * @version 1.0.0 February 2013
 */
class Work extends Event  {
	
	/** Integer to hold the shift length in hours. */
	private int nShiftLength;
	
	/**
	 * Get method that returns the shift length as an integer.
	 * @return the shift length in hours.
	 */
	public int getShiftLength() { return nShiftLength; }
	
	/**
	 * Set method that sets the shift length as an integer
	 * @param	nShiftLength	the shift length in hours as an integer.
	 */
	public void setShiftLength(int nShiftLength) { this.nShiftLength = nShiftLength; }
	
	/**
	 * ToString method that calls the super class's ToString method
	 * and appends the shift length.
	 */
	public String toString() {
		return super.toString() + " for " +nShiftLength +" hours";
	}
	
	/**
	 * Void method that prompts user for shift length in hours
	 * from the keyboard.
	 */
	public void inputFromKeyboard() {
		Scanner input = new Scanner(System.in);
		ValidData validate = new ValidData();
		String sUserInput;
		super.inputFromKeyboard(); // call Event class inputFromKeyboard method
		do {
			System.out.print("Enter shift length (in hours): ");
			sUserInput = input.nextLine();
		} while (!validate.validateData(sUserInput) || Integer.parseInt(sUserInput) < 1 || Integer.parseInt(sUserInput) > 24);
		this.nShiftLength = Integer.parseInt(sUserInput);
	} // end method inputFromKeyboard
} // end class Work