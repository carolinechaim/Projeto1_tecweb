<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="edita" method='post'>
ID: <input type='number' name='id'>
	Data=<input type="text" name="data"/>
	Nome=<input type="text" name="usuario"/>
	Tag=<select type ="text" name="tag">
  <option value="Insper">Insper</option>
  <option value="Lazer">Lazer</option>
  <option value="Familia">Familia</option>
  <option value="Entidade">Entidade</option>
</select>
	Tarefa=<input type="text" name="tarefa"/><br>
	
<input type='submit' value='Submit'>
</form>
<body>
</html>
