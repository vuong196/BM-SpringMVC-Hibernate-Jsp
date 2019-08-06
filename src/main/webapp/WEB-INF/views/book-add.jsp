<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book - Book MANAGEMENT</title>
<link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" />"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<div>
			<h2>Add Book</h2>
			<hr />
			<div class="panel panel-info">

				<div class="panel-heading">
					<div class="panel-title">Add Book Form</div>
				</div>
				<div class="panel-body">

					<form:form action="save" cssClass="form-horizontal" method="post" modelAttribute="book">
						<form:hidden path="bookId"/>
						<div class="form-group">
							<label for="bookName" class="col-md-3 control-label">Name</label>
							<div class="col-md-9">
								<form:input path="bookName" cssClass="form-control" />
							</div>
						</div>

						<div class="form-group">
							<label for="bookCategorySet" class="col-md-3 control-label">Category</label>
							<div class="col-md-9">
								<form:select path="bookCategorySet" multiple="multiple" items="${categoryList}" itemValue="categoryId" itemLabel="categoryName" class="form-control" required="true"/>
							</div>
						</div>

						<div class="form-group">
							<label for="bookAuthor" class="col-md-3 control-label">Author</label>
							<div class="col-md-9">
								<form:select path="bookAuthor" items="${authorList}" itemValue="authorId" itemLabel="authorName" class="form-control"/>
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