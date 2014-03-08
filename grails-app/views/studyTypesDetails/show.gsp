
<%@ page import="medicalhistory.StudyTypesDetails" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesDetails.label', default: 'StudyTypesDetails')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-studyTypesDetails" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-studyTypesDetails" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list studyTypesDetails">
			
				<g:if test="${studyTypesDetailsInstance?.abbreviation}">
				<li class="fieldcontain">
					<span id="abbreviation-label" class="property-label"><g:message code="studyTypesDetails.abbreviation.label" default="Abbreviation" /></span>
					
						<span class="property-value" aria-labelledby="abbreviation-label"><g:fieldValue bean="${studyTypesDetailsInstance}" field="abbreviation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailsInstance?.completeName}">
				<li class="fieldcontain">
					<span id="completeName-label" class="property-label"><g:message code="studyTypesDetails.completeName.label" default="Complete Name" /></span>
					
						<span class="property-value" aria-labelledby="completeName-label"><g:fieldValue bean="${studyTypesDetailsInstance}" field="completeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailsInstance?.decimalsQuantity}">
				<li class="fieldcontain">
					<span id="decimalsQuantity-label" class="property-label"><g:message code="studyTypesDetails.decimalsQuantity.label" default="Decimals Quantity" /></span>
					
						<span class="property-value" aria-labelledby="decimalsQuantity-label"><g:fieldValue bean="${studyTypesDetailsInstance}" field="decimalsQuantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailsInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="studyTypesDetails.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${studyTypesDetailsInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailsInstance?.maxRange}">
				<li class="fieldcontain">
					<span id="maxRange-label" class="property-label"><g:message code="studyTypesDetails.maxRange.label" default="Max Range" /></span>
					
						<span class="property-value" aria-labelledby="maxRange-label"><g:fieldValue bean="${studyTypesDetailsInstance}" field="maxRange"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailsInstance?.minRange}">
				<li class="fieldcontain">
					<span id="minRange-label" class="property-label"><g:message code="studyTypesDetails.minRange.label" default="Min Range" /></span>
					
						<span class="property-value" aria-labelledby="minRange-label"><g:fieldValue bean="${studyTypesDetailsInstance}" field="minRange"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailsInstance?.studyTypes}">
				<li class="fieldcontain">
					<span id="studyTypes-label" class="property-label"><g:message code="studyTypesDetails.studyTypes.label" default="Study Types" /></span>
					
						<g:each in="${studyTypesDetailsInstance.studyTypes}" var="s">
						<span class="property-value" aria-labelledby="studyTypes-label"><g:link controller="studyTypes" action="show" id="${s.id}">${s?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${studyTypesDetailsInstance?.id}" />
					<g:link class="edit" action="edit" id="${studyTypesDetailsInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
