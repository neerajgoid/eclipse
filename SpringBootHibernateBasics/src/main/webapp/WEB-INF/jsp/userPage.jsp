<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Information</title>

<style>
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
</style>
</head>
<body>

<h2>${success}</h2>
<h1>${error}</h1>

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
</body>
</html>