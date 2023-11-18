<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${jobs}" var="job">
		<h3 style="display: inline; font-style: oblique; font-size: 19px;">${job.jobName}</h3>
		<br />
		${job.messageBody} <br />
		<i>${job.posterName}</i>
		<small>${job.contactPhone}</small>
		
		<br />
		<br />
		

	</c:forEach>
</body>
</html>