<%@page import="com.atul.model.Note"%>
<%@page import="com.atul.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/s.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http 1.1
	response.setHeader("Pragma", "no-cache");//Http 1.0
	response.setHeader("Expires", "0");//proxy server

	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	}

	Note note = (Note) session.getAttribute("note");
	%>
	<div class="container">
		<%@include file="staticJsp/navbar/navbar_logout.jsp"%>
		<%@include file="staticJsp/bootstrap-css.jsp"%>
		<div class="text-center">
			<h2>Update your notes here</h2>
		</div>
		<form action="addUpdatedNote" method="post">
			<div class="mb-3">
				<label for="username" class="form-label">Title</label> 
				<input
					required type="text" class="form-control" name="title"
					id="username" value="<%= note.getTitle() %>">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Content</label>
				<textarea required class="form-control content" name="content"><%= note.getContent() %></textarea>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Update</button>
			</div>
		</form>
	</div>
</body>
</html>