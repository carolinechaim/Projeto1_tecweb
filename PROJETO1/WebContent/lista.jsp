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

<form action="lista" method = 'Post'>

	Tag=<select type ="text" name="tag">
  <option value="Todos">todos</option>
  <option value="Insper">Insper</option>
  <option value="Lazer">Lazer</option>
  <option value="Familia">Familia</option>
  <option value="Entidade">Entidade</option>
</select>
	<input type = 'submit' value = 'Submit'>
</form>

<table border = '1'>
<% DAO dao = new DAO();
	List<Tasks> tasks = dao.getLista();
	for (Tasks task : tasks) { %>
	<tr>
		<td><%=task.getId()%></td>
		<td><%=task.getData().getTime()%></td>
		<td><%=task.getUsuario()%></td>
		<td><%=task.getTarefa()%></td>
		<td><%=task.getTag()%></td>
	</tr>
<% } %>
		
</table>
</body>
</html>