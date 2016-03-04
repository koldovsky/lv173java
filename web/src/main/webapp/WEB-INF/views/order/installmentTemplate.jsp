<!-- template -->
<div id="template-container" style="display: none">
	<!-- the template used for every fieldset creation -->
	<div id="template">
		<div id="fieldset-{0}" class="fields row">
			<div id="{0}" class="col-sm-offset-3 col-sm-6">
				<h3 class="center">Installment</h3>
				<div class="col-sm-12 form-group">
					<label class="control-label" for="date-{0}"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span>Date
					</label> <input id="date-{0}" name="date-{0}"
						class="data date form-control" placeholder="YYYY-MM-DD" />
				</div>

				<div class="col-sm-12 form-group">
					<label class="control-label" for="amount-{0}"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span>Amount
					</label> <input id="amount-{0}" name="amount-{0}"
						class="data amount form-control" placeholder="1000.00" />
				</div>
			</div>
		</div>
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