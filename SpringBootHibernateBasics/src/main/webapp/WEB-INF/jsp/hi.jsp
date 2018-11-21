<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>

	<style>
	
	* {
    box-sizing: border-box;
    border-color: black;
}

		form{
			background-color:SandyBrown ;
			display: inline-block; 
			padding: 10px;
		}
		table {
			align-content: center;
			align-self: center;
		}
		
		#btn{
				padding: 8px 16px;
				border-radius: 8px;
				cursor: pointer;
		}
		
		#btn:hover{
					background-color: Navy ;
					color: white;
		}
		
	</style>

</head>

<body>

		 <form method="post">
			
			 <h3>Filters</h3>
		 	
		 	<select name="filters">
		   		<option value="salary">salary</option>
		  		<option value="id">id</option>
			</select>
		
	Mininum: <input type="number" name="minFilterValue" required="required" />
	Maximum: <input type="number" name="maxFilterValue" required="required"/>
		 	 <input type="submit" value="Apply" id="btn" formaction="/filter" />  
		
		 </form>
		 
 <br><br><br>
 
   <table border="1">

	   <tr bgcolor="white">
		     <th>Customer Id</th>
		     <th>Customer First Name</th>
    	     <th>Customer Last Name</th>
			 <th>Salary</th> 
	   </tr>
			
 	 <c:forEach var="user" items="${EmployeeList}">
			       <!-- create an html table row -->
			      
	    <tr bgcolor="SandyBrown">
			       <!-- create cells of row -->
		      <td>${user.id}</td>
		      <td>${user.firstName}</td>
			  <td>${user.lastName}</td>
			  <td>${user.salary}</td>
			       <!-- close row -->
		 </tr>
			       <!-- close the loop -->
			   </c:forEach>
			 
 </table>

 

   
</body>
</html>