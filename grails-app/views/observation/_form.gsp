<%@ page import="medicalhistory.Observation" %>



<div class="fieldcontain ${hasErrors(bean: observationInstance, field: 'observation', 'error')} ">
	<label for="observation">
		<g:message code="observation.observation.label" default="Observation" />
		
	</label>
	<g:textField name="observation" value="${observationInstance?.observation}"/>
</div>

