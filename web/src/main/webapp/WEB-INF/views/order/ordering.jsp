<!DOCTYPE html>
<html>
<head>

<title>Add new order - REDplatform</title>

<jsp:include page="../utils/jspheader.jsp" />
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.dataTables-1.10.11.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.structure.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.theme.css">
<link href="${pageContext.request.contextPath}/resources/css/lib/dataTables/jquery.dataTables-1.10.11.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/lib/moment/moment-2.11.2.min.js"></script>

<script src="${pageContext.request.contextPath}/resources/js/order/installment.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/order/usersfororders.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/order/calender.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/order/common.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/order/orderSubmission.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/validationRules.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ordering.css">

</head>

<body>
	<jsp:include page="../utils/navbar.jsp"></jsp:include>
	<jsp:include page="installmentTemplate.jsp"></jsp:include>


	<!-- main container -->
	<div id="container" class="container">

		<h1 class="center">New order</h1>

		<div id="error" class="alert alert-danger" role="alert"><span
					class="close glyphicon glyphicon-remove text-danger" aria-hidden="true"></span>
					Failed to add the order.</div>
		<div id="success" class="alert alert-success" role="alert"><span
					class="close glyphicon glyphicon-remove text-danger" aria-hidden="true"></span>
					The order has been added successfully.</div>
		<div class="text-danger">
			<p class="center">
				<b>Fields marked with <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true">
				</span> are required.
				</b>
			</p>
		</div>


		<div id="formContainer">
			<jsp:include page="orderFieldset.jsp"></jsp:include>
			<jsp:include page="installmentFieldset.jsp"></jsp:include>
			<jsp:include page="customerFieldset.jsp"></jsp:include>
			<jsp:include page="customerList.jsp"></jsp:include>
		</div>
	</div>


	<jsp:include page="../utils/footer.jsp"></jsp:include>
</body>
</html>