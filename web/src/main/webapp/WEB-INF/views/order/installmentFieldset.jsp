<form id="installmentform" class="orderingUnit col-sm-offset-2 col-sm-8">
	<div class="header">
		<h2 class="center">Installments</h2>
	</div>
	<div class="row globalControls">
		<button type="button" class="btn btn-primary prev col-sm-offset-2 col-sm-3">To
			order</button>
		<div class="dropdown col-sm-offset-2 col-sm-3">
			<button type="button" class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				To user <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<li id="toNewCustomer" class="next">New user</li>
				<li id="toCustomerList" class="next">Existing user</li>
			</ul>
		</div>
	</div>
</form>
<script src="${pageContext.request.contextPath}/resources/js/order/installmentValidation.js"></script>