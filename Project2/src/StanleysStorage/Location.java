package StanleysStorage;

/**
 * Location -- Stanley Storage Location object for storing location information
 * and Units/Customers
 * 
 * @author evankoh
 *
 */
public class Location {

	private String designation;
	private int customerCount;
	private Unit[][] unitArr;
	private Customer[] custArr;
	private String state;
	private String city;
	private int locationNumber;
	private double basePrice;

	/**
	 * Constructs a new Location object
	 * 
	 * @param designation
	 *            -- the designation of the Location of this Stanley Storage
	 * @throws IllegalArgumentException
	 *             -- if preconditions are not met for the constructor
	 */
	public Location(String designation, double basePrice) throws IllegalArgumentException {
		setDesignation(designation);
		this.basePrice = basePrice;
		unitArr = new Unit[12][];
		custArr = new Customer[100];
		Unit[] standard = new StandardUnit[10];
		Unit[] humidity = new HumidityUnit[8];
		Unit[] temp = new TemperatureUnit[6];
		int index = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 10; j++) {
				standard[j] = new StandardUnit(16, 16, 8, this, index + 1 + "-" + (j + 1));
			}
			unitArr[index] = standard;
			index++;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 8; j++) {
				humidity[j] = new HumidityUnit(16, 16, 8, 30, this, index + 1 + "-" + (j + 1));
			}
			unitArr[index] = humidity;
			index++;
		}

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				temp[j] = new TemperatureUnit(16, 16, 8, 60, this, index + 1 + "-" + (j + 1));
			}
			unitArr[index] = temp;
			index++;
		}
	}

	/*
	 * Getters and Setters
	 */

	/**
	 * Sets a new designation for the location in the format SSNNCCCCCCC --> State -
	 * Location Number - City
	 * 
	 * @param desig
	 * @throws IllegalArgumentException
	 */
	public void setDesignation(String desig) throws IllegalArgumentException {
		/*
		 * if(desig.substring(0, 2).matches("[A-Z]{4}") && desig.substring(2,
		 * 4).matches("[0-9]{2}") && desig.substring(4,
		 * desig.length()).matches("[a-zA-Z]{1,}")){
		 */
		this.designation = desig;
		this.state = desig.substring(0, 2);
		this.locationNumber = Integer.parseInt((desig.substring(2, 4)));
		this.city = desig.substring(4, desig.length());
		// } else {
		// throw new IllegalArgumentException("Designation not properly formatted!");
		// }
	}

	/**
	 * Returns the designation of the storage location
	 * 
	 * @return
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Returns the city of the storage location
	 * 
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @return
	 */
	public double getBasePrice() {
		return basePrice;
	}

	/**
	 * Returns the location number of the storage location
	 * 
	 * @return
	 */
	public int getLocationNumber() {
		return locationNumber;
	}

	/**
	 * Returns the state of the storage location
	 * 
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * Returns a Unit from a given row and column
	 * 
	 * @param row - the array row to retrieve
	 * @param col - the array column to retrieve
	 * @return a Unit from the row and column specified
	 * @throws IllegalArgumentException
	 */
	public Unit getUnit(int row, int col) throws IllegalArgumentException {
		if(row > 12 || row < 0) {
			throw new IllegalArgumentException("row cannot exceed 12 and must be > 0");
		} else if (row >= 0 && row <= 6) {
			if(col < 1 || col > 10) {
				throw new IllegalArgumentException("Standard Units only have 10 units per row, column value must be 1 - 10");
			} 
		} else if (row >= 7 && row <= 9) {
			if(col < 1 || col > 8) {
				throw new IllegalArgumentException("Humidity Units only have 8 units per row, column value must be 1 - 8");
			} 
		} else if (row >= 10 && row <= 11) {
			if(col < 1 || col > 6) {
				throw new IllegalArgumentException("Temperature Units only have 6 units per row, column value must be 1 - 6");
			} 
		}
		return unitArr[row - 1][col - 1];
	}

	/**
	 * Returns a list of Units currently rented by a given Customer
	 * 
	 * @param cust
	 * @return
	 */
	public Unit[] getUnitsByCustomer(Customer cust) {
		int arrSize = 0;
		for (int row = 0; row < unitArr.length; row++) {
			for (int column = 0; column < unitArr[row].length; column++) {
				if (unitArr[row][column].getCustomer() == cust) {
					arrSize += 1;
				}
			}
		}
		Unit[] tempArr = new Unit[arrSize];
		int idx = 0;
		for (int i = 0; i < unitArr.length; i++) {
			for (int j = 0; j < unitArr[i].length; j++) {
				if (unitArr[i][j].getCustomer() == cust) {
					tempArr[idx] = unitArr[i][j];
					idx += 1;
				}
			}
		}
		return tempArr;
	}

	/**
	 * Returns a list of Units that are currently empty
	 * 
	 * @return
	 */
	public Unit[] getEmptyUnits() {
		int arrSize = 0;
		for (int row = 0; row < unitArr.length; row++) {
			for (int column = 0; column < unitArr[row].length; column++) {
				if (unitArr[row][column].getCustomer() == null) {
					arrSize += 1;
				}
			}
		}
		Unit[] tempArr = new Unit[arrSize];
		int idx = 0;
		for (int i = 0; i < unitArr.length; i++) {
			for (int j = 0; j < unitArr[i].length; j++) {
				if (unitArr[i][j].getCustomer() == null) {
					tempArr[idx] = unitArr[i][j];
					idx += 1;
				}
			}
		}
		return tempArr;
	}

	/**
	 * Returns a list of empty units from a given unit type
	 * 
	 * @param type
	 * @return
	 */
	public Unit[] getEmptyUnits(Object obj) {
		int arrSize = 0;
		for (int row = 0; row < unitArr.length; row++) {
			for (int column = 0; column < unitArr[row].length; column++) {
				if (unitArr[row][column].getCustomer() == null && unitArr[row][column].getClass() == obj) {
					arrSize += 1;
				}
			}
		}
		Unit[] tempArr = new Unit[arrSize];
		int idx = 0;
		for (int i = 0; i < unitArr.length; i++) {
			for (int j = 0; j < unitArr[i].length; j++) {
				if (unitArr[i][j].getCustomer() == null && unitArr[i][j].getClass() == obj) {
					tempArr[idx] = unitArr[i][j];
					idx += 1;
				}
			}
		}
		return tempArr;
	}

	public void addCustomer(Customer cust) {
		for (int i = 0; i < custArr.length; i++) {
			if (custArr[i] == null) {
				custArr[i] = cust;
				break;
			}
		}
		customerCount += 1;
	}

	/**
	 * Return a customer from the customer list
	 * 
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public Customer getCustomer(int idx) throws Exception {
		if (custArr[idx] != null) {
			return custArr[idx];
		} else {
			throw new Exception("Customer not found!");
		}
	}

	/**
	 * Return a count of customers currently in the customer list
	 * 
	 * @return
	 */
	public int getCustomerCount() {
		return customerCount;
	}

	/**
	 * Charges rent to all customers currently renting units
	 */

	public void chargeRent() {
		for (int row = 0; row < unitArr.length; row++) {
			for (int column = 0; column < unitArr[row].length; column++) {
				if (unitArr[row][column].getCustomer() != null) {
					unitArr[row][column].getCustomer().charge(unitArr[row][column].getPrice());
				} 
			}
		}
	}

	/**
	 * Returns a string representation of the Location object
	 */

	public String toString() {
		String retVal = "";
		for (int row = 0; row < unitArr.length; row++) {
			for (int column = 0; column < unitArr[row].length; column++) {
				retVal += (row + 1) + "-" + (column + 1) + " " + unitArr[row][column].toString() + "\n\n";
			}
			retVal += "\n";
		}
		return retVal;
	}

}
