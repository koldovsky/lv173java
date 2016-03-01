$(document).ready(function() {
	
	$("#success").hide();
	$("#error").hide();
	
	$('.alert .close').click(function(e) {
	    $(this).parent().hide();
	});
	
	$('#currency-form').submit(function(event) {	
		var check = dateValidator();
		if(check === true){
			addCurrency();
		}
			return false;
	});
	
	$('#fromMonth').click(function(event) {
		deleteFromDays();
		setFromDays();
		return false;
});
	
	$('#toMonth').click(function(event) {
		deleteToDays();
		setToDays();
		return false;
});
	
	$('#fromYear').click(function(event) {
		deleteFromDays();
		setFromDays();
		return false;
});
	
	$('#toYear').click(function(event) {
		deleteToDays();
		setToDays();
		return false;
});
	
});

function addCurrency() {
	
	var fromDate = new Date();
	fromDate.setFullYear($('#fromYear').val());
	fromDate.setMonth($('#fromMonth').val()); 
	fromDate.setDate($('#fromDay').val());
	
	var toDate = new Date();
	toDate.setFullYear($('#toYear').val());
	toDate.setMonth($('#toMonth').val()); 
	toDate.setDate($('#toDay').val());
	
	var currency = {
		amount : $('#amount').val(),
		fromDate : fromDate,
		toDate : toDate
	};
	
	$.ajax({
		type : "POST",
		url : "currency",
		contentType : "application/json",
		data : JSON.stringify(currency),
		success : function(responseData, textStatus, jqXHR) {
			$('#currency-form')[0].reset();
			$("#success").show();
			$("#error").hide();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$("#error").show();
			$("#success").hide();
		}
	})
}

function setDate(){
	var year = new Date();
	var minYear = year.getFullYear();
	maxYear = minYear + 4;
		
	var select = document.getElementById('fromYear');
		for (var i = minYear; i<=maxYear; i++){
			var opt = document.createElement('option');
			opt.value = i;
			opt.innerHTML = i;
			select.appendChild(opt);
			};
	
	select = document.getElementById('toYear');
		for (var i = minYear; i<=maxYear; i++){
			var opt = document.createElement('option');
			opt.value = i;
			opt.innerHTML = i;
			select.appendChild(opt);
			};
			
	var month = ['January','February','March','April','May','June','July','August','September','October','November','December'];
	
	select = document.getElementById('fromMonth');
	for (var i = 0; i<12; i++){
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = month[i];
		select.appendChild(opt);
		};
		
	select = document.getElementById('toMonth');
	for (var i = 0; i<12; i++){
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = month[i];
		select.appendChild(opt);
		};
	
		setFromDays();
		setToDays();
		
}

function daysInMonth(month,year) {
	month = month - 47;
    var n = new Date(year, month, 0).getDate();
	return n;
}

function setFromDays(){
	var select = document.getElementById('fromDay');
	var month = document.getElementById('fromMonth').value;
	var year = document.getElementById('fromYear').value;
	var days = daysInMonth(month, year);
	for (var i = 1; i<=days; i++){
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		select.appendChild(opt);
		};
};

function setToDays(){
	var select = document.getElementById('toDay');
	var month = document.getElementById('toMonth').value;
	var year = document.getElementById('toYear').value;
	var days = daysInMonth(month, year);
	for (var i = 1; i<=days; i++){
		var opt = document.createElement('option');
		opt.value = i;
		opt.innerHTML = i;
		select.appendChild(opt);
		};
};

function deleteFromDays(){
	var select = document.getElementById("fromDay");
	while (select.firstChild) {
	    select.removeChild(select.firstChild);
	}
};

function deleteToDays(){
	var select = document.getElementById("toDay");
	while (select.firstChild) {
	    select.removeChild(select.firstChild);
	}
};

function dateValidator(){
	var now = new Date();
	
	var fromDate = new Date();
	fromDate.setFullYear($('#fromYear').val());
	fromDate.setMonth($('#fromMonth').val()); 
	fromDate.setDate($('#fromDay').val());
	
	var toDate = new Date();
	toDate.setFullYear($('#toYear').val());
	toDate.setMonth($('#toMonth').val()); 
	toDate.setDate($('#toDay').val());
	
	if(toDate < fromDate){
		console.log("fromDate is greater than toDate" + fromDate);
		$("#error").show();
		return false;
	} else if (now > fromDate){
		$("#error").show();
		console.log("now is greater than fromDate" + now);
		return false;
	} else {
		return true;
	};
}