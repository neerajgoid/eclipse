package spring.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	public static Connection connect() throws SQLException
	{
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/neeraj?autoReconnect=true&useSSL=false";
		String username = "root";
		String pwd = "root";
		
		conn = DriverManager.getConnection(url, username, pwd);
		return conn;
	}
	
	public static void retrieveDataFromDb() throws SQLException {
		Connection con = connect();
		if(con!=null) {
			Statement stmt = null;
			ResultSet rs = null;
			
			String query = "Select * from customer";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1) + " Name: " + rs.getString(2));
			}
				
		}
	}
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = connect();
		if(conn==null)	{
			System.out.println("Connection Failed");
			
		}
		else {
			System.out.println("Connection Success");
			retrieveDataFromDb();
		}
			
		
	}
	
}
