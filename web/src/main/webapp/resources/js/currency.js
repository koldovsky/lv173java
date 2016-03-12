$(document).ready(function() {
	
	var dateToday = new Date();
	var dates = $('#from, #to').datepicker({
	    dateFormat:'dd-mm-yy',
		defaultDate: '+1w',
		changeMonth: true,
		numberOfMonths: 1,
		minDate: dateToday,
		onSelect: function(selectedDate) {
			var option = this.id == 'from' ? 'minDate' : 'maxDate',
			instance = $(this).data('datepicker'),
			date = $.datepicker.parseDate(instance.settings.dateFormat || $.datepicker._defaults.dateFormat, selectedDate, instance.settings);
			dates.not(this).datepicker('option', option, date);
		}
	});
	
	$('#success').hide();
	$('#error').hide();
	
	$('.alert .close').click(function(e) {
	    $(this).parent().hide();
	});
	
	$('#currency-form').submit(function(event) {	
		if ($('#currency-form').valid()) {
			addCurrency();
		return false;
		}
	});
	
});

var nbu = false;

function addCurrency() {
	
	var fromDate = new Date($('#from').datepicker('getDate'));
	var toDate = new Date($('#to').datepicker('getDate'));
	
	var currency = {
		amount : $('#amount').val(),
		fromDate : fromDate,
		toDate : toDate,
		nbu: nbu
	};
	
	$.ajax({
		type : 'POST',
		url : 'currency',
		contentType : 'application/json',
		data : JSON.stringify(currency),
		success : function(responseData, textStatus, jqXHR) {
			$('#currency-form')[0].reset();
			$('#success').show();
			$('#error').hide();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$('#error').show();
			$('#success').hide();
		}
	});
};