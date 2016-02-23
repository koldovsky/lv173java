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
					var date =  row['createdDate'];
					return new Date(date).toISOString().substr(0, 19).replace('T', ' ');
				}
			}
		]
	});
});