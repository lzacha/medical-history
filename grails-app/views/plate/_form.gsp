<%@ page import="medicalhistory.Plate" %>



<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'doctor', 'error')} required">
	<label for="doctor">
		<g:message code="plate.doctor.label" default="Doctor" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="doctor" name="doctor.id" from="${medicalhistory.Doctor.list()}" optionKey="id" required="" value="${plateInstance?.doctor?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'fieldPlate2', 'error')} ">
	<label for="fieldPlate2">
		<g:message code="plate.fieldPlate2.label" default="Field Plate2" />
		
	</label>
	<g:textField name="fieldPlate2" value="${plateInstance?.fieldPlate2}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'fieldPlate3', 'error')} ">
	<label for="fieldPlate3">
		<g:message code="plate.fieldPlate3.label" default="Field Plate3" />
		
	</label>
	<g:textField name="fieldPlate3" value="${plateInstance?.fieldPlate3}"/>
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

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'plateDate', 'error')} required">
	<label for="plateDate">
		<g:message code="plate.plateDate.label" default="Plate Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="plateDate" precision="day"  value="${plateInstance?.plateDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: plateInstance, field: 'plateDescription', 'error')} ">
	<label for="plateDescription">
		<g:message code="plate.plateDescription.label" default="Plate Description" />
		
	</label>
	<g:textField name="plateDescription" value="${plateInstance?.plateDescription}"/>
</div>

