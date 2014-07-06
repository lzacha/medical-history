
<%@ page import="medicalhistory.Patient" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-patient" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-patient" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list patient">
			
				<g:if test="${patientInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="patient.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${patientInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="patient.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${patientInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.birthDate}">
				<li class="fieldcontain">
					<span id="birthDate-label" class="property-label"><g:message code="patient.birthDate.label" default="Birth Date" /></span>
					
						<span class="property-value" aria-labelledby="birthDate-label"><g:formatDate date="${patientInstance?.birthDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.abdominalDiameter}">
				<li class="fieldcontain">
					<span id="abdominalDiameter-label" class="property-label"><g:message code="patient.abdominalDiameter.label" default="Abdominal Diameter" /></span>
					
						<span class="property-value" aria-labelledby="abdominalDiameter-label"><g:fieldValue bean="${patientInstance}" field="abdominalDiameter"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.height}">
				<li class="fieldcontain">
					<span id="height-label" class="property-label"><g:message code="patient.height.label" default="Height" /></span>
					
						<span class="property-value" aria-labelledby="height-label"><g:fieldValue bean="${patientInstance}" field="height"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.medicalHistory}">
				<li class="fieldcontain">
					<span id="medicalHistory-label" class="property-label"><g:message code="patient.medicalHistory.label" default="Medical History" /></span>
					
						<span class="property-value" aria-labelledby="medicalHistory-label"><g:fieldValue bean="${patientInstance}" field="medicalHistory"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.patientId}">
				<li class="fieldcontain">
					<span id="patientId-label" class="property-label"><g:message code="patient.patientId.label" default="Patient Id" /></span>
					
						<span class="property-value" aria-labelledby="patientId-label"><g:fieldValue bean="${patientInstance}" field="patientId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.sex}">
				<li class="fieldcontain">
					<span id="sex-label" class="property-label"><g:message code="patient.sex.label" default="Sex" /></span>
					
						<span class="property-value" aria-labelledby="sex-label"><g:fieldValue bean="${patientInstance}" field="sex"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.weight}">
				<li class="fieldcontain">
					<span id="weight-label" class="property-label"><g:message code="patient.weight.label" default="Weight" /></span>
					
						<span class="property-value" aria-labelledby="weight-label"><g:fieldValue bean="${patientInstance}" field="weight"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${patientInstance?.id}" />
					<g:link class="edit" action="edit" id="${patientInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
