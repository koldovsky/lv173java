function evalMinDate(dateField, pattern) {
	var prevInstallment = findCurrentInstallment(dateField).prevAll('.fields')
			.first();
	var minDateVal = 0; // today
	if (prevInstallment.length !== 0) {
		var prevDateField = prevInstallment.find('.date');
		minDateVal = prevDateField.val();
		minDateVal = $.datepicker.parseDate(pattern, minDateVal);
		minDateVal.setDate(minDateVal.getDate() + 1);
	}
	return minDateVal;
}

function evalMaxDate(dateField, pattern) {
	var nextInstallment = findCurrentInstallment(dateField).nextAll('.fields')
			.first();
	var maxDateVal = null; // no limit
	if (nextInstallment.length !== 0) {
		var nextDateField = nextInstallment.find('.date');
		maxDateVal = nextDateField.val();
		maxDateVal = $.datepicker.parseDate(pattern, maxDateVal);
		maxDateVal.setDate(maxDateVal.getDate() - 1);
	}
	return maxDateVal;
}

function findCurrentInstallment(element) {
	return element.parents('.fields');
}