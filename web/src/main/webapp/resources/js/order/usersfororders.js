$(document).ready(function() {
	var table = $('#table').DataTable({
		processing:true,
		serverSide:true,
		ajax : {
			url : context + '/api/customeruserlist',
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
				return moment(date).format('YYYY-MM-DD HH:mm:ss');
				}
			},
			{
				
                "orderable":      false,
                "data":           null,
                "defaultContent": '<button id="idButton" ' +
					'class="btn btn-primary col-sm-offset-2 col-sm-3">Pick user</button>'
             }
			
		]
	});
	
	// Add event listener for opening and closing details
    $('#table tbody').on('click', '#idButton', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
        var id = row['data']().id;
        //TODO: connect id with submit method.
 
    } );
});