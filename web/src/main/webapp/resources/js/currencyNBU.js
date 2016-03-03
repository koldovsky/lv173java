document.getElementById("nbu").addEventListener("click", checkBox);

var xmlhttp = new XMLHttpRequest();
var url = "http://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
var usd = "";

function checkBox() {
    var x = document.getElementById("nbu").checked;
    if (x === true){
    	document.getElementById("nbu").checked = true;
    	setCurrency(usd);
    } else {
    	document.getElementById("nbu").checked = false;
    	document.getElementById("amount").value = "";
    };
}

xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        usd = JSON.parse(xmlhttp.responseText);
    }
};

xmlhttp.open("GET", url, true);
xmlhttp.send();

function setCurrency(arr) {
    var out = "";
    var i;
    for(i = 0; i < arr.length; i++) {
		if(arr[i].cc === "USD"){
        out += arr[i].rate.toFixed(3);
		}
	}
    document.getElementById("amount").value = out;
};