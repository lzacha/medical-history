
<%@ page import="medicalhistory.Treatment" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'treatment.label', default: 'Treatment')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-treatment" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-treatment" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list treatment">
			
				<g:if test="${treatmentInstance?.frequency}">
				<li class="fieldcontain">
					<span id="frequency-label" class="property-label"><g:message code="treatment.frequency.label" default="Frequency" /></span>
					
						<span class="property-value" aria-labelledby="frequency-label"><g:link controller="treatmentFrequency" action="show" id="${treatmentInstance?.frequency?.id}">${treatmentInstance?.frequency?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="treatment.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${treatmentInstance?.patient?.id}">${treatmentInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentInstance?.treatmentCode}">
				<li class="fieldcontain">
					<span id="treatmentCode-label" class="property-label"><g:message code="treatment.treatmentCode.label" default="Treatment Code" /></span>
					
						<span class="property-value" aria-labelledby="treatmentCode-label"><g:fieldValue bean="${treatmentInstance}" field="treatmentCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentInstance?.treatmentDetail}">
				<li class="fieldcontain">
					<span id="treatmentDetail-label" class="property-label"><g:message code="treatment.treatmentDetail.label" default="Treatment Detail" /></span>
					
						<span class="property-value" aria-labelledby="treatmentDetail-label"><g:fieldValue bean="${treatmentInstance}" field="treatmentDetail"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentInstance?.treatmentId}">
				<li class="fieldcontain">
					<span id="treatmentId-label" class="property-label"><g:message code="treatment.treatmentId.label" default="Treatment Id" /></span>
					
						<span class="property-value" aria-labelledby="treatmentId-label"><g:fieldValue bean="${treatmentInstance}" field="treatmentId"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentInstance?.treatmentValue}">
				<li class="fieldcontain">
					<span id="treatmentValue-label" class="property-label"><g:message code="treatment.treatmentValue.label" default="Treatment Value" /></span>
					
						<span class="property-value" aria-labelledby="treatmentValue-label"><g:fieldValue bean="${treatmentInstance}" field="treatmentValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentInstance?.treatments}">
				<li class="fieldcontain">
					<span id="treatments-label" class="property-label"><g:message code="treatment.treatments.label" default="Treatments" /></span>
					
						<g:each in="${treatmentInstance.treatments}" var="t">
						<span class="property-value" aria-labelledby="treatments-label"><g:link controller="treatmentDetail" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentInstance?.unit}">
				<li class="fieldcontain">
					<span id="unit-label" class="property-label"><g:message code="treatment.unit.label" default="Unit" /></span>
					
						<span class="property-value" aria-labelledby="unit-label"><g:link controller="measurementUnit" action="show" id="${treatmentInstance?.unit?.id}">${treatmentInstance?.unit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${treatmentInstance?.id}" />
					<g:link class="edit" action="edit" id="${treatmentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
