$(function() {
	// apply dynamic padding at the top of the body in order to prevent 
	// page content overlap with navbar 
	(function() {
		  $("body").css("padding-top", $(".navbar-fixed-top").height());
		})();
});