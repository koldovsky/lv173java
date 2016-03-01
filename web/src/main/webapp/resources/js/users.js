$(document).ready(function() {
	var table = $('#table').DataTable({
		processing:true,
		serverSide:true,
		ajax : {
			url : 'api/user',
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
					var date = new Date(row['createdDate']);
					return moment(date).format('YYYY-MM-DD HH:mm:ss');
				}
			}
		]
	});
});