<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@include file="staticJsp/bootstrap-css.jsp"%>
	<div class="container">
		<%@include file="staticJsp/navbar/navbar_login.jsp"%>
		<div class="text-center">
			<h2>Add yourself to this committee, that don't let you forget your things.</h2>
		</div>
		<form action="signIn" method="post">
			<div class="mb-3">
				<label for="username" class="form-label">Name</label> <input
					required type="text" class="form-control" name="username"
					id="username">
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> <input
					required type="password" class="form-control" name="password"
					id="password">
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-primary">Sign in</button>
			</div>
		</form>
		<br>
		<h6 class="text-center">*After success sign In, you will be redirected to login page.</h6>
	</div>
</body>
</html>