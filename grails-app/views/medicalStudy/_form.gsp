<%@ page import="medicalhistory.MedicalStudy" %>



<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'doctor', 'error')} required">
	<label for="doctor">
		<g:message code="medicalStudy.doctor.label" default="Doctor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doctor" name="doctor.id" from="${medicalhistory.Doctor.list()}" optionKey="id" required="" value="${medicalStudyInstance?.doctor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'mainStudy', 'error')} ">
	<label for="mainStudy">
		<g:message code="medicalStudy.mainStudy.label" default="Main Study" />
		
	</label>
	<g:textField name="mainStudy" value="${medicalStudyInstance?.mainStudy}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'medicalStudies', 'error')} ">
	<label for="medicalStudies">
		<g:message code="medicalStudy.medicalStudies.label" default="Medical Studies" />
		
	</label>
	<g:select name="medicalStudies" from="${medicalhistory.MedicalStudyDetail.list()}" multiple="multiple" optionKey="id" size="5" value="${medicalStudyInstance?.medicalStudies*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="medicalStudy.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${medicalStudyInstance?.patient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'studyDate', 'error')} required">
	<label for="studyDate">
		<g:message code="medicalStudy.studyDate.label" default="Study Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="studyDate" precision="day"  value="${medicalStudyInstance?.studyDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'unit', 'error')} required">
	<label for="unit">
		<g:message code="medicalStudy.unit.label" default="Unit" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="unit" name="unit.id" from="${medicalhistory.MeasurementUnit.list()}" optionKey="id" required="" value="${medicalStudyInstance?.unit?.id}" class="many-to-one"/>
</div>

