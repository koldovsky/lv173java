$(document).ready(function() {
	var table = $('#table').DataTable({
		processing:true,
		serverSide:true,
		ajax : {
			url : 'api/orderlist',
			dataSrc: 'aaData',
			dateType:'jsonp',
			type:'GET'
		},
	
		columns : [
		    
			{'data' : 'createdDate',
			'render' : function(data,type,row){
					var date = new Date(row['createdDate']);
					return moment(date).format('YYYY-MM-DD');
				}
			},

			{'data' : 'customer.firstName'},
		    {'data' : 'customer.lastName'},
		    {'data' : 'customer.email'},
		    {'data' : 'area'},
		    {'data' : 'roomsQuantity'},
		    {'data' : 'inProgress',
			 'orderable' : false,
			 'render' : function (data, type, row) {
				 	var status;
				 	var labelClass;
				 	if (row['inProgress']) {
				 		status = 'in progress';
				 		labelClass = 'label-info';
				 	} else {
				 		status = 'finished';
				 		labelClass = 'label-success';
				 		}
				 	return '<span class="label ' + labelClass + '">' + status + '</span>';
				 }
		    },
			{
		    	"width" : '5%',
                "orderable":      false,
                "data":           null,
                "defaultContent": '<a href="#" class="details-control btn btn-info btn-sm">Details</a>'
            }
		]
	});
	// Add event listener for opening and closing details
    $('#table tbody').on('click', '.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
});
function format ( data ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Description:</td>'+
            '<td>'+data.description+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Country:</td>'+
            '<td>'+data.address.country+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>City:</td>'+
            '<td>'+data.address.locality+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Address:</td>'+
            '<td>'+data.address.additional+'</td>'
        '</tr>'
    '</table>';
}