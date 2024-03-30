<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String myname = (String) session.getAttribute("name_key");
String email = (String) session.getAttribute("email_key");
%>
<h3>Welcome: <%= myname %></h3>
<h2>Your are registered with us with email <%= email %></h2>
</body>
</html>