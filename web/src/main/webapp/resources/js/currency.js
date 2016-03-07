$(document).ready(function() {
	
	$("#invalidDate").hide();
	
	$('.alert .close').click(function(e) {
	    $(this).parent().hide();
	});
	
	$('#currency-form').submit(function(event) {	
		if ($('#currency-form').valid()) {
		var check = dateValidator();
		if(check === true){
			addCurrency();
		}
		return false;
		}
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

var nbu = false;

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
		toDate : toDate,
		nbu: nbu
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
			$("#invalidDate").hide();
		},
		error : function(jqXHR, textStatus, errorThrown) {
			$("#error").show();
			$("#success").hide();
		}
	});
}

function setDate(){
	var year = new Date();
	var minYear = year.getFullYear();
	maxYear = minYear + 4;
		
	var select = document.getElementById('fromYear');
		for (var i = minYear; i<=maxYear; i++){
			var year = document.createElement('option');
			year.value = i;
			year.innerHTML = i;
			select.appendChild(year);
			};
	
	select = document.getElementById('toYear');
		for (var i = minYear; i<=maxYear; i++){
			var year = document.createElement('option');
			year.value = i;
			year.innerHTML = i;
			select.appendChild(year);
			};
			
	var month = ['January','February','March','April','May','June','July','August','September','October','November','December'];
	
	select = document.getElementById('fromMonth');
	for (var i = 0; i<12; i++){
		var fromMonth = document.createElement('option');
		fromMonth.value = i;
		fromMonth.innerHTML = month[i];
		select.appendChild(fromMonth);
		};
		
	select = document.getElementById('toMonth');
	for (var i = 0; i<12; i++){
		var toMonth = document.createElement('option');
		toMonth.value = i;
		toMonth.innerHTML = month[i];
		select.appendChild(toMonth);
		};
	
		setFromDays();
		setToDays();
		setTodayDate();
		
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
		$("#invalidDate").show();
		return false;
	} else if (now > fromDate){
		$("#invalidDate").show();
		return false;
	} else {
		return true;
	};
};

function setTodayDate(){
	var todayDate = new Date();
	
	var todayMonth = todayDate.getMonth();
	var todayDay = todayDate.getDay();
	
	var toMonth = document.getElementById("toMonth");
	var fromMonth = document.getElementById("fromMonth");
	var toMonthOptions = toMonth.options;
	
	var toDay = document.getElementById("toDay");
	var fromDay = document.getElementById("fromDay");
	var toDayOptions = toDay.options;
	
	for (var i = 0; i < toMonthOptions.length; i++){
		if(i === todayMonth){
			toMonth.selectedIndex = i;
			fromMonth.selectedIndex = i;
		}
	};
	
	for (var i = 1; i < toDayOptions.length; i++){
		if(i === (todayDay-1)){
			toDay.selectedIndex = i-1;
			fromDay.selectedIndex = i-1;
		}
	};
};