<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency rate</title>
<jsp:include page="utils/jspheader.jsp" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/currency.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.structure.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.theme.css">
</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div id="body">
	<div class="container">
		<h1 class="center">Currency rate</h1>
			
		<form name="currency-form" id="currency-form" method="post" action="">
		<div id="error" class="alert alert-danger" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a>
			Failed to add currency
		</div>
		<div id="success" class="alert alert-success" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a>
			Currency rate has been added successfully.</div>	
			<div class="row">
				<div>
					<div class="form-group">
						<label class="control-label">Input amount of currency rate</label> 
						<div class="text-danger">
						<input type="text" name="amount" id="amount" 
						class="form-control" placeholder="Enter new currency rate">
						</div>
						 <input type="checkbox" name="nbu" value="" id="nbu">Set NBU cource<br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
						<label class="control-label">FROM DATE</label> 
					<div class="text-danger">	
						<input type="text" name="from" id="from" 
							class="form-control" placeholder="Enter from date">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
						<label class="control-label">TO DATE</label> 
					<div class="text-danger">
						<input type="text" name="to" id="to" 
							class="form-control" placeholder="Enter to date">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	<footer id="footer">
	<div class="col-md-12">
		<hr>
		<p class="text-center">Copyright &copy; REDplatform 2016</p>
	</div>
	</footer>
	<script src="${pageContext.request.contextPath}/resources/js/currency.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/currencyNBU.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery-2.2.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/lib/jquery-ui/jquery-ui.min.js"></script>
</body>
</html>