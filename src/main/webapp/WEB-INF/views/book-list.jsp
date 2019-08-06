<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Book Management</title>
<link href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />" rel="stylesheet">
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js" />"></script>
<script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>Book Management</h2>
			<hr />
			<input type="button" value="Add Book"
				onclick="window.location.href='add/form'; return false;"
				class="btn btn-primary" />
			<br/><br/>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Book List</div>
				</div>
				<div class="panel-body">
					<table class="table msgtable-striped table-bordered">
						<tr>
						<th>Name</th>
						<th>Author</th>
						<th>Categories</th>
						<th>Action</th>
						</tr>
							<!-- loop over and print authors -->
							<c:forEach var="book" items="${bookList}">
							
								<!-- construct an "update" link with customer id -->
								<c:url var="updateLink" value="/book/update/form">
									<c:param name="id" value="${book.bookId}" />
								</c:url>
	
								<!-- construct an "delete" link with customer id -->
								<c:url var="deleteLink" value="/book/delete">
									<c:param name="id" value="${book.bookId}" />
								</c:url>
								<tr>
									<td>${book.bookName}</td>
									<td>${book.bookAuthor.authorName}</td></html>
									<td>
										<c:forEach items="${book.bookCategorySet}" var="category">
											<h5><span class="label label-default">${category.categoryName}</span></h5>
										</c:forEach>
									</td>
									<td>
									<a href="${updateLink}">Update</a>
									<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this book?'))) return false">Delete</a>
								</td>
								</tr>
							</c:forEach>
					</table>
					<a href="/">Back to Homepage</a>
				</div>
			</div>
		</div>
	</div>
</body>
