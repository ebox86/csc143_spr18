package drawingApp;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the ShapeLibrary test
 * @author evankoh
 * @version csc143
 *
 */
public class ShapeLibraryTest {

    /**
     * Default constructor for test class ShapeLibraryTest
     */
    public ShapeLibraryTest() {
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
    	ShapeLibrary sl = new ShapeLibrary();
    	sl.getShapeArray().clear();
    	sl.getShapeArray().add(new Shape("Square"));
    	assertEquals(1, sl.getShapeArray().size());
    }
    
    

}
