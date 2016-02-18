<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp"/>
<title>Login</title>
<script src="resources/js/cookies.js"></script>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container"></div>
		</div>
	</section>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<div class="error">${error}</div>
							</div>
						</c:if>
						<form name="loginform" action="<c:url value="/j_spring_security_check"></c:url>"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" name='email' type="text">
								</div>
								<div class="form-group">
									<input class="form-control" name='password' type="password">
								</div>
								<input class="btn btn-lg btn-success btn-block" type="submit"
									value="Login" onclick="WriteCookie();">
							</fieldset>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>