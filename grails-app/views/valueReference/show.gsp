
<%@ page import="medicalhistory.ValueReference" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'valueReference.label', default: 'ValueReference')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-valueReference" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-valueReference" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list valueReference">
			
				<g:if test="${valueReferenceInstance?.ageRange}">
				<li class="fieldcontain">
					<span id="ageRange-label" class="property-label"><g:message code="valueReference.ageRange.label" default="Age Range" /></span>
					
						<span class="property-value" aria-labelledby="ageRange-label"><g:link controller="ageRange" action="show" id="${valueReferenceInstance?.ageRange?.id}">${valueReferenceInstance?.ageRange?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${valueReferenceInstance?.decimalQuantity}">
				<li class="fieldcontain">
					<span id="decimalQuantity-label" class="property-label"><g:message code="valueReference.decimalQuantity.label" default="Decimal Quantity" /></span>
					
						<span class="property-value" aria-labelledby="decimalQuantity-label"><g:fieldValue bean="${valueReferenceInstance}" field="decimalQuantity"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${valueReferenceInstance?.maxValue}">
				<li class="fieldcontain">
					<span id="maxValue-label" class="property-label"><g:message code="valueReference.maxValue.label" default="Max Value" /></span>
					
						<span class="property-value" aria-labelledby="maxValue-label"><g:fieldValue bean="${valueReferenceInstance}" field="maxValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${valueReferenceInstance?.minValue}">
				<li class="fieldcontain">
					<span id="minValue-label" class="property-label"><g:message code="valueReference.minValue.label" default="Min Value" /></span>
					
						<span class="property-value" aria-labelledby="minValue-label"><g:fieldValue bean="${valueReferenceInstance}" field="minValue"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${valueReferenceInstance?.sex}">
				<li class="fieldcontain">
					<span id="sex-label" class="property-label"><g:message code="valueReference.sex.label" default="Sex" /></span>
					
						<span class="property-value" aria-labelledby="sex-label"><g:fieldValue bean="${valueReferenceInstance}" field="sex"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${valueReferenceInstance?.studyTypeDetail}">
				<li class="fieldcontain">
					<span id="studyTypeDetail-label" class="property-label"><g:message code="valueReference.studyTypeDetail.label" default="Study Type Detail" /></span>
					
						<span class="property-value" aria-labelledby="studyTypeDetail-label"><g:link controller="studyTypeDetail" action="show" id="${valueReferenceInstance?.studyTypeDetail?.id}">${valueReferenceInstance?.studyTypeDetail?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${valueReferenceInstance?.unit}">
				<li class="fieldcontain">
					<span id="unit-label" class="property-label"><g:message code="valueReference.unit.label" default="Unit" /></span>
					
						<span class="property-value" aria-labelledby="unit-label"><g:link controller="measurementUnit" action="show" id="${valueReferenceInstance?.unit?.id}">${valueReferenceInstance?.unit?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${valueReferenceInstance?.id}" />
					<g:link class="edit" action="edit" id="${valueReferenceInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
