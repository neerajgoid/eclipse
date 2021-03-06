package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnect {

	public Connection connect() throws SQLException, ClassNotFoundException {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/neeraj?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "root";

		con = DriverManager.getConnection(url, user, password);
		return con;

	}

	public void addUser() throws SQLException, ClassNotFoundException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = connect();
			System.out.println("Enter your name");
			Scanner scanner = new Scanner(System.in);
			String name = scanner.nextLine();
			int newId = 0;
			if (con != null) {

				String query = "Select count(*) from customer";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				if (rs.first()) {
					newId = rs.getInt(1);

				}

				String query1 = "Insert into customer values (?,?)";

				ps = con.prepareStatement(query1);
				ps.setInt(1, ++newId);
				ps.setString(2, name);
				ps.executeUpdate();
				System.out.println("ID: " + newId + "is generated for user:" + name);
				
				displayProducts(newId);
				createOrder(newId);

			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		} finally {

			rs.close();
			stmt.close();
			ps.close();
			con.close();
		}

		// show product list

	}

	public void checkDbForUser(int id) throws SQLException {
		Connection con = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		Scanner sc= new Scanner(System.in);
		String query = "Select cust_id from customer where cust_id = ?";
		try {
			con = connect();

			if (con != null) {
				ps = con.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();

				if (rs.first()) {
					System.out.println("User with ID:" + rs.getInt(1) + "is logged into the system");
					System.out.println("************PRODUCT LIST****************");
					displayProducts(rs.getInt(1));
					
					System.out.println("Enter 1. To Create an Order 2. To Review an Order");
					int ch = sc.nextInt();
					if(ch==1)
						createOrder(rs.getInt(1));
					else
						modifyOrder();
				
				} else { // if no record exists
					System.out.println("This ID does not exist in this system. Redirecting to create a new Id");
					addUser();
				}

			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		finally {
			rs.close();
			ps.close();
			con.close();
		}

	}

	public void displayProducts(int id) throws ClassNotFoundException, SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		con = connect();
		if (con != null) {

			String query = "select * from products order by category,name"; // how come no semicolon needed?

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("Product Id	Name	\tCategory");
			while (rs.next()) {
				System.out.println("\t" + rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3));
			}

			rs.close();
			stmt.close();
			con.close();

		}
		
	}

	public void createOrder(int id) throws SQLException, ClassNotFoundException { // creates a simple Orders table

		Scanner sc = new Scanner(System.in);

		Connection con = null;
		
		Statement stmt = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		con = connect();
		int count = 0;
		if (con != null) {
		//	con.setAutoCommit(false);
			String query = "Select count(*) from orders";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			if (rs.first()) {
				count = rs.getInt(1);

				String query1 = "Insert into orders values(?,?)";

				ps = con.prepareStatement(query1);
				ps.setInt(1, ++count);
				ps.setInt(2, id);
				ps.executeUpdate();

				ps.close();
			}

			acceptOrder(count); // passing the order id to orderItem table

		}

		rs.close();
		stmt.close();
		//con.commit();
		con.close();
		
	}

	public void acceptOrder(int orderId) throws SQLException, ClassNotFoundException {
		Scanner sc = new Scanner(System.in);
		int choice = 1;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		con = connect();
		if (con != null) {
			//con.setAutoCommit(false);
			while (choice != 0) {
				System.out.println("********************************");
				System.out.println("Please enter the product Id you want to add in your order or press 0 to exit");
				int productId = sc.nextInt();
				choice = productId;
				
				if (choice == 0)
					break;
				
				System.out.println("Enter the quantity for that product that you want");
				int quantity = sc.nextInt();

				String query = "Select id from orderItem";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);

				if (rs.last()) {
					int count = rs.getInt(1);
					String query1 = "Insert into orderItem values (?,?,?,?)";

					ps = con.prepareStatement(query1);
					ps.setInt(1, ++count);
					ps.setInt(2, orderId);
					ps.setInt(3, productId);
					ps.setInt(4, quantity);

					int affect = ps.executeUpdate();
					System.out.println(affect + " row(s) affected ");
					ps.close();

				}
				else  // first row being inserted
				{
					String query1 = "Insert into orderItem values (?,?,?,?)";

					ps = con.prepareStatement(query1);
					ps.setInt(1, 1);
					ps.setInt(2, orderId);
					ps.setInt(3, productId);
					ps.setInt(4, quantity);

				 ps.executeUpdate();
				//	System.out.println(affect + " row(s) affected ");
					ps.close();
				}
				rs.close();
				stmt.close();
			}
			//con.commit();
			con.close();
		}
		
	}

	public void modifyOrder() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your customer Id");
		int custId = sc.nextInt();

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		con = connect();
		if (con != null) {
			String query = "select orders.order_id,orderItem.product_id,orderItem.quantity from orderItem,orders where orderItem.order_id = orders.order_id and cust_id = "
					+ custId;

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			// displayProducts(custId); // to show the Item Name and Item Id

			System.out.println("Your orders are:");
			while (rs.next()) {

				System.out.println(
						"Order Id :" + rs.getInt(1) + " Item Id: " + rs.getInt(2) + " Quantity : " + rs.getInt(3));
			}

			System.out.println("Please enter the Order Id which you want to modify ");
			int billNo = sc.nextInt();

			System.out
					.println("Please choose if you want to 1.update or 2.delete a product from the order id: " + billNo);
			int choice = sc.nextInt();

			if (choice == 1) {
				updateOrder(custId, billNo);
			} else {
				deleteOrder(custId, billNo);
			}

			rs.close();
			stmt.close();

		}
		con.close();
		//sc.close();
	}

	public void updateOrder(int custId, int orderid) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		con = connect();
		if (con != null) {
			con.setAutoCommit(false);
			String query = "select orderItem.product_id,orderItem.quantity from orderItem,orders where orderItem.order_id = orders.order_id and cust_id ="
					+ custId + " and orders.order_id=" + orderid;
			;
			;

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			displayProducts(custId); //display list of products to user
			System.out.println("Your items for order id:" + orderid + " are");
			while (rs.next()) {

				System.out.println(" Item Id: " + rs.getInt(1) + " Quantity : " + rs.getInt(2));
			}

			System.out.println("Enter the Id no of the Product who's quantity you want to change");
			int prodId = sc.nextInt();

			System.out.println("Enter the new quantity for the product with id: " + prodId);
			int quantity = sc.nextInt();

			String query1 = "update orderItem set quantity = ? where order_id=? and product_id = ?";

			ps = con.prepareStatement(query1);
			ps.setInt(1, quantity);
			ps.setInt(2, orderid);
			ps.setInt(3, prodId);

			int affect = ps.executeUpdate();
			System.out.println(affect + " row(s) affected");

			ps.close();
			rs.close();
			stmt.close();
			//sc.close();
			con.commit();
			con.close();

		}

	}

	public void deleteOrder(int custId, int orderid) throws ClassNotFoundException, SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		con = connect();
		if (con != null) {
			con.setAutoCommit(false);
			String query = "select orderItem.product_id,orderItem.quantity from orderItem,orders where orderItem.order_id = orders.order_id and cust_id ="
					+ custId + " and orders.order_id=" + orderid;

			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			displayProducts(custId);
			System.out.println("Your items for order id:" + orderid + " are");
			
			while (rs.next()) {

				System.out.println(" Item Id: " + rs.getInt(1) + " Quantity : " + rs.getInt(2));
			}

			System.out.println("Enter the Id no of the Product who's quantity you want to delete");
			int prodId = sc.nextInt();

			String query1 = "delete from orderItem where order_id=? and product_id = ?";

			ps = con.prepareStatement(query1);
			// ps.setInt(1, quantity);
			ps.setInt(1, orderid);
			ps.setInt(2, prodId);

			int affect = ps.executeUpdate();
			System.out.println(affect + " row(s) affected");

			ps.close();
			rs.close();
			stmt.close();
		//	sc.close();
			con.commit();
			con.close();

		}

	}

}
