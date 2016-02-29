$(document).ready(function() {
	
	function createCustomer() {
		var address = {
			country : $('#country').val(),
			region : $('#region').val(),
			postalCode : $('#postalCode').val(),
			locality : $('#locality').val(),
			additional : $('#address').val()
		}

		var customer = {
			email : $('#mail').val(),
			firstName : $('#firstName').val(),
			lastName : $('#lastName').val(),
			phone : $('#phone').val(),
			passport : $('#passport').val(),
			individualTaxNumber : $('#taxNumber').val(),
			address : address
		}

		$.ajax({
			type : 'POST',
			url : 'api/customer',
			contentType : 'application/json; charset=UTF-8',
			data : JSON.stringify(customer),
			success : function(responseData, textStatus, jqXHR) {
				$('#customer-form')[0].reset();
				$('#success').show();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$('#error').show();
			}
		});
	}

	$('#customer-form').submit(function(event) {
		if ($('#customer-form').valid()) {
			createCustomer();
			return false;
		}
	});

});