package drawingApp;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CanvasTest {

    /**
     * Default constructor for test class CanvasTest
     */
    public CanvasTest() {
    }

    /**
     * Sets up the test fixture; called before every test case method
     */
    @Before
    public void setUp() {
    }

    /**
     * Tears down the test fixture; called after every test case method
     */
    @After
    public void tearDown() {
    }
    
    @Test
    public void testConstructor() {
    	String[] a = new String[2];
    	a[0] = "width";
    	a[1] = "150";
    	Canvas c = new Canvas();
    	c.addField(a);
    	assertEquals(150, c.getWidth(), 0);
    }

}
