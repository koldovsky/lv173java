<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/adminregister.css">
<title>Order creation</title>
<script src="${pageContext.request.contextPath}/resources/js/cabinet/customer.js"></script>

</head>
<body>
	<jsp:include page="../utils/navbar.jsp"></jsp:include>
	<div class="col-lg-12">
		<div class="container">
			<h1>Customer work place</h1>
			<div class="indexrow">
				<div class="col-lg-4">
				<h2>Customer edit page</h2>
					<a id="edit-customer" class="btn btn-primary">Edit</a>
				</div>
			</div>

		</div>
	</div>
	<!-- container -->
	<div class="navbar navbar-fixed-bottom">
		<jsp:include page="../utils/footer.jsp"></jsp:include>
	</div>
</body>
</html>
