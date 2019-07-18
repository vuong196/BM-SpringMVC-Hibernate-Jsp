<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
<title>Author Management</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
 rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>Author Management</h2>
			<hr />
			<input type="button" value="Add Author"
				onclick="window.location.href='showForm'; return false;"
				class="btn btn-primary" />
			<br/><br/>
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Author List</div>
				</div>
				<div class="panel-body">
					<table class="table msgtable-striped table-bordered">
						<tr>
						<th>Name</th>
						<th>Action</th>
						</tr>
							<!-- loop over and print authors -->
							<c:forEach var="author" items="${authorList}">
							
								<!-- construct an "update" link with customer id -->
								<c:url var="updateLink" value="/author/editForm">
									<c:param name="id" value="${author.authorId}" />
								</c:url>
	
								<!-- construct an "delete" link with customer id -->
								<c:url var="deleteLink" value="/author/delete">
									<c:param name="id" value="${author.authorId}" />
								</c:url>
								<tr>
									<td>${author.authorName}</td>
									<td>
									<a href="${updateLink}">Update</a>
									<a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this author?'))) return false">Delete</a>
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