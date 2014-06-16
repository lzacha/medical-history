$(function() {
    $("#menu").menu();
});

//Autosuggest patients
var availablePatients = new Array();

$.getJSON(document.location.origin + "/medical-history/medicalHistoryJson/patients", function(json){
    for (var i=0; i<json.length; i++) {
        availablePatients[i] = json[i].firstName + " "+json[i].lastName + "-" + json[i].id;
    }
});

$(function() {
    $( "#patients" ).autocomplete({
        source: availablePatients
    });
});


//Seteo patientId en el form de busqueda de paciente
$("#searchPatientFormId").submit(function() {
    var patientId = $("#patients")[0].value.split("-")[1];
    $("#hiddenPatient")[0].value = patientId;
});


/*
$(function() {
    $( "#tabs" ).tabs({
        beforeLoad: function( event, ui ) {
            ui.jqXHR.error(function() {
                ui.panel.html(
                    "Couldn't load this tab. We'll try to fix this as soon as possible. " +
                        "If this wouldn't be a demo." );
            });
        }
    });
});
*/

$(function() {
    $( "#tabs" ).tabs();
});

/*
$("#upload").click(function() {
	  alert('');
});
*/

/*
$("#upload").change(function () {
	  var filename = $(this).val();
	  $('#imagePlate').val(filename);
}).change();

*/
//var href = "/alert/index/";
//$("#alert-tab").load(href);