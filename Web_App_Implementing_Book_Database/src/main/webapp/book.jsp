<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book DB</title>
</head>
<body>

	<%
            Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root", "Hemanth@1234");
            Statement st=con.createStatement();
            String str="select * from bookdb.books";
            ResultSet rs=st.executeQuery(str);
 out.println("<table border='2'><tr><th>ISBN Number</th><th>Book Name</th> <th>Author </th><th>Price</th></tr>");
while(rs.next()){  
out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+ rs.getString(3)+"</td><td>"+rs.getInt(4)+"</td></tr>");
            }
            out.println("</table><br><br>");
            out.println("<form action='Search'>");
            out.println("ISBN Number:"+""+"<input type='search' name='search'><br><br><br>");
            out.println("<input type='submit' value='Search'");
        %>

</body>
</html>