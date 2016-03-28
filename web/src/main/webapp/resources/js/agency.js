$(document).ready(
		function() {
			$('.alert .close').on('click', function(e) {
			    $(this).parent().hide();
			});		
		
			$.validator.addMethod('agencyName', function(value, element) {
				return /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]{1}[a-zA-Z0-9!.@&$():,-\s\']+[a-zA-Z0-9.!)\'\s]$/
				                 .test(value);
			}, 'Agency name should be valid.');
		
			$.validator.addMethod('description', function(value, element) {
						return /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]+[a-zA-Z0-9!.\[\]@&#%+=;:?\/,-\s\'$%^*()<>№"]+[a-zA-Z0-9.!\])\s:;]$/
								.test(value);
			}, 'Description should be valid.');
		
			$.validator.addMethod('phoneNumber', function(value, element) {
					return rulePhoneUkraine.regexp.test(value);
			}, rulePhoneUkraine.message);
		
			$.validator.addMethod('country', function(value,	element) {
					return ruleCountry.regexp.test(value);
			}, ruleCountry.message);
			
			$.validator.addMethod('regionValid', function(value, element) {
				return this.optional(element) || ruleRegion.regexp.test(value);
			}, ruleRegion.message);
		
			$.validator.addMethod('postalCode', function(value, element) {
					return rulePostalCode.regexp.test(value);
			}, rulePostalCode.message);
			
			$.validator.addMethod('locality', function(value, element) {
				return ruleLocality.regexp.test(value);
			}, ruleLocality.message);
		
			$.validator.addMethod('additional', function(value,	element) {
					return ruleAdditional.regexp.test(value);
			}, ruleAdditional.message);


			$('#register-form')
					.validate(
							{ 		
								focusCleanup: true,
							    onkeyup: false,
								errorClass: 'text-danger',
								rules : {
									agencyName : {
										required : true,
										minlength : 3,
										maxlength : 100,
										agencyName : true,
										remote: {
											url: context+'/checkName',
											type: 'GET'
										}										
									},
									description : {
										required : true,
										minlength : 4,
										maxlength : 400,
										description : true
									},
									phoneNumber : {
										required : true,
										minlength : 10,
										phoneNumber : true
									},
									webSite : {
										minlength : 6,
										url : true,
										maxlength : 50
									},
									country : {
										required : true,
										country : true,
										minlength : 2
									},
									region : {
										minlength : 2,								
										regionValid : true
									},
									postalCode : {
										required : true,
										postalCode : true,
										minlength : 3,
										maxlength : 10

									},
									locality : {
										required : true,
										locality : true,
										minlength : 2
									},
									additionalInfo : {
										required : true,
										minlength : 2,
										additional : true									
									}

								},
								messages : {
									agencyName : {
										required : 'Please enter name of the agency',
										minlength : 'Name must be minimum 3 characters long',
										maxlength : 'Name must be maximum 100 characters long',
										remote : 'Such agency already exists!'
									},
									description : {
										required : 'Please enter description',
										minlength : 'Description must be at least 4 characters long',
										maxlength : 'Description must be maximum 400 characters long'
									},
									phoneNumber : {
										required : 'Please enter phone number',
										minlength : 'Your phone number must be at least 10 characters long'
									},
									country : {
										required : 'Please enter country'
									},
									postalCode : {
										required : 'Please enter postal code'
									},
									locality : {
										required : 'Please enter city'
									},
									additionalInfo : {
										required : 'Please enter address'
									}
								}
							});			

	});

function printErrors(jqXHR) {
	var responseText = jQuery.parseJSON(jqXHR.responseText);
	$("#error").html("Failed to add agency!<br/>");
    $.each( responseText.fieldErrors, function( index, value ){
    	$("#error").append("<br/>"+value.message);
    });		 
}
