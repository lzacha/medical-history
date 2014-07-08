
<%@ page import="medicalhistory.TreatmentValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'treatmentValue.label', default: 'TreatmentValue')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-treatmentValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-treatmentValue" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list treatmentValue">
			
				<g:if test="${treatmentValueInstance?.frequency}">
				<li class="fieldcontain">
					<span id="frequency-label" class="property-label"><g:message code="treatmentValue.frequency.label" default="Frequency" /></span>
					
						<span class="property-value" aria-labelledby="frequency-label"><g:link controller="treatmentFrequency" action="show" id="${treatmentValueInstance?.frequency?.id}">${treatmentValueInstance?.frequency?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentValueInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="treatmentValue.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${treatmentValueInstance?.patient?.id}">${treatmentValueInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentValueInstance?.treatmentDetail}">
				<li class="fieldcontain">
					<span id="treatmentDetail-label" class="property-label"><g:message code="treatmentValue.treatmentDetail.label" default="Treatment Detail" /></span>
					
						<span class="property-value" aria-labelledby="treatmentDetail-label"><g:link controller="treatmentDetail" action="show" id="${treatmentValueInstance?.treatmentDetail?.id}">${treatmentValueInstance?.treatmentDetail?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentValueInstance?.treatmentValue}">
				<li class="fieldcontain">
					<span id="treatmentValue-label" class="property-label"><g:message code="treatmentValue.treatmentValue.label" default="Treatment Value" /></span>
					
						<span class="property-value" aria-labelledby="treatmentValue-label"><g:fieldValue bean="${treatmentValueInstance}" field="treatmentValue"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${treatmentValueInstance?.id}" />
					<g:link class="edit" action="edit" id="${treatmentValueInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
