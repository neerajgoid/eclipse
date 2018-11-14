package com.hi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Customer> customerList() throws ClassNotFoundException, SQLException {
		
		List<Customer> custList = new ArrayList<Customer>();
		
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
			String url = "jdbc:mysql://localhost:3306/neeraj";
			String user = "root";
			String password = "root";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
			String query = "select * from customer"; // how come no semicolon needed?

			statement = con.createStatement();
			rs = statement.executeQuery(query);
			//System.out.println("Product Id	Name	\tCategory");
			
			while (rs.next()) {
		//		System.out.println("\t" + rs.getInt(1) + "\t" + rs.getString(2) + "\t\t");
				Customer c = new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				custList.add(c);
				
			}
			
			return custList;
	}

}
