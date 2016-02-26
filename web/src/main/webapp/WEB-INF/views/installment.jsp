<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<title>Installment addition - REDplatform</title>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/installment.js"></script>
</head>

<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div id="container" class="container">
		<h1>Specify installment for the order</h1>
		<div id="error" class="alert alert-danger" role="alert">Failed
			to add the installment.</div>
		<div id="success" class="alert alert-success" role="alert">
			Installment has been added successfully.</div>
		<form id="installment-addition" name="installment-addition"
			class="installment-addition form-horizontal">
			<h2>Installment item</h2>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="date"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Date
				</label>
				<div class="col-sm-10">
					<input id="date" name="date" class="data form-control"
						placeholder="YYYY-MM-DD" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="amount"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Amount
				</label>
				<div class="col-sm-10">
					<input id="amount" name="amount" class="data name form-control"
						placeholder="100,00" />
				</div>
			</div>
		</form>
		
		<div id="controls" class="row">
			<button id="add-more" type="submit" class="btn btn-primary col-sm-offset-3 col-sm-2">Add more</button>
			<button id="submit-data" type="submit" class="btn btn-primary col-sm-offset-2 col-sm-2">Submit</button>
		</div>
	</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
</body>
</html>
