<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>List of users</title>
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/css/users.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/lib/dataTables/jquery.dataTables-1.10.11.min.css"
	rel="stylesheet">
<!-- users.js -->
<script
	src="${pageContext.request.contextPath}/resources/js/orderList.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/lib/moment/moment-2.11.2.min.js"></script>
</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div class="page">
		<h2 class="text-center">Order statistics</h2>
		<table id="table" class="display">
			<thead>
				<tr>
					<th class="createdDate">Created Date</th>
					<sec:authorize access="hasRole('ROLE_REDADMIN')">
						<th class="firstName">First Name</th>
						<th class="lastName">Last Name</th>
						<th class="email">User e-mail</th>
					</sec:authorize>
					<th class="country">Country</th>
					<th class="locality">City</th>
					<th class="additional">Address</th>
					<sec:authorize access="hasRole('ROLE_USER')">
						<th class="agency">Company</th>
					</sec:authorize>
					<th class="status">Status</th>
					<th class="progress">Progress</th>
				</tr>
			</thead>
		</table>
	</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
	<!-- jQuery dataTables -->
	<script src="resources/js/lib/jquery/jquery.dataTables-1.10.11.min.js"></script>
</body>
</html>