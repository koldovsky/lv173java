$(function() {
	$('#error').hide();
	$('#success').hide();
	$('form fieldset:first-child').fadeIn('slow');

	$('.prev').click(function(event) {
		event.preventDefault();
		$(this).parents('fieldset').fadeOut('slow', function() {
			$(this).prev().fadeIn('slow');
		});
	});

	$('.next').click(function(event) {
		event.preventDefault();
		$(this).parents('fieldset').fadeOut('slow', function() {
			$(this).next().fadeIn('slow');
		});
	});
});