$(document).ready(function() {
	
	$('.alert .close').on('click', function(e) {
	    $(this).parent().hide();
	});

	$('#success').hide();
	$('#error').hide();

	$('#customer-form').validate({
		errorClass : 'text-danger',
		rules : {
			firstName : {
				required : true,
				minlength : 1,
				maxlength :100,
				nameCustom :true
			},
			lastName : {
				required : true,
				minlength : 1,
				maxlength : 100,
				nameCustom : true
			},
			mail : {
				required : true,
				minlength : 6,
				maxlength : 60,
				regexMail: true,
				remote : {
					url : 'checkmail',
					type : 'GET'
				}
			},
			phone : {
				required :true,
				minlength : 10,
				maxlength : 12,
				regexPhoneNumber : true
			},
			passport : {
				required :true,
				minlength : 8,
				maxlength : 9,
				regexPassport : true
			},
			taxNumber : {
				required :true,
				minlength : 9,
				maxlength : 10,
				regexIndividualTaxNumber : true
			},
			country : {
				required : true,
				regexCountry : true,
				minlength : 2
			},
			region : {
				regexRegion : true,
				minlength : 2
			},
			postalCode : {
				required : true,
				regexPostalCode : true,
				minlength : 3,
				maxlength : 10

			},
			locality : {
				required : true,
				regexCountry : true,
				minlength : 2
			},
			address : {
				required : true,
				minlength : 2,
				regexAdditional : true
			}
			
		},
		messages : {
			mail : {
				required : 'Please enter email',
				minlength : 'Email must be minimum 6 characters long',
				maxlength : 'Email must be maximum 60 characters long',
				regexMail : 'Invalid email',
				remote : 'This email is already registered'
			}
		} 
	});
	
	function createCustomer(){
		var address = {
				country : $('#country').val(),
				region : $('#region').val(),
				postalCode : $('#postalCode').val(),
				locality : $('#locality').val(),
				additional : $('#address').val()
		}
		
		var customer = {
				email : $('#mail').val(),
				firstName : $('#firstName').val(),
				lastName : $('#lastName').val(),
				phone : $('#phone').val(),
				passport : $('#passport').val(),
				individualTaxNumber : $('#taxNumber').val(),
				address : address
		}
		
		$.ajax({
			type : 'POST',
			url : 'api/customer',
			contentType : 'application/json; charset=UTF-8',
			data : JSON.stringify(customer),
			success: function(responseData, textStatus, jqXHR) {
				$('#customer-form')[0].reset();
				$('#success').show();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$('#error').show();
			}
		});
	}
	
	$('#customer-form').submit(function(event) {
		if ($('#customer-form').valid()) {
			createCustomer();
		}
	});
	
});