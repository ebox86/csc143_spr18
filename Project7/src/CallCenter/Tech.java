package CallCenter;

import CallCenter.Main.DayOfWeek;
/**
 * Creates a new Technician
 * 
 * @author evankoh
 * @version csc142
 */
public class Tech {

	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String schedule;
	private DayOfWeek dayOff;

	/**
	 * Constructs a new Tech
	 * 
	 * @param id
	 *            - the id of the technician
	 * @param firstName
	 *            - first name of the technician
	 * @param lastName
	 *            - last name of the technician
	 * @param userName
	 *            - username of the technician
	 * @param schedule
	 *            - the schedule of the tech
	 */
	public Tech(String id, String firstName, String lastName, String userName, String schedule) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.schedule = schedule;
		determineDayOff(this.schedule);
	}

	private void determineDayOff(String sched) {
		String[] weekdays = sched.split("");
		int DOW = 0;
		for (String day : weekdays) {
			if (!convertToBoolean(day)) {
				if(DOW == 0) {
					dayOff = DayOfWeek.MONDAY;
				} else if (DOW == 1) {
					dayOff = DayOfWeek.TUESDAY;
				} else if (DOW == 2) {
					dayOff = DayOfWeek.WEDNESDAY;
				} else if (DOW == 3) {
					dayOff = DayOfWeek.THURSDAY;
				} else if (DOW == 4) {
					dayOff = DayOfWeek.FRIDAY;
				} else if (DOW == 5) {
					dayOff = DayOfWeek.SATURDAY;
				} else if (DOW == 6) {
					dayOff = DayOfWeek.SUNDAY;
				}
			}
			DOW++;
		}
	}

	/*
	 * used to convert '1' and '0' to boolean True or False values
	 */
	private boolean convertToBoolean(String value) {
		boolean returnValue = false;
		if ("1".equalsIgnoreCase(value))
			returnValue = true;
		return returnValue;
	}

	/**
	 * Retrieves the first name of tech
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * sets the first name of tech
	 * 
	 * @return
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Retrieves the last name of tech
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * sets the last name of tech
	 * 
	 * @return
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Retrieves the username of tech
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * sets the username of tech
	 * 
	 * @return
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Retrieves the schedule of the tech
	 * 
	 * @return
	 */
	public String getSchedule() {
		return schedule;
	}

	/**
	 * sets the schedule name of tech
	 * 
	 * @return
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	
	/**
	 * Returns a string value of the day off for the technician
	 * @return
	 */
	public DayOfWeek getDayOff() {
		return this.dayOff;
	}

	/**
	 * Retrieves the id of tech
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	public String toString() {
		return "Techician id: " + this.id + ", First Name: " + this.firstName + ", Last Name: " + this.lastName
				+ ", Username: " + this.userName;
	}

}
