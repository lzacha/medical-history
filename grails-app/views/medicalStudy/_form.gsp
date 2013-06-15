<%@ page import="medicalhistory.MedicalStudy" %>



<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'doctor', 'error')} required">
	<label for="doctor">
		<g:message code="medicalStudy.doctor.label" default="Doctor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doctor" name="doctor.id" from="${medicalhistory.Doctor.list()}" optionKey="id" required="" value="${medicalStudyInstance?.doctor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'medicalStudies', 'error')} ">
	<label for="medicalStudies">
		<g:message code="medicalStudy.medicalStudies.label" default="Medical Studies" />
		
	</label>
	<g:select name="medicalStudies" from="${medicalhistory.MedicalStudyDetail.list()}" multiple="multiple" optionKey="id" size="5" value="${medicalStudyInstance?.medicalStudies*.id}" class="many-to-many"/>
</div>

