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
<p align="center">
Adicione uma tarefa
</p>
<p align = "center"> <jsp:include page="adiciona.jsp"></jsp:include> </p> <br>
<p align="center">
Edite uma tarefa
</p>
<jsp:include page="edita.jsp"></jsp:include> <br>
<p align="center">
Remova uma tarefa
</p>
<jsp:include page="remove.jsp"></jsp:include> <br>
<p align="center">
Veja a sua lista
</p>
Escolha o seu filtro
<jsp:include page="lista.jsp"></jsp:include><br>
<jsp:include page="listaa.jsp"></jsp:include> 

</body>
</html>