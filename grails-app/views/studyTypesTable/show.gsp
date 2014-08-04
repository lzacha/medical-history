
<%@ page import="medicalhistory.StudyTypesTable" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesTable.label', default: 'StudyTypesTable')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-studyTypesTable" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-studyTypesTable" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list studyTypesTable">
			
				<g:if test="${studyTypesTableInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="studyTypesTable.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${studyTypesTableInstance?.patient?.id}">${studyTypesTableInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesTableInstance?.studyDate}">
				<li class="fieldcontain">
					<span id="studyDate-label" class="property-label"><g:message code="studyTypesTable.studyDate.label" default="Study Date" /></span>
					
						<span class="property-value" aria-labelledby="studyDate-label"><g:formatDate date="${studyTypesTableInstance?.studyDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesTableInstance?.studyType}">
				<li class="fieldcontain">
					<span id="studyType-label" class="property-label"><g:message code="studyTypesTable.studyType.label" default="Study Type" /></span>
					
						<span class="property-value" aria-labelledby="studyType-label"><g:fieldValue bean="${studyTypesTableInstance}" field="studyType"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${studyTypesTableInstance?.id}" />
					<g:link class="edit" action="edit" id="${studyTypesTableInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
