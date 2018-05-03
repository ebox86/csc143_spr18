package StanleysStorage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests the Location Class
 * @author evankoh
 * @version csc143
 */
public class LocationTest {

	public DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
    /**
     * Default constructor for test class UnitTest
     */
    public LocationTest() {
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
	public void testConstructorAndGets() throws Exception {
		Location loc = new Location("WA23Issaquah", 15.0);
		assertEquals("WA", loc.getState());
		assertEquals(23, loc.getLocationNumber());
		assertEquals("Issaquah", loc.getCity());
		assertEquals("WA23Issaquah", loc.getDesignation());
		Unit unit1010 = loc.getUnit(10, 2);
		assertEquals(unit1010, loc.getUnit(10, 2));
		assertEquals(106, loc.getEmptyUnits().length, 0);
	}

	@Test
	public void testGetEmptyUnits() throws Exception {
		Location loc = new Location("WA23Issaquah", 15.0);
		assertEquals(106, loc.getEmptyUnits().length);
		loc.getUnit(5, 1).rent(new Customer("Evan", "5555555555"), df.parse("04/30/2018"));
	}
	
	@Test
	public void testCustomerAdd() throws Exception {
		Location loc = new Location("WA23Issaquah", 15.0);
		Customer cust = new Customer("Evan", "5555555555");
		loc.addCustomer(cust);
		assertEquals(1, loc.getCustomerCount());
		assertEquals(cust, loc.getCustomer(0));
	}
	
	@Test(expected = Exception.class)
	public void testGetCustomer() throws Exception {
		Location loc = new Location("WA23Issaquah", 15.0);
		Customer cust = new Customer("Evan", "5555555555");
		assertEquals(cust, loc.getCustomer(0));
	}
}
