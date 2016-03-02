$(document).ready( function(){
    
	$('#mail').each(function () {
        $(this).rules('remove', 'remote');
    });
	
	var href = $(location).attr('href');
	var id = href.substr(href.lastIndexOf('/') + 1);
	document.title = 'Edit Customer';
	
	$.ajax({
		type : 'GET',
		url : context + '/api/customer/' + id,
		dataType : 'json',
		success : function (responseData, textStatus, jqHXR) {
			$('#firstName').val(responseData.firstName);
			$('#lastName').val(responseData.lastName);
			$('#mail').val(responseData.email);
			$('#phone').val(responseData.phone);
			$('#passport').val(responseData.passport);
			$('#taxNumber').val(responseData.individualTaxNumber);
			$('#country').val(responseData.address.country);
			$('#region').val(responseData.address.region);
			$('#postalCode').val(responseData.address.postalCode);
			$('#locality').val(responseData.address.locality);
			$('#address').val(responseData.address.additional);
		},
		error : function (jqHXR, textStatus, errorThrown) {
			if (jqHXR.status === 404) {
				$('#error').html('Customer not found.');
			}
			$('#error').show();
			$('#success').hide();
		}
	});
});