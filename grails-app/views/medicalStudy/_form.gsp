<%@ page import="medicalhistory.MedicalStudy" %>



<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'abdominalDiameter', 'error')} required">
	<label for="abdominalDiameter">
		<g:message code="medicalStudy.abdominalDiameter.label" default="Abdominal Diameter" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="abdominalDiameter" value="${fieldValue(bean: medicalStudyInstance, field: 'abdominalDiameter')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'doctor', 'error')} required">
	<label for="doctor">
		<g:message code="medicalStudy.doctor.label" default="Doctor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doctor" name="doctor.id" from="${medicalhistory.Doctor.list()}" optionKey="id" required="" value="${medicalStudyInstance?.doctor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'height', 'error')} required">
	<label for="height">
		<g:message code="medicalStudy.height.label" default="Height" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="height" value="${fieldValue(bean: medicalStudyInstance, field: 'height')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'mainStudyType', 'error')} required">
	<label for="mainStudyType">
		<g:message code="medicalStudy.mainStudyType.label" default="Main Study Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mainStudyType" name="mainStudyType.id" from="${medicalhistory.MainStudyType.list()}" optionKey="id" required="" value="${medicalStudyInstance?.mainStudyType?.id}" class="many-to-one"/>
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

<div class="fieldcontain ${hasErrors(bean: medicalStudyInstance, field: 'weight', 'error')} required">
	<label for="weight">
		<g:message code="medicalStudy.weight.label" default="Weight" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="weight" value="${fieldValue(bean: medicalStudyInstance, field: 'weight')}" required=""/>
</div>

