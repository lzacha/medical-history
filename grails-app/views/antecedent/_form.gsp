<%@ page import="medicalhistory.Antecedent" %>



<div class="fieldcontain ${hasErrors(bean: antecedentInstance, field: 'antecedentDetails', 'error')} ">
	<label for="antecedentDetails">
		<g:message code="antecedent.antecedentDetails.label" default="Antecedent Details" />
		
	</label>
	<g:select name="antecedentDetails" from="${medicalhistory.AntecedentDetail.list()}" multiple="multiple" optionKey="id" size="5" value="${antecedentInstance?.antecedentDetails*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentInstance, field: 'antecedentValue', 'error')} required">
	<label for="antecedentValue">
		<g:message code="antecedent.antecedentValue.label" default="Antecedent Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="antecedentValue" type="number" value="${antecedentInstance.antecedentValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="antecedent.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${antecedentInstance?.patient?.id}" class="many-to-one"/>
</div>

