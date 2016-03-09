<form id="customerform" class="orderingUnit">
	<div class="header">
		<h2 class="center">Customer</h2>
	</div>
	<div class="text-danger">
		<p class="center">
			<b>Fields marked with <span
				class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true">
			</span> are required.
			</b>
		</p>
	</div>
	<fieldset id="generalInfo">
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="firstName"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> First Name
					</label> <input type="text" class="form-control" name="firstName"
						id="firstName" placeholder="Enter First Name Here..">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="lastName"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Last Name
					</label> <input type="text" class="form-control" name="lastName"
						id="lastName" placeholder="Enter Last Name Here..">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="email"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Email
					</label> <input type="email" class="form-control" name="email" id="email"
						placeholder="Enter Email Here..">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="phone"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Phone Number
					</label> <input type="text" class="form-control" name="phone" id="phone"
						placeholder="Enter Phone Number Here..">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="passport"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Passport
					</label> <input type="text" class="form-control" name="passport"
						id="passport" placeholder="Enter Passport Here..">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="individualTaxNumber"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Individual Tax Number
					</label> <input type="text" class="form-control" name="individualTaxNumber"
						id="individualTaxNumber" placeholder="Enter Individual Tax Number Here..">
				</div>
			</div>
		</div>
	</fieldset>

	<fieldset id="address">
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
						aria-hidden="true"></span> City
					</label> <input type="text" class="form-control" name="locality"
						id="locality" placeholder="Enter City Here..">
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label class="control-label" for="additional"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Address
					</label> <input type="text" class="form-control" name="additional"
						id="additional" placeholder="Enter Address Here..">
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="row globalControls">
					<button type="button" id="installmentsButton"
						class="btn btn-primary prev col-sm-offset-2 col-sm-3">Prev</button>
					<button id="submitButton-1" type="button"
						class="submitButton btn btn-primary col-sm-offset-2 col-sm-3">Submit</button>
				</div>
			</div>
		</div>
	</fieldset>
</form>
<script
src="${pageContext.request.contextPath}/resources/js/order/customerValidation.js"></script>