<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<title>Real estate development administrator edition -
	REDplatform</title>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/redAdminRegister.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>
</head>

<body>
	<jsp:include page="../utils/navbar.jsp"></jsp:include>
	<div class="container">
		<h1 class="center">Edit real estate development administrator information</h1>
		<div id="error" class="alert alert-danger" role="alert">Failed
			to save changes to your personal information.</div>
		<div id="success" class="alert alert-success" role="alert">
			Your personal information has been changed successfully.</div>
		<jsp:include page="../utils/redAdminForm.jsp"></jsp:include>
	</div>
	<jsp:include page="../utils/footer.jsp"></jsp:include>
</body>
</html>