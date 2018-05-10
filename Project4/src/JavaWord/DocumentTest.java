package JavaWord;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DocumentTest {

	Document myDoc = Document.getInstance();
	
	/**
	 * Default constructor for test class DocumentTest
	 */
	public DocumentTest() {

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
		myDoc.newDoc("Hippos");
		assertEquals("Hippos", myDoc.getName());
	}
	
	@Test
	public void testClose() {
		myDoc.newDoc("Hippos");
		myDoc.close();
		assertEquals("", myDoc.getName());
	}
	
	@Test
	public void testSaveAndOpen() {
		myDoc.newDoc("Birds");
		myDoc.save();
		myDoc.close();
		myDoc.open("Birds");
		assertEquals("Birds", myDoc.getName());
	}
	
	@Test
	public void testAddParagraph() {
		Section sect1 = new Section();
		sect1.addParagraph(new Paragraph("About birds", Paragraph.ParaStyle.Heading_1));
		sect1.addParagraph(new Paragraph("Birds are cool"));
		myDoc.addSection(sect1);
		myDoc.save();
	}
	
	@Test
	public void testState() {
		myDoc.close();
		assertEquals("", myDoc.getName());
		myDoc.close();
		myDoc.open("Hippos");
		assertEquals("Hippos", myDoc.getName());
		myDoc.open("Birds");
	}
	
}
