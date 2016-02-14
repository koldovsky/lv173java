$(document).ready(
		function() {
			$.ajax({
				type : "GET",
				url : "edit/1",
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
					alert("Error to load agency");
					$("#error").show();
					$("#success").hide();
				}
			})
});

function createOrEdit() {
				
				var address = {
					country : $('#country').val(),
					region : $('#region').val(),
					postalCode : $('#postalCode').val(),
					locality : $('#locality').val(),
					additional : $('#additionalInfo').val()
				};

				var agency = {
					name : $('#agencyName').val(),
					description : $('#description').val(),
					site : $('#webSite').val(),
					phone : $('#phoneNumber').val(),
					address : address
				};

				$.ajax({
					type : "PUT",
					url : "edit/"+$('#agencyID').val(),
					contentType : "application/json",
					data : JSON.stringify(agency),
					dataType : 'json',
					success : function(responseData, textStatus, jqXHR) {
						alert("OK");
						console.log("SUCCESS: ", responseData);
						$('#register-form')[0].reset();
						$("#success").show();
						$("#error").hide();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						$("#error").show();
						$("#success").hide();
					}
				})
}

