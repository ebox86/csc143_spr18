package JavaWord;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {

    /**
     * Default constructor for test class DoublyLinkedListTest
     */
    public DoublyLinkedListTest() {
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
    	DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
    	assertEquals(dll.size(), 0);
    }
    
    /**
     * Tests  add at front
     */
    @Test
    public void testAddAtFront() {
    	DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
    	dll.addAtEnd("Hello");
    	dll.addAtEnd("There");
    	dll.addAtEnd("World");
    	assertEquals(dll.size(), 3);
    	dll.iterator();
    	String s1 = "";
    	for(String sa:dll) {
    		s1+= sa;
    	}
    	assertEquals("HelloThereWorld", s1);
    }	
    
    @Test
    public void testAddAtEnd() {
    	DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
    	dll.addAtFront("1");
    	dll.addAtFront("2");
    	dll.addAtFront("3");
    	String s2 = "";
    	for(String sb:dll) {
    		s2+= sb;
    	}
    	assertEquals("321", s2);
    }
    
    @Test
    public void testClear() {
    	DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
    	dll.addAtFront("1");
    	assertEquals(1, dll.size());
    	dll.clear();
    	assertEquals(0, dll.size());
    }
}

