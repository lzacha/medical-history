<%@ page import="medicalhistory.ReferenceValue" %>



<div class="fieldcontain ${hasErrors(bean: referenceValueInstance, field: 'ageRange', 'error')} required">
	<label for="ageRange">
		<g:message code="referenceValue.ageRange.label" default="Age Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ageRange" name="ageRange.id" from="${medicalhistory.AgeRanges.list()}" optionKey="id" required="" value="${referenceValueInstance?.ageRange?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: referenceValueInstance, field: 'decimalQuantity', 'error')} required">
	<label for="decimalQuantity">
		<g:message code="referenceValue.decimalQuantity.label" default="Decimal Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="decimalQuantity" type="number" value="${referenceValueInstance.decimalQuantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: referenceValueInstance, field: 'maxValue', 'error')} required">
	<label for="maxValue">
		<g:message code="referenceValue.maxValue.label" default="Max Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxValue" type="number" value="${referenceValueInstance.maxValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: referenceValueInstance, field: 'minValue', 'error')} required">
	<label for="minValue">
		<g:message code="referenceValue.minValue.label" default="Min Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minValue" type="number" value="${referenceValueInstance.minValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: referenceValueInstance, field: 'sex', 'error')} ">
	<label for="sex">
		<g:message code="referenceValue.sex.label" default="Sex" />
		
	</label>
	<g:textField name="sex" value="${referenceValueInstance?.sex}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: referenceValueInstance, field: 'studyTypesDetails', 'error')} required">
	<label for="studyTypesDetails">
		<g:message code="referenceValue.studyTypesDetails.label" default="Study Types Details" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studyTypesDetails" name="studyTypesDetails.id" from="${medicalhistory.StudyTypesDetails.list()}" optionKey="id" required="" value="${referenceValueInstance?.studyTypesDetails?.id}" class="many-to-one"/>
</div>

