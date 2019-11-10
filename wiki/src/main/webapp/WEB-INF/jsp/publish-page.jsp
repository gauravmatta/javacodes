<jsp:useBean id="wikipage" scope="request" type="wiki.data.Page" />
<p>
Are you sure you want to publish this page?
</p>
<form method="post">
<input type="submit" name="publish-button" value="Publish" />
<input type="submit" name="cancel-button" value="Cancel" />
<input type="hidden" name="name" value="${wikipage.name}" />
</form>