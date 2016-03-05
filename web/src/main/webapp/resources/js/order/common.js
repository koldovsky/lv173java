$(function() {
	$('#error').hide();
	$('#success').hide();
	$('#formContainer form:first-child').fadeIn('slow');

	function changeForms(button) {
		var parentForm = button.parents('form');
		if (parentForm.valid()) {
			parentForm.fadeOut('slow', function() {
				if (button.hasClass('prev')) {
					$(this).prevAll('form').first().fadeIn('slow');
				} else if (button.hasClass('next')) {
					$(this).nextAll('form').first().fadeIn('slow');
				}
			});
		}
	}

	$('.prev').click(function() {
		changeForms($(this));
	});

	$('.next').click(function() {
		changeForms($(this));
	});
	
});