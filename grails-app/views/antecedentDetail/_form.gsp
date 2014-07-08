<%@ page import="medicalhistory.AntecedentDetail" %>



<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="antecedentDetail.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${antecedentDetailInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'antecedentStudyType', 'error')} required">
	<label for="antecedentStudyType">
		<g:message code="antecedentDetail.antecedentStudyType.label" default="Antecedent Study Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="antecedentStudyType" from="${medicalhistory.AntecedentDetail$AntecedentStudyType?.values()}" keys="${medicalhistory.AntecedentDetail$AntecedentStudyType.values()*.name()}" required="" value="${antecedentDetailInstance?.antecedentStudyType?.name()}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'completeName', 'error')} ">
	<label for="completeName">
		<g:message code="antecedentDetail.completeName.label" default="Complete Name" />
		
	</label>
	<g:textField name="completeName" value="${antecedentDetailInstance?.completeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'decimalsQuantity', 'error')} required">
	<label for="decimalsQuantity">
		<g:message code="antecedentDetail.decimalsQuantity.label" default="Decimals Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="decimalsQuantity" type="number" value="${antecedentDetailInstance.decimalsQuantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'fieldType', 'error')} required">
	<label for="fieldType">
		<g:message code="antecedentDetail.fieldType.label" default="Field Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fieldType" name="fieldType.id" from="${medicalhistory.FieldType.list()}" optionKey="id" required="" value="${antecedentDetailInstance?.fieldType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'measurementUnit', 'error')} required">
	<label for="measurementUnit">
		<g:message code="antecedentDetail.measurementUnit.label" default="Measurement Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="measurementUnit" name="measurementUnit.id" from="${medicalhistory.MeasurementUnit.list()}" optionKey="id" required="" value="${antecedentDetailInstance?.measurementUnit?.id}" class="many-to-one"/>
</div>

