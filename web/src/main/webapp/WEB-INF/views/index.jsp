<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>REDplatform Home Page</title>
<!-- Custom CSS -->
<link href="resources/css/index.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
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
				<h2 class="text-center">
					Our service was created for <b class="red">BUSINESS</b> and <b
						class="red">CUSTOMERS</b>
				</h2>
				<br> <br> <img src="http://i68.tinypic.com/1498etj.jpg"
					width="100%" alt="image"></img> <br> <br> <br>
				<div class="text-description">
					<p>
						Our service helps communicate customer with companies more quickly
						and easier. <br>
					</p>
				</div>
			</div>
		</div>

		<jsp:include page="utils/footer.jsp"></jsp:include>
	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="resources/jquery-2.2.0.min.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- index.js -->
	<script src="resources/js/index.js"></script>
</body>
</html>