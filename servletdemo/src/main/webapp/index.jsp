<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
int a=10;
String name= "Gaurav";
int square() {
	return a*a;
}
%>
<% 
out.println("a :"+a);
out.println("Name :"+name);
out.println(square());
%>
</body>
</html>