package StanleysStorage;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;

/**
 * Unit -- Used for creating and storing Staney Storage Unit information
 * @author evankoh
 * @version csc143
 */
public abstract class Unit {

	private int width;
	private int height;
	private int length;
	private double price;
	private Date rentalDate;
	DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	private Customer customer;
	private Location location;
	private String unitName;
	
	
	/**
	 * Constructs a new Unit object
	 * @param width
	 * @param height
	 * @param length
	 * @param standardPrice
	 * @param type
	 * @throws IllegalArgumentException
	 */
	public Unit(int width, int height, int length, double price, Location loc, String name) throws IllegalArgumentException {
		if(width <= 0 || length <= 0 || height <= 0) {
			throw new IllegalArgumentException("Height, Width and Length must be non-negative and non-zero values");
		}
		if(width % 4 != 0 || length % 4 != 0 || height % 2 != 0) {
			throw new IllegalArgumentException("Width and Length must be multiple of 4, Height multiple of 2");
		}
		this.width = width;
		this.height = height;
		this.length = length;
		setPrice(price);
		this.location = loc;
		this.unitName = name;
	}

	
	/**
	 * returns the Customer object assigned to the unit
	 * @return
	 */
	public Customer getCustomer() {
		return customer;
	}
	
	public Location getLocation() {
		return location;
	}
	
	/**
	 * returns the price of the unit
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) throws IllegalArgumentException {
		if(price < 0.0) {
			throw new IllegalArgumentException("standard unit price must be >= $0.00");
		} else {
			this.price = price;
		}
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
	
	public String getUnitName() {
		return unitName;
	}
	
	/**
	 * returns the rental Date as Date object
	 * @return
	 */
	public Date getRentalDate() {
		return rentalDate;
	}
	
	/**
	 * Rents a Unit to a provided Customer on a specific Date
	 * @param cust - the customer object who the unit is rented to
	 * @param rentalDate - the date that the rental contract starts
	 * @throws Exception - thrown if the unit is already rented
	 * @throws IllegalArgumentException - thrown if the parameters passed for rentalDate are incorrect or missing
	 */
	public void rent(Customer cust, Date rentalDate) throws IllegalArgumentException, Exception {
		// Construct a Date object of the current time to check for backdated rental contracts
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		
		if(rentalDate == null || rentalDate.before(df.parse(df.format(today.getTime())))){
			throw new IllegalArgumentException("rentalDate must be passed or rentalDate must be today or later");
		}
		if (this.customer == null) {
			this.customer = cust;
			this.rentalDate = rentalDate;
		} else {
			throw new Exception("Unit already rented: " + this.getUnitName());
		}
	}
	
	/**
	 * Releases a unit from a Customer, making it available to rent again
	 * @return - true if the unit was released successfully, false if the unit is not currently rented
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
		NumberFormat currencyf = DecimalFormat.getCurrencyInstance(Locale.US);
		if(this.customer != null) {
			return "Unit Information: " + this.getUnitName() + "\n"
					+ "width: " + width + "' height: " + height + "' length: " + length + "'"
					+ "\nRental Date: " + df.format(this.rentalDate) 
					+ "\n" + this.customer.toString()
					+ "\nunit price: " + currencyf.format(price)
					+ "\nunit type: " + this.getClass().getName();
		} else {
			return "Unit Information: " + this.getUnitName() + "\n"
					+ "width: " + width + " height: " + height + " length: " + height
					+ "\n--Unit Not Rented--"
					+ "\nunit price: " + currencyf.format(price)
					+ "\nunit type: " + this.getClass().getName()
					+ "\nunit name: " + this.getUnitName();
		}
	}
}
