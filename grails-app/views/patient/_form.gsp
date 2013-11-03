<%@ page import="medicalhistory.Patient" %>



<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="patient.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${patientInstance?.firstName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="patient.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${patientInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'sexId', 'error')} required">
	<label for="sexId">
		<g:message code="patient.sexId.label" default="Sex Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="sexId" required="" value="${patientInstance?.sexId}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'birthDate', 'error')} required">
	<label for="birthDate">
		<g:message code="patient.birthDate.label" default="Birth Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birthDate" precision="day"  value="${patientInstance?.birthDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'abdominalDiameter', 'error')} required">
	<label for="abdominalDiameter">
		<g:message code="patient.abdominalDiameter.label" default="Abdominal Diameter" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="abdominalDiameter" value="${fieldValue(bean: patientInstance, field: 'abdominalDiameter')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'antecedents', 'error')} ">
	<label for="antecedents">
		<g:message code="patient.antecedents.label" default="Antecedents" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${patientInstance?.antecedents?}" var="a">
    <li><g:link controller="antecedent" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="antecedent" action="create" params="['patient.id': patientInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'antecedent.label', default: 'Antecedent')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'height', 'error')} required">
	<label for="height">
		<g:message code="patient.height.label" default="Height" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="height" value="${fieldValue(bean: patientInstance, field: 'height')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'medicalHistory', 'error')} ">
	<label for="medicalHistory">
		<g:message code="patient.medicalHistory.label" default="Medical History" />
		
	</label>
	<g:textField name="medicalHistory" value="${patientInstance?.medicalHistory}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'medicalStudies', 'error')} ">
	<label for="medicalStudies">
		<g:message code="patient.medicalStudies.label" default="Medical Studies" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${patientInstance?.medicalStudies?}" var="m">
    <li><g:link controller="medicalStudy" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="medicalStudy" action="create" params="['patient.id': patientInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'medicalStudy.label', default: 'MedicalStudy')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'patientId', 'error')} required">
	<label for="patientId">
		<g:message code="patient.patientId.label" default="Patient Id" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="patientId" type="number" value="${patientInstance.patientId}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'plates', 'error')} ">
	<label for="plates">
		<g:message code="patient.plates.label" default="Plates" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${patientInstance?.plates?}" var="p">
    <li><g:link controller="plate" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="plate" action="create" params="['patient.id': patientInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'plate.label', default: 'Plate')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'treatments', 'error')} ">
	<label for="treatments">
		<g:message code="patient.treatments.label" default="Treatments" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${patientInstance?.treatments?}" var="t">
    <li><g:link controller="treatment" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="treatment" action="create" params="['patient.id': patientInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'treatment.label', default: 'Treatment')])}</g:link>
</li>
</ul>

</div>

<div class="fieldcontain ${hasErrors(bean: patientInstance, field: 'weight', 'error')} required">
	<label for="weight">
		<g:message code="patient.weight.label" default="Weight" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="weight" value="${fieldValue(bean: patientInstance, field: 'weight')}" required=""/>
</div>

