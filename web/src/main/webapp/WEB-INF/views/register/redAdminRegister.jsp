<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<title>Real estate development administrator registration -
	REDplatform</title>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/redAdminRegister.js"></script>
</head>

<body>
	<jsp:include page="../utils/navbar.jsp"></jsp:include>
	<div class="container">
		<h1 class="center">New real estate development administrator</h1>
		<div id="error" class="alert alert-danger" role="alert"><span
					class="close glyphicon glyphicon-remove text-danger" aria-hidden="true"></span>
					Failed to add new administrator.</div>
		<div id="success" class="alert alert-success" role="alert"><span
					class="close glyphicon glyphicon-remove text-danger" aria-hidden="true"></span>
			Administrator has been registered successfully.</div>
		<jsp:include page="../utils/redAdminForm.jsp"></jsp:include>
	</div>
	<jsp:include page="../utils/footer.jsp"></jsp:include>
</body>
</html>
