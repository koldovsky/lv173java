$(document).ready(function() {
	$('#register-form').validate();


    $('#agencyName').each(function () {
        $(this).rules('add', {
        	uniqueCompanyName : true
        });
    });
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
		type : "POST",
		url : "create",
		contentType : "application/json",
		data : JSON.stringify(agency),
		success : function(responseData, textStatus, jqXHR) {
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
