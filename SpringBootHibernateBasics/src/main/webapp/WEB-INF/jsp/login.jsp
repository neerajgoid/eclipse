<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-Employee Management System</title>
<style>

* {
    box-sizing: border-box;
    border-color: black;
}

#login 
{
background-color:powderblue;
padding: 10px;
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

form {
 display: inline-block; 
 }
     /* reduces the width of the form to only what is necessary */

h2{
color: red;
}
.inputdata{
width: 110px;
}
</style>


</head>
<body>

<h2>${errorMessage}</h2>

    <form method="post" id="login">
        Name : <input type="text" id="username" name="username" class="inputdata" />
        Password : <input type="password"   id="pwd" name="password" class="inputdata" /> 
        <input type="submit" id="btn" onclick="validate()" />
    </form>
    
<!--      
<script type="text/javascript">
var count=3;


function validate()
{
	alert("count is" + count);
	var name = document.getElementById("username").value;
	var pwd =  document.getElementById("pwd").value;
	//can do that go to window thinge and try
	if(name=="root" && pwd=="root") {
			alert("Success");
	}
	else{
	//	count--;
		if(count==0)
		{
			
			alert("no attempts available");
		    document.getElementById("username").disabled=true;
		    document.getElementById("pwd").disabled=true;
		    document.getElementById("btn").disabled=true;
		}
		else{
			count=count-1;
			alert("counts remaining:" + count);
			
		}
		return false;
		
	}
}
</script>
-->

</body>

</html>

