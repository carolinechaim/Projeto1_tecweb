<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*,br.edu.insper.mvc.model.*"%>
<%@ page import="java.util.*,br.edu.insper.mvc.controller.*"%>

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

		

</body>
</html>