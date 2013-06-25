<%@ page import="medicalhistory.StudyType" %>



<div class="fieldcontain ${hasErrors(bean: studyTypeInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="studyType.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${studyTypeInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypeInstance, field: 'shortDescription', 'error')} ">
	<label for="shortDescription">
		<g:message code="studyType.shortDescription.label" default="Short Description" />
		
	</label>
	<g:textField name="shortDescription" value="${studyTypeInstance?.shortDescription}"/>
</div>

