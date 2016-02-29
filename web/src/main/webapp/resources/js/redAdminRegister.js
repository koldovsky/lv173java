$(function() {
	// apply dynamic padding at the top of the body in order to prevent 
	// page content overlap with navbar 
	(function() {
		  $("body").css("padding-top", $(".navbar-fixed-top").height());
		})();
	
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
					mail: {
						mailCustom: true,
						remote: mailAvailabilityCheckParams
					},
					phone: {
						phoneCustom: true
					}
				},
				messages: {
					mail: {
						remote: messageMailTaken
					}
				}
			});
	
	$form.submit(function(event) {
		
		if ($form.valid()) {
			
			var info = {
					email: $('#mail').val(),
					firstName: $('#first-name').val(),
					lastName: $('#last-name').val(),
					phone: $('#phone').val(),
					agencyId: $('#agency-drop-down').val()
			}
			
			var postData = JSON.stringify(info);
		
		$.ajax({
			type: 'POST',
			url: 'redadmin',
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