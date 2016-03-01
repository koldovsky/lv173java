// When the browser is ready...
$(document).ready(function() {
	$('.alert .close').on('click', function(e) {
	    $(this).parent().hide();
	});
	
	var hideMessages = function(){
		$('#error').hide();
		$('#success').hide();
	}
	hideMessages();
	
	$.validator.addMethod('description', function(value, element) {
		return regexDescription.test(value);
		}, 'Invalid description!');
	
	var href = $(location).attr('href');
	var id = href.substr(href.lastIndexOf('/') + 1);


	// Setup form validation on the #register-form element
	$('#orderform').validate({
		errorClass: 'text-danger',
		// Specify the validation rules
		rules : {
			
			description : {
				required : true,
				minlength : 1,
				maxlength : 400,
				description : true
			},
			area : {
				required : true,
				minlength : 1,
				maxlength : 10,
				number : true
			},
			roomNumber : {
				required : true,
				minlength : 1,
				maxlength : 3,
				digits : true
			}
			
		},
		messages : {
			area : {
				number : 'Only valid numbers allowed!'
			}
			
		}

	});
	$('#submit-data').click(function(event) {
		if ($('#orderform').valid()) {
			hideMessages();

			var data = {
				description : $('#description').val(),
				area : $('#area').val(),
				roomsQuantity : $('#roomsQuantity').val()
			};
			var postData = JSON.stringify(data);

			$.ajax({
				type : 'POST',
				url : redirecturl + '/api/order/' + id,
				data : postData,
				contentType : 'application/json; charset=utf-8',
				success : function(responseData, textStatus, jqXHR) {
						var redirect = redirecturl;
						redirect += "/installment/";
						redirect += responseData.id;
						window.location.assign(redirect);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$('#error').text('Failed to add new order');
					$('#error').show();		
				}
				
			})
			return false;
		}
	});
});
