<!-- template -->
<div id="template-container" style="display: none">
	<!-- the template used for every fieldset creation -->
	<div id="template">
		<div id="fieldset-{0}" class="fields row">
			<div id="fields-container-{0}" class="fields-container row">
				<div class="col-sm-5 form-group">
					<label class="control-label" for="date-{0}"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span>Date
					</label> <input id="date-{0}" name="date-{0}"
						class="data date form-control" placeholder="YYYY-MM-DD" />
				</div>
				
				<input type="hidden" id="dateSubmit-{0}" class="dateSubmit">

				<div class="col-sm-7 form-group">
					<label class="control-label" for="amount-{0}"> <span
						class="glyphicon glyphicon-asterisk text-danger"
						aria-hidden="true"></span>Amount
					</label>
					<div class="row">
						<div class="col-sm-9">
							<input id="amount-{0}" name="amount-{0}"
								class="data amount form-control" placeholder="1000.00" />
						</div>

						<!-- buttons -->
						<div class="col-sm-3">
							<div id="controls-container-{0}" class="controls-container row">
								<button id="add-more-{0}" type="button"
									class="add-more btn btn-primary col-sm-6">
									<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
								</button>
								<button id="delete-item-{0}" type="button"
									class="delete-item btn btn-primary col-sm-6">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>