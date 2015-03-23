/**  
 * This class validates integer data, checking if the integer
 * entered by the user contains no chars.
 * @author Richard Barney
 * @version 1.0.0 February 2013
 */
public class ValidData {
	/**
	 * Boolean method that checks if data entered by user is valid, 
	 * that is, it consists entirely of a valid integer.
	 * @param	sUserInput	input entered by user as a String.
	 * @return true if data is valid, false if not.
	 */
	public boolean validateData(String sUserInput) {
		boolean booleanIsValid = true;
		//if input is a space, input is invalid
		if (sUserInput.equals("") || sUserInput.equals(" ")) {
			booleanIsValid = false;
		}
		//look through what user entered, and if a char is found,
		// then the data is declared invalid.
		for (int i = 0; i < sUserInput.length(); i++) {
			if (!Character.isDigit(sUserInput.charAt(i))) {
				booleanIsValid = false;
				i = sUserInput.length(); // set i to the String length to get out of loop
			}
		}
		return booleanIsValid;		
	} // end method validate
} // end class ValidData