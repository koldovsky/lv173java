$(document).ready(function() {
	$("#error").hide();
	$("#success").hide();
	
	$.validator.addMethod('fieldRequired', 
			$.validator.methods.required, 'Field is required.');
	$.validator.addMethod('emailCustom', function(value, element) {
			return /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i.test(value);
				}, 'Email should be valid.');
	$.validator.addClassRules('data', { fieldRequired: true });
	
	$.validator.addMethod('nameCustom', function(value, element) {
			return /^[A-Z ,.-]+$/i.test(value);
	}, 'Name should be correct.');
	$.validator.addClassRules('name', { nameCustom: true });
	
	var $form = $('#red-admin-register');
	$form.validate({
				rules: {
					'email-adr': {
						emailCustom: true
						},
					phone: {
						digits: true
					}
				},
				messages: {
					digits: 'Only digits are allowed.'
				}
			});
	
	$form.submit(function(event) {
		
		if ($form.valid() == true) {
			
			var info = {
					email: $('#email-adr').val(),
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
				$('#success').show();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				$('#error').show();
			}
		});
		
		return false;
		}
	})
	
});