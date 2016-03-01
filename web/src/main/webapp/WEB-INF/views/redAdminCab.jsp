<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/adminregister.css">
<title>Order creation</title>
<script>
	var ctp = '${pageContext.request.contextPath}';
</script>


</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div class="col-lg-12">
		<div class="container">
			<h1>REDAdmin work place</h1>
			<div class="indexrow">
				<div class="col-lg-4">
				<h2>New order creation</h2>
					<div class="dropdown">
						<button class="btn btn-primary dropdown-toggle" type="button"
							data-toggle="dropdown">
							Create new order
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/customer">Create new order for new user</a></li>
							<li><a href="${pageContext.request.contextPath}/chooseuserfororder">Create new order for existing user</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4">
					<h2>View users</h2>
					<a href="${pageContext.request.contextPath}/users" class="btn btn-primary">View the users</a>
				</div>

			</div>

		</div>
	</div>
	<!-- container -->
	<div class="navbar navbar-fixed-bottom">
		<jsp:include page="utils/footer.jsp"></jsp:include>
	</div>
</body>
</html>
