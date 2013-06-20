<%@ page import="medicalhistory.PlateDetail" %>



<div class="fieldcontain ${hasErrors(bean: plateDetailInstance, field: 'fieldPlateDetail1', 'error')} ">
	<label for="fieldPlateDetail1">
		<g:message code="plateDetail.fieldPlateDetail1.label" default="Field Plate Detail1" />
		
	</label>
	<g:textField name="fieldPlateDetail1" value="${plateDetailInstance?.fieldPlateDetail1}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateDetailInstance, field: 'fieldPlateDetail2', 'error')} ">
	<label for="fieldPlateDetail2">
		<g:message code="plateDetail.fieldPlateDetail2.label" default="Field Plate Detail2" />
		
	</label>
	<g:textField name="fieldPlateDetail2" value="${plateDetailInstance?.fieldPlateDetail2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateDetailInstance, field: 'fieldPlateDetail3', 'error')} ">
	<label for="fieldPlateDetail3">
		<g:message code="plateDetail.fieldPlateDetail3.label" default="Field Plate Detail3" />
		
	</label>
	<g:textField name="fieldPlateDetail3" value="${plateDetailInstance?.fieldPlateDetail3}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateDetailInstance, field: 'plate', 'error')} required">
	<label for="plate">
		<g:message code="plateDetail.plate.label" default="Plate" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="plate" name="plate.id" from="${medicalhistory.Plate.list()}" optionKey="id" required="" value="${plateDetailInstance?.plate?.id}" class="many-to-one"/>
</div>

