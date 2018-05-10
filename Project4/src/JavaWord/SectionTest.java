package JavaWord;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SectionTest {

    /**
     * Default constructor for test class SectionTest
     */
    public SectionTest() {
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
    public void constructorTest() {
    	Section s = new Section();
    	assertEquals(s.getParagraphCount(), 0);
    }
    
    @Test
    public void testAddParagraoh() {
    	Section s = new Section();
    	s.addParagraph(new Paragraph("This is a test"));
    	assertEquals(s.getParagraphCount(), 1);
    }
    
}
