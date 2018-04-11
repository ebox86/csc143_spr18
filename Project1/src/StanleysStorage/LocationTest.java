package StanleysStorage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import StanleysStorage.Unit.unitType;

/**
 * Tests the Location Class
 * @author evankoh
 *
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
		Location loc = new Location("WA23Issaquah");
		assertEquals("WA", loc.getState());
		assertEquals(23, loc.getLocationNumber());
		assertEquals("Issaquah", loc.getCity());
		assertEquals("WA23Issaquah", loc.getDesignation());
		Unit unit1010 = loc.getUnit(10, 10);
		assertEquals(unit1010, loc.getUnit(10, 10));
		assertEquals(240, loc.getEmptyUnits().length);
	}

	@Test
	public void testGetEmptyUnits() throws Exception {
		Location loc = new Location("WA23Issaquah");
		assertEquals(240, loc.getEmptyUnits().length);
		loc.getUnit(5, 1).rent(new Customer("Evan", "5555555555"), df.parse("04/10/2018"));
		assertEquals(239, loc.getEmptyUnits(unitType.STANDARD).length);
	}
	
	@Test
	public void testCustomerAdd() throws Exception {
		Location loc = new Location("WA23Issaquah");
		Customer cust = new Customer("Evan", "5555555555");
		loc.addCustomer(cust);
		assertEquals(1, loc.getCustomerCount());
		assertEquals(cust, loc.getCustomer(0));
	}
	
	@Test(expected = Exception.class)
	public void testGetCustomer() throws Exception {
		Location loc = new Location("WA23Issaquah");
		Customer cust = new Customer("Evan", "5555555555");
		assertEquals(cust, loc.getCustomer(0));
	}
}
