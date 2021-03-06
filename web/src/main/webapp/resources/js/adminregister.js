// When the browser is ready...
$(document).ready(function() {
	$('.alert .close').on('click', function() {
	    $(this).parent().hide();
	});

	$.validator.addMethod('regexMail', function(value, element) {
		return ruleMail.regexp.test(value);
	}, ruleMail.message);

	// Setup form validation on the #register-form element
	$('#adminregisterform').validate({
		errorClass: 'text-danger',
		// Specify the validation rules
		rules : {
			
			email : {
				required : true,
				minlength : 6,
				maxlength : 60,
				regexMail : true,
				remote: ruleMailAvailability.params
			}
		},
		messages : {
			email : {
				required : 'Please enter new system administrator\'s login',
				minlength : 'Login must be minimum 6 characters long',
				maxlength : 'Login must be maximum 60 characters long',
				remote: ruleMailAvailability.message	
			}
		}

	});
	$('#adminregisterform').submit(function(event) {
		if ($('#adminregisterform').valid()) {

			var data = {
				email : $('#email').val()
			};
			var postData = JSON.stringify(data);

			$.ajax({
				type : 'POST',
				url : 'adminregister',
				data : postData,
				contentType : 'application/json; charset=utf-8',
				success : function(responseData, textStatus, jqXHR) {
						$('#success').show();
						$('#adminregisterform')[0].reset();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$('#error').text('Failed to add new System Administrator.');
					$('#error').show();
					
				}
				
			})
			return false;
		}
	});
});
