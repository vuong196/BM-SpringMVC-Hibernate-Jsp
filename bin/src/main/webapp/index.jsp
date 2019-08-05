<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Management</title>
<link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" />"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="container" style="text-align: -webkit-center;">
		<div>
			<div>
			<h2>BOOK MANAGEMENT</h2>
			<hr />
			<div >
			
				<div class="panel-body">
					<div class="btn-group" role="group" aria-label="Basic example">
					  <a class="btn btn-primary" href="book/list" role="button">Book</a>
					  <a class="btn btn-primary" href="category/list" role="button">Category</a>
					  <a class="btn btn-primary" href="author/list" role="button">Author</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>