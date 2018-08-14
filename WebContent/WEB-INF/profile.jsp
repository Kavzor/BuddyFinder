<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>Insert title here</title>
</head>
<body>

	welcome to your profile page
	
	<form method="POST" action="logout">
		<!-- hidden spring security field required https://stackoverflow.com/questions/30487576/error-404-on-spring-logout?rq=1 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
		<button type="Submit">Logout</button>
	</form>
	

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/library/http.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/cookie.js"></script>
</body>
</html>