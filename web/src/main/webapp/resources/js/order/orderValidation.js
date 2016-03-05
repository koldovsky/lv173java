$(function() {
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
			roomsQuantity : {
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
			additional : {
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
});