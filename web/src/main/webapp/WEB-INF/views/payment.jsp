<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/payment.css">
<script
	src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js">
	
</script>
<title>New payment</title>
<script
	src="${pageContext.request.contextPath}/resources/js/validationRules.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/validationRules.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/payment.js"></script>


</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>New Payment</h1>
		<div class="text-danger">
			<b>Fields marked with <span
				class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>
				are required.
			</b> <br /> <br />
		</div>
		<div id="error" class="alert alert-danger" role="alert">
			<a href="#" class="close" aria-label="close">&times;</a> Failed to
			create new payment!
		</div>
		<form name="paymentform" id="paymentform" action="">
			<div class="col-lg-6">
				<div class="row">
					<!-- New payment amount-->
					<div class="form-group">
						<label class="control-label" for="amount"><span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span>Input the amount of a payment.</label> <input
							type="text" class="form-control data amount" name="amount"
							id="amount" placeholder="1000.00">
					</div>
				</div>
				<div class="row">
					<div class="form-group">
						<span class="btn btn-success fileinput-button"> <span>Select
								a photo of a payment</span> <input id="fileupload" type="file"
							name="files[]">
						</span>
					</div>
				</div>
				<div class="row">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
			<div class="col-lg-1"></div>
			<div class="col-lg-5" id="imgColumn">
				<div class="row">
					<div class="form-group">
						<img id="preview" src="#" alt="your image" width="300px" />
					</div>
				</div>
			</div>
		</form>

	</div>

	<!-- container -->
	<div class="navbar navbar-fixed-bottom">
		<jsp:include page="utils/footer.jsp"></jsp:include>
	</div>
</body>
</html>