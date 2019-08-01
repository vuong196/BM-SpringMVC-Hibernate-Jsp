<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Author - Book MANAGEMENT</title>
<link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" />"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"></script>

</head>
<body>

		<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<div>
			<h2>Edit Author</h2>
			<hr />
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Edit Author Form</div>
				</div>
				<div class="panel-body">
					<form:form action="save" cssClass="form-horizontal"
						method="post" modelAttribute="author">
						<form:hidden path="authorId"/>
						<div class="form-group">
							<label for="authorName" class="col-md-3 control-label">Author Name</label>
							<div class="col-md-5">
								<form:input path="authorName" cssClass="form-control" required="true"/>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-offset-3 col-md-9">
								<form:button cssClass="btn btn-primary">Submit</form:button>
								<input type="button" value="Cancel" onclick="javascript:history.back()"/>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>