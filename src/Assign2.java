// import statements
import java.util.Scanner;
/**
 * This class loops options to allow a user to enter activities into a planner. Makes
 * use of the Planner class to create Events to be added to the activity planner.
 * @author Richard Barney
 * @version 1.0.0 January 2013
 * @since 1.7
 */
public class Assign2 {
	/**
	 * main method as required by JVM.
	 * @param  args   standard command line parameters as a string array.
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Planner activity = new Planner();
		OurDate date = new OurDate();
		OurTime time = new OurTime();
		ValidData validate = new ValidData();
		String sOption = "1";
		System.out.println("Welcome to your Activity Planner!");
	
		while (Integer.parseInt(sOption) != 0) { // while option is valid, loop menu
			do {
				System.out.println("Enter 1 to add an activity to your planner  Enter 2 to display activities for a day"
						  		   +"\nEnter 3 to display activities for a week    Enter 4 to delete an event"
						  		   +"\nEnter 0 to quit");
				sOption = input.nextLine();
			} while (!validate.validateData(sOption) || Integer.parseInt(sOption) < 0 || Integer.parseInt(sOption) > 4);
			
			switch(sOption) {
				case "1": // 1 adds an activity to the planner
				do {
					System.out.println("Enter 1 to add a meeting      Enter 2 to add an assignment"
									   +"\nEnter 3 to add a work shift   Enter 4 to add a social event");
					sOption = input.nextLine();
				} while (!validate.validateData(sOption) || Integer.parseInt(sOption) < 1 || Integer.parseInt(sOption) > 4);
				activity.inputActivity(Integer.parseInt(sOption));
				break;
			case "2": // 2 displays activities for one day
				date.inputFromKeyboard();
				activity.displayOneDay(date);
				break;
			case "3": // 3 displays activities for seven days
				date.inputFromKeyboard();
				activity.displaySevenDays(date);
				break;
			case "4": // 4 deletes an event at a date and time
				date.inputFromKeyboard();
				time.inputFromKeyboard();
				activity.deleteEvent(date, time);
				break;
			}
		} // end looping thru menu
	
		if (Integer.parseInt(sOption) == 0) { // 0 ends program
			System.out.print("Goodbye.");
		}
	} // end method main
} // end class Assign2