<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Add Friend</h1>
	<s:form action="addFriend">
		<s:textfield key="name" label="User Name"/>
		<s:submit/>
	</s:form>
<h1>Your Friends:</h1>
<s:iterator value="#session.currentUser.friends" var="user">
<li><s:property value="#user.userName"/></li>
</s:iterator>
</body>
</html>