<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "s" uri = "/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to our Social Network!</title>
</head>
<body>
	<h1>Login</h1>
	<s:form action="login">
		<s:textfield key="user.userName" label="User Name"/>
		<s:password key = "user.password" label="Password"/>
		<s:submit/>
 	</s:form>
 	<form action="/SocialNetwork/register.jsp">
		<input type="submit" value="Register">
	</form>
</body>
</html>