$(document).ready(function() {
	var table = $('#table').DataTable({
		processing:true,
		serverSide:true,
		ajax : {
			url : 'user',
			dataSrc: 'aaData',
			dateType:'jsonp',
			type:'GET'
		},
		columns : [
		    {'data' : 'name'},
			{'data' : 'email'},
			{'data' : 'phone'}, 
			{'data' : 'createdDate',
			'render' : function(data,type,row){
					var rowValue = row['createdDate'];
					return new Date(data).toLocaleString();
				}
			}
		]
	});
});