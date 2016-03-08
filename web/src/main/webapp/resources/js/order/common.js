$(function() {

	$('.alert .close').click(function() {
	    $(this).parent().hide();
	});

	$('#formContainer .orderingUnit:first-child').fadeIn('slow');

	function changeOrderingUnits(oldUnit, newUnit, validationFlag) {
		if (!validationFlag || oldUnit.valid()) {
			oldUnit.fadeOut('slow', function() {
				newUnit.fadeIn('slow');
			});
		}
	}

	function findParentOrderingUnit(element) {
		return element.parents('.orderingUnit');
	}

	$('.prev').click(function() {
		var parentOrderingUnit = findParentOrderingUnit($(this));
		var unitToFadeIn = parentOrderingUnit.prevAll('.orderingUnit').first();
		changeOrderingUnits(parentOrderingUnit, unitToFadeIn, false);
	});

	$('.next').click(function() {
		if ($(this).attr('id') === 'toNewCustomer') {
			$('#customerlist').appendTo('#formContainer');
		} else if ($(this).attr('id') === 'toCustomerList') {
			$('#customerform').appendTo('#formContainer');
		}
		var parentOrderingUnit = findParentOrderingUnit($(this));
		var unitToFadeIn = parentOrderingUnit.nextAll('.orderingUnit').first();
		changeOrderingUnits(parentOrderingUnit, unitToFadeIn, true);
	});
});
