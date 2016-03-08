$(function() {
	$.validator.addMethod('validName', function(value, element) {
		return regexPersonName.test(value);
	}, messageNameUserIncorrect);

	$.validator.addMethod('validMail', function(value, element) {
		return regexMail.test(value);
	}, messageMailIncorrect);

	$.validator.addMethod('validPhoneNumber', function(value, element) {
		return regexPhoneNumber.test(value);
	}, messagePhoneIncorrect);

	$.validator.addMethod('validPassport', function(value, element) {
		return regexPassport.test(value);
	}, 'Passport should be valid.');

	$.validator.addMethod('validIndividualTaxNumber', function(value, element) {
		return regexIndividualTaxNumber.test(value);
	}, 'Individual Tax Number should be valid.');

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

	$('#customerform').validate({
		errorClass : 'text-danger',
		rules : {
			firstName : {
				required : true,
				minlength : 1,
				maxlength : 100,
				validName : true
			},
			lastName : {
				required : true,
				minlength : 1,
				maxlength : 100,
				validName : true
			},
			email : {
				required : true,
				minlength : 6,
				maxlength : 60,
				validMail : true,
				remote : {
					url : context + '/checkmail',
					type : 'GET'
				}
			},
			phone : {
				required : true,
				minlength : 10,
				maxlength : 12,
				validPhoneNumber : true
			},
			passport : {
				required : true,
				minlength : 8,
				maxlength : 8,
				validPassport : true
			},
			individualTaxNumber : {
				required : true,
				minlength : 10,
				maxlength : 10,
				validIndividualTaxNumber : true
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
			firstName : {
				validName : 'First name should be correct.'
			},
			lastName : {
				validName : 'Last name should be correct.'
			},
			email : {
				remote : messageMailTaken
			}
		}
	});
});