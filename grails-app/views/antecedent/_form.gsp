<%@ page import="medicalhistory.Antecedent" %>



<div class="fieldcontain ${hasErrors(bean: antecedentInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="antecedent.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${antecedentInstance?.description}"/>
</div>

