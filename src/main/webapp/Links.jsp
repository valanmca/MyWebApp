<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
   a {
      text-decoration: none;
      color: white;
    }
    
    th {
      background-color: green;
      height : 50px;
      font-weight: bold; 
          
    }
</style>

</head>
<body>
<br><br>
   <table width="80%" cellspacing="15" align="center">
     <th><a href="InsertEmployee.jsp" target="content">Insert Employee</a></th>
     <th><a href="EMSController?emsAction=Delete" target="content">Delete Employee</a></th>
     <th><a href="EMSController?emsAction=Update" target="content">Update Employee</a></th>
     <th><a href="EMSController?emsAction=Find" target="content">Find Employee</a></th>
     <th><a href="EMSController?emsAction=Find-All" target="content">Find All Employee</a></th>
   </table>
</body>
</html>