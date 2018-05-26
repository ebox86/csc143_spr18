package drawingApp;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the shape class
 * @author evankoh
 * @version csc143
 */
public class ShapeTest {

    /**
     * Default constructor for test class ShapeTest
     */
    public ShapeTest() {
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
    
    /**
     * Test the shape constructor
     */
    @Test
    public void testConstructor() {
    	Shape s = new Shape("line");
    	assertEquals("line", s.getName());
    }

    @Test
    public void testAddPoints() {
        Shape square = new Shape("square");
        square.addPoint(new Point(0, 0));
        square.addPoint(new Point(100, 0));
        square.addPoint(new Point(100, 100));
        square.addPoint(new Point(0, 100));
        assertEquals(4, square.getPoints().size());
    }
    
    @Test
    public void testRotate() {
        Shape square = new Shape("line");
        square.addPoint(new Point(0, 0));
        square.addPoint(new Point(100, 0));
        square.rotate(90);
        assertEquals(new Point(100.0, 0.0).getX(), square.getPoints().get(0).getX(), 0.0);
    }
}
