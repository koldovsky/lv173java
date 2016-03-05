$(document).ready( function(){
    
	$('#email').each(function () {
        $(this).rules('remove', 'remote');
    });
	
	var href = $(location).attr('href');
	var id = href.substr(href.lastIndexOf('/') + 1);
	document.title = 'Edit Customer';
	
	$('#pageHeader').html('Customer Edit');
	
	$('#email').prop('readonly', true);
	$('#email').prop('tabindex', -1);
	
	var customerEmail;
	var customerId;
	var addressId;
	
	$.ajax({
		type : 'GET',
		url : context + '/api/customer/' + id,
		dataType : 'json',
		success : function (responseData, textStatus, jqHXR) {
			$('#firstName').val(responseData.firstName);
			$('#lastName').val(responseData.lastName);
			$('#email').val(responseData.email);
			$('#phone').val(responseData.phone);
			$('#passport').val(responseData.passport);
			$('#taxNumber').val(responseData.individualTaxNumber);
			$('#country').val(responseData.address.country);
			$('#region').val(responseData.address.region);
			$('#postalCode').val(responseData.address.postalCode);
			$('#locality').val(responseData.address.locality);
			$('#address').val(responseData.address.additional);
			
			customerEmail = responseData.email;
			customerId = responseData.id;
			addressId = responseData.address.id;
			
			$.validator.addMethod('checkEmail', function(value, element){
				return $('#email').val() === customerEmail;
			}, 'Email is \"' + customerEmail + '\", it is not allowed to change it');
			
		},
		error : function (jqHXR, textStatus, errorThrown) {
			if (jqHXR.status === 404) {
				$('#error').html('Customer not found.');
			}
			$('#error').show();
			$('#success').hide();
		}
	});
	
	$('#mail').each(function(){
		$(this).rules('add', {checkEmail : true});
	});
	
	$('#customer-form').submit(function(event) {
		if ($('#customer-form').valid()) {
			var address = {
				id : addressId,
				country : $('#country').val(),
				region : $('#region').val(),
				postalCode : $('#postalCode').val(),
				locality : $('#locality').val(),
				additional : $('#address').val()
			}
			
			var customer = {
				id : customerId,
				firstName : $('#firstName').val(),
				lastName : $('#lastName').val(),
				email : $('#email').val(),
				phone : $('#phone').val(),
				passport : $('#passport').val(),
				individaulTaxNumber : $('#taxNumber').val(),
				address : address
			}
			
			$.ajax({
				type : 'PUT',
				url : context + '/api/customer/' + customerId,
				contentType : 'application/json; charset=UTF-8',
				data : JSON.stringify(customer),
				dataType : 'json',
				success : function(responseData, textStatus, jqXHR) {	
					$('#success').html('Customer has been edited successfully').show();
					$('#error').hide();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$('#error').html('Failed to edit Customer').show();
					$('#success').hide();
				}
			});
		}
		return false;
	});
	
});