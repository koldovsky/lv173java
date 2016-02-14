
	<jsp:include page="navbar.jsp"></jsp:include>

	<div class="container">
		<h1 class="well">Registration for Real Estate Agency</h1>
		<div id="success" class="alert alert-success container" role="alert">
			Real estate agency has been added to the list successfully.</div>
		<div id="error" class="alert alert-danger container" role="alert">
			Failed to add Real estate agency.</div>
		<div class="col-lg-12">
			<div class="row">
				<form name="register-form" id="register-form" method="post"
					action="">
					<div class="col-sm-12">

						<!-- Name of Agency-->
						<div class="form-group">
							<label class="control-label" for="agencyName">Name of
								Agency</label> <input type="text" class="form-control" name="agencyName"
								id="agencyName" placeholder="Enter Name of Agency Here..">
						</div>

						<!-- Description-->
						<div class="form-group">
							<label class="control-label" for="description">Description</label>
							<textarea name="description" class="form-control"
								id="description" placeholder="Enter Description Here.." rows="3"></textarea>
						</div>

						<!-- Phone number-->
						<div class="form-group">
							<label class="control-label" for="phoneNumber">Phone
								Number</label> <input type="text" name="phoneNumber" id="phoneNumber"
								class="form-control" placeholder="Enter Phone Number Here..">
						</div>

						<!-- Website-->
						<div class="form-group">
							<label class="control-label" for="webSite">Website</label> <input
								type="text" name="webSite" id="webSite" class="form-control"
								placeholder="Enter Website Name Here..">
						</div>

						<!-- Address-->
						<div class="row">
							<div class="col-sm-6 form-group">
								<label class="control-label" for="country">Country</label> <input
									type="text" name="country" id="country"
									placeholder="Enter Country Here.." class="form-control">
							</div>
							<div class="col-sm-6 form-group">
								<label class="control-label" for="region">Region</label> <input
									type="text" name="region" id="region"
									placeholder="Enter Region Here.." class="form-control">
							</div>

						</div>
						<div class="row">
							<div class="col-sm-3 form-group">
								<label class="control-label" for="postalCode">Postal
									Code</label> <input type="text" name="postalCode" class="form-control"
									id="postalCode" placeholder="Enter Postal Code Here..">
							</div>

							<div class="col-sm-3 form-group">
								<label class="control-label" for="locality">City or
									Village</label> <input type="text" name="locality" class="form-control"
									id="locality" placeholder="Enter City or Village Here..">
							</div>

							<div class="col-sm-6 form-group">
								<label class="control-label" for="additionalInfo">Address</label>
								<input type="text" name="additionalInfo" class="form-control"
									id="additionalInfo" placeholder="Enter Additional Info Here..">
							</div>
						</div>
					</div>
					<div class="submitButtonDiv">
						<button id="submitButton" type="submit" class="btn btn-default">Submit</button>
					</div>
					<br>
				</form>
			</div>
		</div>

	</div>
	<!-- container -->
	<jsp:include page="footer.jsp"></jsp:include>
