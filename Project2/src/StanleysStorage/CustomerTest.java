package StanleysStorage;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Customer Class
 * @author evankoh
 * @version csc143
 */
public class CustomerTest {
	
    /**
     * Default constructor for test class UnitTest
     */
    public CustomerTest() {
    }
    
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
    }
	
	@Test
	public void testConstructorAndGets() {
		Customer cust = new Customer("Evan", "5555555555");
		assertEquals("Evan", cust.getName());
		assertEquals("5555555555", cust.getPhone());
	}
	
	@Test
	public void testSettersAndMethods() throws IllegalArgumentException {
		Customer cust = new Customer("Evan", "5555555555");
		cust.setName("Evan K");
		assertEquals("Evan K", cust.getName());
		cust.setPhone("4444444444");
		assertEquals("4444444444", cust.getPhone());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPhoneValidation() throws IllegalArgumentException {
		Customer cust = new Customer("Evan", "5555555555");
		assertEquals("5555555555", cust.getPhone());
		cust.setPhone("abc");
	}

	@Test
	public void testBalanceCreditAndCharge() {
		Customer cust = new Customer("Evan", "5555555555");
		cust.charge(25.0);
		assertEquals(25.0, cust.getBalance(), 0.0);
		cust.credit(10.0);
		assertEquals(15.0, cust.getBalance(), 0.0);
	}
	
}
