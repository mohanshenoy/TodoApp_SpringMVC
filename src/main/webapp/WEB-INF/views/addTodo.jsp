<%@ include file="common/header.jspf" %>
	
		<%@ include file="common/navigation.jspf" %>
		
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
<%@ include file="common/footer.jspf" %>
<script>
	$('#targetDate').datepicker({
		format : 'dd/mm/yyyy'
	});
</script>