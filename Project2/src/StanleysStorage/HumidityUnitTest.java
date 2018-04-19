package StanleysStorage;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the HumidityUnit class
 * @author evankoh
 * @version csc143
 */
public class HumidityUnitTest {

	public DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	
    /**
     * Default constructor for test class UnitTest
     */
    public HumidityUnitTest() {
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
    	Location loc = new Location("WV16Morgantown", 25.0);
    	HumidityUnit hum = new HumidityUnit(16, 16, 8, 20, loc, "1-1");
    	assertEquals(20, hum.getHumidity(), 0);
    	assertEquals("1-1", hum.getUnitName());
    	hum.setHumidity(40);
    	assertEquals(40, hum.getHumidity(), 0);
    	assertEquals(1305.0, hum.getPrice(), 0.0);
    	hum.setHumidity(25);
    	assertEquals(1325.0, hum.getPrice(), 0.0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testIllegalParameters() throws IllegalArgumentException {
    	Location loc = new Location("WV16Morgantown", 25.0);
    	HumidityUnit hum = new HumidityUnit(16, 16, 8, 2, loc, "1-2");
    }

}
