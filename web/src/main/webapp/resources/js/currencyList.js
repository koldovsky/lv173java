$(document).ready(function() {
	var table = $('#table').DataTable({
		processing:true,
		serverSide:true,
		ajax : {
			url : 'api/currency',
			dataSrc: 'aaData',
			dateType:'jsonp',
			type:'GET'
		},
		columns : [
		    {'data' : 'amount'}, 
			{'data' : 'fromDate',
			'render' : function(data,type,row){
					var date = new Date(row['fromDate']);
					return moment(date).format('YYYY-MM-DD');
				}
			},
			{'data' : 'toDate',
			'render' : function(data,type,row){
					var date = new Date(row['toDate']);
					return moment(date).format('YYYY-MM-DD');
				}
			}
		]
	});
});