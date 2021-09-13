package testing;

public class login_test_class {
	
	String user_name ="karmagrg";
	String pass= "karma123";
	
	public boolean userLogin(String username, String password) {
		boolean result = false;
		
		if(username == user_name && password == pass) {
			result = true;			
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
