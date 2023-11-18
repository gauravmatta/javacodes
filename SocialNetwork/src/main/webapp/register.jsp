<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h1>Register</h1>
	<s:form action="register">
		<s:textfield key="user.userName" label="User Name"></s:textfield>
		<s:password key="user.password" label="Password"></s:password>
		<s:submit/>
	</s:form>
</body>
</html>