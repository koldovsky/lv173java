// When the browser is ready...
$(document).ready(function() {
	$("#error").hide();
	$("#error_if_exists").hide();
	$("#success").hide();

	$.validator.addMethod("regexMail", function(value, element) {
		return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value);
	}, "Invalid email!");

	// Setup form validation on the #register-form element
	$("#adminregisterform").validate({
		// Specify the validation rules
		rules : {
			adminregister : {
				required : true,
				minlength : 6,
				maxlength : 60,
				regexMail : true
			}
		},
		messages : {
			adminregister : {
				required : "Please enter new system administrator's login",
				minlength : "Login must be minimum 6 characters long",
				maxlength : "Login must be maximum 60 characters long"
			}
		}

	});
	$("#adminregisterform").submit(function(event) {
		if ($("#adminregisterform").valid() == true) {

			var data = {
				email : $('#adminregister').val()
			};
			var postData = JSON.stringify(data);

			$.ajax({
				type : "POST",
				url : "adminregister",
				data : postData,
				contentType : "application/json; charset=utf-8",
				success : function(responseData, textStatus, jqXHR) {
					$("#error_if_exists").hide();
					$("#error").hide();
					$("#success").hide();
					if (JSON.stringify(responseData) == postData) {
						$("#error_if_exists").show();
					} else {
						$("#success").show();
					}
					$("#adminregisterform")[0].reset();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$("#error").show();
				}
				
			})
			return false;
		}
	});
});
