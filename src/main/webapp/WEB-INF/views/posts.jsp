<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${postList}" var="post" >
		<li id="post_<c:out value="post.id"/>">
			<div class="postMessage">
				<c:out value="${post.message}" />
			</div>
			<div>
				<span class="postTime">
					<c:out value="${post.time}" />
				</span>
				<span class="postLocation">
					(<c:out value="${post.latitude}" />,<c:out value="${post.longitude}" />)
				</span>
			</div>
		</li>
	</c:forEach>
</body>
</html>