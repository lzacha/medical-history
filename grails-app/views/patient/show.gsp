
<%@ page import="medicalhistory.Patient" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'patient.label', default: 'Patient')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
		    <style>

    body {
        color: #333333;
        font: 13px/20px Arial,Helvetica,"Nimbus Sans L",sans-serif;
    }

    .ch-box {
        border: 1px solid #ccc;
        padding: 10px;
        margin: 10px auto;
    }

    .ch-header {
        height: 50px;
        padding: 20px 10px;
        background: #eee;
        margin: 10px auto 0px;
    }

    .ch-footer {
        clear:both;
        text-align: center;
        margin: 10px auto;
        background: #eee;

    }
    </style>

    <!-- chico-ui css-->
    <link rel="stylesheet" href="${resource(dir: 'css/chico-ui/css', file: 'chico-min-0.13.1.css')}" type="text/css">
    <link rel="stylesheet" href="${resource(dir: 'css/chico-ui/css', file: 'mesh-min-2.1.css')}" type="text/css">

	</head>
	<body>
		<div id="show-patient" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list patient">
			
				<g:if test="${patientInstance?.birthDate}">
				<li class="fieldcontain">
					<span id="birthDate-label" class="property-label"><g:message code="patient.birthDate.label" default="Birth Date" /></span>
					
						<span class="property-value" aria-labelledby="birthDate-label"><g:formatDate date="${patientInstance?.birthDate}" /></span>
					
				</li>
				</g:if>
			
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
			
				<g:if test="${patientInstance?.patientId}">
				<li class="fieldcontain">
					<span id="patientId-label" class="property-label"><g:message code="patient.patientId.label" default="Patient Id" /></span>
					
						<span class="property-value" aria-labelledby="patientId-label"><g:fieldValue bean="${patientInstance}" field="patientId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${patientInstance?.sexId}">
				<li class="fieldcontain">
					<span id="sexId-label" class="property-label"><g:message code="patient.sexId.label" default="Sex Id" /></span>
					
						<span class="property-value" aria-labelledby="sexId-label"><g:fieldValue bean="${patientInstance}" field="sexId"/></span>
					
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
