package StanleysStorage;

import StanleysStorage.Unit.unitType;

/**
 * Location -- Stanley Storage Location object for storing location information and Units/Customers
 * @author evankoh
 *
 */
public class Location {

	private String designation;
	private int row;
	private int col;
	private int customerCount;
	private Unit[][] unitArr;
	private Customer[] custArr;
	private String state;
	private String city;
	private int locationNumber;
	
	
	/**
	 * Constructs a new Location object
	 * @param designation
	 * @throws Exception
	 */
	public Location(String designation) throws Exception {
		setDesignation(designation);
		this.row = 12;
		this.col = 20;
		this.unitArr = new Unit[row][col];
		this.custArr = new Customer[100];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				unitArr[i][j] = new Unit(16, 16, 8, 50.0, unitType.STANDARD);
			}
		}
	}


	/*
	 * Getters and Setters
	 */
	
	/**
	 * Sets a new designation for the location in the format SSNNCCCCCCC
	 * 									-->		State - Location Number - City
	 * @param desig
	 * @throws IllegalArgumentException
	 */
	public void setDesignation(String desig) throws IllegalArgumentException {
		if(desig.substring(0, 2).matches("[A-Z]{4}") && desig.substring(2, 4).matches("[0-9]{2}") 
				&& desig.substring(4, desig.length()).matches("[a-zA-Z]{1,}")){
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
	 * @return
	 */
	public String getDesignation() {
		return designation;
	}
	
	/**
	 * Returns the city of the storage location
	 * @return
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Returns the location number of the storage location
	 * @return
	 */
	public int getLocationNumber() {
		return locationNumber;
	}
	
	/**
	 * Returns the state of the storage location
	 * @return
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * Returns a Unit from a given row and column
	 * @param row
	 * @param col
	 * @return
	 */
	public Unit getUnit(int row, int col) {
		return unitArr[row - 1][col - 1];
	}

	/**
	 * Returns a list of Units currently rented by a given Customer
	 * @param cust
	 * @return
	 */
	public Unit[] getUnitsByCustomer(Customer cust) {
		int arrSize = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(unitArr[i][j].getCustomer() == cust) {
					arrSize += 1;
				}
			}
		}
		Unit[] tempArr = new Unit[arrSize];
		int idx = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(unitArr[i][j].getCustomer() == cust) {
					tempArr[idx] = unitArr[i][j];
					idx += 1;
				}
			}
		}
		return tempArr;
	}
	
	/**
	 * Returns a list of Units that are currently empty
	 * @return
	 */
	public Unit[] getEmptyUnits() {
		int arrSize = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(unitArr[i][j].getCustomer() == null) {
					arrSize += 1;
				}
			}
		}
		Unit[] tempArr = new Unit[arrSize];
		int idx = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(unitArr[i][j].getCustomer() == null) {
					tempArr[idx] = unitArr[i][j];
					idx += 1;
				}
			}
		}
		return tempArr;
	}
	
	/**
	 * Returns a list of empty units from a given unit type
	 * @param type
	 * @return
	 */
	public Unit[] getEmptyUnits(Unit.unitType type) {
		int arrSize = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(unitArr[i][j].getCustomer() == null && unitArr[i][j].getUnitType().equals(type)) {
					arrSize += 1;
				}
			}
		}
		Unit[] tempArr = new Unit[arrSize];
		int idx = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(unitArr[i][j].getCustomer() == null && unitArr[i][j].getUnitType().equals(type)) {
					tempArr[idx] = unitArr[i][j];
					idx += 1;
				}
			}
		}
		return tempArr;
	}
	
	public void addCustomer(Customer cust) {
		for(int i = 0; i < custArr.length; i++) {
			if(custArr[i] == null) {
				custArr[i] = cust;
			}
		}
		customerCount += 1;
	}
	
	/**
	 * Return a customer from the customer list
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public Customer getCustomer(int idx) throws Exception{
		if(custArr[idx] != null) {
			return custArr[idx];
		} else {
			throw new Exception("Customer not found!");
		}
	}
	
	/**
	 * Return a count of customers currently in the customer list
	 * @return
	 */
	public int getCustomerCount() {
		return customerCount;
	}
	
	/**
	 * Charges rent to all customers currently renting units
	 */
	public void chargeRent() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(unitArr[i][j].getPrice() > 0.0) {
					unitArr[i][j].getCustomer().charge(unitArr[i][j].getPrice());
				} else if (unitArr[i][j].getCustomer() != null) {
					unitArr[i][j].getCustomer().charge(unitArr[i][j].getStandardPrice());
				}
			}
		}
	}
	
	/**
	 * Returns a string representation of the Location object
	 */
	public String toString() {
		String retVal = "";
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				retVal += (i + 1) + "-" + (j + 1) + " " + unitArr[i][j].toString() + "\n\n";
			}
			retVal += "\n";
		}
		return retVal;
	}
	
	
}
