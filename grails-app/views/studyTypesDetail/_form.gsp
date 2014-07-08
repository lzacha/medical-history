<%@ page import="medicalhistory.StudyTypesDetail" %>



<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="studyTypesDetail.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${studyTypesDetailInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'completeName', 'error')} ">
	<label for="completeName">
		<g:message code="studyTypesDetail.completeName.label" default="Complete Name" />
		
	</label>
	<g:textField name="completeName" value="${studyTypesDetailInstance?.completeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'decimalsQuantity', 'error')} required">
	<label for="decimalsQuantity">
		<g:message code="studyTypesDetail.decimalsQuantity.label" default="Decimals Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="decimalsQuantity" type="number" value="${studyTypesDetailInstance.decimalsQuantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="studyTypesDetail.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${studyTypesDetailInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'fieldType', 'error')} required">
	<label for="fieldType">
		<g:message code="studyTypesDetail.fieldType.label" default="Field Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fieldType" name="fieldType.id" from="${medicalhistory.FieldType.list()}" optionKey="id" required="" value="${studyTypesDetailInstance?.fieldType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'maxRange', 'error')} required">
	<label for="maxRange">
		<g:message code="studyTypesDetail.maxRange.label" default="Max Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxRange" value="${fieldValue(bean: studyTypesDetailInstance, field: 'maxRange')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'measurementUnit', 'error')} required">
	<label for="measurementUnit">
		<g:message code="studyTypesDetail.measurementUnit.label" default="Measurement Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="measurementUnit" name="measurementUnit.id" from="${medicalhistory.MeasurementUnit.list()}" optionKey="id" required="" value="${studyTypesDetailInstance?.measurementUnit?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'minRange', 'error')} required">
	<label for="minRange">
		<g:message code="studyTypesDetail.minRange.label" default="Min Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minRange" value="${fieldValue(bean: studyTypesDetailInstance, field: 'minRange')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailInstance, field: 'studyTypes', 'error')} required">
	<label for="studyTypes">
		<g:message code="studyTypesDetail.studyTypes.label" default="Study Types" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studyTypes" name="studyTypes.id" from="${medicalhistory.StudyTypes.list()}" optionKey="id" required="" value="${studyTypesDetailInstance?.studyTypes?.id}" class="many-to-one"/>
</div>

