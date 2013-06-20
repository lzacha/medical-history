
<%@ page import="medicalhistory.MedicalStudyDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'medicalStudyDetail.label', default: 'MedicalStudyDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-medicalStudyDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-medicalStudyDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list medicalStudyDetail">
			
				<g:if test="${medicalStudyDetailInstance?.abbreviation}">
				<li class="fieldcontain">
					<span id="abbreviation-label" class="property-label"><g:message code="medicalStudyDetail.abbreviation.label" default="Abbreviation" /></span>
					
						<span class="property-value" aria-labelledby="abbreviation-label"><g:fieldValue bean="${medicalStudyDetailInstance}" field="abbreviation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.ageRange}">
				<li class="fieldcontain">
					<span id="ageRange-label" class="property-label"><g:message code="medicalStudyDetail.ageRange.label" default="Age Range" /></span>
					
						<span class="property-value" aria-labelledby="ageRange-label"><g:link controller="ageRange" action="show" id="${medicalStudyDetailInstance?.ageRange?.id}">${medicalStudyDetailInstance?.ageRange?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.completeName}">
				<li class="fieldcontain">
					<span id="completeName-label" class="property-label"><g:message code="medicalStudyDetail.completeName.label" default="Complete Name" /></span>
					
						<span class="property-value" aria-labelledby="completeName-label"><g:fieldValue bean="${medicalStudyDetailInstance}" field="completeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.decimalsQuantity}">
				<li class="fieldcontain">
					<span id="decimalsQuantity-label" class="property-label"><g:message code="medicalStudyDetail.decimalsQuantity.label" default="Decimals Quantity" /></span>
					
						<span class="property-value" aria-labelledby="decimalsQuantity-label"><g:fieldValue bean="${medicalStudyDetailInstance}" field="decimalsQuantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.fieldType}">
				<li class="fieldcontain">
					<span id="fieldType-label" class="property-label"><g:message code="medicalStudyDetail.fieldType.label" default="Field Type" /></span>
					
						<span class="property-value" aria-labelledby="fieldType-label"><g:link controller="fieldType" action="show" id="${medicalStudyDetailInstance?.fieldType?.id}">${medicalStudyDetailInstance?.fieldType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.maxValue}">
				<li class="fieldcontain">
					<span id="maxValue-label" class="property-label"><g:message code="medicalStudyDetail.maxValue.label" default="Max Value" /></span>
					
						<span class="property-value" aria-labelledby="maxValue-label"><g:fieldValue bean="${medicalStudyDetailInstance}" field="maxValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.minValue}">
				<li class="fieldcontain">
					<span id="minValue-label" class="property-label"><g:message code="medicalStudyDetail.minValue.label" default="Min Value" /></span>
					
						<span class="property-value" aria-labelledby="minValue-label"><g:fieldValue bean="${medicalStudyDetailInstance}" field="minValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.studyType}">
				<li class="fieldcontain">
					<span id="studyType-label" class="property-label"><g:message code="medicalStudyDetail.studyType.label" default="Study Type" /></span>
					
						<span class="property-value" aria-labelledby="studyType-label"><g:link controller="studyType" action="show" id="${medicalStudyDetailInstance?.studyType?.id}">${medicalStudyDetailInstance?.studyType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${medicalStudyDetailInstance?.unit}">
				<li class="fieldcontain">
					<span id="unit-label" class="property-label"><g:message code="medicalStudyDetail.unit.label" default="Unit" /></span>
					
						<span class="property-value" aria-labelledby="unit-label"><g:link controller="measurementUnit" action="show" id="${medicalStudyDetailInstance?.unit?.id}">${medicalStudyDetailInstance?.unit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${medicalStudyDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${medicalStudyDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
