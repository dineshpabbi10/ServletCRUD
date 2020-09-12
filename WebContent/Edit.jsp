<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="org.dinesh.pabbi.UserModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit EMployee Data</title>
</head>
<body>

<% UserModel user = request.getAttribute("user") !=null ? (UserModel) request.getAttribute("user") : null; %>

<% if(user == null){  %>
	No user Found. Click <a href="Success.jsp">Here</a> to go see all records.
<%}else{ %>
<form action="EditCRUD" method="post">

	ID: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="number" name="id" value="<%=user.getId()%>"  min="<%=user.getId()%>" max="<%=user.getId()%>" /> <br>
	Name: <input type="text" name="name" value = "<%=user.getName()%>" /> <br>
	Email: <input type="text" name="email" value = "<%=user.getEmail()%>" /> <br>
	Salary: <input type="number" name="salary" value = "<%=user.getSalary()%>" /> <br>
	<button type="submit">Submit</button>
</form>
<% } %>
</body>
</html>