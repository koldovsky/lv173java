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
	<jsp:include page="../utils/customer.jsp" />
	<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/register/customer.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/customer.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/validationRules.js"></script>
</body>
</html>