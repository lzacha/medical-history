
<%@ page import="medicalhistory.Plate" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'plate.label', default: 'Plate')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-plate" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-plate" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list plate">
			
				<g:if test="${plateInstance?.doctor}">
				<li class="fieldcontain">
					<span id="doctor-label" class="property-label"><g:message code="plate.doctor.label" default="Doctor" /></span>
					
						<span class="property-value" aria-labelledby="doctor-label"><g:link controller="doctor" action="show" id="${plateInstance?.doctor?.id}">${plateInstance?.doctor?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateInstance?.fieldPlate2}">
				<li class="fieldcontain">
					<span id="fieldPlate2-label" class="property-label"><g:message code="plate.fieldPlate2.label" default="Field Plate2" /></span>
					
						<span class="property-value" aria-labelledby="fieldPlate2-label"><g:fieldValue bean="${plateInstance}" field="fieldPlate2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateInstance?.fieldPlate3}">
				<li class="fieldcontain">
					<span id="fieldPlate3-label" class="property-label"><g:message code="plate.fieldPlate3.label" default="Field Plate3" /></span>
					
						<span class="property-value" aria-labelledby="fieldPlate3-label"><g:fieldValue bean="${plateInstance}" field="fieldPlate3"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateInstance?.imagePlate}">
				<li class="fieldcontain">
					<span id="imagePlate-label" class="property-label"><g:message code="plate.imagePlate.label" default="Image Plate" /></span>
					
						<span class="property-value" aria-labelledby="imagePlate-label"><g:fieldValue bean="${plateInstance}" field="imagePlate"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateInstance?.observation}">
				<li class="fieldcontain">
					<span id="observation-label" class="property-label"><g:message code="plate.observation.label" default="Observation" /></span>
					
						<span class="property-value" aria-labelledby="observation-label"><g:fieldValue bean="${plateInstance}" field="observation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateInstance?.plateDate}">
				<li class="fieldcontain">
					<span id="plateDate-label" class="property-label"><g:message code="plate.plateDate.label" default="Plate Date" /></span>
					
						<span class="property-value" aria-labelledby="plateDate-label"><g:formatDate date="${plateInstance?.plateDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${plateInstance?.plateDescription}">
				<li class="fieldcontain">
					<span id="plateDescription-label" class="property-label"><g:message code="plate.plateDescription.label" default="Plate Description" /></span>
					
						<span class="property-value" aria-labelledby="plateDescription-label"><g:fieldValue bean="${plateInstance}" field="plateDescription"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${plateInstance?.id}" />
					<g:link class="edit" action="edit" id="${plateInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
