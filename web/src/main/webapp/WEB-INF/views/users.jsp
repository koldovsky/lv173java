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
<link href="resources/css/lib/dataTables/jquery.dataTables.css"
	rel="stylesheet">
<script src="resources/js/users.js"></script>
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
				</tr>
			</thead>
		</table>
	</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
	<!-- jQuery dataTables -->
	<script src="resources/js/lib/jquery/jquery.dataTables.js"></script>
	<!-- users.js -->
</body>
</html>