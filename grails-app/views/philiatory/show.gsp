
<%@ page import="medicalhistory.Philiatory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'philiatory.label', default: 'Philiatory')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-philiatory" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-philiatory" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list philiatory">
			
				<g:if test="${philiatoryInstance?.abdominalDiameter}">
				<li class="fieldcontain">
					<span id="abdominalDiameter-label" class="property-label"><g:message code="philiatory.abdominalDiameter.label" default="Abdominal Diameter" /></span>
					
						<span class="property-value" aria-labelledby="abdominalDiameter-label"><g:fieldValue bean="${philiatoryInstance}" field="abdominalDiameter"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${philiatoryInstance?.height}">
				<li class="fieldcontain">
					<span id="height-label" class="property-label"><g:message code="philiatory.height.label" default="Height" /></span>
					
						<span class="property-value" aria-labelledby="height-label"><g:fieldValue bean="${philiatoryInstance}" field="height"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${philiatoryInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="philiatory.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${philiatoryInstance?.patient?.id}">${philiatoryInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${philiatoryInstance?.weight}">
				<li class="fieldcontain">
					<span id="weight-label" class="property-label"><g:message code="philiatory.weight.label" default="Weight" /></span>
					
						<span class="property-value" aria-labelledby="weight-label"><g:fieldValue bean="${philiatoryInstance}" field="weight"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${philiatoryInstance?.id}" />
					<g:link class="edit" action="edit" id="${philiatoryInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
