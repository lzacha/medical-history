<%@ page import="medicalhistory.Treatment" %>



<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="treatment.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${treatmentInstance?.description}"/>
</div>

