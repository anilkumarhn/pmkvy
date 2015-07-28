
function editBatch(batchID) {

	$.get("get/" + batchID, function(result) {

		$("#batchDialog").html(result);

		$('#batchDialog').dialog("option", "title", 'Edit Batch');

		$("#batchDialog").dialog('open');

		initializeDatePicker();
	});
}

function initializeDatePicker() {
	$(".datepicker").datepicker({
		dateFormat : "yy-mm-dd",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true
	});
}

function resetDialog(form) {

	form.find("input").val("");
}

$(document).ready(function() {

	$('#batchDialog').dialog({

		autoOpen : false,
		position : 'center',
		modal : true,
		resizable : false,
		width : 440,
		buttons : {
			"Save" : function() {
				$('#batchEditForm').submit();
			},
			"Cancel" : function() {
				$(this).dialog('close');
			}
		},
		close : function() {

			resetDialog($('#batchEditForm'));

			$(this).dialog('close');
		}
	});

	initializeDatePicker();
});
