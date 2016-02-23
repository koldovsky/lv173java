<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Navbar JS -->
<script src="${pageContext.request.contextPath}/resources/js/common/navbar.js"></script>
<!-- Autorisation CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/autorization.css">
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
				<li><a href="/REDplatform/">Home page</a></li>
				<li><a href="#">Contact</a></li>
			</ul>
		</div>
		<div id="autorization">
			<sec:authorize access="isAnonymous()">
					<form action="/REDplatform/login">
    					<input class="btn btn-success" type="submit" value="Login">
					</form>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<form action="/REDplatform/logout">
    					<input class="btn btn-danger" type="submit" value="Logout">
				</form>
			</sec:authorize>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>