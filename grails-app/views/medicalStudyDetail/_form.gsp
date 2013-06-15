<%@ page import="medicalhistory.MedicalStudyDetail" %>



<div class="fieldcontain ${hasErrors(bean: medicalStudyDetailInstance, field: 'ageRange', 'error')} required">
	<label for="ageRange">
		<g:message code="medicalStudyDetail.ageRange.label" default="Age Range" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ageRange" name="ageRange.id" from="${medicalhistory.AgeRange.list()}" optionKey="id" required="" value="${medicalStudyDetailInstance?.ageRange?.id}" class="many-to-one"/>
</div>

