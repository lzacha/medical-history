<%@ page contentType="text/html;charset=UTF-8" %>

<div id="tabs">
	<ul>
        <li><a href="/medical-history/patient/show/${patient.id}">Paciente</a></li>
		<li><a href="/medical-history/medicalStudy/show/${patient.id}">Estudios</a></li>
        <li><a href="/medical-history/treatment/show/${patient.id}">Tratamientos</a></li>
        <!--li><a href="/medical-history/medicalHistory/listAntecedentsByPatient/?id=${patient.id}">Antecedentes</a></li-->
        <li><a href="/medical-history/antecedent/list">Antecedentes</a></li>
        <li><a href="/medical-history/plate/${patient.id}">Placas</a></li>
    </ul>
	<div>
	</div>
</div>