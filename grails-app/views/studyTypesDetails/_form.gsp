<%@ page import="medicalhistory.StudyTypesDetails" %>



<div class="fieldcontain ${hasErrors(bean: studyTypesDetailsInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="studyTypesDetails.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${studyTypesDetailsInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailsInstance, field: 'completeName', 'error')} ">
	<label for="completeName">
		<g:message code="studyTypesDetails.completeName.label" default="Complete Name" />
		
	</label>
	<g:textField name="completeName" value="${studyTypesDetailsInstance?.completeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailsInstance, field: 'decimalsQuantity', 'error')} required">
	<label for="decimalsQuantity">
		<g:message code="studyTypesDetails.decimalsQuantity.label" default="Decimals Quantity" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="decimalsQuantity" type="number" value="${studyTypesDetailsInstance.decimalsQuantity}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailsInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="studyTypesDetails.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${studyTypesDetailsInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailsInstance, field: 'maxRange', 'error')} required">
	<label for="maxRange">
		<g:message code="studyTypesDetails.maxRange.label" default="Max Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="maxRange" type="number" value="${studyTypesDetailsInstance.maxRange}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailsInstance, field: 'minRange', 'error')} required">
	<label for="minRange">
		<g:message code="studyTypesDetails.minRange.label" default="Min Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="minRange" type="number" value="${studyTypesDetailsInstance.minRange}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesDetailsInstance, field: 'studyTypes', 'error')} ">
	<label for="studyTypes">
		<g:message code="studyTypesDetails.studyTypes.label" default="Study Types" />
		
	</label>
	<g:select name="studyTypes" from="${medicalhistory.StudyTypes.list()}" multiple="multiple" optionKey="id" size="5" value="${studyTypesDetailsInstance?.studyTypes*.id}" class="many-to-many"/>
</div>

