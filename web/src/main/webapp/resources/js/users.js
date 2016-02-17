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
			{"data" : "createdDate",
			"render" : function(data,type,row){
					var rowValue = row["createdDate"];
					return new Date(data).toLocaleString();
				}
			}
		]
		

	});
	
});
