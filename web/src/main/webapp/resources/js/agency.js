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

			$('#register-form')
					.validate(
							{ 							
								errorClass: 'text-danger',
								rules : {
									agencyName : {
										required : true,
										minlength : 3,
										maxlength : 100,
										regexName : true,
										regexDoubleSpace : true,
										remote: {
											url: 'checkName',
											type: 'GET'
										}										
									},
									description : {
										required : true,
										minlength : 4,
										maxlength : 400,
										regexDescription : true
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
										regexAdditional : true,
										regexDoubleSpace : true
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
										regexRegion : 'Invalid region!'
									},
									postalCode : {
										required : 'Please enter postal code'
									},
									locality : {
										required : 'Please enter city or village',
										regexCountry : 'Invalid city name!'
									},
									additionalInfo : {
										required : 'Please enter address',
										regexDoubleSpace : 'Invalid address!'
									}
								}
							});

		});
