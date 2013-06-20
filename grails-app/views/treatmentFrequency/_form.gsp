<%@ page import="medicalhistory.TreatmentFrequency" %>



<div class="fieldcontain ${hasErrors(bean: treatmentFrequencyInstance, field: 'field1', 'error')} ">
	<label for="field1">
		<g:message code="treatmentFrequency.field1.label" default="Field1" />
		
	</label>
	<g:textField name="field1" value="${treatmentFrequencyInstance?.field1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentFrequencyInstance, field: 'field2', 'error')} ">
	<label for="field2">
		<g:message code="treatmentFrequency.field2.label" default="Field2" />
		
	</label>
	<g:textField name="field2" value="${treatmentFrequencyInstance?.field2}"/>
</div>

