$(document).ready(
		function() {
			
			var href = $(location).attr("href");
			var id = href.substr(href.lastIndexOf('/') + 1);
			
			$('#title').html("Edit Real Estate Agency");
			
			$.ajax({
				type : "GET",
				url : "api/agency/"+id,
				dataType : 'json',
				success : function(responseData, textStatus, jqXHR) {
					alert("ok")
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
					console.log(jqXHR)
					console.log(textStatus+ errorThrown)
					if (jqXHR.status == 404) {
						$("#error").html('Agency is not found');						
					} 
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
					id:	$('#agencyID').val(),
					name : $('#agencyName').val(),
					description : $('#description').val(),
					site : $('#webSite').val(),
					phone : $('#phoneNumber').val(),
					address : address
				};

				$.ajax({
					type : "PUT",
					url : 'edit',
					contentType : "application/json",
					data : JSON.stringify(agency),
					success : function(responseData, textStatus, jqXHR) {	
						$("#success").html(responseData);
						$("#success").show();
						$("#error").hide();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						$("#error").show();
						$("#success").hide();
					}
				})
}

