<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>	
	<jsp:include page="utils/jspheader.jsp" />
	<script>var ctp = '${pageContext.request.contextPath}';</script>
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>List of users</title>
<!-- Custom CSS -->
	<link href="${pageContext.request.contextPath}/resources/css/users.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/resources/css/lib/dataTables/jquery.dataTables-1.10.11.min.css"
	rel="stylesheet">
	<script src="${pageContext.request.contextPath}/resources/js/redirecturl.js"></script>
	<!-- usersfororders.js -->
	<script src="${pageContext.request.contextPath}/resources/js/usersfororders.js"></script>
</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div class="page">
		<h2 class="text-center">List of Users</h2>
			<table id="table" class="display" cellspacing="0" width="90%">
				<thead>
					<tr>
						<th>Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Phone</th>
						<th>Created Date</th>
						<th>Create new order</th>
					</tr>
				</thead>
			</table>
		</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
	<!-- jQuery dataTables -->
	<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.dataTables-1.10.11.min.js"></script>
</body>
</html>