<%@ page import="medicalhistory.Doctor" %>



<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'docId', 'error')} required">
	<label for="docId">
		<g:message code="doctor.docId.label" default="Doc Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="docId" type="number" value="${doctorInstance.docId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="doctor.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${doctorInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="doctor.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${doctorInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: doctorInstance, field: 'medicalEnrollment', 'error')} ">
	<label for="medicalEnrollment">
		<g:message code="doctor.medicalEnrollment.label" default="Medical Enrollment" />
		
	</label>
	<g:textField name="medicalEnrollment" value="${doctorInstance?.medicalEnrollment}"/>
</div>

