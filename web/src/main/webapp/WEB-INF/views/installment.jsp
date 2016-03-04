<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="utils/jspheader.jsp" />
<title>Installment addition - REDplatform</title>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/lib/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/installment.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/regexes.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.structure.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/lib/jquery-ui/jquery-ui.theme.css">
</head>

<body>
	<jsp:include page="utils/navbar.jsp"></jsp:include>
	<div id="container" class="container">
		<h1 class="center">Installments for the order</h1>
		<div id="error" class="alert alert-danger" role="alert">Failed
			to add the installment.</div>
		<div id="success" class="alert alert-success" role="alert">
			Installment has been added successfully.</div>

		<div contenteditable="true" style="display: none"
			id="template-container">
			<!-- the template used for every fieldset creation -->
			<div id="template">
				<fieldset id="fieldset-{0}" class="fields row">
					<div id="{0}" class="col-sm-offset-3 col-sm-6">
						<h2 class="center">Installment</h2>
						<div class="col-sm-12 form-group">
							<label class="control-label" for="date-{0}"> <span
								class="glyphicon glyphicon-asterisk text-danger"
								aria-hidden="true"></span>Date
							</label> <input id="date-{0}" name="date-{0}" class="data date form-control"
								placeholder="YYYY-MM-DD" />
						</div>

						<div class="col-sm-12 form-group">
							<label class="control-label" for="amount-{0}"> <span
								class="glyphicon glyphicon-asterisk text-danger"
								aria-hidden="true"></span>Amount
							</label> <input id="amount-{0}" name="amount-{0}"
								class="data amount form-control" placeholder="1000.00" />
						</div>
					</div>
				</fieldset>
			</div>

			<!-- buttons -->
			<div id="controls-container" class="row">
				<div class="col-sm-offset-3 col-sm-6">
					<div class="col-sm-12">
						<button id="add-more" type="button"
							class="btn btn-primary col-sm-offset-3 col-sm-1">
							<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
						</button>
						<button id="delete-item" type="button"
							class="btn btn-primary col-sm-1">
							<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
						</button>
						<button id="submit-data" type="button"
							class="btn btn-primary col-sm-offset-1 col-sm-3">Submit</button>
					</div>
				</div>
			</div>
		</div>

		<!-- the form, where fields will be added to -->
		<form id="installment-form" name="installment-form">
			<div class="text-danger">
				<p class="center">
					<b>Fields marked with <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> are required.
					</b>
				</p>
			</div>
		</form>
	</div>
	<jsp:include page="utils/footer.jsp"></jsp:include>
</body>
</html>
