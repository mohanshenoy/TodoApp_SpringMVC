<%@ page import="java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome to my website mohanshenoy.com</title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
			<div class="container">
				<h1>Login here </h1>
				<form action="/TodoApp_SpringMVC/login" method="POST">
					<p><font color="red">${errorMessage}</font></p>
					Enter your name : &nbsp; <input type="text" name="userId" value="mohan">&nbsp; 
					Enter your password : &nbsp; <input type="password" name="password" value="password">&nbsp; 
					<input type="Submit" value="login">
				</form>
			</div>
			<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
			<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>	
	</body>
</html>