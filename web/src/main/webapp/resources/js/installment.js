$(function() {
	// apply dynamic padding at the top of the body in order to prevent
	// page content overlap with navbar
	(function() {
		$("body").css("padding-top", $(".navbar-fixed-top").height());
	})();

	var href = $(location).attr('href');
	var id = href.substr(href.lastIndexOf('/') + 1);

	$('#error').hide();
	$('#success').hide();

	$.validator.addMethod('fieldRequired', $.validator.methods.required,
			messageFieldRequired);
	$.validator.addMethod('dateCustom', function(value, element) {
		return /^20\d\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/.test(value);
	}, 'Date should be valid.');
	
	function evalMinDate(dateField, pattern) {
		var prevFieldset = findCurrentFieldset(dateField).prevAll('fieldset').first();
		var minDateVal = 0; //today
		if (prevFieldset.length !== 0) {
			var prevDateField = prevFieldset.find('.date');
			minDateVal = prevDateField.val();
			minDateVal = $.datepicker.parseDate(pattern, minDateVal);
			minDateVal.setDate(minDateVal.getDate() + 1);
		}
		return minDateVal;
	}
	
	function evalMaxDate(dateField, pattern) {
		var nextFieldset = findCurrentFieldset(dateField).nextAll('fieldset').first();
		var maxDateVal = null; //no limit
		if (nextFieldset.length !== 0) {
			var nextDateField = nextFieldset.find('.date');
			maxDateVal = nextDateField.val();
			maxDateVal = $.datepicker.parseDate(pattern, maxDateVal);
			maxDateVal.setDate(maxDateVal.getDate() - 1);
		}
		return maxDateVal;
	}
	
	function findCurrentFieldset(element) {
		return element.parents('fieldset');
	}

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

	$.validator.addMethod('amountCustom', function(value, element) {
		return /^[1-9]\d*\.\d\d$/.test(value);
	}, 'Amount should be valid.');

	$.validator.addClassRules('data', {fieldRequired : true});
	$.validator.addClassRules('date', {dateCustom : true});
	$.validator.addClassRules('amount', {amountCustom : true});

	$('#installment-form').validate({
		errorClass : 'text-danger'
	});

	var template = $.validator.format($('#template').html());
	function addInstallmentItemFieldsAfter(element) {
		var fieldset = $(template(++itemCount));
		fieldset.insertAfter(element);
	}

	var itemCount = 0;
	addInstallmentItemFieldsAfter($('#installment-form').children().last());
	$('#add-more').click(function() {
		if ($('#installment-form').valid()) {
			addInstallmentItemFieldsAfter($(this).parents('#controls-container'));
		}
	});

	$(this).on('keydown', '.fields', function() {
		$('#controls-container').insertAfter($(this));
		if ($('#installment-form fieldset.fields').length > 1) {
			$('#delete-item').attr('style', 'display: inline');
		} else {
			$('#delete-item').attr('style', 'display: none');
		}
	});

	$(this).on('click', '#delete-item', function() {
		var fieldset = $(this).parents('#controls-container').prev();
		fieldset.remove();
		$('.fields').last().trigger('keydown');
	});

	$('#submit-data').click(function() {
		if ($('#installment-form').valid()) {

			function collectInstallmentData() {
				var installment = [];
				var i = 0;
				var $fieldsets = $('#installment-form').find('fieldset');
				$fieldsets.each(function() {
					var $inputs = $(this).find('input');
					installment[i] = {};
					$inputs.each(function() {
						var name = this.name.replace(/-.*/g, '');
						installment[i][name] = $(this).val();
					});
					++i;
				});
				return installment;
			}

			var postData = JSON.stringify(collectInstallmentData());

			$.ajax({
				type : 'POST',
				url : id,
				data : postData,
				contentType : 'application/json; charset=utf-8',
				success : function(responseData, textStatus, jqXHR) {
					$('#error').hide;
					$('#success').show();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					if (jqXHR.status === 400) {
						if (jqXHR.responseText !== "") {
							$("#error").text(jqXHR.responseText);
						}
					}
					$('#success').hide();
					$('#error').show();
				}
			});
			return false;
		}
	});
});