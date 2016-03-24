$(function() {
    var table = $('#table')
	    .DataTable(
		    {
			processing : true,
			serverSide : true,
			ajax : {
			    url : 'api/orderlist',
			    dataSrc : 'aaData',
			    dateType : 'jsonp',
			    type : 'GET'
			},

			columnDefs : [
				{
				    'targets' : 'createdDate',
				    'data' : 'createdDate',
				    'render' : function(data, type, row) {
					var date = new Date(row['createdDate']);
					return moment(date)
						.format('YYYY-MM-DD');
				    }
				},
				{
				    'targets' : 'firstName',
				    'data' : 'customer.firstName'
				},
				{
				    'targets' : 'lastName',
				    'data' : 'customer.lastName'
				},
				{
				    'targets' : 'email',
				    'data' : 'customer.email'
				},
				{
				    'targets' : 'country',
				    'data' : 'address.country'
				},
				{
				    'targets' : 'locality',
				    'data' : 'address.locality'
				},
				{
				    'targets' : 'additional',
				    'data' : 'address.additional'
				},
				{
				    'targets' : 'status',
				    'data' : 'status',
				    'orderable' : false,
				    'render' : function(data, type, row) {
					var status;
					var labelClass;
					if (row['status'] === 'IN_PROGRESS') {
					    status = 'in progress';
					    labelClass = 'label-info';
					} else if (row['status'] === 'MISSED_FULFILLMENT') {
					    status = 'missed fulfillment';
					    labelClass = 'label-danger';
					} else {
					    status = 'finished';
					    labelClass = 'label-success';
					}
					return '<span class="label '
						+ labelClass + '">' + status
						+ '</span>';
				    }
				},
				{
				    'targets' : 'progress',
				    'data' : 'progress',
				    'orderable' : false,
				    'render' : function(data, type, row) {
					var progress = Math
						.round(row['progress'] * 100);
					return '<div class="progress">'
						+ '<div class="progress-bar progress-bar-success" role="progressbar" aria-valuemin="0"'
						+ 'aria-valuemax="100" aria-valuenow="'
						+ progress + '" style="width:'
						+ progress + '%">' + progress
						+ '%' + '</div>' + '</div>'
				    }
				}

			]
		    });
    // Add event listener for opening and closing details
    $('#table tbody').on('click', 'tr', function() {
	var row = table.row($(this));

	if (row.child.isShown()) {
	    // This row is already open - close it
	    row.child.hide();
	    $(this).removeClass('shown');
	} else {
	    // Open this row
	    row.child(format(row.data())).show();
	    $(this).addClass('shown');
	}
    });
});
function format(data) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'
	    + '<tr>'
	    + '<td>Area:</td>'
	    + '<td>'
	    + data.area
	    + '</td>'
	    + '</tr>'
	    + '<tr>'
	    + '<td>Rooms Quantity:</td>'
	    + '<td>'
	    + data.roomsQuantity
	    + '</td>'
	    + '</tr>'
	    + '<tr>'
	    + '<td>Description:</td>'
	    + '<td>'
	    + data.description
	    + '</td>'
	    + '</tr>'
    '</table>';
}