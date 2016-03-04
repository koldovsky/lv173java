// When the browser is ready...
$(document).ready(function() {
	$('.alert .close').on('click', function(e) {
	    $(this).parent().hide();
	});
	
	var hideMessages = function(){
		$('#error').hide();
		$('#success').hide();
	}
	hideMessages();
	
	$.validator.addMethod('description', function(value, element) {
		return regexDescription.test(value);
	}, 'Invalid description!');

	$.validator.addMethod('validGeographicalName', function(value, element) {
		return regexCountry.test(value);
	}, messageCountryIncorrect);

	$.validator.addMethod('validRegion', function(value, element) {
		return this.optional(element) || regexCountry.test(value);
	}, messageRegionIncorrect);

	$.validator.addMethod('validPostalCode', function(value, element) {
		return regexPostalCode.test(value);
	}, messagePostalCodeIncorrect);

	$.validator.addMethod('validAdditional', function(value, element) {
		return regexAdditional.test(value);
	}, messageAddressIncorrect);
	
	var href = $(location).attr('href');
	var id = href.substr(href.lastIndexOf('/') + 1);


	// Setup form validation on the #register-form element
	$('#orderform').validate({
		errorClass: 'text-danger',
		// Specify the validation rules
		rules : {
			
			description : {
				required : true,
				minlength : 1,
				maxlength : 400,
				description : true
			},
			area : {
				required : true,
				minlength : 1,
				maxlength : 10,
				number : true
			},
			roomNumber : {
				required : true,
				minlength : 1,
				maxlength : 3,
				digits : true
			},
			country : {
				required : true,
				validGeographicalName : true,
				minlength : 2
			},
			region : {
				validRegion : true,
				minlength : 2
			},
			postalCode : {
				required : true,
				validPostalCode : true,
				minlength : 3,
				maxlength : 10
			},
			locality : {
				required : true,
				validGeographicalName : true,
				minlength : 2
			},
			address : {
				required : true,
				minlength : 2,
				validAdditional : true
			}
			
		},
		messages : {
			area : {
				number : 'Only valid numbers allowed!'
			}
			
		}

	});
	$('#submit-data').click(function(event) {
		if ($('#orderform').valid()) {
			hideMessages();
			var address = {
					country : $('#country').val(),
					region : $('#region').val(),
					postalCode : $('#postalCode').val(),
					locality : $('#locality').val(),
					additional : $('#address').val()
				}

			var data = {
				description : $('#description').val(),
				area : $('#area').val(),
				roomsQuantity : $('#roomsQuantity').val(),
				address : address
			};
			var postData = JSON.stringify(data);

			$.ajax({
				type : 'POST',
				url : redirecturl + '/api/order/' + id,
				data : postData,
				contentType : 'application/json; charset=utf-8',
				success : function(responseData, textStatus, jqXHR) {
						var redirect = redirecturl;
						redirect += "/installment/";
						redirect += responseData.id;
						window.location.assign(redirect);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$('#error').text('Failed to add new order');
					$('#error').show();		
				}
				
			})
			return false;
		}
	});
});
