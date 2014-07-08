
<%@ page import="medicalhistory.StudyTypesValues" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesValues.label', default: 'StudyTypesValues')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-studyTypesValues" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-studyTypesValues" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list studyTypesValues">
			
				<g:if test="${studyTypesValuesInstance?.patient}">
				<li class="fieldcontain">
					<span id="patient-label" class="property-label"><g:message code="studyTypesValues.patient.label" default="Patient" /></span>
					
						<span class="property-value" aria-labelledby="patient-label"><g:link controller="patient" action="show" id="${studyTypesValuesInstance?.patient?.id}">${studyTypesValuesInstance?.patient?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesValuesInstance?.studyTypeValue}">
				<li class="fieldcontain">
					<span id="studyTypeValue-label" class="property-label"><g:message code="studyTypesValues.studyTypeValue.label" default="Study Type Value" /></span>
					
						<span class="property-value" aria-labelledby="studyTypeValue-label"><g:fieldValue bean="${studyTypesValuesInstance}" field="studyTypeValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesValuesInstance?.studyTypesDetail}">
				<li class="fieldcontain">
					<span id="studyTypesDetail-label" class="property-label"><g:message code="studyTypesValues.studyTypesDetail.label" default="Study Types Detail" /></span>
					
						<span class="property-value" aria-labelledby="studyTypesDetail-label"><g:link controller="studyTypesDetail" action="show" id="${studyTypesValuesInstance?.studyTypesDetail?.id}">${studyTypesValuesInstance?.studyTypesDetail?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${studyTypesValuesInstance?.id}" />
					<g:link class="edit" action="edit" id="${studyTypesValuesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
