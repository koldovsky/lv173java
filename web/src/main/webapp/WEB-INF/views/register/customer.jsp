<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<title>Customer registration</title>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/register/customer.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>
</head>
<body>
	<jsp:include page="../utils/customer.jsp" />
</body>
</html>