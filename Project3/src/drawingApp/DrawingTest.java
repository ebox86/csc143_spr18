package drawingApp;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests the Drawing class
 * @author evankoh
 * @version csc143
 *
 */
public class DrawingTest {

	/**
	 * Default constructor for test class DrawingTest
	 */
	public DrawingTest() {
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
	 * tests the constructor for Drawing
	 * @throws FileNotFoundException
	 */
	@Test(expected = FileNotFoundException.class)
	public void testConstructor() throws FileNotFoundException {
		Drawing d = new Drawing(new ShapeLibrary(), new File("instruction"));
	}
	
	@Test
	public void testMethods() {
		Drawing drawing1 = null;
    	Path folderPath = Paths.get(".");
    	String path = folderPath.toAbsolutePath().toString() + "/src/";
        ShapeLibrary shapeLib  = new ShapeLibrary();
        try {
			drawing1 = new Drawing(shapeLib, new File(path + "Instruct-Simple.txt"));
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        drawing1.draw();
	}
	
}
