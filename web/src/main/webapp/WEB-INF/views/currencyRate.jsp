<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Currency rate</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/currency.css">
<jsp:include page="utils/jspheader.jsp" />
</head>
<body onload="setDate()">
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div >
	<div class="container" id="body">
		<h1>Currency rate</h1>
		
		<div id="error" class="alert alert-danger" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a>
			Failed to add currency
		</div>
		
		<div id="invalidDate" class="alert alert-danger" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a>
			Wrong date: "FROM DATE" must be greater/equal than today's date, and less/equal than "TO DATE"
		</div>
		
		<div id="success" class="alert alert-success" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a>
			Currency rate has been added successfully.</div>
		
		<form name="currency-form" id="currency-form" method="post" action="">
			<div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label">Input amount of currency rate</label> 
						<input type="text" name="amount" id="amount" 
						class="form-control" placeholder="Enter new currency rate">
						 <input type="checkbox" name="nbu" value="" id="nbu">Set NBU cource<br>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label">FROM DATE</label> 
						<div>	
						 <div class="date"><label class="control-label">Year</label>
						<p><select size="1" class="form-control" name="fromYear" id="fromYear">	
						   </select></p>
						 </div>
						 <div class="date"><label class="control-label">Month</label>
						<p><select size="1" class="form-control" name="fromMonth" id="fromMonth">
						   </select></p>
						 </div>
						 <div class="date"><label class="control-label">Day</label>
						<p><select size="1" class="form-control" name="fromDay" id="fromDay">
						   </select></p>
						 </div>
						 </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label">TO DATE</label> 
						<div>
						 <div class="date"><label class="control-label">Year</label>
						<p><select size="1" name="toYear" class="form-control" id="toYear">
						   </select></p>
						 </div>
						 <div class="date"><label class="control-label">Month</label>
						<p><select size="1" class="form-control" name="toMonth" id="toMonth">
						   </select></p>
						 </div>
						 <div class="date"><label class="control-label">Day</label>
						<p><select class="form-control" size="1" id="toDay">
						   </select></p>
						 </div>
						 </div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
		</div>
	</div>
	<div id="footer">
	<jsp:include page="utils/footer.jsp"></jsp:include>
	</div>
	<script src="${pageContext.request.contextPath}/resources/js/currency.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/currencyNBU.js"></script>
</body>
</html>