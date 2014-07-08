<%@ page import="medicalhistory.AntecedentValue" %>



<div class="fieldcontain ${hasErrors(bean: antecedentValueInstance, field: 'antecedentDetail', 'error')} required">
	<label for="antecedentDetail">
		<g:message code="antecedentValue.antecedentDetail.label" default="Antecedent Detail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="antecedentDetail" name="antecedentDetail.id" from="${medicalhistory.AntecedentDetail.list()}" optionKey="id" required="" value="${antecedentValueInstance?.antecedentDetail?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentValueInstance, field: 'antecedentValue', 'error')} required">
	<label for="antecedentValue">
		<g:message code="antecedentValue.antecedentValue.label" default="Antecedent Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="antecedentValue" value="${fieldValue(bean: antecedentValueInstance, field: 'antecedentValue')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentValueInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="antecedentValue.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${antecedentValueInstance?.patient?.id}" class="many-to-one"/>
</div>

