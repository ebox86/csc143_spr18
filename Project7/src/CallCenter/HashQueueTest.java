package CallCenter;

import static org.junit.Assert.assertEquals;
import java.util.NoSuchElementException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HashQueueTest {

    /**
     * Default constructor for test class HashQueueTest
     */
    public HashQueueTest() {
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
    	HashQueue<?> hq = new HashQueue<Object>();
    	assertEquals(0, hq.size());
    }
    
    @Test
    public void testPush() {
    	HashQueue<Customer> hq = new HashQueue<Customer>();
    	Customer cust1 = new Customer("1", "bob", "smith", "email@example.com", "5555555555");
    	hq.push(cust1);
    	assertEquals(1, hq.size());
    	Customer cust2 = new Customer("1", "bill", "gray", "email@aol.com", "5555555555");
    	hq.push(cust2);
    	assertEquals(2, hq.size());
    	hq.push(cust2);
    	assertEquals(2, hq.size());
    }
    
    @Test
    public void testClear() {
    	HashQueue<Customer> hq = new HashQueue<Customer>();
    	Customer cust1 = new Customer("1", "bob", "smith", "email@example.com", "5555555555");
    	hq.push(cust1);
    	assertEquals(1, hq.size());
    	hq.clear();
    	assertEquals(0, hq.size());
    	}
    
    @Test
    public void testIsEmpty() {
    	HashQueue<Customer> hq = new HashQueue<Customer>();
    	assertEquals(true, hq.isEmpty());
    	Customer cust1 = new Customer("1", "bob", "smith", "email@example.com", "5555555555");
    	hq.push(cust1);
    	assertEquals(false, hq.isEmpty());
    }
    
    @Test
    public void testIterator() {
    	HashQueue<Customer> hq = new HashQueue<Customer>();
    	Customer cust1 = new Customer("1", "bob", "smith", "email@example.com", "5555555555");
    	hq.push(cust1);
    	assertEquals(1, hq.size());
    	while(hq.iterator().hasNext()) {
    		hq.pop();
    	}
    	assertEquals(0, hq.size());
    }
    
    @Test
    public void testPeek() {
    	HashQueue<Customer> hq = new HashQueue<Customer>();
    	Customer cust1 = new Customer("1", "bob", "smith", "email@example.com", "5555555555");
    	hq.push(cust1);
    	Customer tempCust = hq.peek();
    	assertEquals("bob", tempCust.getFirstName());
    }
    
    @Test(expected = NoSuchElementException.class)
    public void testPeekWithEmpty() {
    	HashQueue<Customer> hq = new HashQueue<Customer>();
    	Customer tempCust = hq.peek();
    	assertEquals(null, tempCust.getFirstName());
    }
    
    @Test
    public void testPop() {
    	HashQueue<Customer> hq = new HashQueue<Customer>();
    	Customer c = hq.pop();
    	assertEquals(null, c);
    	Customer cust1 = new Customer("1", "bob", "smith", "email@example.com", "5555555555");
    	hq.push(cust1);
    	hq.pop();
    	assertEquals(0, hq.size());
    	
    }
    
}

