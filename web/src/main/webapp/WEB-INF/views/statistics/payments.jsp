<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Payments Statistics</title>
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/resources/css/users.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/lib/dataTables/jquery.dataTables-1.10.11.min.css"
	rel="stylesheet">
</head>
<body>
	<div id="container">
		<jsp:include page="../utils/navbar.jsp"></jsp:include>
		<div class="page">
			<h2 class="text-center">Payments Statistics</h2>
			<div class="row">
				<div class="col-md-7">
					<h3 class="center">List of Payments</h3>
					<table id="table" class="display" cellspacing="0" width="100%">
						<thead>
							<tr>
								<th>Date</th>
								<th>Amount USD</th>
								<th>Rate</th>
								<th>Amount UAH</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="col-md-5" id="info">
					<div id="progressCol" class="col-md-12">
						<div id="progressbar">
							<div class="progress-bar progress-bar-info" id="progress"
								role="progressbar" aria-valuenow="0" aria-valuemin="0"
								aria-valuemax="100" style="width: 0%;"></div>
						</div>
					</div>
					<table class="table table-striped table-bordered center">
						<thead>
							<tr>
								<th colspan="2" class="center">Info</th>
							</tr>
						</thead>
						<tr>
							<td>Price</td>
							<td id="apartmentPrice"></td>
						</tr>
						<tr>
							<td>Total paid amount</td>
							<td id="totalPaidAmount"></td>
						</tr>
						<tr>
							<td>Total amount left to pay</td>
							<td id="leftPayAmount"></td>
						</tr>
					</table>
					<div id="missed" hidden="true">
						<table class="table table-striped table-bordered center">
							<thead>
								<tr>
									<th colspan="2" class="center">Missed Installment</th>
								<tr>
							</thead>
							<tbody>
								<tr>
									<td>Due date</td>
									<td id="missedDueDate"></td>
								</tr>
								<tr>
									<td>Amount</td>
									<td id="missedAmount"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div id="next" hidden="true">
						<table class="table table-striped table-bordered center">
							<thead>
								<tr>
									<th colspan="2" class="center">Next Installment</th>
								<tr>
							</thead>
							<tbody>
								<tr>
									<td>Due date</td>
									<td id="nextDueDate"></td>
								</tr>
								<tr>
									<td>Amount</td>
									<td id="nextAmount"></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="row">
						<sec:authorize access="hasRole('ROLE_REDADMIN')">
							<div class="col-md-6 col-md-offset-3">
								<a href="${pageContext.request.contextPath}/orders">
									<button class="btn btn-primary col-md-12">View Orders</button>
								</a>
							</div>
						</sec:authorize>
						<sec:authorize access="hasRole('ROLE_USER')">
							<div class="col-md-6">
								<a href="${pageContext.request.contextPath}/payment">
									<button class="btn btn-primary col-md-12">Add Payment</button>
								</a>
							</div>
							<div class="col-md-6">
								<a href="${pageContext.request.contextPath}/orders"><button
										class="btn btn-primary col-md-12">View Orders</button></a>
							</div>
						</sec:authorize>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../utils/footer.jsp"></jsp:include>
		<!-- jQuery dataTables -->
		<script
			src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.dataTables-1.10.11.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/js/lib/moment/moment-2.11.2.min.js"></script>
		<script
			src="${pageContext.request.contextPath}/resources/js/statistics/payments.js"></script>
	</div>
</body>
</html>