
<%@ page import="medicalhistory.Antecedent" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'antecedent.label', default: 'Antecedent')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-antecedent" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-antecedent" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list antecedent">
			
				<g:if test="${antecedentInstance?.antecedentDetails}">
				<li class="fieldcontain">
					<span id="antecedentDetails-label" class="property-label"><g:message code="antecedent.antecedentDetails.label" default="Antecedent Details" /></span>
					
						<g:each in="${antecedentInstance.antecedentDetails}" var="a">
						<span class="property-value" aria-labelledby="antecedentDetails-label"><g:link controller="antecedentDetail" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentInstance?.antecedentValue}">
				<li class="fieldcontain">
					<span id="antecedentValue-label" class="property-label"><g:message code="antecedent.antecedentValue.label" default="Antecedent Value" /></span>
					
						<span class="property-value" aria-labelledby="antecedentValue-label"><g:fieldValue bean="${antecedentInstance}" field="antecedentValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="antecedent.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${antecedentInstance?.patient?.id}">${antecedentInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${antecedentInstance?.id}" />
					<g:link class="edit" action="edit" id="${antecedentInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
