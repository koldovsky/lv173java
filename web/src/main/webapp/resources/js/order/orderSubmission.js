$(function() {
	
	function collectInputsFromFieldset(fieldset) {
		var data = {};
		var inputs = fieldset.find('input');
		inputs.each(function() {
			data[this.name] = $(this).val();
		});
		return data;
	}

	$(this).on('submit', '.submitButton', function() {
		var customer;
		if ($(this).attr('id') === 'submitButton-1') {
			if ($('#customerform').valid()) {	
				customer = collectInputsFromFieldset($('#customerform #generalInfo'));
				customer.address = collectInputsFromFieldset($('#customerform #address'));
			} else {
				return;
			}
		} else {
			var tr = $(this).closest('tr');
			var row = table.row( tr );
			customer = row['data']();
		}

			function collectInstallmentsData() {
				var installments = [];
				var i = 0;
				var $fieldsets = $('#installmentform').find('.fields');
				$fieldsets.each(function() {
					installments[i] = {};
					installments[i].date = $(this).find('.dateSubmit').val();
					installments[i].amount = $(this).find('.amount').val();
					++i;
				});
				return installments;
			}

			function collectOrderData() {
				var order = collectInputsFromFieldset($('#orderform #generalInfo'));
				order.description = $('#orderform').find('#description').val();
				order.address = collectInputsFromFieldset($('#orderform #address'));
				order.customer = customer;
				order.installment = collectInstallmentsData();
				return order;
			}
			
			var postData = JSON.stringify(collectOrderData());

			$.ajax({
				type : 'POST',
				url : context + '/api/order/',
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
	});
});