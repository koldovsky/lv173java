<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Agency registration</title>
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="resources/bootstrap/css/bootstrap-theme.min.css">
<script src="//code.jquery.com/jquery-1.9.1.js"></script>
<script
	src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>

<script
	src="http://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.0.2/js/bootstrap.min.js"></script>
<script src="resources/js/validationREAgency.js"></script>

</head>
<body>
	<div class="container">
		<h1 class="well">Registration for Real Estate Agency</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form name="myform" id="myform" method="post" action="">
					<div class="col-sm-12">

						<!-- Name of Agency-->
						<div class="form-group">
							<label class="control-label" for="agencyName">Name of
								Agency</label> <input type="text" class="form-control" name="agencyName"
								placeholder="Enter Name of Agency Here..">
						</div>

						<!-- Description-->
						<div class="form-group">
							<label class="control-label" for="description">Description</label>
							<textarea name="description" class="form-control"
								placeholder="Enter Description Here.." rows="3"></textarea>
						</div>

						<!-- Phone number-->
						<div class="form-group">
							<label class="control-label" for="phoneNumber">Phone
								Number</label> <input type="text" name="phoneNumber"
								class="form-control" placeholder="Enter Phone Number Here..">
						</div>

						<!-- Website-->
						<div class="form-group">
							<label class="control-label" for="webSite">Website</label> <input
								type="text" name="webSite" class="form-control"
								placeholder="Enter Website Name Here..">
						</div>

						<!-- Address-->
						<div class="row">
							<div class="col-sm-6 form-group">
								<label class="control-label" for="country">Country</label> <input
									type="text" name="country" placeholder="Enter Country Here.."
									class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label class="control-label" for="region">Region</label> <input
									type="text" name="region" placeholder="Enter Region Here.."
									class="form-control">
							</div>

						</div>
						<div class="row">
							<div class="col-sm-3 form-group">
								<label class="control-label" for="postalCode">Postal
									Code</label> <input type="text" name="postalCode" class="form-control"
									placeholder="Enter Postal Code Here..">
							</div>

							<div class="col-sm-3 form-group">
								<label class="control-label" for="locality">City or
									Village</label> <input type="text" name="locality" class="form-control"
									placeholder="Enter City or Village Here..">
							</div>

							<div class="col-sm-6 form-group">
								<label class="control-label" for="additionalInfo">Address</label> <input type="text" name="additionalInfo"
									class="form-control" placeholder="Enter Additional Info Here..">
							</div>
						</div>
					</div>

					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>