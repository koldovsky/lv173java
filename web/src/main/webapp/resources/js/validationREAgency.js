	// When the browser is ready...
	$(document)
			.ready(
					function() {

						$.validator.addMethod("regexName", function(value,
								element) {
							return /^[a-zA-Z0-9]+$/.test(value);
						}, "Only letters and numbers are allowed!");

						$.validator
								.addMethod(
										"regexPhoneNumber",
										function(value, element) {
											return /^[+]?\d{2}[\s-]?\d{3}[\s-]?\d{2}[\s-]?\d{2}[\s-]?\d{3}/
													.test(value);
										}, "Length should be 12 digits!");
						
						$.validator
						.addMethod(
								"regexCountry",
								function(value, element) {
									return /[a-zA-Z.\-]/
											.test(value);
								}, "Invalid country");
						
					$.validator
					.addMethod(
							"regexPostalCode",
							function(value, element) {
								return /\d{5}[\s\-]?\d{3,4}/
										.test(value);
							}, "Invalid postal code");

						// Setup form validation on the #register-form element
						$("#myform")
								.validate(
										{

											// Specify the validation rules
											rules : {
												agencyName : {
													required : true,
													minlength : 4,
													regexName : true
												},
												description : {
													required : true,
													minlength : 6
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
													regexCountry:true
												},
												region : {
													regexCountry:true
												},
												postalCode : {
													regexPostalCode:true
												},
												locality : {

												},
												additionalInfo : {

												}

											},
											messages : {
												agencyName : {
													required : "Please enter name of the agency",
													minlength : "Name should be minimum 5 characters"
												},
												description : {
													required : "Please enter your first name",
													minlength : "Your password must be at least 4 characters long"
												},
												phoneNumber : {
													required : "Please enter your first name",
													minlength : "Your password must be at least 4 characters long"
												},
												webSite : {

												},
												country : {

												},
												region : {

												},
												postalCode : {

												},
												locality : {

												},
												additionalInfo : {

												}

											}

										});

					});