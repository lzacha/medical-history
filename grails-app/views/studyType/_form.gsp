<%@ page import="medicalhistory.StudyType" %>



<div class="fieldcontain ${hasErrors(bean: studyTypeInstance, field: 'studyType', 'error')} ">
	<label for="studyType">
		<g:message code="studyType.studyType.label" default="Study Type" />
		
	</label>
	<g:textField name="studyType" value="${studyTypeInstance?.studyType}"/>
</div>

