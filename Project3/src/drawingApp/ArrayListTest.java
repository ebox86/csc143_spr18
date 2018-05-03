package drawingApp;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayListTest {

    /**
     * Default constructor for test class ArrayListTest
     */
    public ArrayListTest() {
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
    	ArrayList testAL = new ArrayList<String>();
    	assertEquals(100, testAL.DEFAULT_CAPACITY);
    	testAL.add("test");
    	assertEquals("test", testAL.get(0));
    }

}
