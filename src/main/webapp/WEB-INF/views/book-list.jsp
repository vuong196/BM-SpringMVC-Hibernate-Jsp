<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Book Management</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>Book Management</h2>
			<hr />
			<input type="button" value="Add Book"
				onclick="window.location.href='showForm'; return false;"
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
						<th>Category</th>
						<th>Author</th>
						<th>Action</th>
						</tr>
							<!-- loop over and print Books -->
							<c:forEach var="book" items="${bookList}">
							
								<!-- construct an "update" link with customer id -->
								<c:url var="updateLink" value="/book/editForm">
									<c:param name="id" value="${book.BookId}" />
								</c:url>
	
								<!-- construct an "delete" link with customer id -->
								<c:url var="deleteLink" value="/book/delete">
									<c:param name="id" value="${book.bookId}" />
								</c:url>
								<tr>
									<td>${book.bookName}</td>
									<td>
										<c:forEach var="category" items="${book.bookCategorySet}">
											<label>${category.categoryName}</label>
										</c:forEach>
									</td>
									<td>
										"${book.bookAuthor.authorName}
									</td>
									<td>
									<a href="${updateLink}">Update</a>
									<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this Book?'))) return false">Delete</a>
								</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>