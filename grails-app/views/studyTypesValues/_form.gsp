<%@ page import="medicalhistory.StudyTypesValues" %>



<div class="fieldcontain ${hasErrors(bean: studyTypesValuesInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="studyTypesValues.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${studyTypesValuesInstance?.patient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesValuesInstance, field: 'studyTypeValue', 'error')} required">
	<label for="studyTypeValue">
		<g:message code="studyTypesValues.studyTypeValue.label" default="Study Type Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="studyTypeValue" value="${fieldValue(bean: studyTypesValuesInstance, field: 'studyTypeValue')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesValuesInstance, field: 'studyTypesDetail', 'error')} required">
	<label for="studyTypesDetail">
		<g:message code="studyTypesValues.studyTypesDetail.label" default="Study Types Detail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studyTypesDetail" name="studyTypesDetail.id" from="${medicalhistory.StudyTypesDetail.list()}" optionKey="id" required="" value="${studyTypesValuesInstance?.studyTypesDetail?.id}" class="many-to-one"/>
</div>

