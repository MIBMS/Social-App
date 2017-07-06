<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"type="text/css"href="<c:url value="/resources/css/screen.css" />" >
</head>
<body>
	<h1>Register</h1>
	<form:form method="POST" commandName = "register-user" action = "register">
		<form:label path="userID">ID:</form:label>
		<form:input path="userID" />
		<br/>
		<form:label path="firstName">First name:</form:label>
		<form:input path="firstName" />
		<br/>
		<form:label path="lastName">Last name:</form:label>
		<form:input path="lastName" />
		<br/>
		<form:label path="username">Username:</form:label>
		<form:input path="username" />
		<br/>
		<form:label path="password">Password:</form:label>
		<form:input path="password" />
		<br/>
		<input type="submit" value="Register" />
	</form:form>
</body>
</html>