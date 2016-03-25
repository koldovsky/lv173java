$(function() {
    var orderId;
    var table = $('#table')
	    .DataTable(
		    {
			ajax : {
			    url : 'api/orderlist',
			    dataSrc : '',
			    dateType : 'json',
			    type : 'GET'
			},

			columnDefs : [
				{
				    'targets' : 'id',
				    'data' : 'id',
				    'render' : function(data, type, row) {
					orderId = data;
					return data;
				    },
				    'visible' : false
				},
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
				    'targets' : 'agency',
				    'data' : 'agency'
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
				    'render' : function(data, type, row, meta) {
					var progress = Math
						.round(row['progress'] * 100);
					return '<div class="progress">'
						+ '<div class="progress-bar progress-bar-success" role="progressbar" aria-valuemin="0"'
						+ 'aria-valuemax="100" aria-valuenow="'
						+ progress + '" style="width:'
						+ progress + '%">' + progress
						+ '%' + '</div>' + '</div>';
				    }
				}

			]
		    });
    $('#table tbody').on('click', 'tr', function() {
	document.location.href = 'statistics/order/' + orderId + '/payments';
    });
});