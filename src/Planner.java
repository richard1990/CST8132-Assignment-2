/**
 * This class creates activities for a personal planner. It uses
 * an array of Events to add a date, time, and event for an
 * activity and adds it to the personal planner.
 * @author Richard Barney
 * @version 1.0.0 January 2013 
 */
public class Planner {

	/** Integer that will be used to limit the array of activites (1000). */
	private final int MAXEVENTS = 1000;
	/** Integer to indicate a meeting location (Meeting) will be added. */
	final private int MEETING = 1;
	/** Integer to indicate an assignment (Assignment) is being added. */
	final private int ASSIGNMENT = 2;
	/** Integer to indicate a shift length (Work) is being added */
	final private int WORK = 3;
	/** Integer to indicate a social event (Social) is being added. */
	final private int SOCIAL = 4;
	/** Array of Events with 1000 being the max. */
	private Event[]activities;
	/** Integer to keep track of Events added to the array. */
	private int nNumberOfEvents;
	
	/**
	 * Default constructor.
	 */
	public Planner() {
		activities = new Event[MAXEVENTS];
		nNumberOfEvents = 0;
	}
	
	/**
	 * Void method that allows user to add an activity.
	 * @param	nEventType	an integer that will indicate what inherited class object will be
	 * 						created, could be Meeting, Assignment, Work, or Social.
	 */
	public void inputActivity(int nEventType) {
		boolean booleanOccupied = false; // boolean to check if an activity already exists for a specific date and time
		//check if the array is full, if not, move on
		if (nNumberOfEvents >= MAXEVENTS) {
			System.out.println("Your planner is full! You must delete an activity before you can add another.");
		}
		else {
			switch(nEventType) {
				case MEETING: activities [nNumberOfEvents] = new Meeting(); break;
				case ASSIGNMENT: activities[nNumberOfEvents] = new Assignment(); break;
				case WORK: activities[nNumberOfEvents] = new Work(); break;
				case SOCIAL: activities[nNumberOfEvents] = new Social(); break;
			}
			activities[nNumberOfEvents].inputFromKeyboard(); // get user input
			//look through array to see if an activity already exists for that date and time
			for (int i = 0; i < nNumberOfEvents; i++)	{
				if (activities[i].getDate().isEqual(activities[nNumberOfEvents].getDate())
					&& activities[i].getTime().isEqual(activities[nNumberOfEvents].getTime())) {
		            booleanOccupied = true;
		            break;
				} 
			}
			// if an activity already exists for the date and time the user entered,
			// nullify the object to kill entry data, else increment the number of events 
			if (booleanOccupied) {
				System.out.println("An activity already exists for that date and time."
								   +"\nYou have to first delete the activity for that date and time to modify it.");
	            activities[nNumberOfEvents] = null;
			} else {
				System.out.println("The activity has been added to your planner.");
				nNumberOfEvents++;
			}
		} // end big else
	} // end method inputActivity
	
	/**
	 * Void method to display one day's activities.
	 * @param	date	OurDate object.
	 */
	public void displayOneDay(OurDate date) {
		StringBuilder sbActivitiesOneDay = new StringBuilder();
		// look through array to see if date exists, if it does append the
		// StringBuilder object with the Event and then display that day's
		// activities
		for (int i = 0; i < nNumberOfEvents; i++) {
			if (date.isEqual(activities[i].getDate())) {
				sbActivitiesOneDay.append(activities[i] +"\n");
			}
		}
		System.out.print("Your activities for "
						   +date.toString()
						   +" are:\n"
						   +sbActivitiesOneDay.toString());
		if (sbActivitiesOneDay.length() < 1) {
			System.out.println("     " +"No activities exist for this date.");
		}
	} // end method displayOneDay
	
	/**
	 * Void method to display activities for a week.
	 * @param	date	OurDate object.
	 */
	public void displaySevenDays(OurDate date) {
		System.out.println("Your activities for the week starting " +date.toString() +" are: ");
		//loop seven times to display activities for seven days
		for (int i = 0; i < 7; i++) {
			displayOneDay(date);
			date.addOne(); // add one day and loop again
		}
	} // end method displaySevenDays
	
	/**
	 * Void method to delete an activity at a specific
	 * date and time.
	 * @param	date	OurDate object.
	 * @param	time	OurTime object.
	 */
	public void deleteEvent(OurDate date, OurTime time) {
		boolean booleanFoundEvent = false; // boolean to check if an activity exists for that date and time
		int i;
		// loop through array and if an activity is found with the
		// date and time the user entered, set booleanFoundEvent
		// to true and break
		for (i = 0; i < nNumberOfEvents; i++) {
			if (activities[i].getDate().isEqual(date) && activities[i].getTime().isEqual(time)) {
				booleanFoundEvent = true;
				break;
			}
		}
		// if booleanFoundEvent is true, delete that index from the array, 
		// otherwise tell user no activity exists for that date and time
		if (booleanFoundEvent){
			activities[i] = activities[nNumberOfEvents - 1];
			nNumberOfEvents--;
			System.out.println("Activity deleted. That date and time slot is now free.");
		}
		else {
			System.out.println("There is no activity for that date and time!");
		}
	} // end method deleteEvent
} // end class Planner