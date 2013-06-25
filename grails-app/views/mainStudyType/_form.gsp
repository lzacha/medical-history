<%@ page import="medicalhistory.MainStudyType" %>



<div class="fieldcontain ${hasErrors(bean: mainStudyTypeInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="mainStudyType.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${mainStudyTypeInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mainStudyTypeInstance, field: 'mainStudyType', 'error')} ">
	<label for="mainStudyType">
		<g:message code="mainStudyType.mainStudyType.label" default="Main Study Type" />
		
	</label>
	<g:textField name="mainStudyType" value="${mainStudyTypeInstance?.mainStudyType}"/>
</div>

