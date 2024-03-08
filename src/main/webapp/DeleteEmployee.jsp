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
   width: 300px;
   border-radius : 20px;
  }
  
  .button {
    border : none;
    background-color: green;
    color: white;
    font-weight: bold;
  }
</style>
</head>
<body>
  
  
    <table widht="80%" align="center" border="0">
      <tr><td>Employee Id</td><td>
       <form action="EMSController" method="post">
        <select name="eid">
          <%
             List<Integer> idList = (List<Integer>) request.getAttribute("IdList");
             for(Integer i : idList) {
            	out.println("<option value='"+i+"'>"+i+"</option>"); 
             }
          %>
        </select>
       </td></tr>
        
      <tr><td colspan="2" align="center"><input class="button" type="submit" value="Delete Employee" name="emsAction"/><td></tr>
    </form>
    </table>
    
    
    <br>
    <%
      String result = (String)request.getAttribute("msg");
      if(result != null ){
    	 out.println("<center><font color=green><b>"+result+"</b></font></center>") ;
      }
    %>
    
</body>
</html>