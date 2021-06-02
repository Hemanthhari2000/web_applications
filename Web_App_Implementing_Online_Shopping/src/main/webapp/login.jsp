<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	
	<%!
		String uname;
		String pwd;
	%>
	<%
		uname = request.getParameter("uname");
		pwd = request.getParameter("pwd");
		if (uname != null && pwd != null){
			response.sendRedirect("ShoppingCart");
		}else{
			response.sendRedirect("index.html");
		}
	%>
</body>
</html>