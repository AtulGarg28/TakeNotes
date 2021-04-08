<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="css/s.css" rel="stylesheet">
</head>
<body>
	<%@include file="staticJsp/bootstrap-css.jsp"%>
	<div class=" fo container">
		<%@include file="staticJsp/navbar/navbar_login.jsp"%>
		<div class="text-center">
			<h2>Pls Login here to add your private notes</h2>
		</div>
		
		<div class="fo">
			Hello, this is font check in login.jsp
		</div>
		<form action="login" method="post">
			<div class="mb-3">
				<label for="username" class="form-label">Username</label> <input
					required type="text" class="form-control" name="username"
					id="username">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					required type="password" class="form-control" name="password"
					id="password">
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Log in</button>
			</div>
		</form>
	</div>
</body>
</html>