<%@ page import="medicalhistory.Treatment" %>



<div class="fieldcontain ${hasErrors(bean: treatmentInstance, field: 'treatments', 'error')} ">
	<label for="treatments">
		<g:message code="treatment.treatments.label" default="Treatments" />
		
	</label>
	<g:select name="treatments" from="${medicalhistory.TreatmentDetail.list()}" multiple="multiple" optionKey="id" size="5" value="${treatmentInstance?.treatments*.id}" class="many-to-many"/>
</div>

