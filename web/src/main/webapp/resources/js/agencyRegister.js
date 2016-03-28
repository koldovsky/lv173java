$(document).ready(function() {
	$('#register-form').validate();

    
	$('#register-form').submit(function(event) {
		if ($('#register-form').valid()) {
			createAgency();
			return false;
		}

	});
});

function createAgency() {

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
		type : "POST",
		url : "agency",
		contentType : "application/json",
		data : JSON.stringify(agency),
		success : function(responseData, textStatus, jqXHR) {
			$('#register-form')[0].reset();
			$("#success").show();
			$("#error").hide();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			if (jqXHR.status === 400) {
				printErrors(jqXHR);      
			}
			$("#error").show();
			$("#success").hide();
		}
	})
}
