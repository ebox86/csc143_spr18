package drawingApp;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PointTest {

    /**
     * Default constructor for test class PointTest
     */
    public PointTest() {
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
    public void testConstructorandMethods() {
    	Point p = new Point(100, 100);
    	assertEquals(100, p.getX(), 0);
    	assertEquals(100, p.getY(), 0);
    }
    
    @Test
    public void testDistance() {
    	Point p1 = new Point(50, 50);
    	Point p2 = new Point(50, 60);
    	assertEquals(10.0, p1.distance(p2), 0.0);
    }
    
}
