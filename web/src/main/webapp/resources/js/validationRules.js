var ruleMail = {
		regexp : /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i,
		message: 'E-mail should be valid.'
};
var ruleUserName = {
		regexp : /^(?:[A-Z]+(['-\s]|\.\s[A-Z]|,\s[A-Z])?)+$/i,
		message: 'Name should be correct.'
};
var ruleMoneyAmount = {
		regexp : /^[1-9]\d*\.\d\d$/,
		message: 'Amount should be correct.'
};
var ruleMailAvailability = {
		params: {
			url: redirecturl + '/checkmail',
			type: 'GET'
		},
		message: 'This e-mail is already taken.'
};
var rulePhoneUkraine = {
		regexp : /^(?:\+38)?(?:0\d\d)\d{7}$/,
		message: 'Please, enter a real phone number '
			+ 'starting with a subzone/provider code.' 
			+ 'You may add +38 at the beginning.'
};
var ruleFieldRequired = {
		message: 'Field is required'
};