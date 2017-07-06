<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Social App</title>
<link rel="stylesheet"type="text/css"href="<c:url value="/resources/css/screen.css" />" >
</head>
<body>
	<h1>Welcome to Social App</h1>
	<a href="<c:url value="/posts" />">Posts</a> |
	<a href="<c:url value="/SocialApp/register" />">Register</a></body>
</body>
</html>