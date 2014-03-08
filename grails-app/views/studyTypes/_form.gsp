<%@ page import="medicalhistory.StudyTypes" %>



<div class="fieldcontain ${hasErrors(bean: studyTypesInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="studyTypes.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${studyTypesInstance?.description}"/>
</div>

