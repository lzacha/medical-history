<%@ page import="medicalhistory.Plate" %>



<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'doctor', 'error')} required">
	<label for="doctor">
		<g:message code="plate.doctor.label" default="Doctor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doctor" name="doctor.id" from="${medicalhistory.Doctor.list()}" optionKey="id" required="" value="${plateInstance?.doctor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'observations', 'error')} ">
	<label for="observations">
		<g:message code="plate.observations.label" default="Observations" />
		
	</label>
	<g:select name="observations" from="${medicalhistory.Observation.list()}" multiple="multiple" optionKey="id" size="5" value="${plateInstance?.observations*.id}" class="many-to-many"/>
</div>

