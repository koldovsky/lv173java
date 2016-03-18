<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
								<th>Amount</th>
								<th>Rate</th>
								<th>Amount According to Rate</th>
							</tr>
						</thead>
					</table>
				</div>
				<div class="col-md-5" id="info">
					<h3 class="center">Info</h3>
					<table class="table table-striped table-bordered center">
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
						<tr>
							<td>Progress</td>
							<td>
								<div class="progress">
									<div class="progress-bar progress-bar-info" role="progressbar"
										aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"
										id="progress" style="width: 50%">0% Complete</div>
								</div>
							</td>
						</tr>
					</table>
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