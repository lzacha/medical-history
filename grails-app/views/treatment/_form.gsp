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

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatmentCode', 'error')} ">
	<label for="treatmentCode">
		<g:message code="treatment.treatmentCode.label" default="Treatment Code" />
		
	</label>
	<g:textField name="treatmentCode" value="${treatmentInstance?.treatmentCode}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatmentDetail', 'error')} ">
	<label for="treatmentDetail">
		<g:message code="treatment.treatmentDetail.label" default="Treatment Detail" />
		
	</label>
	<g:textField name="treatmentDetail" value="${treatmentInstance?.treatmentDetail}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatmentId', 'error')} required">
	<label for="treatmentId">
		<g:message code="treatment.treatmentId.label" default="Treatment Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="treatmentId" type="number" value="${treatmentInstance.treatmentId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatmentValue', 'error')} required">
	<label for="treatmentValue">
		<g:message code="treatment.treatmentValue.label" default="Treatment Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="treatmentValue" type="number" value="${treatmentInstance.treatmentValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatments', 'error')} ">
	<label for="treatments">
		<g:message code="treatment.treatments.label" default="Treatments" />
		
	</label>
	<g:select name="treatments" from="${medicalhistory.TreatmentDetail.list()}" multiple="multiple" optionKey="id" size="5" value="${treatmentInstance?.treatments*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'unit', 'error')} required">
	<label for="unit">
		<g:message code="treatment.unit.label" default="Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unit" name="unit.id" from="${medicalhistory.MeasurementUnit.list()}" optionKey="id" required="" value="${treatmentInstance?.unit?.id}" class="many-to-one"/>
</div>

