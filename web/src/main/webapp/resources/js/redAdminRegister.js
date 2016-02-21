$(function() {
	// apply dynamic padding at the top of the body in order to prevent 
	// page content overlap with navbar 
	(function() {
		  $("body").css("padding-top", $(".navbar-fixed-top").height());
		})();
	
	$('#error').hide();
	$('#success').hide();
	
	$.validator.addMethod('fieldRequired', 
			$.validator.methods.required, 'Field is required.');
	$.validator.addClassRules('data', { fieldRequired: true });
	
	$.validator.addMethod('mailCustom', function(value, element) {
			return /^[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\.)+[A-Z]{2,}$/i.test(value);
				}, 'Email should be valid.');
	
	$.validator.addMethod('nameCustom', function(value, element) {
			return /^[A-Z][A-Z ,.-]{0,}$/i.test(value);
	}, 'Name should be correct.');
	$.validator.addClassRules('name', { nameCustom: true });
	
	var $form = $('#red-admin-register');
	$form.validate({
	    		errorClass: 'text-danger',
				rules: {
					mail: {
						mailCustom: true,
						remote: {
							url: 'checkmail',
							type: 'GET'
						}
					},
					phone: {
						digits: true
					}
				},
				messages: {
					mail: {
						remote: 'This email is already taken.'
					},
					phone: {
						digits: 'Only digits are allowed.'
					}
				}
			});
	
	$form.submit(function(event) {
		
		if ($form.valid() == true) {
			
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