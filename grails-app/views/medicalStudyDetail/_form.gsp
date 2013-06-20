<%@ page import="medicalhistory.MedicalStudyDetail" %>



<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="medicalStudyDetail.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${medicalStudyDetailInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'ageRange', 'error')} required">
	<label for="ageRange">
		<g:message code="medicalStudyDetail.ageRange.label" default="Age Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ageRange" name="ageRange.id" from="${medicalhistory.AgeRange.list()}" optionKey="id" required="" value="${medicalStudyDetailInstance?.ageRange?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'completeName', 'error')} ">
	<label for="completeName">
		<g:message code="medicalStudyDetail.completeName.label" default="Complete Name" />
		
	</label>
	<g:textField name="completeName" value="${medicalStudyDetailInstance?.completeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'decimalsQuantity', 'error')} required">
	<label for="decimalsQuantity">
		<g:message code="medicalStudyDetail.decimalsQuantity.label" default="Decimals Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="decimalsQuantity" type="number" value="${medicalStudyDetailInstance.decimalsQuantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'fieldType', 'error')} required">
	<label for="fieldType">
		<g:message code="medicalStudyDetail.fieldType.label" default="Field Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fieldType" name="fieldType.id" from="${medicalhistory.FieldType.list()}" optionKey="id" required="" value="${medicalStudyDetailInstance?.fieldType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'maxValue', 'error')} required">
	<label for="maxValue">
		<g:message code="medicalStudyDetail.maxValue.label" default="Max Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxValue" type="number" value="${medicalStudyDetailInstance.maxValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'minValue', 'error')} required">
	<label for="minValue">
		<g:message code="medicalStudyDetail.minValue.label" default="Min Value" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minValue" type="number" value="${medicalStudyDetailInstance.minValue}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'studyType', 'error')} required">
	<label for="studyType">
		<g:message code="medicalStudyDetail.studyType.label" default="Study Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studyType" name="studyType.id" from="${medicalhistory.StudyType.list()}" optionKey="id" required="" value="${medicalStudyDetailInstance?.studyType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'unit', 'error')} required">
	<label for="unit">
		<g:message code="medicalStudyDetail.unit.label" default="Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unit" name="unit.id" from="${medicalhistory.MeasurementUnit.list()}" optionKey="id" required="" value="${medicalStudyDetailInstance?.unit?.id}" class="many-to-one"/>
</div>

