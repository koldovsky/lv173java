<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../utils/jspheader.jsp" />
<title>System Administrator registration</title>
<script src="resources/js/lib/jquery/jquery.validate.min.js">
	
</script>
<script src="resources/js/adminregister.js"></script>

</head>
<body>
	<div class="container">
		<h1 class="well">New System Administrator Registration</h1>

		<div id="error" class="alert alert-danger container" role="alert">
			Failed to add new System Administrator.</div>
		<div id="error_if_exists" class="alert alert-danger container"
			role="alert">This System Administrator already exists!</div>
		<div id="success" class="alert alert-success container" role="alert">
			System Administrator has been registered successfully.</div>
		<div class="col-lg-12 well">
			<form name="adminregisterform" id="adminregisterform" action="">
				<div class="row">
					<div class="col-sm-6">
						<!-- New system adminstrator login-->
						<div class="form-group">
							<label class="control-label" for="adminregister">New
								system administrator login</label> <input type="text"
								class="form-control" name="adminregister" id="adminregister"
								placeholder="Enter new system administrator's mail">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form>

		</div>
	</div>
	<!-- container -->
</body>
</html>
