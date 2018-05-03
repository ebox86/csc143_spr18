package StanleysStorage;

/**
 * Location -- Stanley Storage Location object for storing location information
 * and Units/Customers
 * 
 * @author evankoh
 * @version csc143
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
 
		int index = 0;
		// standard units
		for (int i = 0; i < 7; i++) {
			Unit[] standard  = new StandardUnit[10];
			for (int j = 0; j < 10; j++) {
				standard[j] = new StandardUnit(16, 16, 8, this, index + 1 + "-" + (j + 1));
			}
			unitArr[index] = standard;
			index++;
		}
		// humidity units
		for (int i = 0; i < 3; i++) {
			Unit[] humidity = new HumidityUnit[8];
			for (int j = 0; j < 8; j++) {
				humidity[j] = new HumidityUnit(16, 16, 8, 30, this, index + 1 + "-" + (j + 1));
			}
			unitArr[index] = humidity;
			index++;
		}
		// temperature units
		for (int i = 0; i < 2; i++) {
			Unit[] temp = new TemperatureUnit[6];
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
		if(desig.matches("^[a-zA-Z]{2}\\d{2}[a-zA-Z]+$")) {
			this.designation = desig;
			this.state = desig.substring(0, 2);
			this.locationNumber = Integer.parseInt((desig.substring(2, 4)));
			this.city = desig.substring(4, desig.length());
		 } else {
			 throw new IllegalArgumentException("Designation not properly formatted!");
		 }
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
	public Unit[] getEmptyUnits(Class c) {
		int arrSize = 0;
		for (int row = 0; row < unitArr.length; row++) {
			for (int column = 0; column < unitArr[row].length; column++) {
				if (unitArr[row][column].getCustomer() == null && unitArr[row][column].getClass() == c) {
					arrSize += 1;
				}
			}
		}
		Unit[] tempArr = new Unit[arrSize];
		int idx = 0;
		for (int i = 0; i < unitArr.length; i++) {
			for (int j = 0; j < unitArr[i].length; j++) {
				if (unitArr[i][j].getCustomer() == null && unitArr[i][j].getClass() == c) {
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
					// checks if the user is a multi-unit renter, if so, apply discount to calculated price
					if(getUnitsByCustomer(unitArr[row][column].getCustomer()).length > 1) {
						double multiDiscount = unitArr[row][column].getPrice() * 0.05;
						unitArr[row][column].getCustomer().charge(unitArr[row][column].getPrice() - multiDiscount);
					// standard rate for a single unit renter
					} else {
						unitArr[row][column].getCustomer().charge(unitArr[row][column].getPrice());
					}
				} 
			}
		}
	}

	/**
	 * UnitMap -- a pseudo-graphical representation of the currently booked units
	 * 
	 * @return String representation of site layout and units
	 */
	public String unitMap() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------------------------------------------------------\n"
				+ "           Unit Map for Location " + this.designation + "\n"
				+ "-----------------------------------------------------------");
		sb.append("\n\n      0   1   2   3   4   5   6   7   8   9\n");
		for (int row = 0; row <= 12; row++) {
			if (row != 0) {
				sb.append("\n" + String.format("%02d", row - 1) + ":  ");
				for (int col = 0; col < unitArr[row - 1].length; col++) {
					if (unitArr[row - 1][col].getCustomer() != null) {
						// This is some wonky looking string formatting for the
						// unit map, but it works
						// TODO: Improve this later on
						if (unitArr[row - 1][col].getClass() == StandardUnit.class) {
							sb.append(" S*_");
						} else if (unitArr[row - 1][col].getClass() == HumidityUnit.class) {
							sb.append(" H" + ((HumidityUnit) unitArr[row - 1][col]).getHumidity());
						} else if ((unitArr[row - 1][col].getClass() == TemperatureUnit.class)) {
							sb.append(" T" + ((TemperatureUnit) unitArr[row - 1][col]).getTemperature());
						}
					} else {
						if (unitArr[row - 1][col].getClass() == StandardUnit.class) {
							sb.append(" S__");
							} else if (unitArr[row - 1][col].getClass() == HumidityUnit.class) {
								sb.append(" H__");
							} else if ((unitArr[row - 1][col].getClass() == TemperatureUnit.class)) {
								sb.append(" T__");
							}
					}
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * Returns a string representation of the Location object
	 */

	public String toString() {
		String retVal = "";
		for (int row = 0; row < unitArr.length; row++) {
			for (int column = 0; column < unitArr[row].length; column++) {
				retVal += unitArr[row][column].toString() + "\n\n";
			}
			retVal += "\n";
		}
		return retVal;
	}

}
