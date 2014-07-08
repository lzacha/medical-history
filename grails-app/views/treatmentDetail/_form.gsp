<%@ page import="medicalhistory.TreatmentDetail" %>



<div class="fieldcontain ${hasErrors(bean: treatmentDetailInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="treatmentDetail.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${treatmentDetailInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentDetailInstance, field: 'completeName', 'error')} ">
	<label for="completeName">
		<g:message code="treatmentDetail.completeName.label" default="Complete Name" />
		
	</label>
	<g:textField name="completeName" value="${treatmentDetailInstance?.completeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentDetailInstance, field: 'decimalsQuantity', 'error')} required">
	<label for="decimalsQuantity">
		<g:message code="treatmentDetail.decimalsQuantity.label" default="Decimals Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="decimalsQuantity" type="number" value="${treatmentDetailInstance.decimalsQuantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentDetailInstance, field: 'fieldType', 'error')} required">
	<label for="fieldType">
		<g:message code="treatmentDetail.fieldType.label" default="Field Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fieldType" name="fieldType.id" from="${medicalhistory.FieldType.list()}" optionKey="id" required="" value="${treatmentDetailInstance?.fieldType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentDetailInstance, field: 'measurementUnit', 'error')} required">
	<label for="measurementUnit">
		<g:message code="treatmentDetail.measurementUnit.label" default="Measurement Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="measurementUnit" name="measurementUnit.id" from="${medicalhistory.MeasurementUnit.list()}" optionKey="id" required="" value="${treatmentDetailInstance?.measurementUnit?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: treatmentDetailInstance, field: 'treatmentType', 'error')} required">
	<label for="treatmentType">
		<g:message code="treatmentDetail.treatmentType.label" default="Treatment Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="treatmentType" from="${medicalhistory.TreatmentDetail$TreatmentType?.values()}" keys="${medicalhistory.TreatmentDetail$TreatmentType.values()*.name()}" required="" value="${treatmentDetailInstance?.treatmentType?.name()}"/>
</div>

