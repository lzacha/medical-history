
<%@ page import="medicalhistory.AgeRanges" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ageRanges.label', default: 'AgeRanges')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-ageRanges" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-ageRanges" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ageRanges">
			
				<g:if test="${ageRangesInstance?.maxValue}">
				<li class="fieldcontain">
					<span id="maxValue-label" class="property-label"><g:message code="ageRanges.maxValue.label" default="Max Value" /></span>
					
						<span class="property-value" aria-labelledby="maxValue-label"><g:fieldValue bean="${ageRangesInstance}" field="maxValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ageRangesInstance?.minValue}">
				<li class="fieldcontain">
					<span id="minValue-label" class="property-label"><g:message code="ageRanges.minValue.label" default="Min Value" /></span>
					
						<span class="property-value" aria-labelledby="minValue-label"><g:fieldValue bean="${ageRangesInstance}" field="minValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${ageRangesInstance?.rangeDescription}">
				<li class="fieldcontain">
					<span id="rangeDescription-label" class="property-label"><g:message code="ageRanges.rangeDescription.label" default="Range Description" /></span>
					
						<span class="property-value" aria-labelledby="rangeDescription-label"><g:fieldValue bean="${ageRangesInstance}" field="rangeDescription"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${ageRangesInstance?.id}" />
					<g:link class="edit" action="edit" id="${ageRangesInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
