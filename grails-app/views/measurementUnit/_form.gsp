<%@ page import="medicalhistory.MeasurementUnit" %>



<div class="fieldcontain ${hasErrors(bean: measurementUnitInstance, field: 'descriptionUnit', 'error')} ">
	<label for="descriptionUnit">
		<g:message code="measurementUnit.descriptionUnit.label" default="Description Unit" />
		
	</label>
	<g:textField name="descriptionUnit" value="${measurementUnitInstance?.descriptionUnit}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: measurementUnitInstance, field: 'unit', 'error')} ">
	<label for="unit">
		<g:message code="measurementUnit.unit.label" default="Unit" />
		
	</label>
	<g:textField name="unit" value="${measurementUnitInstance?.unit}"/>
</div>

