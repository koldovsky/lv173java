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
			'Field is required.');
	$.validator.addClassRules('data', {
		fieldRequired : true
	});

	$.validator.addMethod('dateCustom', function(value, element) {
		return /^20\d\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$/.test(value);
	}, 'Date should be valid.');
	$.validator.addMethod('amountCustom', function(value, element) {
		return /^\d+\.\d\d$/.test(value);
	}, 'Amount should be valid.');

	$('.installment-addition').last().validate({
		errorClass : 'text-danger',
		rules : {
			date : {
				dateCustom : true,
			},
			amount : {
				amountCustom : true
			}
		}
	});

	$('#add-more').click(
			function() {
				if ($('.installment-addition').last().valid()) {
					$('.installment-addition').last().clone().appendTo(
							$('#container'));
					$('#controls').appendTo($('#container'));
				}
			});

	$('#submit-data').click(function() {
		if ($('.installment-addition').last().valid()) {
			var info = [];
			var i = 0;
			$('.installment-addition').each(function() {
				var formData = {};
				var $inputs = $(this).find('input');
				$inputs.each(function() {
					formData[this.name] = $(this).val();
				});
				info[i] = formData;
				++i;

			});
			
			var postData = JSON.stringify(info);

			$.ajax({
				type : 'POST',
				url :  id,
				data : postData,
				contentType : 'application/json; charset=utf-8',
				success : function(responseData, textStatus, jqXHR) {
					$('#success').show();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					if (jqXHR.status === 400) {
						if (jqXHR.responseText !== "") {
							$("#error").text(jqXHR.responseText);
						}
					}
					$('#error').show();
				}
			});

			return false;
		}
	});
});