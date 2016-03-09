$(function() {
    $("#currency-form").validate({
        rules: {
        	errorClass: 'text-danger',
            amount: {
				required: true,
				amount: true
			},
			from:{
				required: true
			},
			to:{
				required: true
			}
        },
        messages: {
			amount: {
				required: "Please provide an amount"
			},
			from: {
				required: "Please fill the date"
			},
			to: {
				required: "Please fill the date"
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