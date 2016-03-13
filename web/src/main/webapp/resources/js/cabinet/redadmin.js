$(document).ready(function(){
	$.ajax({
		type: 'GET',
		url: context + '/api/agencyId',
		success: function (responseData, textStatus, jqHXR){
			var link = $("a#agencyEdit").attr("href");
			$("a#agencyEdit").attr("href", link + responseData);
		}
	});
});