<%@ include file="common/header.jspf" %>
	
		<%@ include file="common/navigation.jspf" %>

			
		<div class="container">
			<h1><font color="green">Hello &nbsp; ${userId} </font></h1><br/>
			<div>
				<table class="table table-striped">
					<caption>
						<spring:message code="todo.caption" />
					</caption>
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
									<a type="button" class="btn btn-success" href="/TodoApp_SpringMVC/updateTodo?id=${todo.id}">Update</a> &nbsp;
									<a type="button" class="btn btn-warning" href="/TodoApp_SpringMVC/deleteTodo?id=${todo.id}">Delete</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
			   </div><br/>
			<div>
				<a class="btn btn-success" href="/TodoApp_SpringMVC/addTodo">Add</a>
			</div>
<%@ include file="common/footer.jspf" %>