<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*" %>
<%@page import="org.dinesh.pabbi.UserModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<UserModel> a = (ArrayList<UserModel>) request.getAttribute("employees");
	%>
	<table border=1>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Salary</th>
			<th>Edit </th>
			<th>Delete </th>
		</tr>
		<%	for(int i=0;i<a.size();i++){ %>
			<tr>
				<td><%= a.get(i).getId() %></td>
				<td><%= a.get(i).getName() %></td>
				<td><%= a.get(i).getEmail() %></td>
				<td><%= a.get(i).getSalary() %></td>
				<td> <a href="EditCRUD?id=<%= a.get(i).getId() %>">Edit</a></td>
				<td> <a href="DeleteCRUD?id=<%= a.get(i).getId() %>">Delete</a></td>
			</tr>
		<% } %>
	</table>
	<br>
	<a href="Logout">LogOut</a>
</body>
</html>