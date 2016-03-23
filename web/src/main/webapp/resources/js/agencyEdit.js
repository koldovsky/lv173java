$(document).ready(
		function() {
			
		    $('#agencyName').each(function () {
		        $(this).rules('remove', 'remote');
		    });
	
			$('#register-form').submit(function(event) {
				if ($('#register-form').valid()) {
					var address = {
							id:	$('#addressID').val(),
							country : $('#country').val(),
							region : $('#region').val(),
							postalCode : $('#postalCode').val(),
							locality : $('#locality').val(),
							additional : $('#additionalInfo').val()
						};

						var agency = {
							id:	$('#agencyID').val(),
							name : $('#agencyName').val(),
																																																																																																																												description : $('#description').val(),
							site : $('#webSite').val(),
							phone : $('#phoneNumber').val(),
							address : address
						};
						
						$.ajax({
							type : 'PUT',
							url : context + '/api/agency/'+agency.id,
							contentType : 'application/json',
							data : JSON.stringify(agency),
							dataType : 'json',
							success : function(responseData, textStatus, jqXHR) {	
								$('#success').html('Agency has been edited successfully').show();
								$('#error').hide();
							},
							error : function(jqXHR, textStatus, errorThrown) {
								
								$('#error').show();
								$('#success').hide();
							}
						})
					return false;
				}

			});
});

