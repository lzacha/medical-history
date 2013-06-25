<%@ page import="medicalhistory.AgeRange" %>



<div class="fieldcontain ${hasErrors(bean: ageRangeInstance, field: 'rangeDescription', 'error')} required">
	<label for="rangeDescription">
		<g:message code="ageRange.rangeDescription.label" default="Range Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="rangeDescription" maxlength="150" required="" value="${ageRangeInstance?.rangeDescription}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: ageRangeInstance, field: 'minValue', 'error')} required">
	<label for="minValue">
		<g:message code="ageRange.minValue.label" default="Min Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minValue" type="number" min="0" max="200" value="${ageRangeInstance.minValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: ageRangeInstance, field: 'maxValue', 'error')} required">
	<label for="maxValue">
		<g:message code="ageRange.maxValue.label" default="Max Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxValue" type="number" min="0" max="200" value="${ageRangeInstance.maxValue}" required=""/>
</div>

