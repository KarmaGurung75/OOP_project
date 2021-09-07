package billing_system;


import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;

public class database_connector {
	Connection con;
	Statement st;
	int ans;
	
	public database_connector() {
		try {
			//Class.forName("con.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/billing_system","root","karma16502@");
			if(con!=null) {
				System.out.println("Database is connect");
			st =con.createStatement();
			}		
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	public int insert(String query) {
		
		try {
			ans = st.executeUpdate(query);
		}catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		return ans;
	}
	public static void main(String[] args) {
		new database_connector();
		}
	
	

}