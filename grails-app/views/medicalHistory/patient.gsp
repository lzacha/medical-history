<%@ page contentType="text/html;charset=UTF-8" %>

<div>
Nombre: ${patient.firstName} <p>
Apellido: ${patient.lastName}


<div id="patientTabs">
	<ul>
		<li><a href="/medical-history/patient/show/${patient.id}">Paciente</a></li>
		<li><a href="#tab2">Estudios</a></li>
		<li><a href="#tab3">Antecedentes</a></li{}
		<li><a href="#tab4">Placas</a></li>

	</ul>
	<div>
		<div id="tab1">Contenido Paciente</div>
		<div id="tab2">Contenido Estudios</div>
		<div id="tab3">Contenido Antecedentes</div>
		<div id="tab4">Contenido Placas</div>
	</div>
</div>

</div>