<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student" >
	First name: <form:input path="firstName"/>
	Last name: <form:input path="lastName"/>
	<br><br>
	<form:select path="country">
	<!--  <form:option value="Germany" label="Germany"></form:option> -->
		<form:options items="${student.countryOptions}"></form:options>
	</form:select>
	<br><br>
	Favorite Languages:
	Java <form:radiobutton path="favoriteLanguage" value="Java"/>
	C# <form:radiobutton path="favoriteLanguage" value="C#"/>
	PHP <form:radiobutton path="favoriteLanguage" value="PHP"/>
	Ruby <form:radiobutton path="favoriteLanguage" value="Ruby"/>
	<br><br>
	Operating Systems: 
	Windows <form:checkbox path="operatingSystems" value="Windows"/>
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	MAC-OS <form:checkbox path="operatingSystems" value="MAC-OS"/>
<input type="submit" value="Submit"/>

</form:form>
</body>

</html>