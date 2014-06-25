<%@ page import="medicalhistory.StudyTypesValues" %>



<div class="fieldcontain ${hasErrors(bean: studyTypesValuesInstance, field: 'studyTypesDetails', 'error')} ">
	<label for="studyTypesDetails">
		<g:message code="studyTypesValues.studyTypesDetails.label" default="Study Types Details" />
		
	</label>
	<g:select name="studyTypesDetails" from="${medicalhistory.StudyTypesDetails.list()}" multiple="multiple" optionKey="id" size="5" value="${studyTypesValuesInstance?.studyTypesDetails*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesValuesInstance, field: 'value', 'error')} required">
	<label for="value">
		<g:message code="studyTypesValues.value.label" default="Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="value" type="number" value="${studyTypesValuesInstance.value}" required=""/>
</div>

