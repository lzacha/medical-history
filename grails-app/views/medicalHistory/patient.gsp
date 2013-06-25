<%@ page contentType="text/html;charset=UTF-8" %>


<!--Nombre: ${patient.firstName} 
Apellido: ${patient.lastName} -->

<div id="patientTabs">
	<ul>
		<li><a href="/medical-history/patient/show/${patient.id}">Paciente</a></li>
		<li><a href="/medical-history/medicalStudy/show/${patient.id}">Estudios</a></li>
		<li><a href="/medical-history/antecedent/show/${patient.id}">Antecedentes</a></li>
		<li><a href="/medical-history/plate/${patient.id}">Placas</a></li>

	</ul>
	<div>
		<div id="tab1"></div>
		<div id="tab2"></div>
		<div id="tab3"></div>
		<div id="tab4"></div>
	</div>
</div>
</div>