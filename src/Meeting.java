// import statements
import java.util.Scanner;
/**
 * This class inherits from Event and only adds the function to let the user
 * enter a meeting location.
 * @author Richard Barney
 * @version 1.0.0 February 2013
 */
public class Meeting extends Event  {
	
	/** String to hold the meeting location */
	private String sMeetingLocation;
	
	/**
	 * Get method that returns the meeting location as a String.
	 * @return the meeting location.
	 */
	public String getMeetingLocation() { return sMeetingLocation; }
	
	/**
	 * Set method that sets the meeting location as a String.
	 * @param	sMeetingLocation	the meeting location.
	 */
	public void setMeetingLocation(String sMeetingLocation) { this.sMeetingLocation = sMeetingLocation; }
	
	/**
	 * ToString method that calls the super class's ToString method
	 * and appends the meeting location.
	 */
	public String toString() {
		return super.toString() + " at " +sMeetingLocation;
	}
	
	/**
	 * Void method that prompts user for the meeting location 
	 * from the keyboard.
	 */
	public void inputFromKeyboard() {
		Scanner input = new Scanner(System.in);
		ValidData validate = new ValidData();
		super.inputFromKeyboard(); // call Event class inputFromKeyboard method
		do {
			System.out.print("Enter location: ");
			this.sMeetingLocation = input.nextLine();
		} while(sMeetingLocation.equals("") || sMeetingLocation.equals(" "));
	} // end method inputFromKeyboard
} // end class Meeting