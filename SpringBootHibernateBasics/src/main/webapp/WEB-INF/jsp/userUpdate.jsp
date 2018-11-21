<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Information</title>

<style>

* {
    box-sizing: border-box;
    border-color: black;
}

table {
	align :center;
	border: black solid 1px;
}
h2 {
	color: green
}
h1 {
	color: red
}


#update {
background-color:SandyBrown;
display: none;
width: 25%;
padding: 10px;

}

.btn {

padding: 8px 16px;
border-radius: 8px;
}

.btn:hover{
background-color: Navy ;
color: white; 

}

.inputdata{
width: 110px;
}
</style>
</head>
<body onload="showDivUpdate()">

<h2>${success}</h2> <!-- Employee Found -->
<h1>${error}</h1>
<p> </p>

<table>

<tr>
<th>Employee Id</th>
<th>First Name</th>
<th>Last Name</th>
<th>Salary</th>
</tr>
<tr bgcolor="powderblue">
<td>${EmployeeInfo.id}</td>
<td>${EmployeeInfo.firstName}</td>
<td>${EmployeeInfo.lastName}</td>
<td>${EmployeeInfo.salary}</td>
</tr>

</table>
<br><br>
<!--  
<input type="button" name="update" id="updateButton" class="update" value="Update Employee" onclick="showDivUpdate()" />
-->
<div class="row" id="update">

<form method="get" > <!-- sensitive data should be sent using post -->
<!-- can change it to 'post' here and then make changes in EmpController for @RM /user/add to POST  -->

<table>
       <tr> 
       		<td>Employee Identifier </td>   
       	    <td><input type="number" name="id" min="1" max="100" class="inputdata" value="${EmployeeInfo.id}" readonly="readonly" /> </td>
       	    
        </tr>
        <tr>
      	    <td> FirstName:</td>
        	<td><input type="text" name="fname" required="required" class="inputdata"/></td>
        </tr>
       
         <tr>
       		<td>  LastName: </td> 
        <td><input type="text" name="lname" required="required" class="inputdata"/>  </td>
         </tr>
          <tr>
        <td> Salary:  </td>
        <td><input type="number" name="salary" min="1" max="5000" required="required" class="inputdata"/></td>
          </tr>

 
 </table>
  <input type="submit" value="Update" class="btn" formaction="/user/update"  > 
</form>

</div>

<script type="text/javascript">



function showDivUpdate() {
	var a= ${status};
	if(a==1){
		 document.getElementById('update').style.display = "block";
	}
	else{
		 document.getElementById('updateButton').disabled="true";
	}
	
  
}




</script>


</body>
</html>