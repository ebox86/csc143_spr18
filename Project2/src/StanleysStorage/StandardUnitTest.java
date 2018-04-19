package StanleysStorage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Unit class
 * @author evankoh
 * @version csc143
 */
public class StandardUnitTest {

	public DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	public Location loc = new Location("WA24Issaquah", 15.0);
	
    /**
     * Default constructor for test class UnitTest
     */
    public StandardUnitTest() {
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
    	Unit unit = new StandardUnit(16, 16, 8, loc, "1-1");
    	assertEquals(16, unit.getHeight());
    	assertEquals(8, unit.getLength(), 0);
    	assertEquals(16, unit.getWidth(), 0);
    }

    @Test
    public void testGettersAndSetters() throws Exception {
    	Unit unit = new StandardUnit(16, 16, 8, loc, "1-1");
    	Customer cust = new Customer("Evan", "5555555555");
    	unit.rent(cust, df.parse("04/20/2018"));
    	assertEquals(90.0, unit.getPrice(), 0.0);
    	assertEquals(15.0, loc.getBasePrice(), 0.0);
    	assertEquals(cust, unit.getCustomer());
    }
    
    @Test ()
    public void testRent() throws Exception {
    	Unit unit = new StandardUnit(16, 16, 8, loc, "1-2");
    	Customer cust = new Customer("Evan", "5555555555");
    	unit.rent(cust, df.parse("04/30/2018"));
    	assertEquals(cust, unit.getCustomer());
    }
    
    @Test
    public void testRelease() throws Exception {
    	Unit unit = new StandardUnit(16, 16, 8, loc, "1-3");
    	Customer cust = new Customer("Evan", "5555555555");
    	unit.rent(cust, df.parse("04/30/2018"));
    	assertEquals(true, unit.releaseUnit());
    	assertEquals(false, unit.releaseUnit());
    }
    
    
}
