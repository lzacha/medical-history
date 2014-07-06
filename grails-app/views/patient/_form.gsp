<%@ page import="medicalhistory.Patient" %>



<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="patient.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${patientInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="patient.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${patientInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'birthDate', 'error')} required">
	<label for="birthDate">
		<g:message code="patient.birthDate.label" default="Birth Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthDate" precision="day"  value="${patientInstance?.birthDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'abdominalDiameter', 'error')} required">
	<label for="abdominalDiameter">
		<g:message code="patient.abdominalDiameter.label" default="Abdominal Diameter" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="abdominalDiameter" value="${fieldValue(bean: patientInstance, field: 'abdominalDiameter')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'height', 'error')} required">
	<label for="height">
		<g:message code="patient.height.label" default="Height" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="height" value="${fieldValue(bean: patientInstance, field: 'height')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'medicalHistory', 'error')} ">
	<label for="medicalHistory">
		<g:message code="patient.medicalHistory.label" default="Medical History" />
		
	</label>
	<g:textField name="medicalHistory" value="${patientInstance?.medicalHistory}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'patientId', 'error')} required">
	<label for="patientId">
		<g:message code="patient.patientId.label" default="Patient Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="patientId" type="number" value="${patientInstance.patientId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'sex', 'error')} required">
	<label for="sex">
		<g:message code="patient.sex.label" default="Sex" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sex" from="${medicalhistory.Patient$Sex?.values()}" keys="${medicalhistory.Patient$Sex.values()*.name()}" required="" value="${patientInstance?.sex?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'weight', 'error')} required">
	<label for="weight">
		<g:message code="patient.weight.label" default="Weight" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="weight" value="${fieldValue(bean: patientInstance, field: 'weight')}" required=""/>
</div>

