<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/adminregister.css">
<title>Order creation</title>


</head>
<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>New Order Registration</h1>

		<div id="error" class="alert alert-danger" role="alert">
			<a href="#" class="close" aria-label="close">&times;</a>
		</div>

		<form name="orderform" id="orderform" action="">
			<div class="row">
				<div class="col-sm-12">
					<!-- Description-->
					<div class="form-group">
						<label class="control-label" for="description"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Description
						</label>
						<textarea name="description" class="form-control" id="description"
							placeholder="Enter Description Here.." rows="2"></textarea>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<!-- Room area-->
					<div class="form-group">
						<label class="control-label" for="area"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Area of the real estate.
						</label> <input type="text" name="area" id="area" class="form-control"
							placeholder="Enter real estate area in square meters here...">
					</div>
				</div>
				<div class="col-sm-6">
					<!-- Room number-->
					<div class="form-group">
						<label class="control-label" for="area"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Room number of the real estate.
						</label> <input type="text" name="roomsQuantity" id="roomsQuantity"
							class="form-control"
							placeholder="Enter real estate number of rooms here...">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label" for="country"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Country
						</label> <input type="text" class="form-control" name="country"
							id="country" placeholder="Enter Country Here..">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label" for="region"> Region </label> <input
							type="text" class="form-control" name="region" id="region"
							placeholder="Enter Region Here..">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label" for="postalCode"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Postal Code
						</label> <input type="text" class="form-control" name="postalCode"
							id="postalCode" placeholder="Enter Postal Code Here..">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label class="control-label" for="locality"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Locality
						</label> <input type="text" class="form-control" name="locality"
							id="locality" placeholder="Enter Locality Here..">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label" for="address"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Address
						</label> <input type="text" class="form-control" name="address"
							id="address" placeholder="Enter Address Here..">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<button id="submit-data" type="submit" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>

	</div>

	<!-- container -->
	<div class="navbar navbar-fixed-bottom">
		<jsp:include page="utils/footer.jsp"></jsp:include>
	</div>
	<script
		src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/order.js"></script>

</body>
</html>
