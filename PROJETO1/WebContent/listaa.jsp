<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*,br.edu.insper.mvc.model.*"%>
<table border='1'>
<% DAO dao =new DAO();
List<Tasks> tasks = dao.getLista();
for(Tasks task : tasks ){%>
<tr>
<td><%=task.getId()%></td>
<td><%=task.getUsuario()%></td>
<td><%=task.getTag()%></td>
<td><%=task.getTarefa()%></td>
</tr>
<% } %>
</table>

</body>
</html>