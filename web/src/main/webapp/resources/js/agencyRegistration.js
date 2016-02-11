// When the browser is ready...
$(document).ready(
			function() {
				$("#navMenu").removeClass("navbar-fixed-top");
				$("#success").hide();
				$("#error").hide();
				$.validator
						.addMethod(
								"regexName",
								function(value, element) {
									return /^(?=.*[a-z])[a-zA-Z0-9 ]+[ !.@&,-]?[ a-zA-Z0-9!.@&,-]+$/
											.test(value);
								}, "Invalid symbol!");

				$.validator
						.addMethod(
								"regexPhoneNumber",
								function(value, element) {
									return /^[+]?\d{2}[\s-]?\d{3}[\s-]?\d{2}[\s-]?\d{2}[\s-]?\d{3}/
											.test(value);
								}, "Length should be 12 digits!");

				$.validator.addMethod("regexCountry", function(value,
						element) {
					return /^[a-zA-Z.\-, ]+$/.test(value);
				}, "Invalid country");

				$.validator.addMethod("regexPostalCode", function(value,
						element) {
					return /^(?=.*[0-9])[a-zA-Z0-9]+[ -]?[a-zA-Z0-9]+$/
							.test(value);
				}, "Invalid postal code");

				$.validator.addMethod("regexAdditional", function(value,
						element) {
					return /^[a-zA-Z0-9.\-,/ ]+$/.test(value);
				}, "Invalid address");

				// Setup form validation on the #register-form element
				$("#register-form")
						.validate(
								{

								// Specify the validation rules
								rules : {
									agencyName : {
										required : true,
										minlength : 3,
										maxlength : 100,
										regexName : true
									},
									description : {
										required : true,
										minlength : 4,
										maxlength : 200,
										regexName : true
									},
									phoneNumber : {
										required : true,
										minlength : 8,
										regexPhoneNumber : true
									},
									webSite : {
										minlength : 6,
										url : true
									},
									country : {
										required : true,
										regexCountry : true,
										minlength : 2
									},
									region : {
										required : true,
										regexCountry : true,
										minlength : 2
									},
									postalCode : {
										required : true,
										regexPostalCode : true,
										minlength : 3,
										maxlength : 10

									},
									locality : {
										required : true,
										regexCountry : true,
										minlength : 2
									},
									additionalInfo : {
										required : true,
										minlength : 2,
										regexAdditional : true
									}

								},
								messages : {
									agencyName : {
										required : "Please enter name of the agency",
										minlength : "Name must be minimum 3 characters long",
										maxlength : "Name must be maximum 100 characters long"
									},
									description : {
										required : "Please enter description",
										minlength : "Description must be at least 4 characters long",
										maxlength : "Description must be maximum 200 characters long"
									},
									phoneNumber : {
										required : "Please enter phone number",
										minlength : "Your phone number must be at least 4 characters long"
									},
									country : {
										required : "Please enter country"
									},
									region : {
										required : "Please enter region"
									},
									postalCode : {
										required : "Please enter postal code"
									},
									locality : {
										required : "Please enter city or village"
									},
									additionalInfo : {
										required : "Please enter address"
									}
									}

								});

			function searchViaAjax() {
				
				var address = {
					country : $('#country').val(),
					region : $('#region').val(),
					postalCode : $('#postalCode').val(),
					locality : $('#locality').val(),
					additional : $('#additionalInfo').val()
				};

				var agency = {
					name : $('#agencyName').val(),
					description : $('#description').val(),
					site : $('#webSite').val(),
					phone : $('#phoneNumber').val(),
					address : address
				};

				$.ajax({
					type : "POST",
					url : "registerAgency",
					contentType : "application/json; charset=utf-8",
					data : JSON.stringify(agency),
					success : function(responseData, textStatus, jqXHR) {
						$('#register-form')[0].reset();
						$("#success").show();
					},
					error : function(jqXHR, textStatus, errorThrown) {
						$("#error").show();
					}
				})
			}
			
			
				
			$("#register-form").submit(function(event) {
				event.preventDefault();
				searchViaAjax();
			});
	});

