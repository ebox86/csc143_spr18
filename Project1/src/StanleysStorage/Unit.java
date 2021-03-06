package StanleysStorage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Unit -- Used for creating and storing Staney Storage Unit information
 * @author evankoh
 *
 */
public class Unit {

	private int width;
	private int height;
	private int length;
	private double standardPrice;
	private double price;
	private unitType unitType;
	private Customer customer;
	private Date rentalDate;
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
	/**
	 * Constructs a new Unit object
	 * @param width
	 * @param height
	 * @param length
	 * @param standardPrice
	 * @param type
	 * @throws IllegalArgumentException
	 */
	public Unit(int width, int height, int length, double standardPrice, unitType type) throws IllegalArgumentException {
		if(width <= 0 || length <= 0 || height <= 0) {
			throw new IllegalArgumentException("Height, Width and Length must be non-negative and non-zero values");
		}
		if(width % 4 != 0 || length % 4 != 0 || height % 2 != 0) {
			throw new IllegalArgumentException("Width and Length must be multiple of 4, Height multiple of 2");
		}
		if(standardPrice < 0.0) {
			throw new IllegalArgumentException("standard unit price must be >= $0.00");
		}
		this.width = width;
		this.height = height;
		this.length = length;
		this.standardPrice = standardPrice;
		this.unitType = type;
	}

	/**
	 * Enum of storage unit types
	 * @author evankoh
	 *
	 */
	public enum unitType {
		STANDARD, HUMIDITY, TEMPERATURE
	}
	
	/**
	 * returns the type of the unit
	 * @return
	 */
	public unitType getUnitType(){
		return unitType;
	}
	
	/**
	 * returns the Customer object assigned to the unit
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	/**
	 * returns the special price of a unit given to a customer
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * returns the standard price of the unit
	 * @return
	 */
	public double getStandardPrice() {
		return standardPrice;
	}
	
	/**
	 * returns the width of the unit
	 * @return
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * returns the height of the unit
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * returns the length of the unit
	 * @return
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * returns the rental Date as Date object
	 * @return
	 */
	public Date getRentalDate() {
		return rentalDate;
	}
	
	/**
	 * Rents a Unit to a provided Customer on a specific Date with a special customer price
	 * @param cust
	 * @param rentalDate
	 * @param price
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public void rent(Customer cust, Date rentalDate, double price) throws IllegalArgumentException, Exception {
		if(price < 0.0) {
			throw new IllegalArgumentException("Price cannot be < $0.00");
		}
		if (this.customer == null) {
			this.customer = cust;
			this.rentalDate = rentalDate;
			this.price = price;
		} else {
			throw new Exception("Unit already rented");
		}
	}
	
	/**
	 * Rents a Unit to a provided Customer on a specific Date
	 * @param cust
	 * @param rentalDate
	 * @throws Exception
	 */
	public void rent(Customer cust, Date rentalDate) throws Exception {
		if (this.customer == null) {
			this.customer = cust;
			this.rentalDate = rentalDate;
		} else {
			throw new Exception("Unit already rented");
		}
	}
	
	/**
	 * Releases a unit from a Customer, making it available to rent again
	 * @return
	 */
	public boolean releaseUnit() {
		if(this.customer != null) {
			this.customer = null;
			this.price = 0.0;
			this.rentalDate = null;
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns a String representation of the Unit
	 */
	public String toString() {
		String tmpPriceStr = "";
		if(price == 0.0) {
			tmpPriceStr = "Not Set";
		} else {
			tmpPriceStr = String.valueOf(price);
		}
		if(this.customer != null) {
			return "Unit Information:\n"
					+ "width: " + width + "' height: " + height + "' length: " + length + "'"
					+ "\nRental Date: " + df.format(this.rentalDate) 
					+ "\n" + this.customer.toString()
					+ "\nunit special price: $" + tmpPriceStr
					+ "\nunit standard price: $" + standardPrice
					+ "\nunit type: " + unitType.toString();
		} else {
			return "Unit Information:\n"
					+ "width: " + width + " height: " + height + " length: " + height
					+ "\n--Unit Not Rented--"
					+ "\nunit standard price: $" + standardPrice
					+ "\nunit type: " + unitType.toString();
		}
	}
}
