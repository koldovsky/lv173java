$(function() {
	var template = $.validator.format($('#template').html());
	function addInstallmentItemFieldsAfter(element) {
		var installment = $(template(++itemCount));
		installment.insertAfter(element);
	}

	var itemCount = 0;
	addInstallmentItemFieldsAfter($('#installmentform').children().first());
	$('#add-more').click(function() {
		if ($('#installmentform').valid()) {
			addInstallmentItemFieldsAfter($(this).parents('#controls-container'));
		}
	});
	
	$('#delete-item').click(function() {
		var installment = $(this).parents('#controls-container').prev();
		installment.remove();
		$('.fields').last().trigger('keydown');
	});

	$(this).on('keydown', '.fields', function() {
		$('#controls-container').insertAfter($(this));
		if ($('#installmentform div.fields').length > 1) {
			$('#delete-item').attr('style', 'display: inline');
		} else {
			$('#delete-item').attr('style', 'display: none');
		}
	});
	
	$(this).on('focus', '.date', function() {
		var pattern = 'yy-mm-dd';
		var minDateVal = evalMinDate($(this), pattern);
		var maxDateVal = evalMaxDate($(this), pattern);
		
		$(this).datepicker({
			dateFormat : pattern,
			minDate : minDateVal,
			maxDate : maxDateVal
		});
	});
});