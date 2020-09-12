<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% if((String) session.getAttribute("email") == null){ System.out.println("Heloo "+session.getAttribute("email")); %>
<form method="post" action="Login">
	<input type="email" placeholder="email" name="email"><br>
	<input type="password" placeholder="password" name="password"><br>
	<button type="submit">Submit</button>
</form>
<% } else { 
	System.out.println("Heloo "+session.getAttribute("email"));
	response.sendRedirect("Login");
	} %>

</body>
</html>