package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class register_class_Test extends register_test_class {

	@Test
	// testing class not null
	public void testConstructor() {
		register_test_class rtc = new register_test_class();
		assertNotNull(rtc);
	}
	
	@Test
	// Register inserting test pass
	public void testGetters() {
		register_test_class rt = new register_test_class("karma","karmagrg","karma123",987, "ktm");
		String expected = "karmagrg";
		String actual = rt.getuserName();
		
		assertEquals(expected,actual);
	}
	
	     @Test
	    // Register inserting test fail
		public void testGetters1() {
			register_test_class rt = new register_test_class("karma","karmagrg","karma123",987, "ktm");
			String expected = "nepal";
			String actual = rt.getaddress();
			
			assertEquals(expected,actual);
		}
	
	
}
