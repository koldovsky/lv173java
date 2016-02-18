// When the browser is ready...
$(document).ready(function() {
	var hideMessages = function(){
		$("#error").hide();
		$("#success").hide();
	}
	hideMessages();

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
			hideMessages();

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
						$("#success").show();
					
					$("#adminregisterform")[0].reset();
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$("#error").text("Failed to add new System Administrator.");
					if(jqXHR.status == 400) {
						if(jqXHR.responseText != ""){
							$("#error").text(jqXHR.responseText);
						}
					} 
					$("#error").show();
					
				}
				
			})
			return false;
		}
	});
});
