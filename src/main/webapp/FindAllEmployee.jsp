<%@page import="com.ems.bean.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
  td {
   height : 40px;
  }
  
  select, input {
   height : 40px;
   width: 220px;
   border-radius : 20px;
  }
  
  .button {
    border : none;
    background-color: green;
    color: white;
    font-weight: bold;
  }
</style>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
   <%
      List<Employee> empList = (List<Employee>) request.getAttribute("EmpList");
      out.println("<table width='60%' align='center'>");
      out.println("<tr><th>E-Id</th><th>E-Name</th><th>E-Salary</th>");
      
      for(Employee e : empList) {
    	  out.println("<tr>");
    	  out.println("<form action='EMSController' method='post'>");
    	  out.println("<td><input type='text' value='"+e.getEid()+"' name='eid' readonly='readonly'/></td>");
    	  out.println("<td><input type='text' value='"+e.getEname()+"' name='ename' /></td>");
    	  out.println("<td><input type='text' value='"+e.getEsalary()+"' name='esalary' /></td>");
    	  out.println("<td><input type='submit' value='Edit/Save' class='btn btn-primary' name='emsAction'/></td>");
    	  out.println("<td><input type='submit' value='Delete' class='btn btn-danger' name='emsAction'/></td>");
    	  out.println("</form>");  
    	  out.println("</tr>");
      }
        
      out.println("<form action='EMSController' method='post'>");
	  out.println("<tr><td><input type='text' name='eid' /></td>");
	  out.println("<td><input type='text' name='ename' /></td>");
	  out.println("<td><input type='text' name='esalary' /></td>");
	  out.println("<td><input type='submit' value='Save' class='btn btn-success' name='emsAction'/></td>");
	  out.println("</tr>");
	  out.println("</form>");
      
      out.println("</table>");
   %>
</body>
</html>