$(function() {
	// apply dynamic padding at the top of the body in order to prevent 
	// page content overlap with navbar 
	(function() {
		  $("body").css("padding-top", $(".navbar-fixed-top").height());
		})();
	
	$('.alert .close').click(function() {
	    $(this).parent().hide();
	});
	
	var path = $(location).attr('pathname');
	
	$.validator.addMethod('fieldRequired', 
			$.validator.methods.required, ruleFieldRequired.message);
	$.validator.addClassRules('data', { fieldRequired: true });
	
	$.validator.addMethod('mailCustom', function(value, element) {
			return ruleMail.regexp.test(value);
	}, ruleMail.message);
	
	$.validator.addMethod('nameCustom', function(value, element) {
			return ruleUserName.regexp.test(value);
	}, ruleUserName.message);
	$.validator.addClassRules('name', { nameCustom: true });
	
	$.validator.addMethod('phoneCustom', function(value, element) {
			return rulePhoneUkraine.regexp.test(value);
	}, rulePhoneUkraine.message);
	
	var $form = $('#red-admin-register');
	$form.validate({
	    		errorClass: 'text-danger',
				rules: {
					email: {
						mailCustom: true,
						remote: ruleMailAvailability.params
					},
					phone: {
						phoneCustom: true
					}
				},
				messages: {
					email: {
						remote: ruleMailAvailability.message
					}
				}
			});
	
	$form.submit(function(event) {
		
		if ($form.valid()) {
			var $fields = $form.find('.data');
			var info = {};
			$fields.each(function (){
				info[this.name] = $(this).val();
			});
			
			var postData = JSON.stringify(info);
		
		$.ajax({
			type: 'POST',
			url: path,
			data: postData,
			contentType : 'application/json; charset=utf-8',
			success: function(responseData, textStatus, jqXHR) {
				$('#error').hide();
				$('#success').show();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$('#success').hide();
				$('#error').show();
			}
		});
		
		return false;
		}
	})
	
});