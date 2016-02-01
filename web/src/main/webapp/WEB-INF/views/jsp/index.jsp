<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>REDplatform Home Page</title>

<!-- Bootstrap Core CSS -->
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="resources/css/indexCss.css" rel="stylesheet">


</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/REDplatform/">
				<div class="indexHeader">
					<b class="red">RED</b>platform
				</div>
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="/REDplatform/">Home page</a></li>
				<li><a href="#">Contact</a></li>
				<li><a href="#">Login</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

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
                    <p>Time is money<p>
                </div>
            </div>
            <div class="item">
                <!-- Set the third background image using inline CSS below. -->
				<div class="image3"></div>
                <div class="carousel-text">
                    <p>You are in safe hands<p>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>

    </header>

	
				<br>
			<br>
    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12">
			<br>
			<br>
			<br>
			<br>
                <h1 class="text-center">We use technology to make your life easier</h1>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
				
               
			   <h2 class="text-center">Our service was created for <b class="red">BUSINESS</b> and <b class="red">CUSTOMERS</b></h2>
			<br> 
<br>			
			
			   <img src="http://i68.tinypic.com/1498etj.jpg"  width="100%" alt="image"></img>
			   <br> 
			   <br>
			   <br>
			   <div class="text-description">
			   <p>
					Our service helps cummunicate customer with companies more quickly and easier.
					<br>
					
					
			   </p>
			   </div>
            </div>
			 
        </div>
        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p class="text-center">Copyright &copy; REDplatform 2016</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

	<!-- jQuery -->
	<script src="resources/jquery-2.2.0.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>

	<!-- Script to Activate the Carousel -->
	<script>
		$('.carousel').carousel({
			interval : 5000
		//changes the speed
		})
	</script>

</body>

</html>
