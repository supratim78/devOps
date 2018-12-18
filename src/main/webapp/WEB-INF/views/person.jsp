<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
	<form:form modelAttribute = "person" action = "/addperson" method= "post">
		<div>
			<div>
				<p>First Name</p>
			</div>
			<div>
				<form:input path = "firstName"/>
			</div>
			<div>
				<p>Last Name</p>
			</div>
			<div>
				<form:input path = "lastName"/>
			</div>
			<div>
				<input type = "submit" value = "Save Changes"/>
			</div>
			
		</div>
	</form:form>
</body>
</html>