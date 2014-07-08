<%@ page import="medicalhistory.Philiatory" %>



<div class="fieldcontain ${hasErrors(bean: philiatoryInstance, field: 'abdominalDiameter', 'error')} required">
	<label for="abdominalDiameter">
		<g:message code="philiatory.abdominalDiameter.label" default="Abdominal Diameter" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="abdominalDiameter" value="${fieldValue(bean: philiatoryInstance, field: 'abdominalDiameter')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: philiatoryInstance, field: 'height', 'error')} required">
	<label for="height">
		<g:message code="philiatory.height.label" default="Height" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="height" value="${fieldValue(bean: philiatoryInstance, field: 'height')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: philiatoryInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="philiatory.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${philiatoryInstance?.patient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: philiatoryInstance, field: 'weight', 'error')} required">
	<label for="weight">
		<g:message code="philiatory.weight.label" default="Weight" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="weight" value="${fieldValue(bean: philiatoryInstance, field: 'weight')}" required=""/>
</div>

