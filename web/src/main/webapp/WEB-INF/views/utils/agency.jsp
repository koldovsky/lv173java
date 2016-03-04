<jsp:include page="navbar.jsp"></jsp:include>

<div class="container">

	<h1>Registration for Real Estate Agency</h1>

	<input type="hidden" name="id" value="${agency.id}" id="agencyID">
	<input type="hidden" name="id" value="${agency.address.id}"
		id="addressID">

	<div id="error" class="alert alert-danger" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a> Failed to add
		agency
	</div>

	<div id="success" class="alert alert-success" role="alert">
		<a href="#" class="close" aria-label="close">&times;</a> Real estate
		agency has been registered successfully.
	</div>

	<div class="text-danger">
		<b>Fields marked with <span
			class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>
			are required.
		</b> <br /> <br />
	</div>

	<div class="col-lg-12">
		<div class="row">
			<form name="register-form" id="register-form" method="post" action="">
				<div class="col-sm-12">

					<!-- Name of Agency-->
					<div class="form-group">
						<label class="control-label" for="agencyName"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Name of Agency
						</label> <input type="text" class="form-control" name="agencyName"
							id="agencyName" value="${agency.name}"
							placeholder="Enter Name of Agency Here..">
					</div>

					<!-- Description-->
					<div class="form-group">
						<label class="control-label" for="description"> <span
							class="glyphicon glyphicon-asterisk text-danger"
							aria-hidden="true"></span> Description
						</label>
						<textarea name="description" class="form-control" id="description"
							placeholder="Enter Description Here.." rows="2">${agency.description}</textarea>
					</div>

					<div class="row">
						<!-- Phone number-->
						<div class="col-sm-6 form-group">
							<div class="form-group">
								<label class="control-label" for="phoneNumber"> <span
									class="glyphicon glyphicon-asterisk text-danger"
									aria-hidden="true"></span> Phone Number
								</label> <input type="text" name="phoneNumber" value="${agency.phone}"
									id="phoneNumber" class="form-control"
									placeholder="Enter Phone Number Here..">
							</div>
						</div>

						<!-- Website-->
						<div class="col-sm-6 form-group">
							<div class="form-group">
								<label class="control-label" for="webSite"> Website </label> <input
									type="text" name="webSite" id="webSite" class="form-control"
									value="${agency.site}" placeholder="Enter Website Name Here..">
							</div>
						</div>
					</div>


					<!-- Address-->
					<div class="row">
						<div class="col-sm-6 form-group">
							<label class="control-label" for="country"> <span
								class="glyphicon glyphicon-asterisk text-danger"
								aria-hidden="true"></span> Country
							</label> <input type="text" name="country" id="country"
								value="${agency.address.country}"
								placeholder="Enter Country Here.." class="form-control">
						</div>
						<div class="col-sm-6 form-group">
							<label class="control-label" for="region"> Region </label> <input
								type="text" name="region" id="region"
								value="${agency.address.region}"
								placeholder="Enter Region Here.." class="form-control">
						</div>

					</div>
					<div class="row">
						<div class="col-sm-3 form-group">
							<label class="control-label" for="postalCode"> <span
								class="glyphicon glyphicon-asterisk text-danger"
								aria-hidden="true"></span> Postal Code
							</label> <input type="text" name="postalCode" class="form-control"
								id="postalCode" value="${agency.address.postalCode}"
								placeholder="Enter Postal Code Here..">
						</div>

						<div class="col-sm-3 form-group">
							<label class="control-label" for="locality"> <span
								class="glyphicon glyphicon-asterisk text-danger"
								aria-hidden="true"></span> City
							</label> <input type="text" name="locality" class="form-control"
								id="locality" value="${agency.address.locality}"
								placeholder="Enter City Here..">
						</div>

						<div class="col-sm-6 form-group">
							<label class="control-label" for="additionalInfo"> <span
								class="glyphicon glyphicon-asterisk text-danger"
								aria-hidden="true"></span> Address
							</label> <input type="text" name="additionalInfo" class="form-control"
								id="additionalInfo" value="${agency.address.additional}"
								placeholder="Enter Additional Info Here..">
						</div>
					</div>

					<div class="submitButtonDiv">
						<button id="submitButton" type="submit" class="btn btn-primary">Submit</button>
					</div>
				</div>

				<br>
			</form>
		</div>
	</div>
</div>
<!-- container -->
<jsp:include page="footer.jsp"></jsp:include>
