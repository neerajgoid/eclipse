<%@ page contentType = "text/html; charset = UTF-8" %>
<%@ page isELIgnored="false" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>${msg}</h2>

 <!--provide an html table start tag -->
   <table border="1" align="center">
    <tr bgcolor="green">
     <th>Customer Id</th>
     <th>Customer Name</th>  
      </tr>
   <!-- iterate over the collection using forEach loop -->
   <c:forEach var="user" items="${CustomerList}">
       <!-- create an html table row -->
      
       <tr bgcolor="cyan">
       <!-- create cells of row -->
       <td>${user.id}</td>
       <td>${user.name}</td>
       <!-- close row -->
       </tr>
       <!-- close the loop -->
   </c:forEach>
   <!-- close table -->
   </table>


</body>
</html>
