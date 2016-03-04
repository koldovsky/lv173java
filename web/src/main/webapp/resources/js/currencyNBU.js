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
}