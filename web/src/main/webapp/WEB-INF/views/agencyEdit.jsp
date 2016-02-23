<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<script
	src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js">
</script>
<title>Agency registration</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/agencyRegistration.css">
<script src="${pageContext.request.contextPath}/resources/js/agency.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/agencyEdit.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/validators.js"></script>

</head>
	<body>
		<input type="hidden" name="id" value="" id="agencyID">
		<jsp:include page="utils/agency.jsp"></jsp:include>
	</body>
</html>