$(function() {

	$('#formContainer form:first-child').fadeIn('slow');

	function changeForms(button) {
		findParentForm(button).fadeOut('slow', function() {
			var fadeInForm;
			if (button.hasClass('prev')) {
				fadeInForm = $(this).prevAll('form').first();
			} else {
				fadeInForm = $(this).nextAll('form').first();
			}
			fadeInForm.fadeIn('slow');
		});
	}

	function findParentForm(element) {
		return element.parents('form');
	}

	$('.prev').click(function() {
		changeForms($(this));
	});

	$('.next').click(function() {
		if (findParentForm($(this)).valid()) {
			changeForms($(this));
		}
	});

});