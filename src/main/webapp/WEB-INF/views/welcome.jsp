<%@ page import="java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome to my website mohanshenoy.com</title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<div class="container">
		<body>
			<h1><font color="green">Welcome &nbsp; ${userId}. You are now authenticated</font></h1><br/>
			<a href="/listTodos">Click here</a> to start maintaining your todo's.
		</body>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</html>
