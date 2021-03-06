var regexName = /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]+[a-zA-Z0-9!.@&$():,-\s\']+[a-zA-Z0-9.!)\'\s]$/;
var regexDescription = /^(?=.*[a-zA-Z])[a-zA-Z0-9\s]+[a-zA-Z0-9!.\[\]@&#%+=;:?\/,-\s\'$%^*()<>№"]+[a-zA-Z0-9.!\])\s:;]$/;
var regexPhoneNumber = /^[+]?\d{10,12}$/;
var regexPhoneUkraine = /^(?:\+38)?(?:0\d\d)\d{7}$/;
var regexCountry = /^(?=.*[a-zA-Z])[a-zA-Z.\-,\' ]+$/;
var regexRegion = /^(?=.*[a-zA-Z])[a-zA-Z.\-,\' ]+$/;
var regexPostalCode = /^(?=.*[0-9])[a-zA-Z0-9]{3,10}$/;
var regexAdditional = /^(?=.*[a-zA-Z])[a-zA-Z0-9.:\-'\\\/,\s\[\]]+$/;
var regexNameUser = /^[A-Z][A-Z ,.-]{0,}$/i;
var regexMail = /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i;
var regexIndividualTaxNumber = /^\d{10}$/;
var regexPassport = /^[ABCEHIKMOPTX]{2}\d{6}$/;
var regexPersonName= /^[A-Za-z]+([']?[A-Za-z])+([\s'-]?[A-Za-z])*$/;
var mailAvailabilityCheckParams = {
	url: 'checkmail',
	type: 'GET'
};
var regexCurrencyRate = /^\d{1,3}(\.\d{0,6})?$/;
var messageCurrencyIncorrect = 'Incorrect value';
var messageMailTaken = 'This e-mail is already taken.';
var messageNameUserIncorrect = 'Name should be correct.';
var messageMailIncorrect = 'E-mail should be valid.';
var messageFieldRequired = 'Field is required.';
var messagePhoneIncorrect = 'Phone number should be valid.';
var messageCountryIncorrect = 'Country should be valid.';
var messageRegionIncorrect = 'Region should be valid.';
var messagePostalCodeIncorrect = 'Postal code should be valid.';
var messageLocalityIncorrect = 'City should be valid.';
var messageAddressIncorrect = 'Address should be valid.';