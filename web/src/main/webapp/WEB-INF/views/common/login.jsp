<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<jsp:include page="../utils/jspheader.jsp"/>
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
	<div class="container" style="margin-top: 140px;">
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
			<form name="loginform" action="<c:url value="/j_spring_security_check"></c:url>" method="post">
               <fieldset>
                <div class="input-group" id="email-form">
                <span class="input-group-addon" id="icon-email"></span>
					<input class="form-control" name='email' type="email" placeholder="Email...">
				 </div>
				<div class="input-group" id="email-form">
                 <span class="input-group-addon" id="icon-password"></span>
					<input class="form-control" name='password' type="password" placeholder="Password...">
				</div>
					<input id="button" class="btn btn-lg btn-success btn-block" type="submit" value="Login">
               </fieldset>
			</form>
		</div>
		</div>
		</div>
		</div>
	</div>
</body>
</html>