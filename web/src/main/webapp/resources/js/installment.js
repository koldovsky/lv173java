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
	function addInstallmentItemFields() {
		var fieldset = $(template(++itemCount));
		fieldset.appendTo('#installment-form');
	}

	var itemCount = 0;
	addInstallmentItemFields();
	$('#add-more').click(function() {
		if ($('#installment-form').valid()) {
			addInstallmentItemFields();
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
						installment[i][this.name] = $(this).val();
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