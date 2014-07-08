<%@ page import="medicalhistory.TreatmentValue" %>



<div class="fieldcontain ${hasErrors(bean: treatmentValueInstance, field: 'frequency', 'error')} required">
	<label for="frequency">
		<g:message code="treatmentValue.frequency.label" default="Frequency" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="frequency" name="frequency.id" from="${medicalhistory.TreatmentFrequency.list()}" optionKey="id" required="" value="${treatmentValueInstance?.frequency?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentValueInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="treatmentValue.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${treatmentValueInstance?.patient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentValueInstance, field: 'treatmentDetail', 'error')} required">
	<label for="treatmentDetail">
		<g:message code="treatmentValue.treatmentDetail.label" default="Treatment Detail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="treatmentDetail" name="treatmentDetail.id" from="${medicalhistory.TreatmentDetail.list()}" optionKey="id" required="" value="${treatmentValueInstance?.treatmentDetail?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentValueInstance, field: 'treatmentValue', 'error')} required">
	<label for="treatmentValue">
		<g:message code="treatmentValue.treatmentValue.label" default="Treatment Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="treatmentValue" value="${fieldValue(bean: treatmentValueInstance, field: 'treatmentValue')}" required=""/>
</div>

