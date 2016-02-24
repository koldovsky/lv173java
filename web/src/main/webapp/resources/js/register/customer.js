$(document).ready(function() {
	
	$('.alert .close').on('click', function(e) {
	    $(this).parent().hide();
	});

	$('#success').hide();
	$('#error').hide();

	$('#customer-form').validate({
		errorClass : 'text-danger',
		rules : {
			mail : {
				required : true,
				minlength : 6,
				maxlength : 60,
				regexMail: true,
				remote : {
					url : 'checkmail',
					type : 'GET'
				}
			}
		},
		messages : {
			mail : {
				required : 'Please enter email',
				minlength : 'Email must be minimum 6 characters long',
				maxlength : 'Email must be maximum 60 characters long',
				regexMail : 'Invalid email',
				remote : 'This email is already registered'
			}
		} 
	});
	
});