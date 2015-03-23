// import statements
import java.util.Scanner;
/** 
 * This class models a time. Most of the code was provided by
 * my professor, while I was responsible for user input.
 * @author Prof. Linda Crane, Richard Barney
 * @version 1.0.0 January 2013
 */
public class OurTime {
	
	/** integer to hold the hour, 00 to 24 */
	private int nHour;
	/** integer to hold the minute */
	private int nMinute;
	
	/**
	 * Default constructor.
	 */
	public OurTime() { }
	/**
	 * Parameterized constructor.
	 * @param	hour	hour as an integer.
	 * @param	minute	minute as an integer.
	 */
	public OurTime(int nHour, int nMinute) {
		this.setHour(nHour);
		this.setMinute(nMinute);
	}
	/**
	 * Parameterized constructor.
	 * @param	time	OurTime object.
	 */
	public OurTime(OurTime time){
		this.nHour = time.nHour;
		this.nMinute = time.nMinute;
	}
	
	/**
	 * Get method that returns the hour.
	 * @return the hour as an integer.
	 */
	public int getHour() { return nHour; }
	/**
	 * Get method that returns the minute.
	 * @return the minute as an integer.
	 */
	public int getMinute() { return nMinute; }
	
	/**
	 * Set method that sets the hour.
	 * @param	nHour	the hour.
	 */
	public void setHour (int nHour) {
		if (nHour < 0 || nHour > 23)
			this.nHour = 0;
		else this.nHour = nHour;
	}
	/**
	 * Set method that sets the minute.
	 * @param	nMinute		the minute.
	 */
	public void setMinute (int nMinute) {
		if (nMinute < 0 || nMinute > 59)
			this.nMinute = 0;
		else this.nMinute = nMinute;
	}
	
	/**
	 * Boolean method to check if time and hour values
	 * have same value as OurTime object.
	 * @param	time	OurTime object.
	 * @return true if values match, false if they don't.
	 */
	public boolean isEqual(OurTime time) {
		if (this.nHour == time.nHour && this.nMinute == time.nMinute) return true;
		else return false;
	}
	
	/**
	 * ToString method that will display the hour and minute 
	 * in format 00:00.
	 */
	public String toString() {
		if (nHour > 10 && nMinute < 10) {
			return new String(nHour +":0" +nMinute);
		}
		else if (nHour < 10 && nMinute < 10) {
			return new String("0" +nHour +":0" + nMinute);
		}
		else if (nHour < 10 && nMinute > 10) {
			return new String("0" +nHour +":" +nMinute);
		}
		else {
			return new String(nHour +":" +nMinute);
		}
	} // end method ToString
	
	/**
	 * Void method that prompts user for time values
	 * from keyboard.
	 */
	public void inputFromKeyboard() {
		Scanner input = new Scanner (System.in);
		ValidData validate = new ValidData();
		String sUserInput;
		
		// prompt for hour
		do {
			System.out.print("Enter hour (0-23): ");
			sUserInput = input.nextLine();
		} while(!validate.validateData(sUserInput) || Integer.parseInt(sUserInput) < 0 || Integer.parseInt(sUserInput) > 23);
		this.nHour = Integer.parseInt(sUserInput);
		
		// prompt for minute
		do {
			System.out.print("Enter minute: ");
			sUserInput = input.nextLine();
		} while (!validate.validateData(sUserInput) || Integer.parseInt(sUserInput) < 0 || Integer.parseInt(sUserInput) > 59);
		this.nMinute = Integer.parseInt(sUserInput);
	} // end method inputFromKeyboard
} // end class OurTime