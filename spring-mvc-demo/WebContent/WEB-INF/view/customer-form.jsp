<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Customer Registration Form</title>
<style>
	.error{color: red;}
</style>
</head>
<body>
<h2>Fill out the form. Asterisk (*) means required.</h2>
<br><br>
<form:form action="processForm" modelAttribute="customer">
	First name: <form:input path="firstName"/>
	Last name (*): <form:input path="lastName"/>
	
	<form:errors path="lastName" cssClass="error"></form:errors>
	<br><br>
<input type="submit" value="Submit"/>

</form:form>
</body>

</html>

