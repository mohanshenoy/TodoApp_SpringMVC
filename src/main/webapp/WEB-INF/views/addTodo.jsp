<%@ page import="java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<h1><font color="green">Hello &nbsp; ${userId} </font></h1><br/>
			<form:form method="POST" commandName="todo">
				<form:hidden path="id"/>

				<fieldset class="form-group">
					<form:label path="description">Description</form:label> 
					<form:input path="description" type="text" class="form-control" required="required" />
					<form:errors path="description" cssClass="text-warning" />
				</fieldset>

				<fieldset class="form-group">
					<form:label path="targetDate">Target Date</form:label> 
					<form:input path="targetDate" type="text" class="form-control" required="required" />
					<form:errors path="targetDate" cssClass="text-warning" />
				</fieldset>
				
				<input class="btn btn-success" type="submit" value="Submit" />
			</form:form>
			<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
			<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		</div>
	</body>
</html>