<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>REDplatform Home Page</title>
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/css/index.css" rel="stylesheet">

</head>
<body>
	<jsp:include page="../utils/navbar.jsp"></jsp:include>
	<!-- Page Content -->
	<div class="container">
		<h1 class="text-center" id="motto">We use technology to make your life easier</h1>
		<div class="row">
			<div class="col-lg-12">
				<div class="container">
					<div class="row">
						<div class="indexrow">
						<div class="col-md-3">
						 		<h2 class="red">REDplatform</h2>
						 	<p class="text-description">
						 			Real Estate Development Platform is software service. This service is developed for Real Estate companies and their customers. 
						 	</p>
						</div>
						<div class="col-md-3">
						 		<h2 class="red">For Business</h2>
						 		<p class="text-description">Create new orders. Control all customer and payments online. Maintain your business.</p>
						</div>
						<div class="col-md-3">
						 		<h2  class="red">For Customers</h2>
						 		<p class="text-description">Approve your payments online. Organize your life.</p>
						</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../utils/footer.jsp"></jsp:include>
	</div>
	<!-- /.container -->

	<!-- index.js -->
	<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
</body>
</html>