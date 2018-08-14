<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>BuddyLogin</title>
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
	<c:if test="${not empty param.error}">
		<label style="color:red">Invalid credentials!</label>
	</c:if>

	<form action="login" method="POST">
		<p>
			<label>Username: </label><input type="text" name="username">
		</p>
		<p>
			<label>Password: </label><input type="text" name="password">
		</p>
		<!-- csrf måste finnas i alla fält som ska gå igenom spring security -->
    	<input type="hidden" id="csrfField" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="Submit">Login</button>
	</form>
	
	<!-- Olika konfigurartioner kan skapa olika context paths, e.g. /BuddyFinder/ -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/library/http.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/client.js"></script>

</body>
</html>