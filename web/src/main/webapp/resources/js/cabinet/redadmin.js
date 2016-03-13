$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url: context + '/api/agencyId',
		success: function (responseData, textStatus, jqHXR){
			console.log( responseData);	
			var link = $("a#agencyEdit").attr("href");
			$("a#agencyEdit").attr("href", link + responseData);
		}
	});
});