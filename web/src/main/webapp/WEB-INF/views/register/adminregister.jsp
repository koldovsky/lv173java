<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/adminregister.css">
<title>System Administrator registration</title>
<script src="resources/js/lib/jquery/jquery.validate.min.js"></script>
<script src="resources/js/adminregister.js"></script>

</head>
<body>
	<jsp:include page="../utils/navbar.jsp"></jsp:include>
	<div class="container">
		<h1>New System Administrator Registration</h1>

		<div id="error" class="alert alert-danger" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a>
		</div>
		<div id="success" class="alert alert-success" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a>
			System Administrator has been registered successfully.</div>

		<form name="adminregisterform" id="adminregisterform" action="">
			<div class="row">
				<div class="col-sm-6">
					<!-- New system adminstrator login-->
					<div class="form-group">
						<label class="control-label" for="adminregister">Input new
							system administrator login</label> <input type="text"
							class="form-control" name="mail" id="mail"
							placeholder="Enter new system administrator's mail">
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

	<!-- container -->
	<div class="navbar navbar-fixed-bottom">
		<jsp:include page="../utils/footer.jsp"></jsp:include>
	</div>
</body>
</html>
