<%@ page import="medicalhistory.AntecedentDetail" %>



<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="antecedentDetail.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${antecedentDetailInstance?.abbreviation}"/>
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

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'fieldType', 'error')} ">
	<label for="fieldType">
		<g:message code="antecedentDetail.fieldType.label" default="Field Type" />
		
	</label>
	<g:textField name="fieldType" value="${antecedentDetailInstance?.fieldType}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'maxValue', 'error')} required">
	<label for="maxValue">
		<g:message code="antecedentDetail.maxValue.label" default="Max Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxValue" type="number" value="${antecedentDetailInstance.maxValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'measureUnit', 'error')} ">
	<label for="measureUnit">
		<g:message code="antecedentDetail.measureUnit.label" default="Measure Unit" />
		
	</label>
	<g:textField name="measureUnit" value="${antecedentDetailInstance?.measureUnit}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: antecedentDetailInstance, field: 'minValue', 'error')} required">
	<label for="minValue">
		<g:message code="antecedentDetail.minValue.label" default="Min Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minValue" type="number" value="${antecedentDetailInstance.minValue}" required=""/>
</div>

