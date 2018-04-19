package StanleysStorage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Customer --  A Stanley Storage Customer object used to track Customer and balance information
 * @author evankoh
 *
 */
public class Customer {

	private String name;
	private String phone;
	private double balance;
	
	/**
	 * Constructs a new Customer object
	 * @param name
	 * @param phone
	 */
	public Customer(String name, String phone) {
		this.name = name;
		setPhone(phone);
	}
	
	/**
	 * Returns the ledger balance of the customer
	 * @return
	 */
	public double getBalance(){
		return balance;
	}
	
	/**
	 * Returns the customer's name
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the customer's phone number
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * Sets the customer's provided name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Sets the customer's provided phone number
	 * @param phone
	 * @throws IllegalArgumentException
	 */
	public void setPhone(String phone) throws IllegalArgumentException {
		if(phone.matches("[0-9]{10}") && phone.length() <= 10) {
			this.phone = phone;
		} else {
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * Charges rent based on the price of the unit
	 * @param amt - the amount to charge the customer for the use of a unit
	 * @throws IllegalArgumentException - if the amount is less than 0.0
	 */
	public void charge(double amt) throws IllegalArgumentException {
		if(amt > 0.0) {
			this.balance += amt;
		} else {
			throw new IllegalArgumentException("Charge amount must be > $0.00");
		}
	}
	
	/**
	 * Credits a customer a dollar amount to their ledger balance
	 * @param amt - the amount to credit the customer to their ledger balance
	 */
	public void credit(double amt) {
		if(amt < 0.0) {
			throw new IllegalArgumentException("Credit amount must be > $0.00");
		} else if (this.balance - amt < 0.0){
			this.balance = 0.0;
		} else {
			this.balance -= amt;
		}
	}
	
	/**
	 * Returns a string representation of the Customer object
	 */
	public String toString() {
		NumberFormat currencyf = DecimalFormat.getCurrencyInstance(Locale.US);
		return "Customer Name: " + this.name 
				+ "\nPhone Number: " + this.phone
				+ "\n#########################"
				+ "\nCurrent Balance: " + currencyf.format(this.balance);
	}
}
