<%@ page import="medicalhistory.Treatment" %>



<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'frequency', 'error')} required">
	<label for="frequency">
		<g:message code="treatment.frequency.label" default="Frequency" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="frequency" name="frequency.id" from="${medicalhistory.TreatmentFrequency.list()}" optionKey="id" required="" value="${treatmentInstance?.frequency?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="treatment.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${treatmentInstance?.patient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatmentDetails', 'error')} ">
	<label for="treatmentDetails">
		<g:message code="treatment.treatmentDetails.label" default="Treatment Details" />
		
	</label>
	<g:select name="treatmentDetails" from="${medicalhistory.TreatmentDetail.list()}" multiple="multiple" optionKey="id" size="5" value="${treatmentInstance?.treatmentDetails*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatmentValue', 'error')} required">
	<label for="treatmentValue">
		<g:message code="treatment.treatmentValue.label" default="Treatment Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="treatmentValue" type="number" value="${treatmentInstance.treatmentValue}" required=""/>
</div>

