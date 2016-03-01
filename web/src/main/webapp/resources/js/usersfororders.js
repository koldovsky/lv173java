$(document).ready(function() {
	var table = $('#table').DataTable({
		processing:true,
		serverSide:true,
		ajax : {
			url : 'customeruserlist',
			dataSrc: 'aaData',
			dateType:'jsonp',
			type:'GET'
		},
		
		columns : [
		    {'data' : 'firstName'},
		    {'data' : 'lastName'},
			{'data' : 'email'},
			{'data' : 'phone'}, 
			{'data' : 'createdDate',
			'render' : function(data,type,row){
					var date = new Date(row['createdDate']);
					return date.getFullYear() + '-' + (date.getMonth() < 9 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1)
					+ '-' + (date.getDate() < 10 ? '0' + date.getDate() : date.getDate())
					+ ' ' + (date.getHours() < 10 ? '0' + date.getHours() : date.getHours())
					+ ':' + (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes())
					+ ':' + (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds());
				}
			},
			{'data' : 'id',
				'render' : function(data,type,row){
					
					var str='<a href=\''+redirecturl+ '/order/'+data+ '\'class="btn btn-primary btn-xs">Create new order</a>';
					return str;
				}
			}
			
		]
	});
});