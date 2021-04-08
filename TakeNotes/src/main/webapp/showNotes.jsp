<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.atul.model.Note"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/notes.css" rel="stylesheet">
</head>
<body>
<%@include file="staticJsp/bootstrap-css.jsp"%>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

if (session.getAttribute("user") == null) {
	response.sendRedirect("login.jsp");
}
%>
	<div class="container" >
	<%@include file="staticJsp/navbar/navbar_logout.jsp"%>
		<div class="r">
			<%
			if (session.getAttribute("user") != null) {
				List<Note> list = (List<Note>) session.getAttribute("list");
				for (Note n : list) {
			%>
			
			<div class="noteDiv title">
			<div class="text-center">
			    	<img class="text-center card-img-top m-3 mx-auto" style="max-width: 80px" alt="" src="images/Notes.png">
			</div>
			
			  <div class="r px-4">
			    <h5 class="" ><%=n.getTitle()%></h5>
			    <p class=""><%=n.getContent()%></p>
			    <p class=""><%=n.getDate()%></p>
			    <div class="text-center">
			    	<a href="deleteNote?note_id=<%=n.getNid() %>" class="btn btn-danger">Delete</a>
			    	<a href="updateNote?note_id=<%=n.getNid() %>" class="btn btn-primary">Edit</a>
			    </div>
			  </div>
			</div>
			<%
					}
				}
			%>
		</div>
	</div>

</body>
</html>