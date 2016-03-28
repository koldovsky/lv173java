// When the browser is ready...
$(document).ready(function() {
	$('.alert .close').on('click', function() {
	    $(this).parent().hide();
	});
	$('#preview').hide();

	
	
	$.validator.addMethod('fieldRequired', $.validator.methods.required,
			ruleFieldRequired.message);

	$.validator.addMethod('amountCustom', function(value, element) {
		return ruleMoneyAmount.regexp.test(value);
	}, ruleMoneyAmount.message);
	
	$.validator.addClassRules('amount', {amountCustom: true});

	// Setup form validation on the #register-form element
	$('#paymentform').validate({
		errorClass: 'text-danger'
	});
	
	var upload = undefined;
	
	$(this).on('focus', '.date', function() {
		var pattern = 'yy-mm-dd';
		var minDateVal = evalMinDate($(this), pattern);
		
		$(this).datepicker({
			dateFormat : pattern,
			altFormat : '@',
			altField : $('#dateSubmit'),
			minDate : minDateVal
		});
	});
	
	$('#paymentform').submit(function(event) {
		if ($('#paymentform').valid()) {

			
			var oMyForm = new FormData();
			oMyForm.append("image", upload);
			oMyForm.append("date", $("#dateSubmit").val());
			oMyForm.append('amount', '123.34');
			oMyForm.append('orderId','131');

			$.ajax({
				url : 'uploadPaymentImage',
				data : oMyForm,
				dataType: 'text',
				type : 'POST',
				processData : false,
				contentType : false,
				success : function(result) {
						console.log(result);
				},
				error : function(result) {
					$('#error').text('Failed to add new System Administrator.');
				}
			});
			return false;
		}
	});
	var readURL= function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            if(validateFile(input.files[0])){
            	reader.onload = function (e) {
                    $('#preview').attr('src', e.target.result);
                }
            	reader.readAsDataURL(input.files[0]);
            	return true;
            }
            
            return false;
            
        }
    }
	var validateFile = function(file){
		if(file.type.search("image*")>=0){
			if(file.name.search(/\.(gif|jpg|jpeg|tiff|png)$/i)>=0) {
				return true;
			}
		}
		return false;
	}
    
    $("#fileupload").change(function(){
        if(readURL(this)){
        var allowedWidth = $('#imgColumn').width();
        var allowedHeight = $('#footer').offset().top - $('#imgColumn').offset().top;
        if($('#preview').height() > allowedHeight){
        	$('#preview').height(allowedHeight);
        }else{
        	$('#preview').width(allowedWidth);
        }
        upload = this.files[0];
        $('#preview').show();
        }else{
        	$('#preview').hide();
        	upload = undefined;
        	$('#messDiv').text('Wrong type of file!');
        	$('#error').show();
        }
    });
});
