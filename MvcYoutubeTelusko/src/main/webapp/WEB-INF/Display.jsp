<%@ page contentType = "text/html; charset = UTF-8" %>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.SQLException"%>

<h2 align="center"><font><strong>Retrieve data from database in </strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="#A52A2A">
<td><b>id</b></td>
<td><b>Name</b></td>
<td><b>Category</b></td>

</tr>


<%
Connection con = null;
Statement statement = null;
ResultSet rs = null;
	String url = "jdbc:mysql://localhost:3306/neeraj";
	String user = "root";
	String password = "root";
	Class.forName("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection(url, user, password);
	
	String query = "select * from products order by category,name"; // how come no semicolon needed?

	statement = con.createStatement();
	rs = statement.executeQuery(query);
	System.out.println("Product Id	Name	\tCategory");
	while (rs.next()) {
		%>
		<tr bgcolor="#DEB887">

<td><%=rs.getInt(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>

</tr>
		<% 
	//	System.out.println("\t" + rs.getInt(1) + "\t" + rs.getString(2) + "\t\t" + rs.getString(3));
	}

	rs.close();
	statement.close();
	con.close();

 %>
   
</table>
 
<html>
   <head>
      <title>Hello World</title>
   </head>
   
   <body>
      <h2>${message}</h2>
   </body>
</html>