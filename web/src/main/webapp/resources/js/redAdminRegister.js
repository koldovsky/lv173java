$(function() {
	// apply dynamic padding at the top of the body in order to prevent 
	// page content overlap with navbar 
	(function() {
		  $("body").css("padding-top", $(".navbar-fixed-top").height());
		})();
	
	var path = $(location).attr('pathname');
	
	$('#error').hide();
	$('#success').hide();
	
	$.validator.addMethod('fieldRequired', 
			$.validator.methods.required, messageFieldRequired);
	$.validator.addClassRules('data', { fieldRequired: true });
	
	$.validator.addMethod('mailCustom', function(value, element) {
			return regexMail.test(value);
	}, messageMailIncorrect);
	
	$.validator.addMethod('nameCustom', function(value, element) {
			return regexNameUser.test(value);
	}, messageNameUserIncorrect);
	$.validator.addClassRules('name', { nameCustom: true });
	
	$.validator.addMethod('phoneCustom', function(value, element) {
			return regexPhoneUkraine.test(value);
	}, messagePhoneIncorrect);
	
	var $form = $('#red-admin-register');
	$form.validate({
	    		errorClass: 'text-danger',
				rules: {
					email: {
						mailCustom: true,
						remote: mailAvailabilityCheckParams
					},
					phone: {
						phoneCustom: true
					}
				},
				messages: {
					email: {
						remote: messageMailTaken
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