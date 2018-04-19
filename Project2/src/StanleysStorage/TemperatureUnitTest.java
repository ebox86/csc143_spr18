package StanleysStorage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the TemperatureUnit class
 * @author evankoh
 * @version csc143
 */
public class TemperatureUnitTest {
	public DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
    /**
     * Default constructor for test class UnitTest
     */
    public TemperatureUnitTest() {
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
    
    /**
     * Tests various setters and getters and constructor
     */
    @Test
    public void testGettersAndSetters() {
    	Location loc = new Location("WV23Morgantown", 30.0);
    	TemperatureUnit temp = new TemperatureUnit(16, 16, 8, 60, loc, "1-1");
    	assertEquals(60, temp.getTemperature(), 0);
    	assertEquals("1-1", temp.getUnitName());
    	assertEquals(2078.0, temp.getPrice(), 0);
    	temp.setTemperature(66);
    	assertEquals(66, temp.getTemperature(), 0);
    	assertEquals(2108.0, temp.getPrice(), 0);
    }


}