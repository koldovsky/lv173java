<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Navbar JS -->
<script src="${pageContext.request.contextPath}/resources/js/common/navbar.js"></script>
<!-- Autorisation CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/autorization.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/bootstrap/bootstrap.min.css">
<!-- Navigation -->
<nav id="navMenu" class="navbar navbar-default navbar-fixed-top"
	role="navigation">
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
				<li><a href="${pageContext.request.contextPath}/index">Home page</a></li>
				<li>
					<sec:authorize access="isAnonymous()">
						<a href="${pageContext.request.contextPath}/login">Login</a>
					</sec:authorize> <sec:authorize access="isAuthenticated()">
						<a id="navbarMail" href="${pageContext.request.contextPath}/cabinet">Email</a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/cabinet">Cabinet</a>
							</li>
							<li><a href="${pageContext.request.contextPath}/logout">Logout</a>
							</li>
						</ul>
					</sec:authorize>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>