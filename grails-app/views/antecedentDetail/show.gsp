
<%@ page import="medicalhistory.AntecedentDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'antecedentDetail.label', default: 'AntecedentDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-antecedentDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-antecedentDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list antecedentDetail">
			
				<g:if test="${antecedentDetailInstance?.abbreviation}">
				<li class="fieldcontain">
					<span id="abbreviation-label" class="property-label"><g:message code="antecedentDetail.abbreviation.label" default="Abbreviation" /></span>
					
						<span class="property-value" aria-labelledby="abbreviation-label"><g:fieldValue bean="${antecedentDetailInstance}" field="abbreviation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentDetailInstance?.antecedentStudyType}">
				<li class="fieldcontain">
					<span id="antecedentStudyType-label" class="property-label"><g:message code="antecedentDetail.antecedentStudyType.label" default="Antecedent Study Type" /></span>
					
						<span class="property-value" aria-labelledby="antecedentStudyType-label"><g:fieldValue bean="${antecedentDetailInstance}" field="antecedentStudyType"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentDetailInstance?.completeName}">
				<li class="fieldcontain">
					<span id="completeName-label" class="property-label"><g:message code="antecedentDetail.completeName.label" default="Complete Name" /></span>
					
						<span class="property-value" aria-labelledby="completeName-label"><g:fieldValue bean="${antecedentDetailInstance}" field="completeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentDetailInstance?.decimalsQuantity}">
				<li class="fieldcontain">
					<span id="decimalsQuantity-label" class="property-label"><g:message code="antecedentDetail.decimalsQuantity.label" default="Decimals Quantity" /></span>
					
						<span class="property-value" aria-labelledby="decimalsQuantity-label"><g:fieldValue bean="${antecedentDetailInstance}" field="decimalsQuantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentDetailInstance?.fieldType}">
				<li class="fieldcontain">
					<span id="fieldType-label" class="property-label"><g:message code="antecedentDetail.fieldType.label" default="Field Type" /></span>
					
						<span class="property-value" aria-labelledby="fieldType-label"><g:link controller="fieldType" action="show" id="${antecedentDetailInstance?.fieldType?.id}">${antecedentDetailInstance?.fieldType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${antecedentDetailInstance?.measureUnit}">
				<li class="fieldcontain">
					<span id="measureUnit-label" class="property-label"><g:message code="antecedentDetail.measureUnit.label" default="Measure Unit" /></span>
					
						<span class="property-value" aria-labelledby="measureUnit-label"><g:link controller="measurementUnit" action="show" id="${antecedentDetailInstance?.measureUnit?.id}">${antecedentDetailInstance?.measureUnit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${antecedentDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${antecedentDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
