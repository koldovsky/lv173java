
	$.validator.addMethod('mailCustom', function(value, element) {
			return /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i.test(value);
				}, 'Email should be valid.');
	
	$.validator.addMethod('nameCustom', function(value, element) {
			return /^[A-Z][A-Z ,.-]{0,}$/i.test(value);
	}, 'Name should be correct.');

	$.validator.addMethod('regexName', function(value, element) {
				return /^(?=.*[a-zA-Z])[a-zA-Z0-9]+[a-zA-Z0-9!.@&,-\s\']+[a-zA-Z0-9.!]$/
						.test(value);
			}, 'Invalid name!');
	
	$.validator.addMethod('regexDoubleSpace', function(value, element) {
		return /^((?!\s\s).)*$/
				.test(value);
	}, 'Invalid name!');
		
	$.validator.addMethod('regexDescription', function(value, element) {
				return /^(?=.*[a-zA-Z])[a-zA-Z0-9]+[\s]?[a-zA-Z0-9!.@&,-\s\'$%^*()<>№"]+[a-zA-Z0-9.!]$/
						.test(value);
			}, 'Invalid description!');

	$.validator.addMethod('regexPhoneNumber', function(value, element) {
			return /^[+]?\d{10,12}$/.test(value);
	}, 'Invalid phone number!');

	$.validator.addMethod('regexCountry', function(value,	element) {
			return /^[a-zA-Z.\-,\' ]+$/.test(value);
		}, 'Invalid country');
	
	$.validator.addMethod('regexRegion', function(value, element) {
			return /[a-zA-Z.\-,\' ]*/.test(value);
		}, 'Invalid region');

	$.validator.addMethod('regexPostalCode', function(value, element) {
			return /^(?=.*[0-9])[a-zA-Z0-9]{3,10}$/
					.test(value);
		}, 'Invalid postal code');

	$.validator.addMethod('regexAdditional', function(value,	element) {
			return /^[a-zA-Z0-9.\-,/' ]+$/.test(value);
		}, 'Invalid address');
	
	$.validator.addMethod('regexMail', function(value, element) {
		return /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i.test(value);
	}, 'The e-mail should be valid!');
	
	$.validator.addMethod('regexIndividualTaxNumber', function(value, element) {
		return /^[0-9]{9,10}$/.test(value);
	}, 'Invalid individual tax number');
	
	$.validator.addMethod('regexPassport', function(value, element) {
		return /^((?=[A-Z])([A-Z0-9]){2}|([0-9]){2})[0-9]{6,7}$/.test(value);
	}, 'Invalid passport number');