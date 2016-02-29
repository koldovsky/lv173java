var regexName = /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]+[a-zA-Z0-9!.@&$():,-\s\']+[a-zA-Z0-9.!)\'\s]$/i;
var regexDescription = /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]+[a-zA-Z0-9!.\[\]@&#%+=;:?\/,-\s\'$%^*()<>№"]+[a-zA-Z0-9.!\])\s:;]$/i;
var regexPhoneNumber = /^[+]?\d{10,12}$/i;
var regexPhoneUkraine = /^(?:\+38)?(?:0\d\d)\d{7}$/;
var regexCountry = /^(?=.*[a-zA-Z])[a-zA-Z.\-,\' ]+$/i;
var regexRegion = /^(?=.*[a-zA-Z])[a-zA-Z.\-,\' ]+$/i;
var regexPostalCode = /^(?=.*[0-9])[a-zA-Z0-9]{3,10}$/i;
var regexAdditional = /^(?=.*[a-zA-Z])[a-zA-Z0-9.:\-'\\\/,\s\[\]]+$/i;
var regexNameUser = /^[A-Z][A-Z ,.-]{0,}$/i;
var regexMail = /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i;
var regexIndividualTaxNumber = /^[0-9]{9,10}$/;
var regexPassport = /^((?=[A-Z])([A-Z0-9]){2}|([0-9]){2})[0-9]{6,7}$/;
var mailAvailabilityCheckParams = {
	url: 'checkmail',
	type: 'GET'
};
var messageMailTaken = 'This e-mail is already taken.';
var messageNameUserIncorrect = 'Name should be correct.';
var messageMailIncorrect = 'E-mail should be valid.';
var messageFieldRequired = 'Field is required.';
var messagePhoneIncorrect = 'Phone number should be valid.';
	
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