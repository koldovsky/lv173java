<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>List of users</title>
<!-- Custom CSS -->
<link href="resources/css/users.css" rel="stylesheet">
<link href="resources/css/lib/jquery.dataTables.css"
	rel="stylesheet">
</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div class="page">
		<h2 class="text-center">List of Users</h2>
		<table id="table" class="display" cellspacing="0" width="90%">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Created Date</th>
					<th>Company Name</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.email}</td>
					<td>${item.phone}</td>
					<td>${item.createdDate}</td>
					<td>${item.companyName}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
	<!-- jQuery dataTables -->
	<script src="resources/js/lib/jquery.dataTables.js"></script>
	<!-- users.js -->
	<script src="resources/js/users.js"></script>
</body>
</html>