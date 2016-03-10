<form id="installmentform" class="orderingUnit">
	<div>
		<div class="text-danger">
			<p class="center">
				<b>Fields marked with <span
					class="glyphicon glyphicon-asterisk text-danger" aria-hidden="true">
				</span> are required.
				</b>
			</p>
		</div>
	</div>
	<div class="row globalControls">
		<button type="button" class="btn btn-primary prev col-sm-offset-2 col-sm-3">Prev</button>
		<div class="dropdown col-sm-offset-2 col-sm-3">
			<button type="button" class="btn btn-primary dropdown-toggle" type="button" 
				data-toggle="dropdown">
				Next<span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li><a id="toNewCustomer" class="next" href="#">New user</a></li>
				<li><a id="toCustomerList" class="next" href="#">Existing user</a></li>
			</ul>
		</div>
	</div>
</form>