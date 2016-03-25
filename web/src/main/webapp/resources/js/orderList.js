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
				    'targets' : 'paymentStatistics',
				    'orderable' : false,
				    'data' : function(data, type, row) {
					return '<button type="button" class="toPayments btn btn-default btn-sm">Payment Statistics</button>';
				    }
				},
				{
				    'targets' : 'submitPayment',
				    'orderable' : false,
				    'data' : function(data, type, row) {
					return '<button type="button" class="newPayment btn btn-default btn-sm">Submit Payment</button>';
				    }
				}
			]
		    });
    $('#table tbody').on('click', 'button.toPayments', function() {
	document.location.href = 'statistics/order/' + orderId + '/payments';
    });
    $('#table tbody').on('click', 'button.newPayment', function() {
	document.location.href = 'payment';
    });
});