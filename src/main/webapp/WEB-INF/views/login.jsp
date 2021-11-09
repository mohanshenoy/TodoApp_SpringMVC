<%@ include file="common/header.jspf" %>
	
		<%@ include file="common/navigation.jspf" %>
		
			<div class="container">
				<h1>Login here </h1>
				<form action="/TodoApp_SpringMVC/login" method="POST">
					<p><font color="red">${errorMessage}</font></p>
					Enter your name : &nbsp; <input type="text" name="userId" value="mohan">&nbsp; 
					Enter your password : &nbsp; <input type="password" name="password" value="password">&nbsp; 
					<input type="Submit" value="login">
				</form>
			</div>
<%@ include file="common/footer.jspf" %>