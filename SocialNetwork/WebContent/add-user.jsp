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
Welcome to our Social Network
<s:form action="insert-user">
	<s:textfield key="user.userName" label="User Name"></s:textfield>
	<s:textfield key="user.password" label="Password"></s:textfield>
	<s:submit/>
</s:form>
</body>
</html>