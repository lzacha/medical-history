
<%@ page import="medicalhistory.TreatmentDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'treatmentDetail.label', default: 'TreatmentDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-treatmentDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-treatmentDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list treatmentDetail">
			
				<g:if test="${treatmentDetailInstance?.abbreviation}">
				<li class="fieldcontain">
					<span id="abbreviation-label" class="property-label"><g:message code="treatmentDetail.abbreviation.label" default="Abbreviation" /></span>
					
						<span class="property-value" aria-labelledby="abbreviation-label"><g:fieldValue bean="${treatmentDetailInstance}" field="abbreviation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentDetailInstance?.completeName}">
				<li class="fieldcontain">
					<span id="completeName-label" class="property-label"><g:message code="treatmentDetail.completeName.label" default="Complete Name" /></span>
					
						<span class="property-value" aria-labelledby="completeName-label"><g:fieldValue bean="${treatmentDetailInstance}" field="completeName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentDetailInstance?.decimalsQuantity}">
				<li class="fieldcontain">
					<span id="decimalsQuantity-label" class="property-label"><g:message code="treatmentDetail.decimalsQuantity.label" default="Decimals Quantity" /></span>
					
						<span class="property-value" aria-labelledby="decimalsQuantity-label"><g:fieldValue bean="${treatmentDetailInstance}" field="decimalsQuantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentDetailInstance?.fieldType}">
				<li class="fieldcontain">
					<span id="fieldType-label" class="property-label"><g:message code="treatmentDetail.fieldType.label" default="Field Type" /></span>
					
						<span class="property-value" aria-labelledby="fieldType-label"><g:link controller="fieldType" action="show" id="${treatmentDetailInstance?.fieldType?.id}">${treatmentDetailInstance?.fieldType?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${treatmentDetailInstance?.treatmentType}">
				<li class="fieldcontain">
					<span id="treatmentType-label" class="property-label"><g:message code="treatmentDetail.treatmentType.label" default="Treatment Type" /></span>
					
						<span class="property-value" aria-labelledby="treatmentType-label"><g:fieldValue bean="${treatmentDetailInstance}" field="treatmentType"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${treatmentDetailInstance?.id}" />
					<g:link class="edit" action="edit" id="${treatmentDetailInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
