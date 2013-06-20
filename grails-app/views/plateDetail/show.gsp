
<%@ page import="medicalhistory.PlateDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'plateDetail.label', default: 'PlateDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-plateDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-plateDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list plateDetail">
			
				<g:if test="${plateDetailInstance?.fieldPlateDetail1}">
				<li class="fieldcontain">
					<span id="fieldPlateDetail1-label" class="property-label"><g:message code="plateDetail.fieldPlateDetail1.label" default="Field Plate Detail1" /></span>
					
						<span class="property-value" aria-labelledby="fieldPlateDetail1-label"><g:fieldValue bean="${plateDetailInstance}" field="fieldPlateDetail1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateDetailInstance?.fieldPlateDetail2}">
				<li class="fieldcontain">
					<span id="fieldPlateDetail2-label" class="property-label"><g:message code="plateDetail.fieldPlateDetail2.label" default="Field Plate Detail2" /></span>
					
						<span class="property-value" aria-labelledby="fieldPlateDetail2-label"><g:fieldValue bean="${plateDetailInstance}" field="fieldPlateDetail2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateDetailInstance?.fieldPlateDetail3}">
				<li class="fieldcontain">
					<span id="fieldPlateDetail3-label" class="property-label"><g:message code="plateDetail.fieldPlateDetail3.label" default="Field Plate Detail3" /></span>
					
						<span class="property-value" aria-labelledby="fieldPlateDetail3-label"><g:fieldValue bean="${plateDetailInstance}" field="fieldPlateDetail3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateDetailInstance?.plate}">
				<li class="fieldcontain">
					<span id="plate-label" class="property-label"><g:message code="plateDetail.plate.label" default="Plate" /></span>
					
						<span class="property-value" aria-labelledby="plate-label"><g:link controller="plate" action="show" id="${plateDetailInstance?.plate?.id}">${plateDetailInstance?.plate?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${plateDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${plateDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
