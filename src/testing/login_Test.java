package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class login_Test {

	@Test
	// login pass test
	void test() {
		String username ="karmagrg";
		String pass = "karma123";
		
		login_test_class ltc = new login_test_class();
		boolean result = ltc.userLogin(username,pass);
		
		assertEquals(true,result);

	}
	
	// login fail test
	void test1() {
		String username ="karmagrg";
		String pass = "karma";
		
		login_test_class ltc = new login_test_class();
		boolean result = ltc.userLogin(username,pass);
		
		assertEquals(true,result);

	}
	
	  
	

}
