<%@ page import="medicalhistory.StudyTypesTable" %>



<div class="fieldcontain ${hasErrors(bean: studyTypesTableInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="studyTypesTable.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${studyTypesTableInstance?.patient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesTableInstance, field: 'studyDate', 'error')} required">
	<label for="studyDate">
		<g:message code="studyTypesTable.studyDate.label" default="Study Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="studyDate" precision="day"  value="${studyTypesTableInstance?.studyDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: studyTypesTableInstance, field: 'studyType', 'error')} ">
	<label for="studyType">
		<g:message code="studyTypesTable.studyType.label" default="Study Type" />
		
	</label>
	<g:textField name="studyType" value="${studyTypesTableInstance?.studyType}"/>
</div>

