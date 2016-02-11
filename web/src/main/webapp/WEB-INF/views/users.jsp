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
</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div class="page">
		<table id="table" class="display" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Email</th>
					<th>Created Date</th>
				</tr>
			</thead>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.email}</td>
					<td>${item.createdDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
	<!-- jQuery -->
	<script src="resources/jquery-2.2.0.min.js"></script>
	<!-- jQuery dataTables -->
	<script src="resources/jquerydatatables/js/jquery.dataTables.js"></script>
	<!-- users.js -->
	<script src="resources/js/users.js"></script>
</body>
</html>