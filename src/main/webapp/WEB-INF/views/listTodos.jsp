<%@ page import="java.util.Date" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome to my website mohanshenoy.com</title>
		<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
	
	
		<nav role="navigation" class="navbar navbar-default">
			<div class="">
				<a href="#" class="navbar-brand">MyApp</a>
			</div>
			<div class="navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/login">Home</a></li>
					<li><a href="/listTodos">Todos</a></li>
		
				</ul>
			</div>
		</nav>
			
		<div class="container">
			<h1><font color="green">Hello &nbsp; ${userId} </font></h1><br/>
			<div>
				<table class="table table-striped">
					<caption>Your Todos are</caption>
					<thead>
						<tr>
							<th>id</th>
							<th>User</th>
							<th>Description</th>
							<th>Date</th>
							<th>Completed</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${todos}" var="todo">
							<tr>
								<td>${todo.id}</td>
								<td>${todo.user}</td>
								<td>${todo.description}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
								<td>${todo.done}</td>
								<td>
									<a type="button" class="btn btn-success" href="/updateTodo?id=${todo.id}">Update</a> &nbsp;
									<a type="button" class="btn btn-warning" href="/deleteTodo?id=${todo.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
			   </div><br/>
			<div>
				<a class="btn btn-success" href="/addTodo">Add</a>
			</div>
			<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
			<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
       </div>
	</body>
</html>