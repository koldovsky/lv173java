$(document).ready(function() {
	table = $('#table').DataTable({
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
                "defaultContent": '<button type="submit" id="idButton" ' +
					'class="submitButton btn btn-primary">Pick user</button>'
             }
			
		]
	});
	
	// Add event listener for opening and closing details
    $('#table tbody').on('submit', '#idButton', function () {
        $('#idButton').trigger('click');
    } );
});
