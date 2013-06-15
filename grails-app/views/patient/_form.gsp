<%@ page import="medicalhistory.Patient" %>



<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'birthDate', 'error')} required">
	<label for="birthDate">
		<g:message code="patient.birthDate.label" default="Birth Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthDate" precision="day"  value="${patientInstance?.birthDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="patient.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${patientInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="patient.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${patientInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'patientId', 'error')} required">
	<label for="patientId">
		<g:message code="patient.patientId.label" default="Patient Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="patientId" type="number" value="${patientInstance.patientId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'sexId', 'error')} ">
	<label for="sexId">
		<g:message code="patient.sexId.label" default="Sex Id" />
		
	</label>
	<g:textField name="sexId" value="${patientInstance?.sexId}"/>
</div>

