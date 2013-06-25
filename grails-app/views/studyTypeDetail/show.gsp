
<%@ page import="medicalhistory.StudyTypeDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypeDetail.label', default: 'StudyTypeDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-studyTypeDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-studyTypeDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list studyTypeDetail">
			
				<g:if test="${studyTypeDetailInstance?.abbreviation}">
				<li class="fieldcontain">
					<span id="abbreviation-label" class="property-label"><g:message code="studyTypeDetail.abbreviation.label" default="Abbreviation" /></span>
					
						<span class="property-value" aria-labelledby="abbreviation-label"><g:fieldValue bean="${studyTypeDetailInstance}" field="abbreviation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypeDetailInstance?.completeName}">
				<li class="fieldcontain">
					<span id="completeName-label" class="property-label"><g:message code="studyTypeDetail.completeName.label" default="Complete Name" /></span>
					
						<span class="property-value" aria-labelledby="completeName-label"><g:fieldValue bean="${studyTypeDetailInstance}" field="completeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypeDetailInstance?.studyType}">
				<li class="fieldcontain">
					<span id="studyType-label" class="property-label"><g:message code="studyTypeDetail.studyType.label" default="Study Type" /></span>
					
						<span class="property-value" aria-labelledby="studyType-label"><g:link controller="studyType" action="show" id="${studyTypeDetailInstance?.studyType?.id}">${studyTypeDetailInstance?.studyType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${studyTypeDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${studyTypeDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
