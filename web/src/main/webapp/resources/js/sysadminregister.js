// When the browser is ready...
$(document).ready(function() {

	$.validator.addMethod("regexMail", function(value, element) {
		return /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value);
	}, "Invalid email!");

	// Setup form validation on the #register-form element
	$("#sysadminregisterform").validate({
		// Specify the validation rules
		rules : {
			sysadminlogin : {
				required : true,
				minlength : 6,
				maxlength : 60,
				regexMail : true
			}
		},
		messages : {
			sysadminlogin : {
				required : "Please enter new system administrator's login",
				minlength : "Login must be minimum 6 characters long",
				maxlength : "Login must be maximum 60 characters long"
			}
		}

	});
});
$("#sysadminregisterform").submit(function(event) {

	var data = {
		sysadminlogin : $('#sysadminlogin').val()
	};
	var postData = JSON.stringify(data);
	
	$.ajax({
		type : "POST",
		url : "sysadminregister",
		data : postData,
		contentType : "application/json; charset=utf-8",
		success : function(responseData, textStatus, jqXHR) {
			alert("New administrator registered!")
		},
		error : function(jqXHR, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	})
});