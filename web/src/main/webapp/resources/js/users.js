$(document).ready(function() {
	var table = $('#table').DataTable({
		ajax : {
			url : "user",
			dataSrc: "",
			dateType:"jsonp",
			type:"GET"
		},
		columns : [
		    {"data" : "name"},
			{"data" : "email"},
			{"data" : "phone"}, 
			{"data" : "createdDate"}
		]

	});
	
});
