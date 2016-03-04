$(function() {
    $("#currency-form").validate({
        rules: {
        	errorClass: 'text-danger',
            amount: {
				required: true,
				minlength: 1,
				amount: true
			}
        },
        messages: {
			amount: {
				required: "Please provide an amount",
				minlength: "Amount must be at least 1 character long"
			}
        }
    });
	
	$.validator.addMethod('amount', function(value, element) {
		return regexCurrencyRate.test(value);
	}, messageCurrencyIncorrect);

  });


document.getElementById("nbu").addEventListener("click", checkBox);

function checkBox() {
    var x = document.getElementById("nbu").checked;
    if (x === true){
    	document.getElementById("nbu").checked = true;
    	document.getElementById("amount").disabled = true;
    	nbu = true;
    } else {
    	document.getElementById("nbu").checked = false;
    	document.getElementById("amount").disabled = false;
    	nbu = false;
    };
};