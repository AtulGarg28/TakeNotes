<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>index</title>
</head>
<body>
	<%@include file="staticJsp/bootstrap-css.jsp"%>
	<div class="container">
	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	if (session.getAttribute("user") == null) {
		response.sendRedirect("login.jsp");
	%>
		
		<%@include file="staticJsp/navbar/navbar_login.jsp"%>
	<%
		}else{
	%>
		<%@include file="staticJsp/navbar/navbar_logout.jsp"%>
	<%
		}
	%>
	
		Hello <br>
		Index called
	</div>
</body>
</html>