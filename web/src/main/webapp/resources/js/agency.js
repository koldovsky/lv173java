$(document).ready(
		function() {
			$('.alert .close').on('click', function(e) {
			    $(this).parent().hide();
			});
			
			var hideMessages = function(){
				$('#error').hide();
				$('#success').hide();
			}
			hideMessages();
			
			$.validator.addMethod('agencyName', function(value, element) {
				return regexName.test(value);
			}, 'Invalid name!');
		
			$.validator.addMethod('description', function(value, element) {
						return regexDescription.test(value);
			}, 'Invalid description!');
		
			$.validator.addMethod('phoneNumber', function(value, element) {
					return regexPhoneNumber.test(value);
			}, 'Invalid phone number!');
		
			$.validator.addMethod('country', function(value,	element) {
					return regexCountry.test(value);
			}, 'Invalid country');
			
			$.validator.addMethod('regionValid', function(value, element) {
					return regexRegion.test(value);
			}, 'Invalid region');
		
			$.validator.addMethod('postalCode', function(value, element) {
					return regexPostalCode.test(value);
			}, 'Invalid postal code');
		
			$.validator.addMethod('additional', function(value,	element) {
					return regexAdditional.test(value);
			}, 'Invalid address');

			
			$('#register-form')
					.validate(
							{ 		
								focusCleanup: true,
							    onkeyup: false,
								errorClass: 'text-danger',
								rules : {
									agencyName : {
										required : true,
										minlength : 3,
										maxlength : 100,
										agencyName : true,
										remote: {
											url: 'checkName',
											type: 'GET'
										}										
									},
									description : {
										required : true,
										minlength : 4,
										maxlength : 400,
										description : true
									},
									phoneNumber : {
										required : true,
										minlength : 10,
										phoneNumber : true
									},
									webSite : {
										minlength : 6,
										url : true,
										maxlength : 50
									},
									country : {
										required : true,
										country : true,
										minlength : 2
									},
									region : {
										regionValid : true,
										minlength : 2
									},
									postalCode : {
										required : true,
										postalCode : true,
										minlength : 3,
										maxlength : 10

									},
									locality : {
										required : true,
										country : true,
										minlength : 2
									},
									additionalInfo : {
										required : true,
										minlength : 2,
										additional : true									
									}

								},
								messages : {
									agencyName : {
										required : 'Please enter name of the agency',
										minlength : 'Name must be minimum 3 characters long',
										maxlength : 'Name must be maximum 100 characters long',
										remote : 'Such agency already exists!'
									},
									description : {
										required : 'Please enter description',
										minlength : 'Description must be at least 4 characters long',
										maxlength : 'Description must be maximum 400 characters long'
									},
									phoneNumber : {
										required : 'Please enter phone number',
										minlength : 'Your phone number must be at least 10 characters long'
									},
									country : {
										required : 'Please enter country'
									},
									region : {
										required : 'Please enter region',
										region : 'Invalid region!'
									},
									postalCode : {
										required : 'Please enter postal code'
									},
									locality : {
										required : 'Please enter city or village',
										country : 'Invalid city name!'
									},
									additionalInfo : {
										required : 'Please enter address'
									}
								}
							});

		});
