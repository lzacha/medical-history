<%@ page import="medicalhistory.MedicalStudyDetail" %>



<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="medicalStudyDetail.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${medicalStudyDetailInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'completeName', 'error')} ">
	<label for="completeName">
		<g:message code="medicalStudyDetail.completeName.label" default="Complete Name" />
		
	</label>
	<g:textField name="completeName" value="${medicalStudyDetailInstance?.completeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'fieldType', 'error')} required">
	<label for="fieldType">
		<g:message code="medicalStudyDetail.fieldType.label" default="Field Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="fieldType" name="fieldType.id" from="${medicalhistory.FieldType.list()}" optionKey="id" required="" value="${medicalStudyDetailInstance?.fieldType?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'studyType', 'error')} required">
	<label for="studyType">
		<g:message code="medicalStudyDetail.studyType.label" default="Study Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studyType" name="studyType.id" from="${medicalhistory.StudyType.list()}" optionKey="id" required="" value="${medicalStudyDetailInstance?.studyType?.id}" class="many-to-one"/>
</div>

