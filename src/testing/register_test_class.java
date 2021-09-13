package testing;

public class register_test_class {
private String Name, userName,password,address;
private int contact;
	
	public register_test_class() {
		
	}
	
	
	public register_test_class(String Name,String userName,String password,int contact,String address) {
		this.Name = Name;
		this.userName = userName;
		this.password =password;
		this.contact = contact;
		this.address = address;
		
	}
	
	public void setName (String Name) {
		 this.Name = Name;
	}
	public String Name () {
		return this.Name;
		
	}
	public void setuserName (String userName) {
		this.userName = userName;
	}
	public String getuserName () {
		return this.userName;
	}
	
	public void setpassword (String password) {
		this.password = password;
	}
	public String getpassword() {
		return this.password;
	}
	public void setcontact (int contact) {
		 this.contact = contact;
	}
	public int getcontact () {
		return this.contact;
		
	}
	public void setaddress (String address) {
		 this.address = address;
	}
	public String getaddress () {
		return this.address;
		
	}
	
	


}
