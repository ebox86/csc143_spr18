package CallCenter;

import java.util.Random;
import java.util.Scanner;

/**
 * Main class for execution of sim
 * @author evankoh
 * @version csc143
 */
public class Main {
	private static int custSize, calls;
	private static long interval;
	private static Simulator sim;
	private static Scanner sc;
	
	/**
	 * Main method to interact with user and then execute simulation
	 * @param args
	 */
	public static void main(String[] args) {
		String separator = "##########################################";
		System.out.println(separator +"\n" +
				"###### Sophocles Software (c) 2018) ######\n\n" +
				"   ______      ____   ______           __           \n" + 
				"  / ____/___ _/ / /  / ____/__  ____  / /____  _____\n" + 
				" / /   / __ `/ / /  / /   / _ \\/ __ \\/ __/ _ \\/ ___/\n" + 
				"/ /___/ /_/ / / /  / /___/  __/ / / / /_/  __/ /    \n" + 
				"\\____/\\__,_/_/_/   \\____/\\___/_/ /_/\\__/\\___/_/     \n" + 
				"                                                    \n" + 
				"    ____ _ _  _ _  _ _    ____ ___ ____ ____ \n" + 
				"    [__  | |\\/| |  | |    |__|  |  |  | |__/ \n" + 
				"    ___] | |  | |__| |___ |  |  |  |__| |  \\ \n" + 
				"                                         ");
		custSize = checkCustSize("0");
		System.out.println();
		interval = checkInterval("0");
		System.out.println();
		calls = checkCallSize("0");
    	DayOfWeek day = DayOfWeek.getRandomDay();
		System.out.println(separator + "\n" + "Starting Simulation in 3 seconds \nwith below params\n" + separator
				+ "\n\nInitial Queue size: " + custSize + " customer(s)\nCall Interval: " + interval + " second(s)\nTotal Call volume: " 
				+ calls + "\nDay of Week: " + day.toString() + "\n\n");
		sim = new Simulator(custSize, interval, calls, day);
		sim.runSim();
		
	}
	
	public enum DayOfWeek{
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
		
	    public static DayOfWeek getRandomDay() {
	        Random random = new Random();
	        return values()[random.nextInt(values().length)];
	    }
	}
	
	/*
	 * recursive private method for cleansing user input
	 */
	private static int checkCustSize(String size) {
		String retVal = size;
		if(!size.matches(".*[a-zA-Z].*") && Integer.parseInt(size) <= 50 && Integer.parseInt(size) > 0) {
			retVal = size;
		} else {
			sc = new Scanner(System.in);
			System.out.print("please enter an intial customer queue size [1 - 50]: ");
			String n = sc.next();
			retVal = String.valueOf(checkCustSize(n));
		}
		return Integer.parseInt(retVal);
	}
	
	/*
	 * recursive private method for cleansing user input
	 */
	private static long checkInterval(String inter) {
		String retVal = inter;
		if(!inter.matches(".*[a-zA-Z].*") && Long.parseLong(inter) <= 5 && Long.parseLong(inter) > 0) {
			retVal = inter;
		} else {
			sc = new Scanner(System.in);
			System.out.print("please enter an initial call interval [1 - 5]: ");
			String n = sc.next();
			retVal = String.valueOf(checkInterval(n));
		}
		return Long.parseLong(retVal);
	}
	
	/*
	 * recursive private method for cleansing user input
	 */
	private static int checkCallSize(String calls) {
		String retVal = calls;
		if(!calls.matches(".*[a-zA-Z].*") && Integer.parseInt(calls) <= 50 && Integer.parseInt(calls) > 0) {
			retVal = calls;
		} else {
			sc = new Scanner(System.in);
			System.out.print("please enter an initial call volume [1 - 50]: ");
			String n = sc.next();
			retVal = String.valueOf(checkCallSize(n));
		}
		return Integer.parseInt(retVal);
	}
	

}
