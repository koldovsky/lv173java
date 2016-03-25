$(document).ready(function() {

	var href = $(location).attr('href');
	href = href.substr(href.lastIndexOf('order/') + 6);
	var id = href.substr(0, href.lastIndexOf('/payments'));
	
	$.ajax({
		type : 'GET',
		url : context + '/api/statistics/order/' + id + '/payments',
		dataType : 'json',
		success : function(responseData, textStatus, jqXHR) {
			$('#apartmentPrice').html(responseData.apartmentPrice);
			$('#totalPaidAmount').html(responseData.totalPaidAmount);
			$('#leftPayAmount').html(responseData.leftPayAmount);
			var progress = responseData.progress.toFixed(2);
			if (progress >= 99.99) {
				$('#progress').prop('class','progress-bar progress-bar-success');
			}
			if (progress < 0.01) {
				$('#progress').prop('style','width: 100%;');
				$('#progress').prop('class','progress-bar');
			} else{ 
				$('#progress').prop('style', 'width:' + progress + '%;');
			}
			$('#progress').html(progress + '%');
			if (responseData.nextInstallment){
				$('#next').prop('hidden',false);
				$('#nextDueDate').html(moment(responseData.nextInstallment.date).format('YYYY-MM-DD'));
				$('#nextAmount').html(responseData.nextInstallment.amount);
			}
			if (responseData.missedInstallment){
				$('#missed').prop('hidden',false);
				$('#missedDueDate').html(moment(responseData.missedInstallment.date).format('YYYY-MM-DD'));
				$('#missedAmount').html(responseData.missedInstallment.amount);
				$('#progress').prop('class','progress-bar progress-bar-danger');
			}
			
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
				} ]
			});
			
		},
		error : function(jqHXR, textStatus, errorThrown) {
			$('#container').html(jqHXR.responseText);
		}
	});
	
	
});