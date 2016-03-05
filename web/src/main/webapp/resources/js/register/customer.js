$(document).ready(function() {

	$('#customer-form').submit(function(event) {
		if ($('#customer-form').valid()) {var address = {
				country : $('#country').val(),
				region : $('#region').val(),
				postalCode : $('#postalCode').val(),
				locality : $('#locality').val(),
				additional : $('#address').val()
			}

			var customer = {
				email : $('#email').val(),
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
					var redirect = redirecturl;
					console.log(redirect);
					redirect += "/order/";
					redirect += responseData.id;
					window.location.assign(redirect);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$('#error').show();
				}
			})
			return false;
		}
	});
});