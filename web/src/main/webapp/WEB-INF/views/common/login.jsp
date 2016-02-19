<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<title>Login Form</title>

<!-- CSS -->

<link rel="stylesheet"
	href="resources/css/lib/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/lib/form-elements.css">
<link rel="stylesheet" href="resources/css/lib/style.css">

</head>

<body>

	<!-- Top content -->
	<div class="top-content">

		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2 text">
						<h1>Login</h1>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6 col-sm-offset-3 form-box">
						<div class="form-top">
							<div class="form-top-left">
								<h3>Please Login</h3>
								<p>Enter your email and password to log on:</p>
							</div>
							<div class="form-top-right">
								<i class="fa fa-lock"></i>
							</div>
						</div>
						
						
						<div class="form-bottom">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<div class="error">${error}</div>
							</div>
						</c:if>
							<form role="form" name="loginform"
								action="<c:url value="/j_spring_security_check"></c:url>"
								method="post" class="login-form">
								<div class="form-group">
									<label class="sr-only" for="form-username">Email</label> <input
										type="text" name="email" placeholder="Email..."
										class="form-username form-control" id="form-username">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-password">Password</label> <input
										type="password" name="password" placeholder="Password..."
										class="form-password form-control" id="form-password">
								</div>
								<button type="submit" class="btn">Sign in!</button>
							</form>
							
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


	<!-- Javascript -->
	<script src="resources/js/login/jquery-1.11.1.min.js"></script>
	<script src="resources/js/login/bootstrap.min.js"></script>
	<script src="resources/js/login/jquery.backstretch.min.js"></script>
	<script src="resources/js/login/scripts.js"></script>

</body>

</html>