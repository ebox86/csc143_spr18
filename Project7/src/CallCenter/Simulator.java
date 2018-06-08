package CallCenter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import CallCenter.Main.DayOfWeek;

/**
 * Similates a call center with passed paramters
 * @author evankoh
 * @version csc143
 */
public class Simulator {
	private int custSize;
	private long interval;
	private int calls;
    private Timer timer = new Timer();
    private static int callCount = 1;
    private ArrayList<Customer> custArr;
    private ArrayList<Tech> techArr;
    private String customerData = "src/customer.csv";
    private String techData = "src/tech.csv";
    private final String DELIMITER = ",";
    private BufferedReader fileReader = null;
    private HashQueue<Customer> custQueue;
    private HashQueue<Tech> techQueue;
    private DayOfWeek day;
	
    /**
     * Constructs a new Simulation object
     * @param size - the initial customer queue size
     * @param interval - the call interval  -- how many seconds each call will be simulated as
     * @param calls - the number of total calls the simulator will simulate
     * @param day - the day of the week, used to determine which techs are working and fielding calls
     */
	public Simulator(int size, long interval, int calls, DayOfWeek day) {
		this.custSize = size;
		this.interval = interval;
		this.calls = calls;
		this.day = day;
		custArr = new ArrayList<Customer>();
		techArr = new ArrayList<Tech>();
		loadData(customerData, custArr);
		loadData(techData, techArr);
		custQueue = new HashQueue<Customer>();
		techQueue = new HashQueue<Tech>();
		for(int i = 0; i < custSize; i++) {
			int randVal = (int)(Math.random() * custArr.size());
			custQueue.push(custArr.get(randVal));
		}
		for(int i = 0; i < techArr.size(); i++) {
			techQueue.push(techArr.get((int)(Math.random() * techArr.size())));
		}
	}
	
	/**
	 * Runs the simulation
	 */
	public void runSim() {
        class simTask extends TimerTask {
            public void run() {
            	Customer currentCust = custQueue.pop();
            	Tech currentTech = techQueue.pop();
                System.out.println("Call number: " + callCount
                		+ "\nCurrently matching customer: \n" + currentCust.toString() + " " 
                		+ "\nWith technician: \n" + currentTech.toString() 
                		+ "\n\n");
                callCount++;
                custQueue.push(custArr.get((int)(Math.random() * custArr.size())));
                techQueue.push(currentTech);
                if (callCount >= calls + 1) {
                    System.out.println("##########################################"
                    		+ "\n          Simulation complete\n"
                    		+ "##########################################");
                    timer.cancel();
                }
            }
        }
        // start timer and set interval with an initial start delay of 3 seconds
        timer.schedule(new simTask(), 3000, interval * 1000);
	}


	/*
	 * Loads csv data
	 */
	private <T> void loadData(String file, ArrayList<T> arr) {
	    try {
	        String line = "";
	        fileReader = new BufferedReader(new FileReader(file));

	        while ((line = fileReader.readLine()) != null) {
	            String[] tokens = line.split(DELIMITER);
	            if(file.contains("customer")) {
		            Customer newCust = new Customer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
		            custArr.add(newCust);
	            } else if (file.contains("tech")) {
		            Tech newTech = new Tech(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
		            if(!day.equals(newTech.getDayOff())){
			            techArr.add(newTech);
		            }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            fileReader.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
