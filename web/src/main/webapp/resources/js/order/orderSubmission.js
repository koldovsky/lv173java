$(function() {

	$('#submitButton').click(function() {
		if ($('#customerform').valid()) {
			
			function collectInputsFromFieldset(fieldset) {
				var data = {};
				var inputs = fieldset.find('input');
				inputs.each(function() {
					data[this.name] = $(this).val();
				});
				return data;
			}
			
			function collectCustomerData() {
				var customer = collectInputsFromFieldset($('#customerform #generalInfo'));
				customer.address = collectInputsFromFieldset($('#customerform #address'));
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
				var order = collectInputsFromFieldset($('#orderform #generalInfo'));
				order.description = $('#orderform').find('#description').val();
				order.address = collectInputsFromFieldset($('#orderform #address'));
				order.customer = collectCustomerData();
				order.installment = collectInstallmentsData();
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