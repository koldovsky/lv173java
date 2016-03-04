<fieldset id="orderform">
	<div class="header">
		<h2 class="center">Order</h2>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<!-- Description-->
			<div class="form-group">
				<label class="control-label" for="description"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>
					Description
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
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>
					Area of the real estate.
				</label> <input type="text" name="area" id="area" class="form-control"
					placeholder="Enter real estate area in square meters here...">
			</div>
		</div>
		<div class="col-sm-6">
			<!-- Room number-->
			<div class="form-group">
				<label class="control-label" for="area"> <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true"></span>
					Room number of the real estate.
				</label> <input type="text" name="roomsQuantity" id="roomsQuantity"
					class="form-control"
					placeholder="Enter real estate number of rooms here...">
			</div>
		</div>
	</div>
	<div class="row globalControls">
		<button class="btn btn-primary next col-sm-offset-7 col-sm-3">To
			installments</button>
	</div>
</fieldset>