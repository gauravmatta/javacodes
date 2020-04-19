<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to our Social Network</title>
</head>
<body>
<h1>Login</h1>
<s:form action="login">
	<s:textfield key="user.userName" label="User Name"></s:textfield>
	<s:password key="user.password" label="Password"></s:password>
	<s:submit/>
</s:form>

<form action="/SocialNetwork/register.jsp">
	<input type="submit" value="Register">
</form>
</body>
</html>