<%@ page import="medicalhistory.AgeRanges" %>



<div class="fieldcontain ${hasErrors(bean: ageRangesInstance, field: 'maxValue', 'error')} required">
	<label for="maxValue">
		<g:message code="ageRanges.maxValue.label" default="Max Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxValue" type="number" value="${ageRangesInstance.maxValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: ageRangesInstance, field: 'minValue', 'error')} required">
	<label for="minValue">
		<g:message code="ageRanges.minValue.label" default="Min Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minValue" type="number" value="${ageRangesInstance.minValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: ageRangesInstance, field: 'rangeDescription', 'error')} ">
	<label for="rangeDescription">
		<g:message code="ageRanges.rangeDescription.label" default="Range Description" />
		
	</label>
	<g:textField name="rangeDescription" value="${ageRangesInstance?.rangeDescription}"/>
</div>

