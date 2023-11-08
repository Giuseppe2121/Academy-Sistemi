<%@page import="com.key.SessionKey"%>
<%@page import="com.vo.StudentVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>StudentUpdate</title>
</head>
<%StudentVO studentVO = (StudentVO) session.getAttribute(SessionKey.studentToUpdKey); %>
<body>

	   <form method="post" action="update">
	   
	    <input type="hidden" name="id" value="<%=studentVO.getId()%>"/><br /><br /><br />
		
		<label for="FirstName">FirstName</label>
		<input type="text" name="firstName" value="<%=studentVO.getFirstName()%>"/><br /><br /><br />

		<label for="LastName">LastName</label>
		<input type="text" name="lastName"  value="<%=studentVO.getLastName()%>" /><br /><br /><br />

		<label for="Age">Age</label>
		<input type="text" name="age"  value="<%=studentVO.getAge()%>" /><br /><br /><br />

		<input type="submit" value="Update"/>

		</form>


</body>

</html>