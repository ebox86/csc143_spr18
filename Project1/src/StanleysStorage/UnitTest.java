package StanleysStorage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import StanleysStorage.Unit.unitType;

/**
 * Tests the Unit class
 * @author evankoh
 *
 */
public class UnitTest {

	public DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
    /**
     * Default constructor for test class UnitTest
     */
    public UnitTest() {
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
    	Unit unit = new Unit(16, 16, 8, 10.0, unitType.STANDARD);
    	Unit unit2 = new Unit(16, 16, 8, 10.0, unitType.HUMIDITY);
    	Unit unit3 = new Unit(16, 16, 8, 10.0, unitType.TEMPERATURE);
    	assertEquals(16, unit.getHeight());
    	assertEquals(8, unit.getLength(), 0);
    	assertEquals(16, unit.getWidth(), 0);
    	assertEquals(10.0, unit.getStandardPrice(), 0.0);
    	assertEquals(unitType.STANDARD, unit.getUnitType());
    	assertEquals(unitType.HUMIDITY, unit2.getUnitType());
    	assertEquals(unitType.TEMPERATURE, unit3.getUnitType());
    }

    @Test
    public void testGettersAndSetters() throws Exception {
    	Unit unit = new Unit(16, 16, 8, 10.0, unitType.STANDARD);
    	Customer cust = new Customer("Evan", "5555555555");
    	unit.rent(cust, df.parse("04/10/2018"), 7.0);
    	assertEquals(7.0, unit.getPrice(), 0.0);
    	assertEquals(10.0, unit.getStandardPrice(), 0.0);
    	assertEquals(cust, unit.getCustomer());
    }
    
    @Test ()
    public void testRent() throws Exception {
    	Unit unit = new Unit(16, 16, 8, 10.0, unitType.STANDARD);
    	Customer cust = new Customer("Evan", "5555555555");
    	unit.rent(cust, df.parse("04/10/2018"), 7.0);
    	assertEquals(cust, unit.getCustomer());
    }
    
    @Test
    public void testRelease() throws Exception {
    	Unit unit = new Unit(16, 16, 8, 10.0, unitType.STANDARD);
    	Customer cust = new Customer("Evan", "5555555555");
    	unit.rent(cust, df.parse("04/10/2018"));
    	assertEquals(true, unit.releaseUnit());
    	assertEquals(false, unit.releaseUnit());
    }
    
    @Test
    public void testToString() throws Exception {
    	Unit unit = new Unit(16, 16, 8, 10.0, unitType.STANDARD);
    	Customer cust1 = new Customer("Evan", "5555555555");
    	unit.rent(cust1, df.parse("04/10/2018"), 100.0);
    	unit.getCustomer().charge(unit.getPrice());
    	assertEquals("Unit Information:\n" + 
    			"width: 16' height: 16' length: 8'\n" + 
    			"Rental Date: 04/10/2018\n" + 
    			"Customer Name: Evan\n" + 
    			"Phone Number: 5555555555\n" + 
    			"#########################\n" + 
    			"Current Balance: $100.0\n" + 
    			"unit special price: $100.0\n" + 
    			"unit standard price: $10.0\n" +
    			"unit type: STANDARD", unit.toString());
    }
    
}
