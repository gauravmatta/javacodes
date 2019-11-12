<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<jsp:useBean id="wikipage" scope="request" type="wiki.data.Page" />
<p>
Are you sure you want to unpublish this page?
</p>
<form method="post">
<input type="submit" name="publish-button" value="Unpublish" />
<input type="submit" name="cancel-button" value="Cancel" />
<input type="hidden" name="name" value="${wikipage.name}" />
</form>