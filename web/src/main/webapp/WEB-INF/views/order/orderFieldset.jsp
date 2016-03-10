<form id="orderform" class="orderingUnit">
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
			<div class="col-sm-12">
				<!-- Description-->
				<div class="form-group">
					<label class="control-label" for="description"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Description
					</label>
					<textarea name="description" class="form-control" id="description"
						placeholder="Enter Description Here.." rows="2"></textarea>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6">
				<!-- Room area-->
				<div class="form-group">
					<label class="control-label" for="area"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Area of the real estate.
					</label> <input type="text" name="area" id="area" class="form-control"
						placeholder="Enter real estate area in square meters here...">
				</div>
			</div>
			<div class="col-sm-6">
				<!-- Room number-->
				<div class="form-group">
					<label class="control-label" for="roomsQuantity"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span> Room number of the real estate.
					</label> <input type="text" name="roomsQuantity" id="roomsQuantity"
						class="form-control"
						placeholder="Enter real estate number of rooms here...">
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
						aria-hidden="true"></span> Locality
					</label> <input type="text" class="form-control" name="locality"
						id="locality" placeholder="Enter Locality Here..">
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
	</fieldset>

	<div class="row globalControls">
		<button type="button"
			class="btn btn-primary next col-sm-offset-7 col-sm-3">Next</button>
	</div>
</form>