<%@ page import="medicalhistory.Plate" %>



<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'doctor', 'error')} required">
	<label for="doctor">
		<g:message code="plate.doctor.label" default="Doctor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doctor" name="doctor.id" from="${medicalhistory.Doctor.list()}" optionKey="id" required="" value="${plateInstance?.doctor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'imagePlate', 'error')} ">
	<label for="imagePlate">
		<g:message code="plate.imagePlate.label" default="Image Plate" />
		
	</label>
	<g:textField name="imagePlate" value="${plateInstance?.imagePlate}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'observation', 'error')} ">
	<label for="observation">
		<g:message code="plate.observation.label" default="Observation" />
		
	</label>
	<g:textField name="observation" value="${plateInstance?.observation}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'patient', 'error')} required">
	<label for="patient">
		<g:message code="plate.patient.label" default="Patient" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="patient" name="patient.id" from="${medicalhistory.Patient.list()}" optionKey="id" required="" value="${plateInstance?.patient?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'plateDate', 'error')} required">
	<label for="plateDate">
		<g:message code="plate.plateDate.label" default="Plate Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="plateDate" precision="day"  value="${plateInstance?.plateDate}"  />
</div>

