<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<title>Customer registration</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/customer.css">
<script>var ctp = '${pageContext.request.contextPath}';</script>
</head>
<body>
	<div id="content">
		<jsp:include page="../utils/navbar.jsp"></jsp:include>
		<div id="error" class="alert alert-danger" role="alert">
		<a class="close" aria-label="close">&times;</a>
		Failed to edit Customer.
		</div>
		<div id="success" class="alert alert-success" role="alert">
		<a class="close" aria-label="close">&times;</a>
			Customer has been edited successfully.</div>
		<jsp:include page="../order/customerFieldset.jsp" />
		<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/order/customerValidation.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/validationRules.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/edit/customer.js"></script>
	</div>
</body>
</html>