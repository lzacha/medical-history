<%@ page import="medicalhistory.TreatmentFrequency" %>



<div class="fieldcontain ${hasErrors(bean: treatmentFrequencyInstance, field: 'frequencyDescription', 'error')} ">
	<label for="frequencyDescription">
		<g:message code="treatmentFrequency.frequencyDescription.label" default="Frequency Description" />
		
	</label>
	<g:textField name="frequencyDescription" value="${treatmentFrequencyInstance?.frequencyDescription}"/>
</div>

