package billing_system;


import java.sql.*;

public class database_connector {
	Connection con;
	Statement st;
	int ans;
	private ResultSet rows;

/////////////////////////////////////////////// CONNECTING THE DATABASE /////////////////////////////////////////
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	

///////////////////////////////////////////// INSERTING QUERY ////////////////////////////////////////////////////
	public int insert(String query) {	
		try {
			ans = st.executeUpdate(query);
			}catch (SQLException throwables) {
				throwables.printStackTrace();
				}
		return ans;
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
/////////////////////////////////////////////// SELECTING QUERY /////////////////////////////////////////////////////	
	public ResultSet select(String query) {
		try {
			rows = st.executeQuery(query);
		}
		catch(SQLException throwables) {
			throwables.printStackTrace();
		}
		return rows;
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {
		new database_connector();
		}
	
	

}