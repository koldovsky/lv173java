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
					<h3 class="center">
						List of Payments
						</h4>
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
				<div class="col-md-5">
					<div class="jumbotron">
						<form class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-6">
									<p class="center form-control-static">Apartment Price :</p>
								</div>
								<div class="col-sm-6">
									<p id="apartmentPrice" class="center form-control-static">65000</p>
								</div>
							</div>
						</form>
						<form class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-6">
									<p class="center form-control-static">Total Paid Amount :</p>
								</div>
								<div class="col-sm-6">
									<p id="totalPaidAmount" class="center form-control-static">65000</p>
								</div>
							</div>
						</form>
						<form class="form-horizontal">
							<div class="form-group">
								<div class="col-sm-6">
									<p class="center form-control-static">Progress :</p>
								</div>
								<div class="col-sm-6">
									<p id="progress" class="center form-control-static">65000</p>
								</div>
							</div>
						</form>
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