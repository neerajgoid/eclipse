<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Administrator</title>

<style>
* {
    box-sizing: border-box;
    border-color: black;
}


/* . for accessing class values*/

.row 
{
/* float: left; */ 
width: 25%;
padding: 10px;
position: fixed;
top: 60px;
left: 220px;

}

.options{
display: block; /* exactly opposite of float:left */
/* background-color: Navy ;
color: white; */ 
padding: 8px 16px;
border-radius: 8px;
cursor: pointer;
}


.options:hover{
background-color: Navy ;
color: white; 

}
.inputdata{
width: 110px;
}

.btn {

padding: 8px 16px;
border-radius: 8px;
}

.btn:hover{
background-color: Navy ;
color: white; 

}


div {
  /* margin: 2px; */
}

h4 {
color: blue;
}

h2 {
color: red
}

h3 {
color: green;
}

#list {
background-color:powderblue;
display: none; 
}
/* # for accessing id values */
#search {
background-color:DodgerBlue ;
display: none; 
}

#add {
background-color:SandyBrown;
 display: none; 
}

#delete {
background-color:GreenYellow;
 display: none; 
}

#update {
background-color:DarkOrchid ;
 display: none; 
}


</style>
</head>


<body>

<h4>${successLogin}</h4>
<h2>${errorInAdd}</h2>
<h3>${successInAdd}</h3>
<h2 >${errorInDelete}</h2>
<h3>${successInDelete}</h3>
<h3>${ successUpdate}</h3>

<input type="button" name="add1" class="options" value="Add Employee" onclick="showDivAdd()" />

<input type="button" name="delete1" class="options" value="Delete Employee" onclick="showDivDelete()" />

<input type="button" name="list1" class="options" value="List of Employees" onclick="showDivDisplay()" />

<input type="button" name="search1" class="options" value="Search for Employee" onclick="showDivSearch()" />

<input type="button" name="update1" class="options" value="Update Employee" onclick="showDivUpdate()" />



<div class="row" id="list">

<form method="post" >
 <input type="submit" value="Employee List" class="btn" formaction="/list">
 <!-- input type ="submit " this is needed to get executed as a button
 formaction - here on click of this button, we get redirected to this URL.
  -->
 
</form>
</div>

<div class="row" id="search" >

	<form method="post">
	        Employee ID : <input type="number" name="id" class="inputdata"  required="required"/>
	 <input type="submit" value="Search for Employee" class="btn" formaction="/user/search">
	 <!-- input type ="submit " this is needed to get executed as a button
	 formaction - here on click of this button, we get redirected to this URL.
	  -->
	 
	</form>

</div>

<div class="row" id="add">

<form method="get" > <!-- sensitive data should be sent using post -->
<!-- can change it to 'post' here and then make changes in EmpController for @RM /user/add to POST  -->
<h2 >${errorInAdd}</h2>
<h3>${successInAdd}</h3>

<table>
       <tr> 
       		<td>Employee Identifier </td>   
       	    <td><input type="number" name="id" min="1" max="100" class="inputdata" /> </td>
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
  <input type="submit" value="Add employee" class="btn" formaction="/user/add"  > 
</form>

</div>

<div class="row" id="delete">

<form method="post" >
<h2 >${errorInDelete}</h2>
<h3>${successInDelete}</h3>

        Employee Id: <input type="number" name="id" required="required" class="inputdata" />
       
         
 <input type="submit" value="Delete employee"  class="btn" formaction="/user/delete" > 
</form>

</div>


<div class="row" id="update" >

	<form method="post">
	        Employee ID : <input type="number" name="id" required="required" class="inputdata"/>
	 <input type="submit" value="Update Employee" class="btn" formaction="/user/update">
	 <!-- input type ="submit " this is needed to get executed as a button
	 formaction - here on click of this button, we get redirected to this URL.
	  -->
	 
	</form>

</div>



<script type="text/javascript">
function showDivAdd() {
   document.getElementById('add').style.display = "block";
   document.getElementById('update').style.display = "none";
   document.getElementById('delete').style.display = "none";
   document.getElementById('list').style.display = "none";
   document.getElementById('search').style.display = "none";

}
function showDivDelete() {
	   document.getElementById('delete').style.display = "block";
	   document.getElementById('update').style.display = "none";
	   document.getElementById('add').style.display = "none";
	   document.getElementById('list').style.display = "none";
	   document.getElementById('search').style.display = "none";
		
	}
function showDivDisplay() {
	   document.getElementById('list').style.display = "block";
	   document.getElementById('update').style.display = "none";
	   document.getElementById('delete').style.display = "none";
	   document.getElementById('add').style.display = "none";
	   document.getElementById('search').style.display = "none";
		
	}	
function showDivSearch() {
	   document.getElementById('search').style.display = "block";
	   document.getElementById('update').style.display = "none";
	   document.getElementById('delete').style.display = "none";
	   document.getElementById('list').style.display = "none";
	   document.getElementById('add').style.display = "none";
	}		
function showDivUpdate() {
	   document.getElementById('update').style.display = "block";
	   document.getElementById('add').style.display = "none";
	   document.getElementById('delete').style.display = "none";
	   document.getElementById('list').style.display = "none";
	   document.getElementById('search').style.display = "none";
	
	}	
	

				
	
	
</script>

</body>
</html>