// import statements
import java.util.Scanner;
/**
 * This class creates an event. Makes use of the OurDate, OurTime, 
 * and Planner classes. User will be able to enter a date, time,
 * and description of event.
 * @author Richard Barney
 * @version 1.0.0 February 2013
 */
public class Event {

	/** OurDate object */
	private OurDate date = new OurDate();
	/** OurTime object */
	private OurTime time = new OurTime();
	/** String for event description */
	private String sDescription;

	/**
	 * Default constructor.
	 */
	public Event() { }
	
	/**
	 * Get method that returns the date.
	 * @return OurDate object.
	 */
	public OurDate getDate() { return date; }
	/**
	 * Get method that returns the time.
	 * @return OurTime object.
	 */
	public OurTime getTime() { return time; }
	/**
	 * Get method that returns the description.
	 * @return String containing event description.
	 */
	public String getDescription() { return sDescription; }
	
	/**
	 * Set method that sets the date.
	 * @param	date	OurDate object.
	 */
	public void setDate(OurDate date) { this.date = date; }
	/**
	 * Set method that sets the time.
	 * @param	time	OurTime object.
	 */
	public void setTime(OurTime time) { this.time = time; }
	/**
	 * Set method that sets the description.
	 * @param	sDescription	String containing event description.
	 */
	public void setDescription(String sDescription) { this.sDescription = sDescription; }
	
	/**
	 * ToString method that returns the date, time, 
	 * and event description.
	 */
	public String toString() {
		return new String("     " +date +" " +time +" - " +sDescription);
	}
	
	/**
	 * Void method that prompts user for date values,
	 * time values, and event description from keyboard.
	 */
	public void inputFromKeyboard() {
		Scanner input = new Scanner(System.in);
		this.date.inputFromKeyboard();
		this.time.inputFromKeyboard();
		do {
			System.out.print("Enter description: ");
			this.sDescription = input.nextLine();
		} while (sDescription.equals("") || sDescription.equals(" "));
	} // end method inputFromKeyboard
} // end class Event