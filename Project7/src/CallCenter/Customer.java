package CallCenter;

/**
 * Creates a Customer
 * @author evankoh
 * @version csc143
 */
public class Customer {

	private String number;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	/**
	 * Constructs a new customer object
	 * @param number - the customer number
	 * @param firstName - the first name of the customer
	 * @param lastName - the last name of the customer
	 * @param email - the email address of the customer
	 * @param phone - the phone number of the customer
	 */
	public Customer(String number, String firstName, String lastName, String email, String phone) {
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;	
	}
	
	public String toString() {
		return "Customer number: " + number + 
				", First Name: " + firstName + ", Last Name: " + lastName + 
				", Email: " + email + ", Phone: " + phone;
	}

	public String getNumber() {
		return number;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
