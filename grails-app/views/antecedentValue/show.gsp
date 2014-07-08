
<%@ page import="medicalhistory.AntecedentValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'antecedentValue.label', default: 'AntecedentValue')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-antecedentValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-antecedentValue" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list antecedentValue">
			
				<g:if test="${antecedentValueInstance?.antecedentDetail}">
				<li class="fieldcontain">
					<span id="antecedentDetail-label" class="property-label"><g:message code="antecedentValue.antecedentDetail.label" default="Antecedent Detail" /></span>
					
						<span class="property-value" aria-labelledby="antecedentDetail-label"><g:link controller="antecedentDetail" action="show" id="${antecedentValueInstance?.antecedentDetail?.id}">${antecedentValueInstance?.antecedentDetail?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentValueInstance?.antecedentValue}">
				<li class="fieldcontain">
					<span id="antecedentValue-label" class="property-label"><g:message code="antecedentValue.antecedentValue.label" default="Antecedent Value" /></span>
					
						<span class="property-value" aria-labelledby="antecedentValue-label"><g:fieldValue bean="${antecedentValueInstance}" field="antecedentValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentValueInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="antecedentValue.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${antecedentValueInstance?.patient?.id}">${antecedentValueInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${antecedentValueInstance?.id}" />
					<g:link class="edit" action="edit" id="${antecedentValueInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
