var regexName = /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]+[a-zA-Z0-9!.@&$():,-\s\']+[a-zA-Z0-9.!)\'\s]$/i;
var regexDescription = /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]+[a-zA-Z0-9!.\[\]@&#%+=;:?\/,-\s\'$%^*()<>№"]+[a-zA-Z0-9.!\])\s:;]$/i;
var regexPhoneNumber = /^[+]?\d{10,12}$/i;
var regexCountry = /^(?=.*[a-zA-Z])[a-zA-Z.\-,\'\s]+$/i;
var regexPostalCode = /^(?=.*[0-9])[a-zA-Z0-9]{3,10}$/i;
var regexAdditional = /^(?=.*[a-zA-Z])[a-zA-Z0-9.:()\-'\\\/,\s\[\]]+$/i;
var regexMailCustom = /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i;
var regexNameCustom = /^[A-Z][A-Z ,.-]{0,}$/i;
var regexMail = /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i;
var regexIndividualTaxNumber = /^[0-9]{9,10}$/;
var regexPassport = /^((?=[A-Z])([A-Z0-9]){2}|([0-9]){2})[0-9]{6,7}$/;

	$.validator.addMethod('mailCustom', function(value, element) {
			return /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i.test(value);
	}, 'Email should be valid.');
	
	$.validator.addMethod('nameCustom', function(value, element) {
			return /^[A-Z][A-Z ,.-]{0,}$/i.test(value);
	}, 'Name should be correct.');
	
	$.validator.addMethod('regexMail', function(value, element) {
		return /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i.test(value);
	}, 'The e-mail should be valid!');
	
	$.validator.addMethod('regexIndividualTaxNumber', function(value, element) {
		return /^[0-9]{9,10}$/.test(value);
	}, 'Invalid individual tax number');
	
	$.validator.addMethod('regexPassport', function(value, element) {
		return /^((?=[A-Z])([A-Z0-9]){2}|([0-9]){2})[0-9]{6,7}$/.test(value);
	}, 'Invalid passport number');