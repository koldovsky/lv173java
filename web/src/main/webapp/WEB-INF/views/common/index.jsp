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
	<!-- Half Page Image Background Carousel Header -->
	<header id="myCarousel" class="carousel slide">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- Wrapper for Slides -->
		<div class="carousel-inner">
			<div class="item active">
				<!-- Set the first background image using inline CSS below. -->
				<div class="image1"></div>
				<div class="carousel-text">
					<p>Your dreams come true</p>
				</div>
			</div>
			<div class="item">
				<!-- Set the second background image using inline CSS below. -->
				<div class="image2"></div>
				<div class="carousel-text">
					<p>Time is money
					<p>
				</div>
			</div>
			<div class="item">
				<!-- Set the third background image using inline CSS below. -->
				<div class="image3"></div>
				<div class="carousel-text">
					<p>You are in safe hands
					<p>
				</div>
			</div>
		</div>
		<!-- Controls -->
		<a class="left carousel-control" href="#myCarousel" data-slide="prev">
			<span class="icon-prev"></span>
		</a> <a class="right carousel-control" href="#myCarousel"
			data-slide="next"> <span class="icon-next"></span>
		</a>
	</header>
	<br>
	<br>
	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<br> <br> <br> <br>
				<h1 class="text-center">We use technology to make your life
					easier</h1>
				<br> <br> <br> <br> <br> <br>
				<div class="container">
					<div class="row">
						<div class="col-lg-4">
						 		<h2>REDplatform</h2>
						 	<p class="text-description">
						 			Real Estate Development Platform is software service. This service is developed for Real Estate companies and their customers. 
						 	</p>
						</div>
						<div class="col-lg-4">
						 		<h2>For Business</h2>
						 		<p class="text-description">Create new orders. Control all customer and payments online. Maintain your business.</p>
						</div>
						<div class="col-lg-4">
						 		<h2>For Customers</h2>
						 		<p class="text-description">Approve your payments online. Organize your life.</p>
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