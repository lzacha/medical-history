
<%@ page import="medicalhistory.StudyTypesDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'studyTypesDetail.label', default: 'StudyTypesDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-studyTypesDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-studyTypesDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list studyTypesDetail">
			
				<g:if test="${studyTypesDetailInstance?.abbreviation}">
				<li class="fieldcontain">
					<span id="abbreviation-label" class="property-label"><g:message code="studyTypesDetail.abbreviation.label" default="Abbreviation" /></span>
					
						<span class="property-value" aria-labelledby="abbreviation-label"><g:fieldValue bean="${studyTypesDetailInstance}" field="abbreviation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.completeName}">
				<li class="fieldcontain">
					<span id="completeName-label" class="property-label"><g:message code="studyTypesDetail.completeName.label" default="Complete Name" /></span>
					
						<span class="property-value" aria-labelledby="completeName-label"><g:fieldValue bean="${studyTypesDetailInstance}" field="completeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.decimalsQuantity}">
				<li class="fieldcontain">
					<span id="decimalsQuantity-label" class="property-label"><g:message code="studyTypesDetail.decimalsQuantity.label" default="Decimals Quantity" /></span>
					
						<span class="property-value" aria-labelledby="decimalsQuantity-label"><g:fieldValue bean="${studyTypesDetailInstance}" field="decimalsQuantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="studyTypesDetail.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${studyTypesDetailInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.fieldType}">
				<li class="fieldcontain">
					<span id="fieldType-label" class="property-label"><g:message code="studyTypesDetail.fieldType.label" default="Field Type" /></span>
					
						<span class="property-value" aria-labelledby="fieldType-label"><g:link controller="fieldType" action="show" id="${studyTypesDetailInstance?.fieldType?.id}">${studyTypesDetailInstance?.fieldType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.maxRange}">
				<li class="fieldcontain">
					<span id="maxRange-label" class="property-label"><g:message code="studyTypesDetail.maxRange.label" default="Max Range" /></span>
					
						<span class="property-value" aria-labelledby="maxRange-label"><g:fieldValue bean="${studyTypesDetailInstance}" field="maxRange"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.measurementUnit}">
				<li class="fieldcontain">
					<span id="measurementUnit-label" class="property-label"><g:message code="studyTypesDetail.measurementUnit.label" default="Measurement Unit" /></span>
					
						<span class="property-value" aria-labelledby="measurementUnit-label"><g:link controller="measurementUnit" action="show" id="${studyTypesDetailInstance?.measurementUnit?.id}">${studyTypesDetailInstance?.measurementUnit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.minRange}">
				<li class="fieldcontain">
					<span id="minRange-label" class="property-label"><g:message code="studyTypesDetail.minRange.label" default="Min Range" /></span>
					
						<span class="property-value" aria-labelledby="minRange-label"><g:fieldValue bean="${studyTypesDetailInstance}" field="minRange"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${studyTypesDetailInstance?.studyTypes}">
				<li class="fieldcontain">
					<span id="studyTypes-label" class="property-label"><g:message code="studyTypesDetail.studyTypes.label" default="Study Types" /></span>
					
						<span class="property-value" aria-labelledby="studyTypes-label"><g:link controller="studyTypes" action="show" id="${studyTypesDetailInstance?.studyTypes?.id}">${studyTypesDetailInstance?.studyTypes?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${studyTypesDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${studyTypesDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
