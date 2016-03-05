$(function() {
	var template = $.validator.format($('#template').html());
	function addInstallmentAfter(element) {
		var installment = $(template(++itemCount));
		installment.insertAfter(element);
		return installment;
	}

	var itemCount = 0;
	var firstFieldset = addInstallmentAfter($('#installmentform').children().first());
	hideDeleteButton.call(firstFieldset);
	
	$(this).on('click', '.add-more', function() {
		if ($('#installmentform').valid()) {
			var currentFieldset = $(this).parents('.fields');
			addInstallmentAfter(currentFieldset);
			showDeleteButton.call(currentFieldset);
		}
	});
	
	function showDeleteButton() {
		$(this).find('.delete-item').attr('style', 'display: inline');
	}
	
	function hideDeleteButton() {
		$(this).find('.delete-item').attr('style', 'display: none');
	}
	
	$(this).on('click', '.delete-item', function() {
		var currentFieldset = $(this).parents('.fields');
		currentFieldset.remove();
		var fieldsets = $('#installmentform div.fields');
		if (fieldsets.length === 1) {
			hideDeleteButton.call(fieldsets);
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