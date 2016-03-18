$(document).ready(function() {

	var href = $(location).attr('href');
	href = href.substr(href.lastIndexOf('order/') + 6);
	var id = href.substr(0, href.lastIndexOf('/payments'));
	$('#table').DataTable({
		searching : false,
		ordering : false,
		paging : false,
		scrollY : '380px',
		info : false,
		scrollCollapse : true,
		ajax : {
			url : context + '/api/order/' + id + '/payments',
			dataSrc : '',
			dateType : 'json',
			type : 'GET'
		},
		columns : [ {
			'data' : 'createdDate',
			"sClass" : "center",
			'render' : function(data, type, row) {
				var date = new Date(row['createdDate']);
				return moment(date).format('YYYY-MM-DD');
			}
		}, {
			'data' : 'amount',
			"sClass" : "center",
		}, {
			'data' : 'currencyRate.amount',
			"sClass" : "center",
		}, {
			'data' : 'amoutAccordingToRate',
			"sClass" : "center",
			"width" : '30%'
		} ]
	});

	$.ajax({
		url : context + '/api/statistics/order/' + id + '/payments',
		success : function(responseData, textStatus, jqXHR) {
			$('#apartmentPrice').html(responseData.apartmentPrice);
			$('#totalPaidAmount').html(responseData.totalPaidAmount);
			$('#leftPayAmount').html(responseData.leftPayAmount);
			var progress = responseData.progress.toFixed(2);
			$('#progress').html(progress + '%');
			$('#progress').prop('style', 'width:' + progress + '%;')
		}
	});
});