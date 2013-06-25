<%@ page import="medicalhistory.StudyTypeDetail" %>



<div class="fieldcontain ${hasErrors(bean: studyTypeDetailInstance, field: 'abbreviation', 'error')} ">
	<label for="abbreviation">
		<g:message code="studyTypeDetail.abbreviation.label" default="Abbreviation" />
		
	</label>
	<g:textField name="abbreviation" value="${studyTypeDetailInstance?.abbreviation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypeDetailInstance, field: 'completeName', 'error')} ">
	<label for="completeName">
		<g:message code="studyTypeDetail.completeName.label" default="Complete Name" />
		
	</label>
	<g:textField name="completeName" value="${studyTypeDetailInstance?.completeName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypeDetailInstance, field: 'studyType', 'error')} required">
	<label for="studyType">
		<g:message code="studyTypeDetail.studyType.label" default="Study Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="studyType" name="studyType.id" from="${medicalhistory.StudyType.list()}" optionKey="id" required="" value="${studyTypeDetailInstance?.studyType?.id}" class="many-to-one"/>
</div>

