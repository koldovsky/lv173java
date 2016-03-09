$(function() {
	$.validator.addMethod('validName', function(value, element) {
		return ruleUserName.regexp.test(value);
	}, ruleUserName.message);
	
	$.validator.addMethod('validMail', function(value, element) {
		return ruleMail.regexp.test(value);
	}, ruleMail.message);
	
	$.validator.addMethod('validPhoneNumber', function(value, element) {
		return rulePhoneUkraine.regexp.test(value);
	}, rulePhoneUkraine.message);
	
	$.validator.addMethod('validPassport', function(value, element) {
		return rulePassport.regexp.test(value);
	}, rulePassport.message);
	
	$.validator.addMethod('validIndividualTaxNumber', function(value, element) {
		return ruleIndividualTaxNumber.regexp.test(value);
	}, ruleIndividualTaxNumber.message);
	
	$.validator.addMethod('validGeographicalName', function(value, element) {
		return ruleGeographicalName.regexp.test(value);
	}, ruleGeographicalName.message);

	$.validator.addMethod('validPostalCode', function(value, element) {
		return rulePostalCode.regexp.test(value);
	}, rulePostalCode.message);

	$.validator.addMethod('validAdditional', function(value, element) {
		return ruleAdditional.regexp.test(value);
	}, ruleAdditional.message);

	$('#customerform').validate({
		errorClass : 'text-danger',
		rules : {
			firstName : {
				required : true,
				minlength : 2,
				maxlength : 100,
				validName : true
			},
			lastName : {
				required : true,
				minlength : 2,
				maxlength : 100,
				validName : true
			},
			email : {
				required : true,
				minlength : 6,
				maxlength : 60,
				validMail : true,
				remote : ruleMailAvailability.params
			},
			phone : {
				required : true,
				minlength : 10,
				maxlength : 13,
				validPhoneNumber : true
			},
			passport : {
				required : true,
				minlength : 8,
				maxlength : 8,
				validPassport : true
			},
			individaulTaxNumber : {
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
				validGeographicalName : true,
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
			firstName : { 
				validName : 'First name should be correct.'
			},
			lastName : {
				validName : 'Last name should be correct.'
			},
			email : {
				remote : ruleMailAvailability.message
			},
			country : {
				validGeographicalName : 'Country should be correct.'
			},
			region : {
				validGeographicalName : 'Region should be correct.'
			},
			locality : {
				validGeographicalName : 'Locality should be correct.'
			}
		}
	});
});