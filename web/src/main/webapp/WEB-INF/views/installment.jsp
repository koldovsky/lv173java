<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<title>Installment addition - REDplatform</title>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/installment.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>
</head>

<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div id="container" class="container">
		<h1>Specify installment for the order</h1>
		<div id="error" class="alert alert-danger" role="alert">Failed
			to add the installment.</div>
		<div id="success" class="alert alert-success" role="alert">
			Installment has been added successfully.</div>

		<!-- template to be used to add fields dynamically -->
		<div contenteditable="true" style="display: none" id="template">
			<h2>Installment item</h2>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="date-{0}"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Date
				</label>
				<div class="col-sm-10">
					<input id="date-{0}" name="date-{0}" class="data date form-control"
						placeholder="YYYY-MM-DD" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label" for="amount-{0}"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>Amount
				</label>
				<div class="col-sm-10">
					<input id="amount-{0}" name="amount-{0}"
						class="data amount form-control" placeholder="100,00" />
				</div>
			</div>
		</div>

		<!-- the form, where fields will be added to -->
		<form id="installment-form" name="installment-form" class="form-horizontal"></form>

		<div id="controls" class="row">
			<button id="add-more" type="submit"
				class="btn btn-primary col-sm-offset-3 col-sm-2">Add more</button>
			<button id="submit-data" type="submit"
				class="btn btn-primary col-sm-offset-2 col-sm-2">Submit</button>
		</div>
	</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
</body>
</html>
