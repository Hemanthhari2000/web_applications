<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP Page</title>
</head>
<body>
<%
try {
	serv.AddSer_Service service = new serv.AddSer_Service();
	serv.AddSer port = service.getAddSerPort();
	java.lang.Integer val1 = Integer.parseInt(request.getParameter("val1"));
	java.lang.Integer val2 = Integer.parseInt(request.getParameter("val2"));
	java.lang.Integer result = port.addition(val1, val2);
	out.println("Result = " + result);
} catch (Exception ex) {
	ex.printStackTrace();
}
%>
</body>
</html>