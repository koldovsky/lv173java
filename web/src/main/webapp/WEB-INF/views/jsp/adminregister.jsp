<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>System Administrator registration</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/bootstrap/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js">
	
</script>

<script
	src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.2/js/bootstrap.min.js">
	
</script>
<script src="resources/js/adminregister.js"></script>

</head>
<body>
	<div class="container">
		<h1 class="well">New System Administrator Registration</h1>
		<div class="col-lg-12 well">
			<div class="row">
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
						<div class="col-sm-6"></div>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>

				</form>
			</div>
		</div>
	</div>
	<!-- container -->
</body>
</html>
