<%@page import="com.dto.StudentDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrazione Corretta</title>
</head>
<%
StudentDTO studentDTO = (StudentDTO) session.getAttribute("studentDTO");

String lastName = studentDTO.getLastName();
String message = "Registrazione Studente" + lastName + "corretta";
%>

<body>

<%=message %>   <%--serve per stampare il contenuto del message --%>

</body>
</html>
