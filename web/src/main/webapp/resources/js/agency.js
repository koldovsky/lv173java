$(document).ready(
		function() {
			$('.alert .close').on('click', function(e) {
			    $(this).parent().hide();
			});
						
			$.validator.addMethod('agencyName', function(value, element) {
				return regexName.test(value);
			}, 'Agency name should be valid.');
		
			$.validator.addMethod('description', function(value, element) {
						return regexDescription.test(value);
			}, 'Description should be valid.');
		
			$.validator.addMethod('phoneNumber', function(value, element) {
					return regexPhoneNumber.test(value);
			}, messagePhoneIncorrect);
		
			$.validator.addMethod('country', function(value,	element) {
					return regexCountry.test(value);
			}, messageCountryIncorrect);
			
			$.validator.addMethod('regionValid', function(value, element) {
				return this.optional(element) || regexCountry.test(value);
			}, messageRegionIncorrect);
		
			$.validator.addMethod('postalCode', function(value, element) {
					return regexPostalCode.test(value);
			}, messagePostalCodeIncorrect);
		
			$.validator.addMethod('additional', function(value,	element) {
					return regexAdditional.test(value);
			}, messageAddressIncorrect);

			
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
										minlength : 2,								
										regionValid : true
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
									postalCode : {
										required : 'Please enter postal code'
									},
									locality : {
										required : 'Please enter city',
										country : messageLocalityIncorrect
									},
									additionalInfo : {
										required : 'Please enter address'
									}
								}
							});

		});
