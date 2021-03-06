package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		connectionCheck();
		userCheck();
		
		
	
		
	}
	
	public static void connectionCheck() {
		
		DBConnect dbconnect = new DBConnect(); // Object of the DBConnection Class
		
		try {
			Connection con = dbconnect.connect(); // Calling the connect method of the DBConnection Class
			
			if(con!=null) {
				System.out.println("Connection Successful");
			}
			else {
				System.out.println("Failed to connect to sql db");
			}
			
			
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void userCheck() throws SQLException, ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		DBConnect dbconnect = new DBConnect(); // Object of the DBConnection Class
		System.out.println("Welcome to the Order Management System \n Please enter your choice to order else -1 for sign up");
	//	System.out.println("1. Create");
		int id = scanner.nextInt();
		if(id==-1)
		{
			dbconnect.addUser();
		}
		else {
			dbconnect.checkDbForUser(id);
		}
		
		System.out.println("Order has been successfully placed. Do you want to modify it? 1.Yes 2.No");
		int modifyChoice = scanner.nextInt();
		if(modifyChoice==1)
		{
			updates();
		}
		else
		{
			System.out.println("You have been logged out successfully and order has been created.");
		}
		
	}
	
	public static void updates() throws ClassNotFoundException, SQLException {
		
		DBConnect dbconnect = new DBConnect();
		dbconnect.modifyOrder();
			
	}

}
