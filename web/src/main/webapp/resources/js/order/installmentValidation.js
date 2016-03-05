$(function() {
	$.validator.addMethod('fieldRequired', $.validator.methods.required,
			ruleFieldRequired.message);

	$.validator.addMethod('amountCustom', function(value, element) {
		return ruleMoneyAmount.regexp.test(value);
	}, ruleMoneyAmount.message);

	$.validator.addClassRules('amount', {amountCustom: true});
	
	$('#installmentform').validate({
		errorClass : 'text-danger',
	});
});