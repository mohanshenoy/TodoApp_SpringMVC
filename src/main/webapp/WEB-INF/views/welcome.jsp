<%@ include file="common/header.jspf" %>
	
		<%@ include file="common/navigation.jspf" %>
	<div class="container">
		<body>
			<h1><font color="green">Welcome &nbsp; ${userId}. You are now authenticated</font></h1><br/>
			<a href="/TodoApp_SpringMVC/listTodos">Click here</a> to start maintaining your todo's.
		</body>
	</div>
<%@ include file="common/footer.jspf" %>