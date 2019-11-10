<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="wikipage" scope="request" type="wiki.data.Page" />
<html>
<head>
<title>Wiki</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/styles.css" />
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0">
<tr>
<td><img src="<%=request.getContextPath()%>/images/logo.gif"></td>
</tr>
<tr>
<td id="upper-bar">
<div id="upper-menu">
<a href="../edit/${wikipage.name}">edit</a>
|
<%
if (wikipage.isPublished()) {
%>
<a href="../unpublish/${wikipage.name}">unpublish</a>
<%
} else {
%>
<a href="../publish/${wikipage.name}">publish</a>
<%
}
%>
</div>
</td>
</tr>
<tr>
<td id="lower-bar">
<div id="layout">
${wikipage.content}
</div>
</td>
</tr>
</table>
</body>
</html>