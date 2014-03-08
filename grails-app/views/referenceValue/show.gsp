
<%@ page import="medicalhistory.ReferenceValue" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'referenceValue.label', default: 'ReferenceValue')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-referenceValue" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-referenceValue" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list referenceValue">
			
				<g:if test="${referenceValueInstance?.ageRange}">
				<li class="fieldcontain">
					<span id="ageRange-label" class="property-label"><g:message code="referenceValue.ageRange.label" default="Age Range" /></span>
					
						<span class="property-value" aria-labelledby="ageRange-label"><g:link controller="ageRanges" action="show" id="${referenceValueInstance?.ageRange?.id}">${referenceValueInstance?.ageRange?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceValueInstance?.decimalQuantity}">
				<li class="fieldcontain">
					<span id="decimalQuantity-label" class="property-label"><g:message code="referenceValue.decimalQuantity.label" default="Decimal Quantity" /></span>
					
						<span class="property-value" aria-labelledby="decimalQuantity-label"><g:fieldValue bean="${referenceValueInstance}" field="decimalQuantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceValueInstance?.maxValue}">
				<li class="fieldcontain">
					<span id="maxValue-label" class="property-label"><g:message code="referenceValue.maxValue.label" default="Max Value" /></span>
					
						<span class="property-value" aria-labelledby="maxValue-label"><g:fieldValue bean="${referenceValueInstance}" field="maxValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceValueInstance?.minValue}">
				<li class="fieldcontain">
					<span id="minValue-label" class="property-label"><g:message code="referenceValue.minValue.label" default="Min Value" /></span>
					
						<span class="property-value" aria-labelledby="minValue-label"><g:fieldValue bean="${referenceValueInstance}" field="minValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceValueInstance?.sex}">
				<li class="fieldcontain">
					<span id="sex-label" class="property-label"><g:message code="referenceValue.sex.label" default="Sex" /></span>
					
						<span class="property-value" aria-labelledby="sex-label"><g:fieldValue bean="${referenceValueInstance}" field="sex"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${referenceValueInstance?.studyTypesDetails}">
				<li class="fieldcontain">
					<span id="studyTypesDetails-label" class="property-label"><g:message code="referenceValue.studyTypesDetails.label" default="Study Types Details" /></span>
					
						<span class="property-value" aria-labelledby="studyTypesDetails-label"><g:link controller="studyTypesDetails" action="show" id="${referenceValueInstance?.studyTypesDetails?.id}">${referenceValueInstance?.studyTypesDetails?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${referenceValueInstance?.id}" />
					<g:link class="edit" action="edit" id="${referenceValueInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
