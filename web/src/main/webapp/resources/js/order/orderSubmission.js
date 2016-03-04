$(function() {

	$('#submitButton').click(function() {
		if ($('#commonForm').valid()) {
			
			function collectCustomerData() {
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
				return customer;
			}

			function collectInstallmentsData() {
				var installments = [];
				var i = 0;
				var $fieldsets = $('#installmentform').find('.fields');
				$fieldsets.each(function() {
					var $inputs = $(this).find('input');
					installments[i] = {};
					$inputs.each(function() {
						var name = this.name.replace(/-.*/g, '');
						installments[i][name] = $(this).val();
					});
					++i;
				});
				return installments;
			}

			function collectOrderData() {
				var order = {
					description : $('#description').val(),
					area : $('#area').val(),
					roomsQuantity : $('#roomsQuantity').val(),
					customer : collectCustomerData(),
					installment : collectInstallmentsData()
				};
				return order;
			}
			
			var postData = JSON.stringify(collectOrderData());

			$.ajax({
				type : 'POST',
				url : redirecturl + '/api/order/',
				data : postData,
				contentType : 'application/json; charset=utf-8',
				success : function(responseData, textStatus, jqXHR) {
					$('#error').hide;
					$('#success').show();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					if (jqXHR.status === 400) {
						if (jqXHR.responseText !== "") {
							$("#error").text(jqXHR.responseText);
						}
					}
					$('#success').hide();
					$('#error').show();
				}
			});
			return false;
		}
	});
});