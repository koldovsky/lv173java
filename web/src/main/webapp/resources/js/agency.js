// When the browser is ready...
$(document)
.ready(
		function() {
			$('#navMenu').removeClass('navbar-fixed-top');
			$('#success').hide();
			$('#error').hide();

			$.validator.addMethod(
				'regexName',
				function(value, element) {
					return /^(?=.*[a-zA-Z])[a-zA-Z0-9 ]+[ !.@&,-]{0,2}[ a-zA-Z0-9!.@&,-]+$/
							.test(value);
				}, 'Invalid symbol!');
			
			$.validator.addMethod(
				'regexDescription',
				function(value, element) {
					return /^(?=.*[a-zA-Z])[a-zA-Z0-9]+[ !.@&,-]?[ a-zA-Z0-9!.@&,-]+$/
							.test(value);
				}, 'Invalid symbol!');

			$.validator.addMethod(
				'regexPhoneNumber',
				function(value, element) {
					return /^[+]?\d{2}[\s-(]?\d{3}[\s-)]?[\s-]?\d{1}[\s-]?\d{1}[\s-]?\d{1}[\s-]?\d{1}[\s-]?\d{1}[\s-]?\d{1}[\s-]?\d{1,3}$/
							.test(value);
			}, 'Invalid phone number!');

			$.validator.addMethod(
				'regexCountry', 
				function(value,	element) {
					return /^[a-zA-Z.\-,\' ]+$/.test(value);
				}, 'Invalid country');
			
			$.validator.addMethod(
				'regexRegion', 
				function(value,	element) {
					return /[a-zA-Z.\-,\' ]*/.test(value);
				}, 'Invalid region');

			$.validator.addMethod(
				'regexPostalCode',
				function(value, element) {
					return /^(?=.*[0-9])[a-zA-Z0-9]+[ -]?[a-zA-Z0-9]+$/
							.test(value);
				}, 'Invalid postal code');

			$.validator.addMethod(
				'regexAdditional', 
				function(value,	element) {
					return /^[a-zA-Z0-9.\-,/ ]+$/.test(value);
				}, 'Invalid address');

			// Setup form validation on the #register-form element
			$('#register-form')
					.validate(
							{
								// Specify the validation rules
								rules : {
									agencyName : {
										required : true,
										minlength : 3,
										maxlength : 100,
										regexName : true,				
										remote: {
											url: 'checkName',
											type: 'GET'
										}										
									},
									description : {
										required : true,
										minlength : 4,
										maxlength : 400,
										regexName : true
									},
									phoneNumber : {
										required : true,
										minlength : 10,
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
										regexRegion : true,
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
										required : 'Please enter name of the agency',
										minlength : 'Name must be minimum 3 characters long',
										maxlength : 'Name must be maximum 100 characters long',
										remote : 'Such agency already exists'
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
										regexRegion : 'Invalid region'
									},
									postalCode : {
										required : 'Please enter postal code'
									},
									locality : {
										required : 'Please enter city or village',
										regexCountry : 'Invalid city name'
									},
									additionalInfo : {
										required : 'Please enter address'
									}
								}
							});

		});
