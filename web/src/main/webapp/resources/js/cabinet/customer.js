$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url: context + '/api/currentuser',
		success: function (responseData, textStatus, jqHXR){
			$('#edit-customer').prop('href',context + '/customer/' +  responseData.id);	
		}
	});
});