<%@ page import="medicalhistory.ValueReference" %>



<div class="fieldcontain ${hasErrors(bean: valueReferenceInstance, field: 'ageRange', 'error')} required">
	<label for="ageRange">
		<g:message code="valueReference.ageRange.label" default="Age Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ageRange" name="ageRange.id" from="${medicalhistory.AgeRange.list()}" optionKey="id" required="" value="${valueReferenceInstance?.ageRange?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: valueReferenceInstance, field: 'decimalQuantity', 'error')} required">
	<label for="decimalQuantity">
		<g:message code="valueReference.decimalQuantity.label" default="Decimal Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="decimalQuantity" type="number" value="${valueReferenceInstance.decimalQuantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: valueReferenceInstance, field: 'maxValue', 'error')} required">
	<label for="maxValue">
		<g:message code="valueReference.maxValue.label" default="Max Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxValue" type="number" value="${valueReferenceInstance.maxValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: valueReferenceInstance, field: 'minValue', 'error')} required">
	<label for="minValue">
		<g:message code="valueReference.minValue.label" default="Min Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minValue" type="number" value="${valueReferenceInstance.minValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: valueReferenceInstance, field: 'sex', 'error')} ">
	<label for="sex">
		<g:message code="valueReference.sex.label" default="Sex" />
		
	</label>
	<g:textField name="sex" value="${valueReferenceInstance?.sex}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: valueReferenceInstance, field: 'studyTypeDetail', 'error')} required">
	<label for="studyTypeDetail">
		<g:message code="valueReference.studyTypeDetail.label" default="Study Type Detail" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studyTypeDetail" name="studyTypeDetail.id" from="${medicalhistory.StudyTypeDetail.list()}" optionKey="id" required="" value="${valueReferenceInstance?.studyTypeDetail?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: valueReferenceInstance, field: 'unit', 'error')} required">
	<label for="unit">
		<g:message code="valueReference.unit.label" default="Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unit" name="unit.id" from="${medicalhistory.MeasurementUnit.list()}" optionKey="id" required="" value="${valueReferenceInstance?.unit?.id}" class="many-to-one"/>
</div>

