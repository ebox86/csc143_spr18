package JavaWord;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ParagraphTest {

    /**
     * Default constructor for test class ParagraphTest
     */
    public ParagraphTest() {
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
    public void constructorAndMethodTest() {
    	Paragraph p = new Paragraph("Test");
    	assertEquals(p.getContent(), "Test");
    	Paragraph p2 = new Paragraph("Test2", Paragraph.ParaStyle.Heading_1);
    	assertEquals(p2.getStyle(), Paragraph.ParaStyle.Heading_1);
    }
    
}
