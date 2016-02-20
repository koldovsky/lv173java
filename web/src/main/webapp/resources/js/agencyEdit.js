$(document).ready(
		function() {
			
			var href = $(location).attr('href');
			var id = href.substr(href.lastIndexOf('/') + 1);
			
			$('#title').html("Edit Real Estate Agency");
			
			$.ajax({
				type : 'GET',
				url : '/REDplatform/api/agency/'+id,
				dataType : 'json',
				success : function(responseData, textStatus, jqXHR) {
					$('#agencyName').val(responseData.name);
					$('#description').val(responseData.description);
					$('#webSite').val(responseData.site);
					$('#phoneNumber').val(responseData.phone);
					
					$('#country').val(responseData.address.country);
					$('#region').val(responseData.address.region);
					$('#postalCode').val(responseData.address.postalCode);
					$('#locality').val(responseData.address.locality);
					$('#additionalInfo').val(responseData.address.additional);
					
					$('#agencyID').val(responseData.id);
			
				},	
				error : function(jqXHR, textStatus, errorThrown) {

					if (jqXHR.status == 404) {
						$("#error").html('Agency is not found');						
					} 
					$("#error").show();
					$("#success").hide();
				}
			})
			
			$('#register-form').submit(function(event) {
				if ($('#register-form').valid() === true) {
					var address = {
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
							type : "PUT",
							url : '/REDplatform/api/agency/'+id,
							contentType : 'application/json',
							data : JSON.stringify(agency),
							dataType : 'json',
							success : function(responseData, textStatus, jqXHR) {	
								$("#success").html("Agency has been edited successfully");
								$("#success").show();
								$("#error").hide();
							},
							error : function(jqXHR, textStatus, errorThrown) {
								console.log(textStatus+" "+errorThrown)
								console.log(jqXHR.responseText)
								
								$("#error").show();
								$("#success").hide();
							}
						})
					return false;
				}

			});
});

